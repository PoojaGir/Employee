package com.java.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.model.Emp;
import com.java.repository.EmpRepository;
@Service
public class EmpServiceImpl implements EmpServices {
	private EmpRepository empRepository;
	
	@Autowired
	public EmpServiceImpl(EmpRepository empRepository) {
		 this.empRepository = empRepository;
	 }

	@Override
	public Emp create(Emp emp) {
		
		return this.empRepository.save(emp);
	}

	@Override
	public Emp update(Emp emp, int empId) {
		Emp emp1=this.empRepository.findById(empId).orElseThrow(()-> new RuntimeException("Emp not found"));
		emp1.setName(emp.getName());
		emp1.setSalary(emp.getSalary());
		
		Emp save=this.empRepository.save(emp1);
		return save;
		
	}

	@Override
	public void delete(int empId) {
		Emp emp1=this.empRepository.findById(empId).orElseThrow(()-> new RuntimeException("Emp not found"));
		this.empRepository.delete(emp1);
		
	}

	@Override
	public Emp getById(int empId) {
		Emp emp1=this.empRepository.findById(empId).orElseThrow(()-> new RuntimeException("Emp not found"));
		
		return emp1;
	}

	@Override
	public List<Emp> getAll() {
		List<Emp> all=this.empRepository.findAll();
		return all;
	}
	

}
