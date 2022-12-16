package kr.or.ddit.wedo.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.util.SqlMapClientFactory;
import kr.or.ddit.wedo.vo.CartVO;
import kr.or.ddit.wedo.vo.MemberVO;

public class CartDaoImpl implements ICartDao {



	private static CartDaoImpl dao;
	SqlMapClient smc;

	private CartDaoImpl() {

		smc = SqlMapClientFactory.getSqlMapClient();
	}

	public static CartDaoImpl getInstance() {
		if (dao == null)
			dao = new CartDaoImpl();

		return dao;

	}

	@Override
	public int insertCart(CartVO cartVo) {
		int cnt = 0;
		try {
			Object obj = smc.insert("cart.insertCart", cartVo);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public void updateCart(CartVO cartVo) {
		
		try {
			Object obj = smc.update("cart.updateCart", cartVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public int deleteCart(String id) {  //장바구니
		int cnt = 0;

		try {
			cnt = smc.delete("cart.deleteCart", id);// 정상적으로 실행되면 1을 반환

		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}

		return cnt;
	}
	
	@Override
	public int deleteCartChoice(String id) {  //장바구니
		int cnt = 0;

		try {
			cnt = smc.delete("cart.deleteCartChoice", id);// 정상적으로 실행되면 1을 반환

		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}

		return cnt;
	}

	@Override
	public CartVO searchCart(CartVO cartVo) {
		CartVO vo = null;
		try {
			vo = (CartVO) smc.queryForObject("cart.searchCart",cartVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}
	

}
