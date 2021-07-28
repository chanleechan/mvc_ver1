package com.kh.pugis.insa.support.domain;

public class member_Account {
	String emp_code;
	String f_emp_pass;
	int f_service_point;
	String emp_id;
	public String getEmp_code() {
		return emp_code;
	}
	public void setEmp_code(String emp_code) {
		this.emp_code = emp_code;
	}
	public String getEmp_pass() {
		return f_emp_pass;
	}
	public void setEmp_pass(String emp_pass) {
		this.f_emp_pass = emp_pass;
	}
	public int getF_service_point() {
		return f_service_point;
	}
	public void setF_service_point(int f_service_point) {
		this.f_service_point = f_service_point;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}

}
