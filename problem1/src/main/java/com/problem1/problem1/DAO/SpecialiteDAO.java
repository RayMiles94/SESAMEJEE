package com.problem1.problem1.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.problem1.problem1.entities.Specialite;

@RepositoryRestResource
public interface SpecialiteDAO extends JpaRepository<Specialite, Long> {

}
