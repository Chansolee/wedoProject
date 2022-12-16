package kr.or.ddit.wedo.service;

import java.util.List;

import kr.or.ddit.wedo.dao.EnrollClassDaoImpl;
import kr.or.ddit.wedo.dao.IEnrollClassDao;
import kr.or.ddit.wedo.vo.EnrollClassVO;

public class EnrollClassServiceImpl implements IEnrollClassService {
	private IEnrollClassDao dao; 

	private static EnrollClassServiceImpl service;

	

	public static EnrollClassServiceImpl getInstance() {
		if (service == null)
			service = new EnrollClassServiceImpl();

		return service;
 
	}

	private EnrollClassServiceImpl() {
		dao = EnrollClassDaoImpl.getInstance(); 
	}

	@Override
	public List<EnrollClassVO> enrollSelect(String mem_id) {
		
		return dao.enrollSelect(mem_id);
	}
}
