package kr.or.ddit.wedo.dao;

import kr.or.ddit.wedo.vo.ManagerVO;

public interface IManagerDao {
	
	/**	관리자 계정정보(id, pw)를 받아서 계정정보 일치여부를 확인한다.
	 * 
	 * @param vo
	 * @return
	 */
	public ManagerVO loginManager(ManagerVO vo);
}
