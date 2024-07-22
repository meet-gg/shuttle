package com.example.Shuttle.Model;

import com.example.Shuttle.Annotation.EmployeevalidRole;
import com.example.Shuttle.Annotation.Primenumber;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private String role;
    private Double salary;
    private LocalDate joiningdate;
    //    @JsonProperty("Active") use for change the field name in the JSON field ex. if Active so JSON is Active but code use isActive
    private Boolean isActive;
//    private Integer number;
}
