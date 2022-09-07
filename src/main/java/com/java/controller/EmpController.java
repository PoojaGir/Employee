package com.java.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.model.Emp;
import com.java.services.EmpServices;


@RestController
@RequestMapping("/emp")
public class EmpController {
 
	@Autowired
	private EmpServices empService;
	

	//create
	@PostMapping
	public ResponseEntity<Emp> createEmp(@RequestBody Emp emp){
		Emp emp1=this.empService.create(emp);
		return new ResponseEntity<>(emp1, HttpStatus.CREATED);
	}
	
	//update
	@PutMapping("/{empId}")
	public ResponseEntity<Emp> updateEmp(@RequestBody Emp emp,@PathVariable int empId){
		Emp emp1=this.empService.update(emp,empId);
		return new ResponseEntity<>(emp1, HttpStatus.OK);
	}
	
	//delete
	@DeleteMapping("/{empId}")
	public ResponseEntity<Map<String,String>>updateEmp(@PathVariable int empId){
		this.empService.delete(empId);
		Map<String,String> message=Map.of("message","employee deleted successfully");
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
	
	//get single emp
	@GetMapping("/{empId}")
	public ResponseEntity<Emp> getEmp(@PathVariable int empId){
		Emp emp=this.empService.getById(empId);
		
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}
	
	// to get all emp
	
	@GetMapping
	public ResponseEntity<List<Emp>> getAll() {
		List<Emp> all=this.empService.getAll();
		return new ResponseEntity<>(all, HttpStatus.OK);
	}
}
