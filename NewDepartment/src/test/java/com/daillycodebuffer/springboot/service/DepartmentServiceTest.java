package com.daillycodebuffer.springboot.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.daillycodebuffer.springboot.entity.Department;
import com.daillycodebuffer.springboot.repository.DepartmentRepository;

@SpringBootTest
public class DepartmentServiceTest {
	@Autowired
	private DepartmentService departmentService;
	@MockBean
	private DepartmentRepository departmentRepository;
	
	 
	//this perticular method is called for each and every test case into this percular class 
	@BeforeEach
	void setUp() {
		Department department=Department.builder().departmentName("mathematics")
				.departmentAddress("pune")
				.departmentCode("math-12").
				departmentId(11L).build();
		Mockito.when(departmentRepository.findByDepartmentName("mathematics"))
				.thenReturn(department);
		
	}
	@Test
	@DisplayName("Getting the data based on valid department name ")
	public void whenValidDepartmentName_thenDepartmentShouldFound() {
		String departmentName="mathematics";
		Department found=departmentService.fetchDepartmentByName(departmentName) ;
		assertEquals(departmentName,found.getDepartmentName());
		 
	}
	 

}
