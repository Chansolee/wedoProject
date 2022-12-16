package kr.or.ddit.wedo.dao;

import java.util.List;

import kr.or.ddit.wedo.vo.ClassVO;

public interface IClassDao {
	/**
	 * 강좌 정보를 insert하는 메서드
	 * @param classVo insert할 강좌 정보가 저장된 ClassVO객체
	 * @return 작업성공:1, 작업실패:0
	 */
	public int insertClass(ClassVO classVo);
	
	/**
	 * 강좌 정보를 삭제하는 메서드
	 * @param classNo 삭제할 강좌번호
	 * @return 작업성공:1, 작업실패:0
	 */
	public int deleteClass(String classNo);
	
	/**
	 * 강좌 정보를 update하는 메서드
	 * @param classVo update할 강좌 정보가 저장된 ClassVO객체
	 * @return  작업성공:1, 작업실패:0
	 */
	public int updateClass(ClassVO classVo);
	
	/**	강좌번호를 입력하여 해당강좌의 정보를 가져온다.
	 * 
	 * @param classNo 강좌번호
	 * @return 해당 강좌번호에 대한 강좌정보데이터
	 */
	public ClassVO getClass(String classNo);
	
	/**
	 * 검색 조건에 맞는 강좌List를 반환하는 메서드
	 * @param searchMap 검색 조건이 있는 Map객체
	 * @return 검색된 강좌 정보가 저장된 List객체
	 */
	public List<ClassVO> getClassList();
	
	public List<ClassVO> getCartClass(String mem_id);
	
	public List<ClassVO> getTeacherClassList(String teacherId);
	
}
