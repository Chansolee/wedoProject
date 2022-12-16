package kr.or.ddit.wedo.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.util.SqlMapClientFactory;
import kr.or.ddit.wedo.vo.CartClassVO;

public class CartClassDaoImpl implements ICartClassDao {
	
	private static CartClassDaoImpl dao;
	SqlMapClient smc;

	private CartClassDaoImpl() {

		smc = SqlMapClientFactory.getSqlMapClient();
	}

	public static CartClassDaoImpl getInstance() {
		if (dao == null)
			dao = new CartClassDaoImpl();

		return dao;

	}

	@Override
	public List<CartClassVO> getCartClass(String mem_id) {
		List<CartClassVO> ccVo = null;
		
		try {
			ccVo = smc.queryForList("cartclass.getCartClass",mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ccVo;
	}
}
