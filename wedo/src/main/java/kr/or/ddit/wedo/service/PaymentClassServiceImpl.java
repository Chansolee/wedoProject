package kr.or.ddit.wedo.service;

import java.util.List;

import kr.or.ddit.wedo.dao.IPaymentClassDao;
import kr.or.ddit.wedo.dao.PaymentClassDaoImpl;
import kr.or.ddit.wedo.vo.PaymentClassVO;

public class PaymentClassServiceImpl implements IPaymentClassService{
	private IPaymentClassDao dao; 

	private static PaymentClassServiceImpl service;
	
	private PaymentClassServiceImpl() {
		dao = PaymentClassDaoImpl.getInstance();
	}
	

	public static PaymentClassServiceImpl getInstance() {
		if (service == null)
			service = new PaymentClassServiceImpl();

		return service;

	}



	@Override
	public List<PaymentClassVO> paymentSelect(String mem_id) {
		return dao.paymentSelect(mem_id);
	}

	
}
