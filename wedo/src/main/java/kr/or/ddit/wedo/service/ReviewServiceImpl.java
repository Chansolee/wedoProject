package kr.or.ddit.wedo.service;

import kr.or.ddit.wedo.dao.IReviewDao;
import kr.or.ddit.wedo.dao.ReviewDaoImpl;

public class ReviewServiceImpl implements IReviewService {


	private IReviewDao dao; 

	private static ReviewServiceImpl service;

	

	public static ReviewServiceImpl getInstance() {
		if (service == null)
			service = new ReviewServiceImpl();

		return service;

	}

	public ReviewServiceImpl() {
		dao = ReviewDaoImpl.getInstance(); 
	}
		
	
}
