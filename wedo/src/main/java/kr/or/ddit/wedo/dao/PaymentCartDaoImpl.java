package kr.or.ddit.wedo.dao;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.util.SqlMapClientFactory;

public class PaymentCartDaoImpl implements IPaymentCartDao {
	private static PaymentCartDaoImpl dao;
	SqlMapClient smc;

	private PaymentCartDaoImpl() {

		smc = SqlMapClientFactory.getSqlMapClient();
	}
 
	public static PaymentCartDaoImpl getInstance() {
		if (dao == null) dao = new PaymentCartDaoImpl();

		return dao;

	}
}
