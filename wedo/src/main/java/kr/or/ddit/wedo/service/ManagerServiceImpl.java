package kr.or.ddit.wedo.service;

import kr.or.ddit.wedo.dao.IManagerDao;
import kr.or.ddit.wedo.dao.ManagerDaoImpl;
import kr.or.ddit.wedo.vo.ManagerVO;

public class ManagerServiceImpl implements IManagerService {
	
	private IManagerDao dao; 

	private static ManagerServiceImpl service;

	

	public static ManagerServiceImpl getInstance() {
		if (service == null)
			service = new ManagerServiceImpl();

		return service;

	}

	public ManagerServiceImpl() {
		dao = ManagerDaoImpl.getInstance(); 
	}

	@Override
	public ManagerVO loginManager(ManagerVO vo) {
		
		return dao.loginManager(vo);
	}

	
}
