package kr.or.ddit.wedo.service;

import java.util.List;

import kr.or.ddit.wedo.vo.CartClassVO;

public interface ICartClassService {
	public List<CartClassVO> getCartClass(String mem_id);
}
