package com.problem1.problem1.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.problem1.problem1.entities.Department;

@RepositoryRestController
public interface DepartmentDAO extends JpaRepository<Department, Long> {

}
