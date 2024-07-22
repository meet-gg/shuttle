package com.example.Shuttle.Services;

import com.example.Shuttle.DTO.DepartDTO;
import com.example.Shuttle.Exception.ResourceNotFoundException;
import com.example.Shuttle.Model.Department;
import com.example.Shuttle.Reposi.DepartmentRepo;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServices {
    private final DepartmentRepo departmentRepo;
    private final ModelMapper mapper;

    public DepartmentServices(DepartmentRepo departmentRepo, ModelMapper mapper) {
        this.departmentRepo = departmentRepo;
        this.mapper = mapper;
    }

    public DepartDTO savedepartment(DepartDTO departDTO){
        Department department=mapper.map(departDTO, Department.class);
        Department department1=departmentRepo.save(department);
        return mapper.map(department1, DepartDTO.class);
    }

    public DepartDTO getDepabyId(Long depId){
        depaisexistornot(depId);
        Department department=departmentRepo.findById(depId).get();
        return mapper.map(department, DepartDTO.class);
    }
    public List<DepartDTO> getAllDepa(){
        List<Department> departments=departmentRepo.findAll();

        return departments.stream().map(department -> mapper.map(department, DepartDTO.class)).collect(Collectors.toList());
    }

    public DepartDTO update(DepartDTO departDTO,Long depaId){
        depaisexistornot(depaId);
        Department department=mapper.map(departDTO,Department.class);
        department.setDepaId(depaId);
        Department department1=departmentRepo.save(department);
        return mapper.map(department1, DepartDTO.class);
    }

    public boolean depadeletebyid(Long depaId) {
        depaisexistornot(depaId);
        departmentRepo.deleteById(depaId);
        return true;
    }

    public DepartDTO UpdatePartialDepament(Long depaId, Map<String,Object> update){
        depaisexistornot(depaId);
        Department department=departmentRepo.findById(depaId).get();
        update.forEach((field, value) ->{
            Field fieldupdate=ReflectionUtils.findRequiredField(Department.class,field);

            fieldupdate.setAccessible(true);

            ReflectionUtils.setField(fieldupdate,department,value);
        } );
        Department department1=departmentRepo.save(department);
        return mapper.map(department1, DepartDTO.class);
    }





    public void depaisexistornot(Long DepartmentId){
        boolean isexist=departmentRepo.existsById(DepartmentId);
        if (!isexist) throw new ResourceNotFoundException("Department not found id : "+DepartmentId);
    }

}
