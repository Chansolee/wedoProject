package kr.or.ddit.wedo.service;

import java.util.List;

import kr.or.ddit.wedo.vo.EnrollClassVO;

public interface IEnrollClassService {
	/** 사용자 id를 입력하여 수강가능한 정보를 가져온다.
	 * 
	 * @param mem_id
	 * @return
	 */
	public List<EnrollClassVO> enrollSelect(String mem_id);
}
