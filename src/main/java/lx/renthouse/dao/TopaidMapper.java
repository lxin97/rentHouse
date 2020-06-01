package lx.renthouse.dao;

import java.util.List;

import lx.renthouse.Pojo.QueryVo;
import lx.renthouse.Pojo.Topaid;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TopaidMapper {
public void inserttopaid(Topaid topaid);
public List<Topaid> findtopaid(QueryVo vo);
public Topaid findbyid(Integer id);
public void deletetopaid(Integer id);
}
