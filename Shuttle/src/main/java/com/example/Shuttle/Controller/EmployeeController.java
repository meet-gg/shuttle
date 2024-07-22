package com.example.Shuttle.Controller;

import com.example.Shuttle.DTO.EmployeeDTO;
import com.example.Shuttle.Exception.ResourceNotFoundException;
import com.example.Shuttle.Services.EmployeeServices;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("employee")
public class EmployeeController {
    private final EmployeeServices employeeServices;

    public EmployeeController(EmployeeServices employeeServices) {
        this.employeeServices = employeeServices;
    }

    @PostMapping(path = "/save")
    public ResponseEntity<EmployeeDTO> save(@RequestBody @Valid  EmployeeDTO employeeDTO){
        EmployeeDTO dto=employeeServices.savedata(employeeDTO);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<EmployeeDTO>> getall(){
        return ResponseEntity.ok(employeeServices.getall());
    }

    @GetMapping(path = "/byid/{id}")
    public ResponseEntity<EmployeeDTO> getbyid(@PathVariable Long id){
//     -----1st method-----
//        Optional<EmployeeDTO> employeeDTO = employeeServices.getbyid(id);
        //convert optional method to the ResponseEntity of employeedto
//        return employeeDTO.map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1))
//                .orElseThrow(()->new ResourceNotFoundException("Employee not found id : "+id));

//      -----2nd method---
        EmployeeDTO employeeDTO = employeeServices.getbyid(id);
        return ResponseEntity.ok(employeeDTO);
    }

    @PutMapping(path = "/update/{empid}")
    public ResponseEntity<EmployeeDTO> updateemployee(@RequestBody @Valid EmployeeDTO empdto,@PathVariable Long empid){
        return ResponseEntity.ok(employeeServices.updateemployee(empdto,empid));
    }
    @DeleteMapping(path = "/delete/{empid}")
    public ResponseEntity<Boolean> deletebyid(@PathVariable Long empid){
       boolean deleteornot = employeeServices.deletebyid(empid);
       if (!deleteornot) return ResponseEntity.notFound().build();
       return ResponseEntity.ok(true);

    }
    @PatchMapping(path = "patch/{empid}")

    //also use ResponseEntity<?> for all the common datatype
    public ResponseEntity<EmployeeDTO> updatepartialbyempid(@PathVariable Long empid,@RequestBody Map<String, Object> map){
        EmployeeDTO employeeDTO=employeeServices.updatepartialempbyempid(empid,map);

        //also use return new ResponseEntity<>(,Https.notfound());
        if (employeeDTO==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(employeeDTO);
    }
}
