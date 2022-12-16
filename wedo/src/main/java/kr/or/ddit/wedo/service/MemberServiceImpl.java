package kr.or.ddit.wedo.service;

import java.util.List;

import kr.or.ddit.wedo.dao.IMemberDao;
import kr.or.ddit.wedo.dao.MemberDaoImpl;
import kr.or.ddit.wedo.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {
	private IMemberDao dao;

	private static MemberServiceImpl service;

	public static MemberServiceImpl getInstance() {
		if (service == null)
			service = new MemberServiceImpl();

		return service;

	}

	public MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
	}

	@Override
	public int join(MemberVO vo) {

		return dao.join(vo);
	}
	
	@Override
	public MemberVO idSearch(String id) {
		// TODO Auto-generated method stub
		return dao.idSearch(id);
	}
	
	@Override
	public MemberVO idSearchMember(MemberVO vo){//아이디찾기
		
		return dao.idSearchMember(vo);
	}
	
	@Override
	public MemberVO passSearchMember(MemberVO vo){//아이디찾기
		
		return dao.passSearchMember(vo);
	}

	@Override
	public MemberVO loginMember(MemberVO vo) {
		return dao.loginMember(vo);
	}

	@Override
	public int updateMember(MemberVO memVo) {
		
		return dao.updateMember(memVo);
	}

	@Override
	public int updatePassMember(MemberVO memVo) {
		 
		return dao.updatePassMember(memVo);
	}

	@Override
	public int withDrawalMember(MemberVO memVo) {
		// TODO Auto-generated method stub
		return dao.withDrawalMember(memVo);
	}

	@Override
	public List<MemberVO> getAllMember() {
		return dao.getAllMember();
	}

	@Override
	public MemberVO getMember(String mem_id) {
		return dao.getMember(mem_id);
	}

	@Override
	public List<MemberVO> selectClassMember(String id) {
		// TODO Auto-generated method stub
		return dao.selectClassMember(id);
	}
	
	

}
