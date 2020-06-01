package lx.renthouse.service;

import java.util.List;

import lx.renthouse.Pojo.Paid;
import lx.renthouse.Pojo.QueryVo;
import lx.renthouse.Pojo.Zulist;

public interface PaidService {
	public List<Paid> selectall(QueryVo vo);
	public Double selectsum(QueryVo vo);
	public void deletepaid(Integer id);
	public List<Zulist> findzuuserlist() throws Exception;
	public Zulist findzukezulist(Integer id);

}
