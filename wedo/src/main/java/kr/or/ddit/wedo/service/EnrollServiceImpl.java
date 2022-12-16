package kr.or.ddit.wedo.service;

import kr.or.ddit.wedo.dao.ClassDaoImpl;
import kr.or.ddit.wedo.dao.EnrollDaoImpl;
import kr.or.ddit.wedo.dao.IEnrollDao;

public class EnrollServiceImpl implements IEnrollService {

	private IEnrollDao dao; 

	private static EnrollServiceImpl service;

	public EnrollServiceImpl() {
		dao = EnrollDaoImpl.getInstance(); 
	}

	public static EnrollServiceImpl getInstance() {
		if (service == null)
			service = new EnrollServiceImpl();

		return service;

	}
	
	@Override
	public void insertEnroll(String cart_no) {
		dao.insertEnroll(cart_no);
		
	}

}
