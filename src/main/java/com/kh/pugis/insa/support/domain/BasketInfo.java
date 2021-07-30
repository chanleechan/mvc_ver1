package com.kh.pugis.insa.support.domain;
//업무기구 정보성클래스
public class BasketInfo {
	String basket_seq;
	String emp_code;
	int h_app_amount;
	String book_code;
	String b_app_code;
	String h_app_code;
	int book_amount;
	int b_app_amount;
	String payment;
	
	Book book;
	H_Appliance h_appliance;
	B_Appliance b_appliance;
	public String getBasket_seq() {
		return basket_seq;
	}
	public void setBasket_seq(String basket_seq) {
		this.basket_seq = basket_seq;
	}
	public String getEmp_code() {
		return emp_code;
	}
	public void setEmp_code(String emp_code) {
		this.emp_code = emp_code;
	}
	public int getH_app_amount() {
		return h_app_amount;
	}
	public void setH_app_amount(int h_app_amount) {
		this.h_app_amount = h_app_amount;
	}
	public String getBook_code() {
		return book_code;
	}
	public void setBook_code(String book_code) {
		this.book_code = book_code;
	}
	public String getB_app_code() {
		return b_app_code;
	}
	public void setB_app_code(String b_app_code) {
		this.b_app_code = b_app_code;
	}
	public String getH_app_code() {
		return h_app_code;
	}
	public void setH_app_code(String h_app_code) {
		this.h_app_code = h_app_code;
	}
	public int getBook_amount() {
		return book_amount;
	}
	public void setBook_amount(int book_amount) {
		this.book_amount = book_amount;
	}
	public int getB_app_amount() {
		return b_app_amount;
	}
	public void setB_app_amount(int b_app_amount) {
		this.b_app_amount = b_app_amount;
	}
	
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public H_Appliance getH_appliance() {
		return h_appliance;
	}
	public void setH_appliance(H_Appliance h_appliance) {
		this.h_appliance = h_appliance;
	}
	public B_Appliance getB_appliance() {
		return b_appliance;
	}
	public void setB_appliance(B_Appliance b_appliance) {
		this.b_appliance = b_appliance;
	}
	
	

	
}
