package kr.or.ddit.wedo.service;

import java.util.List;

import kr.or.ddit.wedo.dao.IOneToOneQnaDao;
import kr.or.ddit.wedo.dao.OneToOneQnaDaoImpl;
import kr.or.ddit.wedo.vo.OneToOneQnaVO;

public class OneToOneQnaServiceImpl implements IOneToOneQnaService {

	

	private IOneToOneQnaDao dao; 

	private static OneToOneQnaServiceImpl service;

	

	public static OneToOneQnaServiceImpl getInstance() {
		if (service == null)
			service = new OneToOneQnaServiceImpl();

		return service;

	}

	public OneToOneQnaServiceImpl() {
		dao = OneToOneQnaDaoImpl.getInstance(); 
	}

	@Override
	public List<OneToOneQnaVO> selectMemQna(String mem_id) {
		return dao.selectMemQna(mem_id);
	}

	@Override
	public List<OneToOneQnaVO> selectTeacherQna(String teacher_id) {
		return dao.selectTeacherQna(teacher_id);
	}

	@Override
	public void insertQna(OneToOneQnaVO otoqVo) {
		dao.insertQna(otoqVo);
		
	}

	@Override
	public void deleteQna(int one_qna_no) {
		dao.deleteQna(one_qna_no);
		
	}

	@Override
	public OneToOneQnaVO selectQnaNo(int one_qna_no) {
		
		return dao.selectQnaNo(one_qna_no);
	}

	@Override
	public void updateQna(OneToOneQnaVO otoqVo) {
		dao.updateQna(otoqVo);
	}
	
	
}
