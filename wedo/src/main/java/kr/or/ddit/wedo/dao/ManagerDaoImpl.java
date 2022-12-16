package kr.or.ddit.wedo.dao;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.util.SqlMapClientFactory;
import kr.or.ddit.wedo.vo.ManagerVO;
import kr.or.ddit.wedo.vo.MemberVO;

public class ManagerDaoImpl implements IManagerDao {

	
	private static ManagerDaoImpl dao;
	SqlMapClient smc;

	private ManagerDaoImpl() {

		smc = SqlMapClientFactory.getSqlMapClient();
	}

	public static ManagerDaoImpl getInstance() {
		if (dao == null)
			dao = new ManagerDaoImpl();

		return dao;

	}

	@Override
	public ManagerVO loginManager(ManagerVO vo) {
		ManagerVO mVo = null;
		try {
			mVo = (ManagerVO) smc.queryForObject("manager.loginManager",vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mVo;
	}

}
