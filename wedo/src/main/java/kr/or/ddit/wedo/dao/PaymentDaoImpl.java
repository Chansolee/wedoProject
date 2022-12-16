package kr.or.ddit.wedo.dao;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.util.SqlMapClientFactory;
import kr.or.ddit.wedo.vo.PaymentVO;

public class PaymentDaoImpl implements IPaymentDao {

	private static PaymentDaoImpl dao;
	SqlMapClient smc;

	private PaymentDaoImpl() {

		smc = SqlMapClientFactory.getSqlMapClient();
	}

	public static PaymentDaoImpl getInstance() {
		if (dao == null)
			dao = new PaymentDaoImpl();

		return dao;

	}

	@Override
	public void insertPayment(PaymentVO payVO) {
		
		try {
			smc.insert("payment.insertPayment", payVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
