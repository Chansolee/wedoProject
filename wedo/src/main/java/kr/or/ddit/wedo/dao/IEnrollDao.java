package kr.or.ddit.wedo.dao;

public interface IEnrollDao {
	
	/** 해당 카트 번호에 대한 정보를 검색해 데이터 insert
	 * 
	 * @param cart_no
	 */
	public void insertEnroll(String cart_no);
}
