package lx.renthouse.dao;

import java.util.List;

import lx.renthouse.Pojo.QueryVo;
import lx.renthouse.Pojo.Solve;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SolveMapper {
	public List<Solve> selectall(QueryVo vo);
	public Integer selectcount(QueryVo vo);
	public void deletesolve(Integer id);
	public void insertsolve(Solve solve);
}
