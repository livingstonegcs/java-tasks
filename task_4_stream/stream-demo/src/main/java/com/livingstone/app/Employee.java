package com.livingstone.app;
import java.util.Date;

class Employee implements Comparable<Employee>{
	long id;
	String name;
	String gender;
	double salary;
	Date joiningDate;
	String state;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public Employee(long id, String name, String gender, double salary, Date joiningDate, String state) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.salary = salary;
		this.joiningDate = joiningDate;
		this.state = state;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", gender=" + gender + ", salary=" + salary + ", joiningDate="
				+ joiningDate + ", state=" + state + "]";
	}
	
	@Override
	public int compareTo(Employee emp){
		return name.compareTo(emp.name);
		//return (int)(this.id - emp.id);
	}
	
}