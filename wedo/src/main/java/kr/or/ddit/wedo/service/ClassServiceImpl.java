package kr.or.ddit.wedo.service;

import java.util.List;

import kr.or.ddit.wedo.dao.ClassDaoImpl;
import kr.or.ddit.wedo.dao.IClassDao;
import kr.or.ddit.wedo.vo.ClassVO;

public class ClassServiceImpl implements IClassService {

	
	private IClassDao dao; 

	private static ClassServiceImpl service;

	

	public static ClassServiceImpl getInstance() {
		if (service == null)
			service = new ClassServiceImpl();

		return service;

	}

	public ClassServiceImpl() {
		dao = ClassDaoImpl.getInstance(); 
	}

	@Override
	public ClassVO getClass(String classNo) {
		return dao.getClass(classNo);
	}

	@Override
	public int insertClass(ClassVO classVo) {
		return dao.insertClass(classVo);
	}

	@Override
	public int deleteClass(String classNo) {
		return dao.deleteClass(classNo);
	}

	@Override
	public int updateClass(ClassVO classVo) {
		return dao.updateClass(classVo);
	}

	@Override
	public List<ClassVO> getClassList() {
		// TODO Auto-generated method stub
		return dao.getClassList();
	}

	@Override
	public List<ClassVO> getCartClass(String mem_id) {
		return dao.getCartClass(mem_id);
	}

	@Override
	public List<ClassVO> getTeacherClassList(String teacherId) {
		return dao.getTeacherClassList(teacherId);
	}


	
	
}
