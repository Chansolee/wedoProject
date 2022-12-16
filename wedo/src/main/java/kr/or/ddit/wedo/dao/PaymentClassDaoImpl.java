package kr.or.ddit.wedo.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.util.SqlMapClientFactory;
import kr.or.ddit.wedo.vo.PaymentClassVO;

public class PaymentClassDaoImpl implements IPaymentClassDao {
	private static PaymentClassDaoImpl dao;
	SqlMapClient smc;

	private PaymentClassDaoImpl() {

		smc = SqlMapClientFactory.getSqlMapClient();
	}

	public static PaymentClassDaoImpl getInstance() {
		if (dao == null) dao = new PaymentClassDaoImpl();

		return dao;

	}

	@Override
	public List<PaymentClassVO> paymentSelect(String mem_id) {
		
		List<PaymentClassVO> pcVo = null; 
		
		try {
			pcVo = smc.queryForList("paymentclass.paymentSelect", mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pcVo;
	}
}
