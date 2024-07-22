package com.example.Shuttle.DTO;

import com.example.Shuttle.Annotation.Password;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import jdk.jfr.BooleanFlag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartDTO {
    private Long DepaId;

    @NotNull(message = "Department title cannot be null")
    @Size(max = 20,min = 3,message = "Department title size between 3 and 7")
    @JsonProperty("title")
    private String DepaTitle;
    @JsonProperty("Active")
    @AssertTrue
    private Boolean DepaisActive;
    @PastOrPresent(message = "department date cannot be future")
    private LocalDate createdAt;
    @Length(max = 10,min = 5 ,message = "password maximum length should be 10 and minimum 5")
    @Password
    private String password;
}
