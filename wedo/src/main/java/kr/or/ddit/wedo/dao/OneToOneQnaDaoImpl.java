package kr.or.ddit.wedo.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.util.SqlMapClientFactory;
import kr.or.ddit.wedo.vo.OneToOneQnaVO;

public class OneToOneQnaDaoImpl implements IOneToOneQnaDao {

	
	private static OneToOneQnaDaoImpl dao;
	SqlMapClient smc;

	private OneToOneQnaDaoImpl() {

		smc = SqlMapClientFactory.getSqlMapClient();
	}

	public static OneToOneQnaDaoImpl getInstance() {
		if (dao == null)
			dao = new OneToOneQnaDaoImpl();

		return dao;

	}

	@Override
	public List<OneToOneQnaVO> selectMemQna(String mem_id) {
		List<OneToOneQnaVO> otoqVo = null;
		
		try {
			otoqVo = smc.queryForList("onetooneqna.selectMemQna", mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return otoqVo;
	}

	@Override
	public List<OneToOneQnaVO> selectTeacherQna(String teacher_id) {
		List<OneToOneQnaVO> otoqVo = null;
		
		try {
			otoqVo = smc.queryForList("onetooneqna.selectTeacherQna", teacher_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return otoqVo;
	}

	@Override
	public void insertQna(OneToOneQnaVO otoqVo) {
		
		try {
			smc.insert("onetooneqna.insertQna", otoqVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteQna(int one_qna_no) {
		
		try {
			smc.delete("onetooneqna.deleteQna", one_qna_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public OneToOneQnaVO selectQnaNo(int one_qna_no) {
		
		OneToOneQnaVO otoqVo = null;
		
		try {
			otoqVo = (OneToOneQnaVO) smc.queryForObject("onetooneqna.selectQnaNo", one_qna_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
		return otoqVo; 
		
	}

	@Override
	public void updateQna(OneToOneQnaVO otoqVo) {
		
		try {
			smc.update("onetooneqna.updateQna",otoqVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
}
