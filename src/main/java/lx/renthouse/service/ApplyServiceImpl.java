package lx.renthouse.service;

import java.util.List;

import lx.renthouse.Pojo.Apply;
import lx.renthouse.Pojo.Houselist;
import lx.renthouse.dao.ApplyMapper;
import lx.renthouse.dao.HouselistMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ApplyServiceImpl implements ApplyService {

	@Autowired
	private ApplyMapper applyMapper;
	@Autowired
	private HouselistMapper houselistMapper;

	@Override
	public void insertapply(Apply apply) {
		applyMapper.insertapply(apply);

	}

	@Override
	public List<Apply> findapplylist() throws Exception {
		List<Apply> apply=applyMapper.findapplylist();
		return  apply;
	}

	@Override
	public Apply findbyhouse_id(String house_id) {
		Apply apply=applyMapper.findbyhouse_id(house_id);
		return apply;
	}

	@Override
	public void deletebyhouse_id(String house_id) {
		applyMapper.deletebyhouse_id(house_id);

	}

	@Override
	public void refuseapply(Houselist houselist) {
		houselistMapper.updatestatus(houselist);
		applyMapper.deletebyhouse_id(houselist.getHouseid());
	}





}
