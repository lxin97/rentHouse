package lx.renthouse.dao;

import java.util.List;

import lx.renthouse.Pojo.Houselist;
import lx.renthouse.Pojo.QueryVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HouselistMapper {
List<Houselist> selectAll();
public Integer findhouselistByVoCount(QueryVo vo);
Houselist findhouseid(String houseid);
void inserthouse(Houselist houselist);
void deletehouse(int id);
Houselist findid(int id);
Houselist findhouseidupdate(Houselist houselist);
void updatehouse(Houselist houselist);
void updatehousestatus(Houselist houselist);
public void deletehousebyhouseid(String house_id);
public void updatestatus(Houselist houselist);
}
