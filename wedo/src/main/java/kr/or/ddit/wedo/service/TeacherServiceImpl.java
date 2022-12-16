package kr.or.ddit.wedo.service;

import java.util.List;

import kr.or.ddit.wedo.dao.ITeacherDao;
import kr.or.ddit.wedo.dao.TeacherDaoImpl;
import kr.or.ddit.wedo.vo.TeacherVO;

public class TeacherServiceImpl implements ITeacherService {


	private ITeacherDao dao; 

	private static TeacherServiceImpl service;

	

	public static TeacherServiceImpl getInstance() {
		if (service == null)
			service = new TeacherServiceImpl();

		return service;

	}

	public TeacherServiceImpl() {
		dao = TeacherDaoImpl.getInstance(); 
	}

	@Override
	public TeacherVO teacherIdSearch(String tId) {
		
		return dao.teacherIdSearch(tId);
	}

	@Override
	public TeacherVO loginTeacher(TeacherVO vo) {
		return dao.loginTeacher(vo);
	}

	@Override
	public int join(TeacherVO vo) {
		// TODO Auto-generated method stub
		return dao.join(vo);
	}

	@Override
	public TeacherVO idSearchTeacher(TeacherVO vo) {
		// TODO Auto-generated method stub
		return dao.idSearchTeacher(vo);
	}

	@Override
	public TeacherVO passSearchTeacher(TeacherVO vo) {
		// TODO Auto-generated method stub
		return dao.passSearchTeacher(vo);
	}

	@Override
	public int updateTeacher(TeacherVO vo) {
		// TODO Auto-generated method stub
		return dao.updateTeacher(vo);
	}

	@Override
	public int updatePassTeacher(TeacherVO vo) {
		// TODO Auto-generated method stub
		return dao.updatePassTeacher(vo);
	}
	
	
	@Override
	public int withDrawalTeacher(TeacherVO vo) {
		// TODO Auto-generated method stub
		return dao.withDrawalTeacher(vo);
	}

	@Override
	public List<TeacherVO> getTeacher(String class_no) {
		// TODO Auto-generated method stub
		return dao.getTeacher(class_no);
	}

	@Override
	public List<TeacherVO> getAllTeacher() {
		return dao.getAllTeacher();
	}

	@Override
	public TeacherVO adminGetTeacher(String teacher_id) {
		return dao.adminGetTeacher(teacher_id);
	}


	
}
