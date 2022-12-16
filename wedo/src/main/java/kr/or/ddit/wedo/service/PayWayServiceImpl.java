package kr.or.ddit.wedo.service;

import kr.or.ddit.wedo.dao.IPayWayDao;
import kr.or.ddit.wedo.dao.PayWayDaoImpl;

public class PayWayServiceImpl implements IPayWayService {


	private IPayWayDao dao; 

	private static PayWayServiceImpl service;

	

	public static PayWayServiceImpl getInstance() {
		if (service == null)
			service = new PayWayServiceImpl();

		return service;

	}

	public PayWayServiceImpl() {
		dao = PayWayDaoImpl.getInstance(); 
	}
	
	

	
}
