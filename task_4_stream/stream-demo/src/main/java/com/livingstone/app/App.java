package com.livingstone.app;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;

import java.util.stream.Collectors;
import java.util.stream.*;
import java.util.DoubleSummaryStatistics;
import java.util.Comparator;


public class App {
	
    public static void main( String[] args ){
    	List<Employee> empList = generateRandomEmployees(100);
    	Stream<Employee> stream = empList.stream();
    	
    	//1.Employee earning more than 1000 and joined 3 years ago
    	List<Employee> results = stream
    			.filter(emp-> emp.getSalary()>1000 && getDiffYears(emp.getJoiningDate(), new Date())>=3)
    			.collect(Collectors.toList());
    	
    	printList(results);
    	
    	//2.Employee grouped by gender with maximum salary
    	stream = empList.stream();
    	Map<String , Employee> results2 = stream
    			.collect(Collectors.groupingBy(Employee::getGender, 
    					Collectors.collectingAndThen(
    							Collectors.reducing( (Employee f1, Employee f2) -> f1.getSalary() > f2.getSalary() ? f1 : f2), Optional::get)));
    	System.out.println(results2);
    	
    	//3.Employee name reversed 
    	stream = empList.stream();
    	List<String> results3 = stream
    			.map(emp -> (new StringBuilder(emp.getName()).reverse().toString()) )
    			.collect(Collectors.toList());
    	System.out.println(results3);
    	
    	
    	//4. Other field "randomString"
    	stream = empList.stream();
    	List<String> result4 = stream.map(emp -> (emp.getName()+emp.getJoiningDate()).replace(" ", "")).collect(Collectors.toList());
    	System.out.println(result4);
    	printList(empList);
    }
    
	//Custom method Random Employee Generation based on "num" integer;
	public static Employee generateRandomEmployee(int num){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, (num*13)%120);
		cal.add(Calendar.YEAR, -(num)%6);
		Date date = cal.getTime();
		return new Employee(
				num*123,
				"name"+num, 
				(num%3)==0 ? ("Male"): ("Female"),
				num*100,
				date,
				"state"+(num%30)		
				);
	}
	
	
	
	//Generates "size" length list of Random Employees
	public static ArrayList<Employee> generateRandomEmployees(int size){
		ArrayList<Employee> list = new ArrayList<Employee>();
		for(int i=1;i<=size;i+=1)
			list.add(generateRandomEmployee(i));
		return list;
	}
	    
    //Prints Employee List to Console
  	public static void printList(List<Employee> empList){
  		
  		System.out.println(":::::::EMPLOYEE LIST:::::::");
      	for(Employee each: empList){
      		System.out.println(each);
      	}
      	System.out.println("No of Rows:"+empList.size());
  	}
  	
    
    //Returns difference of dates in years
  	public static long getDiffYears(Date a, Date b) {
  		long diff = b.getTime() - a.getTime();
  		return (diff / (24 * 60 * 60 * 1000))/365;
    }
}
