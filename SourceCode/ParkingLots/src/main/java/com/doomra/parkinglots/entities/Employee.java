package com.doomra.parkinglots.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.doomra.parkinglots.enums.ReservationStatus;

@Entity
public class Employee {
	
	public Employee(){}
	
	public Employee(long employeeId, String empName, String mobile, String email){
		this.employeeId = employeeId;
		this.empName = empName;
		this.mobile = mobile;
		this.email = email;
	}
	
	public Employee(long employeeId, String empName, String mobile, String email, ReservationStatus reservationStatus){
		this.employeeId = employeeId;
		this.empName = empName;
		this.mobile = mobile;
		this.email = email;
		this.reservationStatus = reservationStatus.toString();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "Employee_ID", nullable = false)
	private long employeeId;
	@Column(name = "Employee_Name", nullable = false)
	private String empName;
	@Column(name = "Employee_Mobile", nullable = false)
	private String mobile;
	@Column(name = "Employee_Email", nullable = false)
	private String email;
	private String reservationStatus=ReservationStatus.UNRESERVED.toString();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getReservationStatus() {
		return reservationStatus;
	}
	public void setReservationStatus(String reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

}
