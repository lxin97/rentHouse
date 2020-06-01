package lx.renthouse.service;

import java.util.List;

import lx.renthouse.Pojo.Paid;
import lx.renthouse.Pojo.QueryVo;
import lx.renthouse.Pojo.Topaid;

public interface TopaidService {
	public void inserttopaid(Topaid topaid);
	public List<Topaid> findtopaid(QueryVo vo);
	public Topaid findbyid(Integer id);
	public void gotopay(Integer id, Paid paid);
}
