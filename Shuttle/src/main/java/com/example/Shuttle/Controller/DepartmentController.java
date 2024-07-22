package com.example.Shuttle.Controller;

import com.example.Shuttle.DTO.DepartDTO;
import com.example.Shuttle.Services.DepartmentServices;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

@Controller
@RestController
@RequestMapping(path = "/department")
public class DepartmentController {
    private final DepartmentServices departmentServices;

    public DepartmentController(DepartmentServices departmentServices) {
        this.departmentServices = departmentServices;
    }

    @PostMapping(path = "/save")
    public DepartDTO save(@RequestBody @Valid DepartDTO departDTO){
        return departmentServices.savedepartment(departDTO);
    }


    @GetMapping(path = "/getbyid/{id}")
    public DepartDTO getbyid(@PathVariable @Valid Long id){
        return departmentServices.getDepabyId(id);
    }

    @GetMapping(path = "/getall")
    public List<DepartDTO> getall(){
        return departmentServices.getAllDepa();
    }

    @PatchMapping(path = "/patch/{id}")
    public DepartDTO partialupdatebyId(@PathVariable Long id,@RequestBody Map<String,Object> update){
        return departmentServices.UpdatePartialDepament(id,update);
    }

    @PutMapping(path = "/update/{id}")
    public DepartDTO updatebyid(@RequestBody DepartDTO departDTO,@PathVariable Long depId){
        return departmentServices.update(departDTO,depId);
    }
}

