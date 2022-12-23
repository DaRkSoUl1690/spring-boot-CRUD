package com.example.demo.controller;

import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
@ExtendWith(SpringExtension.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentAddress("")
                .departmentName("")
                .departmentCode("")
                .departmentId(1L)
                .build();

    }

    @Test
    void saveDepartment() throws Exception {

        Department inputDepartment = Department.builder()
                .departmentAddress("chandigarh")
                .departmentName("pxcom")
                .departmentCode("IT-06")
                .build();

        Mockito.when(departmentService.saveDepartment(inputDepartment))
                .thenReturn(department);

        mockMvc.perform(
                post("/departments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "departmentName":"pxcom",
                                    "departmentCode":"IT-06",
                                    "departmentAddress":"chandigarh"
                                }""")
        ).andExpect(status().isOk());


    }

    @Test
    void fetchDepartmentById() {

    }
}