package com.kh.pugis.insa.support.domain;

public class Worker {
	private String today;
	private String dept;
	private String emp_code;
	private String o_emp_name;
	private String time_now;
	private String status;
	
	
	public Worker() {
		
	}

	public Worker(String emp_code) {
		
		this.emp_code = emp_code;
	}

	public Worker(String today, String dept, String emp_code, String o_emp_name, String time_now2, String status) {
		
		this.today = today;
		this.dept = dept;
		this.emp_code = emp_code;
		this.o_emp_name = o_emp_name;
		this.time_now = time_now2;
		this.status = status;
		
	}



	public String getToday() {
		return today;
	}

	public void setToday(String today) {
		this.today = today;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getEmp_code() {
		return emp_code;
	}

	public void setEmp_code(String emp_code) {
		this.emp_code = emp_code;
	}

	public String getO_emp_name() {
		return o_emp_name;
	}

	public void setO_emp_name(String o_emp_name) {
		this.o_emp_name = o_emp_name;
	}

	public String getTime_now() {
		return time_now;
	}

	public void setTime_now(String time_now) {
		this.time_now = time_now;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Worker [today=" + today + ", dept=" + dept + ", emp_code=" + emp_code + ", o_emp_name=" + o_emp_name
				+ ", time_now=" + time_now + ", status=" + status + "]";
	}
	
	
}
