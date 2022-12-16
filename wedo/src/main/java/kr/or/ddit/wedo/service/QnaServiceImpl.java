package kr.or.ddit.wedo.service;

import kr.or.ddit.wedo.dao.IQnaDao;
import kr.or.ddit.wedo.dao.QnaDaoImpl;

public class QnaServiceImpl implements IQnaService {


	private IQnaDao dao; 

	private static QnaServiceImpl service;

	

	public static QnaServiceImpl getInstance() {
		if (service == null)
			service = new QnaServiceImpl();

		return service;

	}

	public QnaServiceImpl() {
		dao = QnaDaoImpl.getInstance(); 
	}
	
	
	
}
