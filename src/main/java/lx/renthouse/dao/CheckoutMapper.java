package lx.renthouse.dao;

import java.util.List;

import lx.renthouse.Pojo.Checkout;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CheckoutMapper {
	public void insertcheckout(Checkout checkout);
	public List<Checkout> getallcheckout();
	public void deletecheckout(Integer id);
}
