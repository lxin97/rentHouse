package lx.renthouse.service;

import java.util.List;

import lx.renthouse.Pojo.QueryVo;
import lx.renthouse.Pojo.Solve;
import lx.renthouse.Pojo.Wrong;

public interface SolveService {
	public List<Solve> selectall(QueryVo vo);
	public Integer selectcount(QueryVo vo);
	public void deletesolve(Integer id);

	public List<Wrong> findwrong(QueryVo vo);
	public Wrong findbyid(Integer id);
	 public void insertwrong(Wrong wrong);
	 public void gotosolve(Integer id, Solve solve);
}
