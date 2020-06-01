package lx.renthouse.service;

import java.util.List;

import lx.renthouse.Pojo.Checkout;

public interface CheckoutService {
public void insertcheckout(Checkout checkout);
public List<Checkout> getallcheckout();
public void deletecheckout(Integer id);
}
