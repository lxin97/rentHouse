package lx.renthouse.service;

import java.util.List;

import lx.renthouse.Pojo.Paid;
import lx.renthouse.Pojo.QueryVo;
import lx.renthouse.Pojo.Topaid;
import lx.renthouse.dao.PaidMapper;
import lx.renthouse.dao.TopaidMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TopaidServiceImpl implements TopaidService {
	@Autowired
	private TopaidMapper topaidMapper;
	@Autowired
	private PaidMapper paidMapper;
	@Override
	public void inserttopaid(Topaid topaid) {
		topaid.setStatus("租金未缴");
		topaidMapper.inserttopaid(topaid);
	}
	@Override
	public List<Topaid> findtopaid(QueryVo vo) {
		List<Topaid> list=topaidMapper.findtopaid(vo);
		return list;
	}
	@Override
	public Topaid findbyid(Integer id) {
		Topaid topaid=topaidMapper.findbyid(id);
		return topaid;
	}
	@Override
	public void gotopay(Integer id, Paid paid) {
		paidMapper.insertpaid(paid);
		topaidMapper.deletetopaid(id);

	}

}
