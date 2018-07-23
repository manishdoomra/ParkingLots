package com.doomra.parkinglots.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doomra.parkinglots.entities.Employee;
import com.doomra.parkinglots.jparepository.EmployeeJpaRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeJpaRepository empRepository;
	
	public List<Employee> getAllEmployees(){
		return empRepository.findAll();
	}
	
	public Employee getEmployeeById(int employeeId){
		return empRepository.findById(employeeId).get();
	}
	
	public Employee getEmployeeByEmployeeId(long employeeId){
		return empRepository.findByEmployeeId(employeeId);
	}
	
	public void addEmployee(Employee employee){
		empRepository.save(employee);
	}
	
	public void updateEmployee(Employee employee){
		empRepository.save(employee);
	}
	
	public void deleteEmployee(int employeeId){
		empRepository.deleteById(employeeId);
	}
	
	public void deleteEmployeeByEmployeeId(long employeeId){
		Employee emp = empRepository.findByEmployeeId(employeeId);
		empRepository.delete(emp);
	}

}
