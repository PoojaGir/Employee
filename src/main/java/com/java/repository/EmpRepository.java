package com.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.model.Emp;
@Repository
public interface EmpRepository extends JpaRepository<Emp,Integer> {

}
