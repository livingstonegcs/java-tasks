package com.livingstone.app;

import java.util.Date;

class Employee{
	long id;
	String name;
	String gender;
	double salary;
	Date joiningDate;
	String state;
	
	publid Employee(){
		
	}
	public String toString(){
		return "[ Id:"+ id +", Name:"+name+", Gender:"+gender+", Salary"+salary+", JoiningDate:"+joiningDate+", State:"+state+" ]";
	}
}