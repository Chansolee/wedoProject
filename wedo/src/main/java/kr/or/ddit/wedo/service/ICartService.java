package kr.or.ddit.wedo.service;


import kr.or.ddit.wedo.vo.CartVO;

public interface ICartService {

	public int insertCart(CartVO cartVo);
	
	/**    장바구니에서 결제가 완료된 장바구니의 정보를 수정한다.
	 * 
	 * @param cartVo 장바구니번호와 ID가 담겨있다.
	 */
	public void updateCart(CartVO cartVo);
	
	public int deleteCart(String id);  //장바구니삭제
	
	public int deleteCartChoice(String id);  //장바구니선택삭제
	
	public CartVO searchCart(CartVO cartVo);//장바구니중복체크
}
