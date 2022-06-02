package com.daillycodebuffer.springboot.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.daillycodebuffer.springboot.entity.Department;

@DataJpaTest
public class DepartmentRepositoryTest {
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired	
	private TestEntityManager entityManager;
	
	@BeforeEach
	void setUp() {
		Department department=Department.builder()
				.departmentName("Electrical Engg")
				.departmentCode("EE-09")
				.departmentAddress("Hyderabad")
				.build();
		entityManager.persist(department);
		
	}
	@Test
	public void whenFindById_thenReturnDepartment() {
		Department department=departmentRepository.findById(1L).get();
		assertEquals(department.getDepartmentName(),"Electrical Engg");
		
	}
	

}
