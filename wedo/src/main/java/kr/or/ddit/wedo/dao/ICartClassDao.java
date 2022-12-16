package kr.or.ddit.wedo.dao;

import java.util.List;

import kr.or.ddit.wedo.vo.CartClassVO;

public interface ICartClassDao {
	
	public List<CartClassVO> getCartClass(String mem_id);
}
