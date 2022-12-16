package kr.or.ddit.wedo.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.util.SqlMapClientFactory;
import kr.or.ddit.wedo.vo.MemberVO;

public class MemberDaoImpl implements IMemberDao {

	private static MemberDaoImpl dao;
	SqlMapClient smc;

	private MemberDaoImpl() {

		smc = SqlMapClientFactory.getSqlMapClient();
	}

	public static MemberDaoImpl getInstance() {
		if (dao == null)
			dao = new MemberDaoImpl();

		return dao;

	}
	
	public int join(MemberVO vo) {//회원가입
		int cnt = 0;

		try {
			Object obj = smc.insert("member.insertMember", vo);
			if (obj == null)
				cnt++;
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}

		return cnt;
	}
	
	
	
	@Override
	public MemberVO idSearch(String id) {
		MemberVO memId = null;
		try {
		memId = (MemberVO) smc.queryForObject("member.idSearch",id);
		} catch (SQLException e) {
			memId = null;
			e.printStackTrace();
		}
		return memId;
	}
	
	
	@Override
	public MemberVO idSearchMember(MemberVO vo) {//아이디찾기
		MemberVO mem = null;
		try {
		mem = (MemberVO) smc.queryForObject("member.idSearchMember",vo);
		} catch (SQLException e) {
			mem = null;
			e.printStackTrace();
		}

		return mem;
	}
	
	

	@Override
	public MemberVO passSearchMember(MemberVO vo) {//비번찾기
		MemberVO mem = null;
		try {
		mem = (MemberVO) smc.queryForObject("member.passSearchMember",vo);
		} catch (SQLException e) {
			mem = null;
			e.printStackTrace();
		}

		return mem;
	}

	@Override
	public MemberVO loginMember(MemberVO vo) { //로그인
		MemberVO mem = null;
		try {
			mem = (MemberVO) smc.queryForObject("member.loginMember",vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mem;
	}
	
	
	@Override
	public int updateMember(MemberVO memVo) { //회원정보수정
		int cnt = 0;

		try {
			cnt = smc.update("member.updateMember", memVo);

		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}

		return cnt;
	}

	@Override
	public int updatePassMember(MemberVO memVo) { //비밀번호수정
		int cnt = 0;

		try {
			cnt = smc.update("member.updatePassMember", memVo);

		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}

		return cnt;
	}

	@Override
	public int withDrawalMember(MemberVO memVo) {
		int cnt = 0;

		try {
			cnt = smc.update("member.withDrawalMember", memVo);

		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}

		return cnt;
	}

	@Override
	public List<MemberVO> getAllMember() {
		List<MemberVO> memlist = null;
		
		try {
			memlist = smc.queryForList("member.getAllMember");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memlist;
	}

	@Override
	public MemberVO getMember(String mem_id) {
		MemberVO mVo = null;
		
		try {
			mVo = (MemberVO)smc.queryForObject("member.getMember", mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return mVo;
	}

	@Override
	public List<MemberVO> selectClassMember(String id) {
		List<MemberVO> memlist = null;
		
		try {
			memlist = smc.queryForList("member.selectClassMember", id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memlist;
	}

	
	
}
