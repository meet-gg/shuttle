package com.example.Shuttle.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jdk.jfr.BooleanFlag;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "Department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long DepaId;
    @JsonProperty("title")
    private String DepaTitle;
    @JsonProperty("Active")
    private Boolean DepaisActive;
    private LocalDate createdAt;
    private String password;
}
