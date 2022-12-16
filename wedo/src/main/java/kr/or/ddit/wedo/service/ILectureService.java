package kr.or.ddit.wedo.service;

import java.util.List;

import kr.or.ddit.wedo.vo.LectureVO;

public interface ILectureService {
	/** 강의번호 입력하여 강의정보 가져오는 메서드
	 * 
	 * @param classNo
	 * @return
	 */
	public List<LectureVO> getLecture(String classNo);
	
	public String getVideo(String lectureVideo);
}
