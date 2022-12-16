package kr.or.ddit.wedo.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.util.SqlMapClientFactory;
import kr.or.ddit.wedo.vo.TeacherVO;

public class TeacherDaoImpl implements ITeacherDao {

	private static TeacherDaoImpl dao;
	SqlMapClient smc;

	private TeacherDaoImpl() {

		smc = SqlMapClientFactory.getSqlMapClient();
	}

	public static TeacherDaoImpl getInstance() {
		if (dao == null)
			dao = new TeacherDaoImpl();

		return dao;

	}

	@Override
	public TeacherVO teacherIdSearch(String tId) {  //아이디중복체크
		TeacherVO tVo = null;
		
		try {
			tVo = (TeacherVO) smc.queryForObject("teacher.teacherIdSearch", tId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return tVo;
	}

	@Override
	public TeacherVO loginTeacher(TeacherVO vo) { //로그인
		TeacherVO tVo = null;
		
		try {
			tVo = (TeacherVO) smc.queryForObject("teacher.loginTeacher", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tVo;
	}

	@Override
	public int join(TeacherVO vo) { //회원가입
		int cnt = 0;

		try {
			Object obj = smc.insert("teacher.insertTeacher", vo);
			if (obj == null)
				cnt++;
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}

		return cnt;
	}
	@Override
	public TeacherVO idSearchTeacher(TeacherVO vo) { //아이디찾기
		TeacherVO teacher = null;
		try {
			teacher = (TeacherVO) smc.queryForObject("teacher.idSearchTeacher",vo);
		} catch (SQLException e) {
			teacher = null;
			e.printStackTrace();
		}

		return teacher;
	}
	

	@Override
	public TeacherVO passSearchTeacher(TeacherVO vo) { //비번찾기
		TeacherVO teacher = null;
		try {
			teacher = (TeacherVO) smc.queryForObject("teacher.passSearchTeacher",vo);
		} catch (SQLException e) {
			teacher = null;
			e.printStackTrace();
		}

		return teacher;
	}
	@Override
	public int updateTeacher(TeacherVO vo) { //강사정보수정
		int cnt = 0;

		try {
			cnt = smc.update("teacher.updateTeacher", vo);

		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}

		return cnt;
	}
	
	
	
	@Override
	public int updatePassTeacher(TeacherVO vo) { //비밀번호수정
		int cnt = 0;

		try {
			cnt = smc.update("teacher.updatePassTeacher", vo);

		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}

		return cnt;
	}
	
	
	@Override
	public int withDrawalTeacher(TeacherVO vo) { //강사탈퇴
		int cnt = 0;

		try {
			cnt = smc.update("teacher.withDrawalTeacher", vo);

		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}

		return cnt;
	}

	@Override
	public List<TeacherVO> getTeacher(String class_no) {
		List<TeacherVO> list = null;
		
		try {
			list = smc.queryForList("teacher.getTeacher",class_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<TeacherVO> getAllTeacher() { //관리자-강사목록
		List<TeacherVO> tlist = null;
		try {
			tlist = smc.queryForList("teacher.getAllTeacher");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tlist;
	}

	@Override
	public TeacherVO adminGetTeacher(String teacher_id) {
		TeacherVO tVo = null;
		
		try {
			tVo=(TeacherVO)smc.queryForObject("teacher.adminGetTeacher", teacher_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tVo;
	}

	


}
