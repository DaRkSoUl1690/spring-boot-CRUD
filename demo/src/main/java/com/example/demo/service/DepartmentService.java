package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.error.DepartmentNotFoundException;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    List<Department> fetchedDepartmentList();

    Department fetchedDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long departmentId);

    Department updateDepartmentById(Long departmentId, Department department);


    public Department fetchDepartmentByName(String departmentName);
}
