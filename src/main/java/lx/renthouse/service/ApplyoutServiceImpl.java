package lx.renthouse.service;

import java.util.List;

import lx.renthouse.Pojo.Applyout;
import lx.renthouse.Pojo.Checkout;
import lx.renthouse.Pojo.Houselist;
import lx.renthouse.Pojo.Zulist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lx.renthouse.dao.ApplyoutMapper;
import lx.renthouse.dao.CheckoutMapper;
import lx.renthouse.dao.HetongMapper;
import lx.renthouse.dao.HouselistMapper;
import lx.renthouse.dao.ZulistMapper;

@Service
@Transactional
public class ApplyoutServiceImpl implements ApplyoutService {

	@Autowired
	private ApplyoutMapper applyoutMapper;
	@Autowired
	private HouselistMapper houselistMapper;
	@Autowired
	private HetongMapper hetongMapper;
	@Autowired
	private CheckoutMapper checkoutMapper;
	@Autowired
	private ZulistMapper zulistMapper;
	@Autowired
	private HouselistService houselistService;
	@Override
	public void insertapplyout(Zulist zulist) {
		Applyout applyout=new Applyout();
		applyout.setHouse_id(zulist.getHouse_id());
		applyout.setAddress(zulist.getAddress());
		applyout.setStatus("申请中");
		applyout.setUserlist_id(zulist.getUserlist_id());
		applyoutMapper.insertapplyout(applyout);

	}
	@Override
	public List<Applyout> findallapplyout() {
		List<Applyout> list=applyoutMapper.findallapplyout();
		return list;
	}
	@Override
	public void updateapplyout(Applyout applyout) {

		applyoutMapper.updateapplyout(applyout);
	}
	@Override
	public void agreeapplyout(Integer id) {
		Applyout applyout=applyoutMapper.findbyid(id);

//		houselistMapper.deletehousebyhouseid(applyout.getHouse_id());

		/*Houselist houselist=new Houselist();
		houselist.setId(id);
		houselist.setStatus("未租赁");*/
		System.out.println("id=============="+id);
		Applyout applyout1= applyoutMapper.findbyid(id);
		Houselist houselist=houselistService.findhouseid(applyout1.getHouse_id());
		houselist.setStatus("未租赁");
		houselistService.updatehousestatus(houselist);
		System.out.println("houselist=============="+houselist.getAddress());
		houselistMapper.updatehousestatus(houselist);

		hetongMapper.deletehetong(applyout.getHouse_id());
		Checkout checkout=new Checkout();
		checkout.setHouse_id(applyout.getHouse_id());
		checkout.setAddress(applyout.getAddress());
		checkout.setStatus("已退租");
		checkout.setUserlist_id(applyout.getUserlist_id());
		checkoutMapper.insertcheckout(checkout);
		applyout.setStatus("已同意");
		applyoutMapper.updateapplyoutbyhouse(applyout);
		zulistMapper.deletezulist(applyout.getHouse_id());
	}
	@Override
	public void deleteapplyout(Integer id) {

		applyoutMapper.deleteapplyout(id);
	}


}
