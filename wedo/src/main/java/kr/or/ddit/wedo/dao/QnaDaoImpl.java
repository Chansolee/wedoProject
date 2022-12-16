package kr.or.ddit.wedo.dao;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.util.SqlMapClientFactory;

public class QnaDaoImpl implements IQnaDao {

	private static QnaDaoImpl dao;
	SqlMapClient smc;

	private QnaDaoImpl() {

		smc = SqlMapClientFactory.getSqlMapClient();
	}

	public static QnaDaoImpl getInstance() {
		if (dao == null)
			dao = new QnaDaoImpl();

		return dao;

	}
	
}
