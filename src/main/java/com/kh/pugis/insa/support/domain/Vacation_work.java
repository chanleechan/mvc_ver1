package com.kh.pugis.insa.support.domain;

public class Vacation_work {
	private String vacation_applyDay;	// 신청 날짜
	private String emp_code;	// 사번
	private String n_emp_name;	// 사원 명
	private String vacation_startDate;	// 휴가 시작일
	private String vacation_endDate;	// 휴가 끝
	private String vcontent;	// 휴가 사유
	private String status;	// 상태
	private String va_code;
	
	public Vacation_work() {
		
	}

	
	/**
	 * 리스트 조회 시 
	 * @param vacation_code
	 * @param emp_code
	 * @param n_emp_name
	 * @param vacation_startDate
	 * @param vacation_endDate
	 * @param vcontent
	 * @param state
	 */
	public Vacation_work(String vacation_applyDay, String emp_code, String n_emp_name, String vacation_startDate,
			String vacation_endDate, String vcontent, String status, String va_code) {
		
		this.vacation_applyDay = vacation_applyDay;
		this.emp_code = emp_code;
		this.n_emp_name = n_emp_name;
		this.vacation_startDate = vacation_startDate;
		this.vacation_endDate = vacation_endDate;
		this.vcontent = vcontent;
		this.status = status;
		this.va_code = va_code;
	}

	public void setVacation_applyDay(String vacation_applyDay) {
		this.vacation_applyDay = vacation_applyDay;
	}


	public String getVacation_applyDay() {
		return vacation_applyDay;
	}


	
	public String getVa_code() {
		return va_code;
	}
	
	public void setVa_code(String va_code) {
		this.va_code = va_code;
	}

	public String getEmp_code() {
		return emp_code;
	}

	public void setEmp_code(String emp_code) {
		this.emp_code = emp_code;
	}

	public String getN_emp_name() {
		return n_emp_name;
	}

	public void setN_emp_name(String n_emp_name) {
		this.n_emp_name = n_emp_name;
	}

	public String getVacation_startDate() {
		return vacation_startDate;
	}

	public void setVacation_startDate(String vacation_startDate) {
		this.vacation_startDate = vacation_startDate;
	}

	public String getVacation_endDate() {
		return vacation_endDate;
	}

	public void setVacation_endDate(String vacation_endDate) {
		this.vacation_endDate = vacation_endDate;
	}

	public String getVcontent() {
		return vcontent;
	}

	public void setVcontent(String vcontent) {
		this.vcontent = vcontent;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Vacation_work [vacation_code=" + vacation_applyDay + ", emp_code=" + emp_code + ", n_emp_name=" + n_emp_name
				+ ", vacation_startDate=" + vacation_startDate + ", vacation_endDate=" + vacation_endDate
				+ ", vcontent=" + vcontent + ", status=" + status + "]";
	}

	

	
	
}
