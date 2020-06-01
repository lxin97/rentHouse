package lx.renthouse.dao;

import java.util.List;

import lx.renthouse.Pojo.Paid;
import lx.renthouse.Pojo.QueryVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaidMapper {
public List<Paid> selectall(QueryVo vo);
public Double selectsum(QueryVo vo);
public void deletepaid(Integer id);
public void insertpaid(Paid paid);
}
