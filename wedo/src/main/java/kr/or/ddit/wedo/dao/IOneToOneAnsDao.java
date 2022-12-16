package kr.or.ddit.wedo.dao;

import java.util.List;

import kr.or.ddit.wedo.vo.OneToOneAnsVO;

public interface IOneToOneAnsDao {
	
	/** 질문번호에 대한 댓글 정보를 가져오는 메서드
	 * 
	 * @param qns_no 글번호.
	 * @return  댓글정보
	 */
	public List<OneToOneAnsVO> getAns(int qns_no);
	
	
	/** 사용자가 입력한 모든 글번호를 가져온다.
	 * 
	 * 
	 * @param mem_id
	 * @return
	 */
	public List<OneToOneAnsVO> getAllAns(String mem_id);
	
	/** 선생님 별 댓글내역을 보여준다.
	 * 
	 * @param teacher_id
	 * @return
	 */
	public List<OneToOneAnsVO> getAllTeacherAns(String teacher_id);
	
	/** 리플작성 
	 * 
	 * @param ansVo
	 */
	public void replyAns(OneToOneAnsVO ansVo);
	
	/** 댓글번호를 받아서 댓글을 삭제한다.
	 * 
	 * @param one_ans_no 댓글번호
	 */
	public void replyDelete(int one_ans_no);
	
	
	/** 글번호를 입력받아 모든 댓글을 삭제한다.
	 * 
	 * @param one_qna_no 글번호
	 */
	public void replyAllDelete(int one_qna_no);
	
	/** 댓글번호를 받아서 댓글내역을 출력한다.
	 * 
	 * 
	 * @param one_qna_no
	 * @return
	 */
	public OneToOneAnsVO selectAns(int one_qna_no);
	
	/** 댓글의 내용을 수정한다.
	 * 
	 * 
	 * @param otoaVo
	 */
	public void updateAns(OneToOneAnsVO otoaVo);
	

}
