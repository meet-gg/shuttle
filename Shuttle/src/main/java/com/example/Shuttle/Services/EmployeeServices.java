package com.example.Shuttle.Services;

import com.example.Shuttle.DTO.EmployeeDTO;
import com.example.Shuttle.Exception.ResourceNotFoundException;
import com.example.Shuttle.Model.Employee;
import com.example.Shuttle.Reposi.Employeerepo;
import org.apache.el.util.ReflectionUtil;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServices {
    private final Employeerepo employeerepo;
    private final ModelMapper mapper;

    public EmployeeServices(Employeerepo employeerepo, ModelMapper mapper) {
        this.employeerepo = employeerepo;
        this.mapper = mapper;
    }

    public EmployeeDTO savedata(EmployeeDTO eDTO){
        Employee employee=mapper.map(eDTO, Employee.class);
        Employee employee1=employeerepo.save(employee);
        return mapper.map(employee1, EmployeeDTO.class);
    }
    public List<EmployeeDTO> getall(){
        List<Employee> employees=employeerepo.findAll();
        // convert list of data one entity to another entity
        return employees.stream().map(employee -> mapper.map(employee, EmployeeDTO.class)).collect(Collectors.toList());
    }
//    Optional<EmployeeDTO> for 1 st method
    public EmployeeDTO getbyid(Long id){
//        Employee employee=employeerepo.findById(id).orElse(null);
//        return mapper.map(employee, EmployeeDTO.class);
        // optional is required for Response entity for if ID IS not found so use optional
//     ------1 st method----
//        return employeerepo.findById(id).map(employee -> mapper.map(employee, EmployeeDTO.class));

//   --------2 nd method------
        isexistornot(id);
        return mapper.map(employeerepo.findById(id).get(), EmployeeDTO.class);
    }

    public EmployeeDTO updateemployee(EmployeeDTO empdto, Long empid) {
        isexistornot(empid);
        Employee employee=mapper.map(empdto, Employee.class);
        employee.setId(empid);
        Employee employee1=employeerepo.save(employee);
        return mapper.map(employee1, EmployeeDTO.class);
    }

    public boolean deletebyid(Long empid) {
        isexistornot(empid);
        employeerepo.deleteById(empid);
        return true;
    }
    public void isexistornot(Long empid){
        boolean isexist=employeerepo.existsById(empid);
        if (!isexist) throw new ResourceNotFoundException("Employee not found id : "+empid);
    }

    public EmployeeDTO updatepartialempbyempid(Long empid, Map<String, Object> update) {
        isexistornot(empid);
        Employee employee=employeerepo.findById(empid).get();
        update.forEach((field,value)->{
            Field fieldupdates = ReflectionUtils.findRequiredField(Employee.class, field);

            // required true bucause fied is private so we access accorading this
            fieldupdates.setAccessible(true);

            //set the fields
            ReflectionUtils.setField(fieldupdates,employee,value);
        });
        Employee employee1=employeerepo.save(employee);
        return mapper.map(employee1,EmployeeDTO.class);
    }
}
