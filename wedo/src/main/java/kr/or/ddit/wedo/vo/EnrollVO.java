package kr.or.ddit.wedo.vo;

public class EnrollVO {
	private String mem_id;
	private int enr_no;
	private String class_no;
	private String enr_period;
	private int pay_id;


	public int getPay_id() {
		return pay_id;
	}
	public void setPay_id(int pay_id) {
		this.pay_id = pay_id;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public int getEnr_no() {
		return enr_no;
	}
	public void setEnr_no(int enr_no) {
		this.enr_no = enr_no;
	}
	public String getClass_no() {
		return class_no;
	}
	public void setClass_no(String class_no) {
		this.class_no = class_no;
	}
	public String getEnr_period() {
		return enr_period;
	}
	public void setEnr_period(String enr_period) {
		this.enr_period = enr_period;
	}
}
