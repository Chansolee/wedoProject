package kr.or.ddit.wedo.vo;

public class ReviewVO {
	private String review_no;
	private String review_title;
	private String review_content;
	private int review_star;
	private String review_date;
	private int enr_no;
	
	public String getReview_no() {
		return review_no;
	}
	public void setReview_no(String review_no) {
		this.review_no = review_no;
	}
	public String getReview_title() {
		return review_title;
	}
	public void setReview_title(String review_title) {
		this.review_title = review_title;
	}
	public String getReview_content() {
		return review_content;
	}
	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}
	public int getReview_star() {
		return review_star;
	}
	public void setReview_star(int review_star) {
		this.review_star = review_star;
	}
	public String getReview_date() {
		return review_date;
	}
	public void setReview_date(String review_date) {
		this.review_date = review_date;
	}
	public int getEnr_no() {
		return enr_no;
	}
	public void setEnr_no(int enr_no) {
		this.enr_no = enr_no;
	}
}
