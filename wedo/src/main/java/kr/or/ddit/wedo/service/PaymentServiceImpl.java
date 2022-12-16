package kr.or.ddit.wedo.service;

import kr.or.ddit.wedo.dao.IPaymentDao;
import kr.or.ddit.wedo.dao.PaymentDaoImpl;
import kr.or.ddit.wedo.vo.PaymentVO;

public class PaymentServiceImpl implements IPaymentService {


	private IPaymentDao dao; 

	private static PaymentServiceImpl service;

	

	public static PaymentServiceImpl getInstance() {
		if (service == null)
			service = new PaymentServiceImpl();

		return service;

	}

	public PaymentServiceImpl() {
		dao = PaymentDaoImpl.getInstance(); 
	}

	@Override
	public void insertPayment(PaymentVO payVO) {
		dao.insertPayment(payVO);
	}
	
	


}
