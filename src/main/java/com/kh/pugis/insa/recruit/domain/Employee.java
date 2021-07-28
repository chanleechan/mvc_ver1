package com.kh.pugis.insa.recruit.domain;

public class Employee {
	private String emp_code;
	private String emp_name;
	private String emp_gender;
	private String emp_phone;
	private String emp_retire;
	private int service_point;
	private String manager;
	
	public Employee() {
		
	}
	public Employee(String emp_code, String emp_name, String emp_gender, String emp_phone, String emp_retire,
			int service_point,String manager) {
		this.emp_code = emp_code;
		this.emp_name = emp_name;
		this.emp_gender = emp_gender;
		this.emp_phone = emp_phone;
		this.emp_retire = emp_retire;
		this.service_point = service_point;
		this.manager = manager;
	}
	
	public String getEmp_code() {
		return emp_code;
	}
	public void setEmp_code(String emp_code) {
		this.emp_code = emp_code;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_gender() {
		return emp_gender;
	}
	public void setEmp_gender(String emp_gender) {
		this.emp_gender = emp_gender;
	}
	public String getEmp_phone() {
		return emp_phone;
	}
	public void setEmp_phone(String emp_phone) {
		this.emp_phone = emp_phone;
	}
	public String getEmp_retire() {
		return emp_retire;
	}
	public void setEmp_retire(String emp_retire) {
		this.emp_retire = emp_retire;
	}
	public int getService_point() {
		return service_point;
	}
	public void setService_point(int service_point) {
		this.service_point = service_point;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	
}
