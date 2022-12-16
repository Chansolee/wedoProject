package kr.or.ddit.wedo.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.wedo.vo.NoticeVO;

public interface INoticeDao {

	//페이지별 리ㅣ스트 가졍오기 
		public List<NoticeVO>  selectByPage(Map<String, Object>  map);
		
		//데이타의 전체갯수 가져오기 
		public int totalCount(Map<String, Object> map);
		
		
		public int insertNotice(NoticeVO vo); //공지사항추가
		
		public int updateNotice(NoticeVO vo); //공지사항수정

		public NoticeVO noSearch(int no); //

		public int deleteNotice(int no);  //공지사항삭제
}
