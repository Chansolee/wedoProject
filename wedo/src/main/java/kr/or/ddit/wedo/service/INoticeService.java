package kr.or.ddit.wedo.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.wedo.vo.NoticeVO;
import kr.or.ddit.wedo.vo.PageVO;

public interface INoticeService {

	//page별 리스트 가져오기 
	public List<NoticeVO>  selectByPage(Map<String, Object>  map);
	
	//데이타의 전체갯수 가져오기 
	public int totalCount(Map<String, Object> map);
	
	//전체 페이지 수 구하기 
	public int totalPage(String stype, String sword);
	
	
	//페이지정보를 얻기위한 메소드 
	public PageVO  pageInfo(int page, String stype, String sword);
	
	
	public int insertNotice(NoticeVO vo);
	
	public int updateNotice(NoticeVO vo); //정보수정
	
	public NoticeVO noSearch(int no); 
	
	public int deleteNotice(int no);  //공지사항삭제

}
