package com.doomra.parkinglots.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.doomra.parkinglots.entities.Employee;
import com.doomra.parkinglots.entities.Vehicle;
import com.doomra.parkinglots.service.EmployeeService;
import com.doomra.parkinglots.service.VehicleService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@Autowired
	private VehicleService vehicleService;
	
	@RequestMapping("/employees")
	public List<Employee> getAllEmployees(){
		return empService.getAllEmployees();
	}
	
	@RequestMapping("/employees/{employeeId}")
	public Employee getEmployeeByEmployeeId(@PathVariable Long employeeId){
		return empService.getEmployeeByEmployeeId(employeeId);
	}
	
	@RequestMapping("/employees/{employeeId}/vehicles")
	public List<Vehicle> getAllVehiclesByEmployeeId(@PathVariable long employeeId){
		return vehicleService.getVehiclesByEmployeeId(employeeId);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/employees")
	public void addEmployee(@RequestBody Employee employee){
		empService.addEmployee(employee);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/employees/{employeeId}")
	public void addEmployee(@PathVariable long employeeId, @RequestBody Employee employee){
		empService.updateEmployee(employee);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/employees/{employeeId}")
	public void deleteEmployee(@PathVariable long employeeId){
		empService.deleteEmployeeByEmployeeId(employeeId);
	}

}
