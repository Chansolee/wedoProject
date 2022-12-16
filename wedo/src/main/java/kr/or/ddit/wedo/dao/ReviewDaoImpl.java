package kr.or.ddit.wedo.dao;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.util.SqlMapClientFactory;

public class ReviewDaoImpl implements IReviewDao {

	private static ReviewDaoImpl dao;
	SqlMapClient smc;

	private ReviewDaoImpl() {

		smc = SqlMapClientFactory.getSqlMapClient();
	}

	public static ReviewDaoImpl getInstance() {
		if (dao == null)
			dao = new ReviewDaoImpl();

		return dao;

	}
	
	
}
