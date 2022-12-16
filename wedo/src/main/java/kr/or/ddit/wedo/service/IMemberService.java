package kr.or.ddit.wedo.service;

import java.util.List;

import kr.or.ddit.wedo.vo.MemberVO;

public interface IMemberService {

	public int join(MemberVO vo);// 회원가입

	public MemberVO idSearch(String id);// 아이디중복확인

	public MemberVO idSearchMember(MemberVO vo);// 아이디찾기

	public MemberVO passSearchMember(MemberVO vo);// 비번찾기

	public MemberVO loginMember(MemberVO vo); // 로그인

	public int updateMember(MemberVO memVo); // 회원정보수정
	
	public int updatePassMember(MemberVO memVo); //비밀번호수정

	public int withDrawalMember(MemberVO memVo); //회원탈퇴
	
	public List<MemberVO> getAllMember();
	
	public MemberVO getMember(String mem_id);
	
	public List<MemberVO> selectClassMember(String id); //강사마이페이지에서 수강생조회
}
