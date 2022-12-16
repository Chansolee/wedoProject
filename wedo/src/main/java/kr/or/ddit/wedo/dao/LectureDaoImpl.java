package kr.or.ddit.wedo.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.util.SqlMapClientFactory;
import kr.or.ddit.wedo.vo.LectureVO;

public class LectureDaoImpl implements ILectureDao {
	
	private static LectureDaoImpl dao;
	SqlMapClient smc;

	private LectureDaoImpl() {

		smc = SqlMapClientFactory.getSqlMapClient();
	}

	public static LectureDaoImpl getInstance() {
		if (dao == null)
			dao = new LectureDaoImpl();

		return dao;

	}

	@Override
	public List<LectureVO> getLecture(String classNo) {
		List<LectureVO> list = null;
		
		try {
			list =  smc.queryForList("lecture.getLecture", classNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public String getVideo(String lectureVideo) {
			String video = null;
			
			try {
				video = (String) smc.queryForObject("lecture.getVideo",lectureVideo);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return video;
	}
}
