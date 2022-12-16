package kr.or.ddit.wedo.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.util.SqlMapClientFactory;
import kr.or.ddit.wedo.vo.EnrollClassVO;

public class EnrollClassDaoImpl implements IEnrollClassDao {
	private static EnrollClassDaoImpl dao;
	SqlMapClient smc;

	private EnrollClassDaoImpl() {

		smc = SqlMapClientFactory.getSqlMapClient();
	}

	public static EnrollClassDaoImpl getInstance() {
		if (dao == null)
			dao = new EnrollClassDaoImpl();

		return dao;

	}

	@Override
	public List<EnrollClassVO> enrollSelect(String mem_id) {
		
		List<EnrollClassVO> ecVo = null;
		
		try {
			ecVo = smc.queryForList("enrollclass.enrollSelect", mem_id);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return ecVo;
	}
	
	
}
