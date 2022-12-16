package kr.or.ddit.wedo.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.util.SqlMapClientFactory;
import kr.or.ddit.wedo.vo.NoticeVO;

public class NoticeDaoImpl implements INoticeDao {

	
	// SqlMapClient
		SqlMapClient client;

		// 자신의 객체
		private static INoticeDao dao;

		// 생성자
		private NoticeDaoImpl() {
			client = SqlMapClientFactory.getSqlMapClient();
		}

		// 자신의 객체를 생성 하고 리턴
		public static INoticeDao getDao() {
			if (dao == null)
				dao = new NoticeDaoImpl();

			return dao;
		}

		@Override
		public List<NoticeVO> selectByPage(Map<String, Object> map) {
			List<NoticeVO> list = null;

			try {
				list = client.queryForList("notice.selectByPage", map);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return list;
		}

		@Override
		public int totalCount(Map<String, Object> map) {
			int cnt = 0;

			try {
				cnt = (int) client.queryForObject("notice.totalCount", map);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return cnt;
		}

		@Override
		public int insertNotice(NoticeVO vo) {

			int cnt = 0;

			try {
				Object obj = client.insert("notice.insertNotice", vo);// 오류가 안나면 null을 반환함
				if (obj == null)
					cnt++;
			} catch (SQLException e) {
				cnt = 0;
				e.printStackTrace();
			}

			return cnt;

		}

		@Override
		public int updateNotice(NoticeVO vo) {
			int cnt = 0;

			try {
				cnt = client.update("notice.updateNotice", vo);

			} catch (SQLException e) {
				cnt = 0;
				e.printStackTrace();
			}

			return cnt;
		}
		
		
		@Override
		public NoticeVO noSearch(int no) {
			NoticeVO vo = null;
			try {
				vo = (NoticeVO) client.queryForObject("notice.noSearch",no);
			} catch (SQLException e) {
				vo = null;
				e.printStackTrace();
			}
			return vo;
		}
		
		
		@Override
		public int deleteNotice(int no) {

			int cnt = 0;

			try {
				cnt = client.delete("notice.deleteNotice", no);// 정상적으로 실행되면 1을 반환

			} catch (SQLException e) {
				cnt = 0;
				e.printStackTrace();
			}

			return cnt;
		}

	
}
