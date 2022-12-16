package kr.or.ddit.wedo.vo;

public class CartClassVO {
	private String tuition;      //강의테이블 데이터
	private String class_name;   //강의테이블 데이터
	private String cart_no;      //장바구니테이블 데이터
	private String cart_withdrawal; //장바구니테이블 구매여부 데이터
	
	
	public String getCart_withdrawal() {
		return cart_withdrawal;
	}
	public void setCart_withdrawal(String cart_withdrawal) {
		this.cart_withdrawal = cart_withdrawal;
	}
	public String getTuition() {
		return tuition;
	}
	public void setTuition(String tuition) {
		this.tuition = tuition;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public String getCart_no() {
		return cart_no;
	}
	public void setCart_no(String cart_no) {
		this.cart_no = cart_no;
	}
	
	
	
}
