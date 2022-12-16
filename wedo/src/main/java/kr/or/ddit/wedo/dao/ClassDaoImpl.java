package kr.or.ddit.wedo.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.util.SqlMapClientFactory;
import kr.or.ddit.wedo.vo.ClassVO;

public class ClassDaoImpl implements IClassDao {


	private static ClassDaoImpl dao;
	SqlMapClient smc;

	private ClassDaoImpl() {

		smc = SqlMapClientFactory.getSqlMapClient();
	}

	public static ClassDaoImpl getInstance() {
		if (dao == null)
			dao = new ClassDaoImpl();

		return dao;

	}

	@Override
	public ClassVO getClass(String classNo) {
		ClassVO cVo = null;
		
		try {
			cVo = (ClassVO) smc.queryForObject("class.getClass", classNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cVo;
	}

	@Override
	public int insertClass(ClassVO classVo) {
		int cnt = 0;
		try {
			Object obj = smc.insert("class.insertClass", classVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteClass(String classNo) {
		int cnt = 0;
		try {
			cnt = smc.delete("class.deleteClass",classNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updateClass(ClassVO classVo) {
		int cnt = 0;
		try {
			cnt = smc.update("class.updateClass", classVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<ClassVO> getClassList() {
		List<ClassVO> list = null;
		try {
			list = smc.queryForList("class.getClassList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<ClassVO> getCartClass(String mem_id) {
		List<ClassVO> Clist = null;
		
		try {
			Clist = smc.queryForList("class.getCartClass", mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Clist;
	}

	@Override
	public List<ClassVO> getTeacherClassList(String teacherId) {
		List<ClassVO> clalist = null;
		
		try {
			clalist = smc.queryForList("class.getTeacherClassList", teacherId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return clalist;
	}


	
	
}
