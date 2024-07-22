package com.example.Shuttle.DTO;

import com.example.Shuttle.Annotation.EmployeevalidRole;
import com.example.Shuttle.Annotation.Primenumber;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private Long id;

    @NotNull(message = "employee name cnnot be null")
    @Size(max = 20,min = 3,message = "name size between 3 and 7")
    private String name;

    @Email(message = "email should be valid")
    private String email;

    @Max(value = 60,message = "age of the employee cannot be greater than 60")
    @Min(value = 18,message = "Age of the employee cannot less than 18")
    private Integer age;

    //    @Pattern(regexp = "^(ADMIN|USER)$",message = "Role of the employee san be USER ang=d ADMIN")
    @EmployeevalidRole // this is custom annonation
    private String role;

    @NotNull
    @Positive(message = "salary cannot be negtive")
    @DecimalMax(value = "895865.23")
    @DecimalMin(value = "100.10")
//    @Digits(integer = 6,fraction = 3,message = "salary format must be XXXXXX.YYY")  mostly use for integer
    private Double salary;

    @PastOrPresent(message = "Date is cannot be future")
    private LocalDate joiningdate;
    @JsonProperty("Active")
//    @AssertTrue  for default value tru or false
    private Boolean isActive;
//    @Primenumber  // custom annonation
//    private Integer number;
}
