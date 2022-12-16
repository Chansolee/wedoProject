package kr.or.ddit.wedo.vo;

public class RefundVO {
	private String refund_date;
	private String pay_id;
	private int refund_pay;
	
	public String getRefund_date() {
		return refund_date;
	}
	public void setRefund_date(String refund_date) {
		this.refund_date = refund_date;
	}
	public String getPay_id() {
		return pay_id;
	}
	public void setPay_id(String pay_id) {
		this.pay_id = pay_id;
	}
	public int getRefund_pay() {
		return refund_pay;
	}
	public void setRefund_pay(int refund_pay) {
		this.refund_pay = refund_pay;
	}
}
