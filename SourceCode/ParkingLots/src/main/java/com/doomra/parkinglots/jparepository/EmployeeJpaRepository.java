package com.doomra.parkinglots.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doomra.parkinglots.entities.Employee;

public interface EmployeeJpaRepository extends JpaRepository<Employee, Integer>{
	
	public Employee findByEmployeeId(long employeeId);

}
