package kr.or.ddit.wedo.service;

import java.util.List;

import kr.or.ddit.wedo.vo.TeacherVO;

public interface ITeacherService {
	
	public int join(TeacherVO vo);// 회원가입
	
	public TeacherVO teacherIdSearch(String tId); // 아이디중복체크

	public TeacherVO loginTeacher(TeacherVO vo); // 로그인

	public TeacherVO idSearchTeacher(TeacherVO vo);// 아이디찾기

	public TeacherVO passSearchTeacher(TeacherVO vo);// 비번찾기


	public int updateTeacher(TeacherVO vo); // 회원정보수정

	public int updatePassTeacher(TeacherVO vo); //비밀번호수정
	
	public int withDrawalTeacher(TeacherVO vo); //회원탈퇴
	
	public List<TeacherVO> getTeacher(String class_no); // 강사정보 불러오기
	
	public List<TeacherVO> getAllTeacher(); //강사목록 불러오기
	
	public TeacherVO adminGetTeacher(String teacher_id);

}
