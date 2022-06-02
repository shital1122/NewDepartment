package com.daillycodebuffer.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daillycodebuffer.springboot.entity.Department;

@Repository

public interface DepartmentRepository extends JpaRepository<Department, Long> {
	public Department findByDepartmentName(String departmentName);

}
//here there is no method available for finding the name in JPA repository ...we have to create this method in repository layer