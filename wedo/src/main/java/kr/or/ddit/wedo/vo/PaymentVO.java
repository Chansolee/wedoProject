package kr.or.ddit.wedo.vo;

public class PaymentVO {
	private String pay_id;
	private String pay_date;
	private String pway_code;
	private String cart_no;
	private String mem_id;
	 
	public String getPay_id() {
		return pay_id;
	}
	public void setPay_id(String pay_id) {
		this.pay_id = pay_id;
	}
	public String getPay_date() {
		return pay_date;
	}
	public void setPay_date(String pay_date) {
		this.pay_date = pay_date;
	}
	public String getPway_code() {
		return pway_code;
	}
	public void setPway_code(String pway_code) {
		this.pway_code = pway_code;
	}
	public String getCart_no() {
		return cart_no;
	}
	public void setCart_no(String cart_no) {
		this.cart_no = cart_no;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
}
