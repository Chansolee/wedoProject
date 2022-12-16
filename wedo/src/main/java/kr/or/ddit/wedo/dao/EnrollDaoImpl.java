package kr.or.ddit.wedo.dao;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.util.SqlMapClientFactory;

public class EnrollDaoImpl implements IEnrollDao {


	private static EnrollDaoImpl dao;
	SqlMapClient smc;

	private EnrollDaoImpl() {

		smc = SqlMapClientFactory.getSqlMapClient();
	}

	public static EnrollDaoImpl getInstance() {
		if (dao == null)
			dao = new EnrollDaoImpl();

		return dao;

	}

	@Override
	public void insertEnroll(String cart_no) {
		try {
			smc.insert("enroll.insertEnroll",cart_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

	
}
