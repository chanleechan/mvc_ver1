package com.kh.pugis.insa.recruit.domain;

public class NewEmployee {
	private String n_emp_code;
	private String n_emp_name;
	private String n_emp_gender;
	private String n_emp_phone;
	private String n_emp_retire;
	private String n_dept_rank;
	
	
	public NewEmployee(String n_emp_code, String n_emp_name, String n_emp_gender, String n_emp_phone,
			String n_emp_retire, String n_dept_rank) {
		this.n_emp_code = n_emp_code;
		this.n_emp_name = n_emp_name;
		this.n_emp_gender = n_emp_gender;
		this.n_emp_phone = n_emp_phone;
		this.n_emp_retire = n_emp_retire;
		this.n_dept_rank = n_dept_rank;
	}
	
	public String getN_emp_code() {
		return n_emp_code;
	}
	public void setN_emp_code(String n_emp_code) {
		this.n_emp_code = n_emp_code;
	}
	public String getN_emp_name() {
		return n_emp_name;
	}
	public void setN_emp_name(String n_emp_name) {
		this.n_emp_name = n_emp_name;
	}
	public String getN_emp_gender() {
		return n_emp_gender;
	}
	public void setN_emp_gender(String n_emp_gender) {
		this.n_emp_gender = n_emp_gender;
	}
	public String getN_emp_phone() {
		return n_emp_phone;
	}
	public void setN_emp_phone(String n_emp_phone) {
		this.n_emp_phone = n_emp_phone;
	}
	public String getN_emp_retire() {
		return n_emp_retire;
	}
	public void setN_emp_retire(String n_emp_retire) {
		this.n_emp_retire = n_emp_retire;
	}
	public String getN_dept_rank() {
		return n_dept_rank;
	}
	public void setN_dept_rank(String n_dept_rank) {
		this.n_dept_rank = n_dept_rank;
	}
}
