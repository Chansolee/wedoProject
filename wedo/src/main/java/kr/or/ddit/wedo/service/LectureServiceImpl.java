package kr.or.ddit.wedo.service;

import java.util.List;

import kr.or.ddit.wedo.dao.ILectureDao;
import kr.or.ddit.wedo.dao.LectureDaoImpl;
import kr.or.ddit.wedo.vo.LectureVO;

public class LectureServiceImpl implements ILectureService {
	private ILectureDao dao; 

	private static LectureServiceImpl service;

	

	public static LectureServiceImpl getInstance() {
		if (service == null)
			service = new LectureServiceImpl();

		return service;

	}

	public LectureServiceImpl() {
		dao = LectureDaoImpl.getInstance(); 
	}

	@Override
	public List<LectureVO> getLecture(String classNo) {
		return dao.getLecture(classNo);
	}

	@Override
	public String getVideo(String lectureVideo) {
		return dao.getVideo(lectureVideo);
	}
	
	
}
