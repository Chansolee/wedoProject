package kr.or.ddit.wedo.dao;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.util.SqlMapClientFactory;

public class RefundDaoImpl implements IRefundDao {


	private static RefundDaoImpl dao;
	SqlMapClient smc;

	private RefundDaoImpl() {

		smc = SqlMapClientFactory.getSqlMapClient();
	}

	public static RefundDaoImpl getInstance() {
		if (dao == null)
			dao = new RefundDaoImpl();

		return dao;

	}
	
	
}
