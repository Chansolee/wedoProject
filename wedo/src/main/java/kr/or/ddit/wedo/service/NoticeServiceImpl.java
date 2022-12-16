package kr.or.ddit.wedo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.wedo.dao.INoticeDao;
import kr.or.ddit.wedo.dao.NoticeDaoImpl;
import kr.or.ddit.wedo.vo.NoticeVO;
import kr.or.ddit.wedo.vo.PageVO;

public class NoticeServiceImpl implements INoticeService {


	int count =0;
	
	 //dao객체 
	private INoticeDao  dao;
	
	//자신의 객체 
	private static INoticeService  service;
	
	//생성자 
	private NoticeServiceImpl() {
		 dao =NoticeDaoImpl.getDao();
	}
	
	//자신의 객체를 생성, 리턴 
	public static INoticeService getService() {
		if(service == null)  service = new NoticeServiceImpl();
		
		return service;
	}

	@Override
	public List<NoticeVO> selectByPage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.selectByPage(map);
	}

	@Override
	public int totalCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.totalCount(map);
	}
	@Override
	public int totalPage(String stype, String sword) {
		
		//전체 글 갯수 구하기 
		Map<String, Object>  map = new HashMap<String, Object>();
		map.put("stype", stype);
		map.put("sword", sword);
		
		 count = this.totalCount(map);
		
		//전체페이지수 구하기 
		int totalPage = (int) Math.ceil((double)count / PageVO.getPerList() );
		
//		System.out.println("전체글 갯수 =" + count);
//		System.out.println("전체 페이지 수 =" +totalPage );
		
		return totalPage;
	}
	
	@Override
	public PageVO pageInfo(int page, String stype, String sword) {
		
		//전체 페이지 수 구하기 기 
		int totalPage  = this.totalPage(stype, sword);
		
	   //start, end, starpage, endPage , totalPage 
		//1페이지 1,3   2페이지 4, 6  3페이지 7, 9 
		//10 12 / 13 15/ 16 18 / 19 20 21/
		int start =  (page-1) * PageVO.getPerList() + 1;
		int end = start + PageVO.getPerList() -1;
		if(end  > count  ) end  = count;
		
		//1페이지 1, 2   2페이지 1 , 2  3페이지 3,4  4페이지 3, 4
		//7페이지 7 , 8 
		int startPage =  
				((page -1) /PageVO.getPerPage() * PageVO.getPerPage() )  + 1;
			
		int endPage = startPage + PageVO.getPerPage() - 1;
		if(endPage >  totalPage) endPage = totalPage;
		
				
		PageVO  vo = new PageVO();
		vo.setStart(start);
        vo.setEnd(end);

        vo.setStartPage(startPage);
        vo.setEndPage(endPage);
        vo.setTotalPage(totalPage);
        
        return vo;
	}

	@Override
	public int insertNotice(NoticeVO vo) {
		// TODO Auto-generated method stub
		return dao.insertNotice(vo);
	}

	@Override
	public int updateNotice(NoticeVO vo) {
		// TODO Auto-generated method stub
		return dao.updateNotice(vo);
	}

	@Override
	public NoticeVO noSearch(int no) {
		// TODO Auto-generated method stub
		return dao.noSearch(no);
	}

	@Override
	public int deleteNotice(int no) {
		// TODO Auto-generated method stub
		return dao.deleteNotice(no);
	}
	
	
	
}
