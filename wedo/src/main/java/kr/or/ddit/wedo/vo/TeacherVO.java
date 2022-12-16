package kr.or.ddit.wedo.vo;

public class TeacherVO {
	private String teacher_id;
	private String teacher_name;
	private String teacher_pass;
	private String teacher_tel;
	private String teacher_mail;
	private int teacher_withdrawal;
	
	
	public int getTeacher_withdrawal() {
		return teacher_withdrawal;
	}
	public void setTeacher_withdrawal(int teacher_withdrawal) {
		this.teacher_withdrawal = teacher_withdrawal;
	}
	public String getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	public String getTeacher_pass() {
		return teacher_pass;
	}
	public void setTeacher_pass(String teacher_pass) {
		this.teacher_pass = teacher_pass;
	}
	public String getTeacher_tel() {
		return teacher_tel;
	}
	public void setTeacher_tel(String teacher_tel) {
		this.teacher_tel = teacher_tel;
	}
	public String getTeacher_mail() {
		return teacher_mail;
	}
	public void setTeacher_mail(String teacher_mail) {
		this.teacher_mail = teacher_mail;
	}
}
