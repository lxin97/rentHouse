package lx.renthouse.dao;

import java.util.List;

import lx.renthouse.Pojo.Schedule;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ScheduleMapper {
	public void insertschedule(Schedule schedule);
	public List<Schedule> selectAll();
	public void deleteschedule(Integer id);
	public void updateschedule(Schedule schedule);
	public Schedule selectbyid(Integer id);
}
