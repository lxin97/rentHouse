package lx.renthouse.dao;

import java.util.List;

import lx.renthouse.Pojo.QueryVo;
import lx.renthouse.Pojo.Wrong;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WrongMapper {
  public List<Wrong> findwrong(QueryVo vo);
  public Wrong findbyid(Integer id);
  public void insertwrong(Wrong wrong);
  public void deletewrong(Integer id);
}
