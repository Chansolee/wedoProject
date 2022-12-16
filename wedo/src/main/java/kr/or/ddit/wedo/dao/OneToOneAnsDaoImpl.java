package kr.or.ddit.wedo.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.util.SqlMapClientFactory;
import kr.or.ddit.wedo.vo.OneToOneAnsVO;

public class OneToOneAnsDaoImpl implements IOneToOneAnsDao {

	private static OneToOneAnsDaoImpl dao;
	SqlMapClient smc;

	private OneToOneAnsDaoImpl() {

		smc = SqlMapClientFactory.getSqlMapClient();
	}

	public static OneToOneAnsDaoImpl getInstance() {
		if (dao == null)
			dao = new OneToOneAnsDaoImpl();

		return dao;

	}
	
	@Override
	public List<OneToOneAnsVO> getAns(int qns_no) {
		
		List<OneToOneAnsVO> otoaVo = null;
		
		try {
			otoaVo = smc.queryForList("onetooneans.getAns",qns_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return otoaVo;
	}

	@Override
	public List<OneToOneAnsVO> getAllAns(String mem_id) {
		List<OneToOneAnsVO> otoaVo = null;
		
		try {
			otoaVo = smc.queryForList("onetooneans.getAllAns",mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return otoaVo;
	}

	//댓글등록
	@Override
	public void replyAns(OneToOneAnsVO ansVo) {
		
		try {
			smc.insert("onetooneans.replyAns", ansVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void replyDelete(int one_ans_no) {
		
		try {
			smc.delete("onetooneans.replyDelete", one_ans_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void replyAllDelete(int one_qna_no) {
		
		try {
			smc.delete("onetooneans.replyAllDelete", one_qna_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public OneToOneAnsVO selectAns(int one_qna_no) {
		OneToOneAnsVO otoaVo = null;
		
		try {
			otoaVo = (OneToOneAnsVO) smc.queryForObject("onetooneans.selectAns",one_qna_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return otoaVo;
	}

	@Override
	public void updateAns(OneToOneAnsVO otoaVo) {
		
		try {
			smc.update("onetooneans.updateAns",otoaVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<OneToOneAnsVO> getAllTeacherAns(String teacher_id) {
		
		List<OneToOneAnsVO> otoaVo = null;
		
		try {
			otoaVo = smc.queryForList("onetooneans.getAllTeacherAns",teacher_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return otoaVo;
	}
	
	

}
