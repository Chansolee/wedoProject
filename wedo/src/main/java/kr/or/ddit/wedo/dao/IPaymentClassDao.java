package kr.or.ddit.wedo.dao;

import java.util.List;

import kr.or.ddit.wedo.vo.PaymentClassVO;

public interface IPaymentClassDao {
	
	/** 사용자의 id를 입력하여 결제한 정보를 검색한다.
	 * 
	 * @param mem_id
	 * @return
	 */
	public List<PaymentClassVO> paymentSelect(String mem_id); 
}
