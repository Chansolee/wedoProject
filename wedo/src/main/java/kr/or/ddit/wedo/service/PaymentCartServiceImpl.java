package kr.or.ddit.wedo.service;

import kr.or.ddit.wedo.dao.IPaymentCartDao;
import kr.or.ddit.wedo.dao.PaymentCartDaoImpl;

public class PaymentCartServiceImpl implements IPaymentCartService {
	private IPaymentCartDao dao; 

	private static PaymentCartServiceImpl service;
	
	private PaymentCartServiceImpl() {
		dao = PaymentCartDaoImpl.getInstance();
	}
	

	public static PaymentCartServiceImpl getInstance() {
		if (service == null)
			service = new PaymentCartServiceImpl();

		return service;

	}
}
