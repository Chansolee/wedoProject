package kr.or.ddit.wedo.service;

import java.util.List;

import kr.or.ddit.wedo.dao.CartDaoImpl;
import kr.or.ddit.wedo.dao.ICartDao;
import kr.or.ddit.wedo.vo.CartVO;


public class CartServiceImpl implements ICartService {

	
	private ICartDao dao; 

	private static CartServiceImpl service;

	

	public static CartServiceImpl getInstance() {
		if (service == null)
			service = new CartServiceImpl();

		return service;

	}

	public CartServiceImpl() {
		dao = CartDaoImpl.getInstance(); 
	}

	@Override
	public int insertCart(CartVO cartVo) {
		return dao.insertCart(cartVo);
	}

	@Override
	public void updateCart(CartVO cartVo) {
		dao.updateCart(cartVo);
		
	}

	@Override
	public int deleteCart(String id) {
		
		return dao.deleteCart(id);
	}

	@Override
	public int deleteCartChoice(String id) {
		
		return dao.deleteCartChoice(id);
	}

	@Override
	public CartVO searchCart(CartVO cartVo) {
		
		return dao.searchCart(cartVo);
	}


	
}
