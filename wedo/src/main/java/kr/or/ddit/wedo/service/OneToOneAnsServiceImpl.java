package kr.or.ddit.wedo.service;

import java.util.List;

import kr.or.ddit.wedo.dao.IOneToOneAnsDao;
import kr.or.ddit.wedo.dao.OneToOneAnsDaoImpl;
import kr.or.ddit.wedo.vo.OneToOneAnsVO;

public class OneToOneAnsServiceImpl implements IOneToOneAnsService {

	private IOneToOneAnsDao dao; 

	private static OneToOneAnsServiceImpl service;

	

	public static OneToOneAnsServiceImpl getInstance() {
		if (service == null)
			service = new OneToOneAnsServiceImpl();

		return service;

	}

	public OneToOneAnsServiceImpl() {
		dao = OneToOneAnsDaoImpl.getInstance(); 
	}
	
	@Override
	public List<OneToOneAnsVO> getAns(int qns_no) {
		return dao.getAns(qns_no);
	}

	@Override
	public List<OneToOneAnsVO> getAllAns(String mem_id) {
		return dao.getAllAns(mem_id);
	}

	@Override
	public void replyAns(OneToOneAnsVO ansVo) {
		dao.replyAns(ansVo);
	}

	@Override 
	public void replyDelete(int one_ans_no) {
		dao.replyDelete(one_ans_no);
	}

	@Override
	public void replyAllDelete(int one_qna_no) {
		dao.replyAllDelete(one_qna_no);
		
	}

	@Override
	public OneToOneAnsVO selectAns(int one_qna_no) {

		return dao.selectAns(one_qna_no);
	}

	@Override
	public void updateAns(OneToOneAnsVO otoaVo) {
		dao.updateAns(otoaVo);
		
	}

	@Override
	public List<OneToOneAnsVO> getAllTeacherAns(String teacher_id) {
		return dao.getAllTeacherAns(teacher_id);
	}



}
