package kr.or.ddit.wedo.dao;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.util.SqlMapClientFactory;

public class PayWayDaoImpl implements IPayWayDao {

	private static PayWayDaoImpl dao;
	SqlMapClient smc;

	private PayWayDaoImpl() {

		smc = SqlMapClientFactory.getSqlMapClient();
	}

	public static PayWayDaoImpl getInstance() {
		if (dao == null)
			dao = new PayWayDaoImpl();

		return dao;

	}
	
	
}
