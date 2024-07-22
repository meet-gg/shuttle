package com.example.Shuttle.Reposi;

import com.example.Shuttle.Model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department,Long> {
}
