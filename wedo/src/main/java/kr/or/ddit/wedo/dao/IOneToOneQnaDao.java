package kr.or.ddit.wedo.dao;

import java.util.List;

import kr.or.ddit.wedo.vo.OneToOneQnaVO;

public interface IOneToOneQnaDao {
	
	/** 학생이 입력한 문의 글내역보기
	 * 
	 * @param mem_id 학생id
	 * @return 글내역
	 */
	public List<OneToOneQnaVO> selectMemQna(String mem_id);
	
	/** 학생이 입력한 문의글 내역보기(선생님기준)
	 * 
	 * @param teacher_id 선생님id
	 * @return 글내역
	 */
	public List<OneToOneQnaVO> selectTeacherQna(String teacher_id);
	
	/** 1:1문의 새글작성
	 * 
	 * @param otoqVo 작성자id, 문의받는강사id, 제목, 내용 
	 */
	public void insertQna(OneToOneQnaVO otoqVo);
	
	/** 1:1게시물 번호를 입력받아 삭제한다.
	 * 
	 * @param one_qna_no
	 */
	public void deleteQna(int one_qna_no);
	
	/** 글번호를 입력받아 해당 게시물의 정보를 가져온다.
	 * 
	 * @param one_qna_no
	 * @return
	 */
	public OneToOneQnaVO selectQnaNo(int one_qna_no);
	
	/** 글번호와 수정된 제목, 내용을 업데이트한다.
	 * 
	 * 
	 * @param otoqVo
	 */
	public void updateQna(OneToOneQnaVO otoqVo);
}
