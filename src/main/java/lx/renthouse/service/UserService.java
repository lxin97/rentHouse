package lx.renthouse.service;

import java.util.List;

import lx.renthouse.Pojo.User;

public interface UserService {

	public List<User> userList() throws Exception;
	public User login(User user) throws Exception;
	public int	register(User user) throws Exception;

}
