package lx.renthouse.dao;

import lx.renthouse.Pojo.Hetong;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HetongMapper {

	public void inserthetong(Hetong hetong);
	public Hetong findhetong(String house_id);
	public void updatehetong(Hetong hetong);
	public void deletehetong(String house_id);
}
