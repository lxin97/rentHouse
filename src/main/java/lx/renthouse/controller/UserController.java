package lx.renthouse.controller;

import javax.servlet.http.HttpSession;

import lx.renthouse.Pojo.User;
import lx.renthouse.dao.UserMapper;
import lx.renthouse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("text2")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private UserMapper userMapper;
	@RequestMapping("/login")
	public String tologin() throws Exception{


		return "login";

	}
	@RequestMapping("/register")
	public String toregister() throws Exception{

		System.out.println("1111111111register");
		return "register";
	}
	//登录
	@RequestMapping("/logincheck")
	public String login(User user, Model model, HttpSession httpSession) throws Exception{
		System.out.println("login");
		User user1=userService.login(user);
		System.out.println(1);
		System.out.println(user1);
		if(user1!=null){
			System.out.println(2);
			httpSession.setAttribute("user", user1);
			if(user1.getType().equals("zuke")){
				System.out.println(2.1);
				return "zuke/main";
			}
			else{
				return "admin/main1";
			}
		}else{
			System.out.println(3);
			String error="error";
			model.addAttribute("error", error);
		return "login";
		}
	}
	//注册账户
	@RequestMapping("/registerCheck")
	public String register(User user, Model model, HttpSession httpSession) throws Exception{
		User user1=userMapper.selectByUser(user);
		if (user1!=null){
			String error="账户名已被注册";
			model.addAttribute("error", error);
			return "register";
		}
		int status=userService.register(user);
		System.out.println(1);
		if(status==1){
			System.out.println(2);
			String sucess="sucess";
			model.addAttribute("sucess", sucess);
			return "login";
		}else{
			System.out.println(3);
			String error="error";
			model.addAttribute("error", error);
			return "register";
		}
	}

	@RequestMapping("/toindex")
	public String toindex(Model model) throws Exception{


		return "admin/index";
		}
	}

