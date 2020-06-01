package lx.renthouse.dao;

import java.util.List;

import lx.renthouse.Pojo.Apply;
import lx.renthouse.Pojo.Applyout;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ApplyMapper {
	void insertapply(Apply apply);
	public List<Apply> findapplylist() throws Exception;
	Apply findbyhouse_id(String house_id);
	public void deletebyhouse_id(String house_id);
	public void updateapplyout(Applyout applyout);
}
