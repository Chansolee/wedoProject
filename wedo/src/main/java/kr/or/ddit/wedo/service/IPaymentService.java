package kr.or.ddit.wedo.service;

import kr.or.ddit.wedo.vo.PaymentVO;

public interface IPaymentService {
	
	/** 장바구니번호, 사용자정보를 PaymentVO에 담아 데이터를 insert한다
	 * 
	 * 
	 * @param payVO
	 */
	public void insertPayment(PaymentVO payVO);
}
