package lx.renthouse.service;

import java.util.List;

import lx.renthouse.Pojo.Zulist;
import lx.renthouse.Pojo.Applyout;

public interface ApplyoutService {
	public void insertapplyout(Zulist zulist);
	List<Applyout> findallapplyout();
	public void updateapplyout(Applyout applyout);
	public void agreeapplyout(Integer id);
	public void deleteapplyout(Integer id);
}
