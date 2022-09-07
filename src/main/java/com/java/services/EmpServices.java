package com.java.services;

import java.util.List;

import com.java.model.Emp;

public interface EmpServices {
	Emp create(Emp emp);
	Emp update(Emp emp,int empId);
	void delete(int empId);
	Emp getById(int empId);
	List<Emp> getAll();
	
	
	
	

}
