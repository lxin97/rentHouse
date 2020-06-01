package lx.renthouse.service;

import java.util.List;


import lx.renthouse.Pojo.User;
import lx.renthouse.Pojo.UserExample;
import lx.renthouse.Pojo.Userlist;
import lx.renthouse.dao.UserMapper;
import lx.renthouse.dao.UserlistMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserlistMapper userlistMapper;

	@Override
	public List<User> userList() throws Exception {
		// TODO Auto-generated method stub
		UserExample example=new UserExample();
		List<User> list=userMapper.selectByExample(example);
		System.out.println("123"+list);
		return list;
	}

	@Override
	public User login(User user) throws Exception {
		User user1=userMapper.selectByUser(user);
		return user1;
	}

	@Override
	public int register(User user) throws Exception {
		int status= 0;
		userMapper.insert(user);
		User user1=userMapper.selectByUser(user);
		Userlist userlist=new Userlist();
		userlist.setUser_id(user1.getId());
		userlist.setIdcard("");
		userlist.setName("");
		userlist.setPhone("");
		userlistMapper.insertuserlist(userlist);
		status=1;
		return status;
	}


}
