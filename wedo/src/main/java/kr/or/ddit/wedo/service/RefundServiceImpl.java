package kr.or.ddit.wedo.service;

import kr.or.ddit.wedo.dao.IRefundDao;
import kr.or.ddit.wedo.dao.RefundDaoImpl;

public class RefundServiceImpl implements IRefundService {


	private IRefundDao dao; 

	private static RefundServiceImpl service;

	

	public static RefundServiceImpl getInstance() {
		if (service == null)
			service = new RefundServiceImpl();

		return service;

	}

	public RefundServiceImpl() {
		dao = RefundDaoImpl.getInstance(); 
	}
		
	
}
