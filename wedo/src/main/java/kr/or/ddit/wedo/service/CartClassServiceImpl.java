package kr.or.ddit.wedo.service;

import java.util.List;

import kr.or.ddit.wedo.dao.CartClassDaoImpl;
import kr.or.ddit.wedo.dao.ICartClassDao;
import kr.or.ddit.wedo.vo.CartClassVO;

public class CartClassServiceImpl implements ICartClassService {
	private ICartClassDao dao; 

	private static CartClassServiceImpl service;

	

	public static CartClassServiceImpl getInstance() {
		if (service == null)
			service = new CartClassServiceImpl();

		return service;

	}

	private CartClassServiceImpl() {
		dao = CartClassDaoImpl.getInstance(); 
	}

	@Override
	public List<CartClassVO> getCartClass(String mem_id) {
		return dao.getCartClass(mem_id);
	}
}
