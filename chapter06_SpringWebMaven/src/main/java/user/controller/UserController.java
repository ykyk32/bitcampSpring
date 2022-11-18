package user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import user.bean.UserDTO;
import user.service.UserService;
import user.service.UserServiceImpl;

@Component
@RequestMapping(value="user")
public class UserController {	
	@Autowired
	private UserService userService;
	
	@GetMapping(value="writeForm")
	public String writeForm() {
		return "user/writeForm";
	}
	@PostMapping(value="write")
	@ResponseBody//dispatch로 가지마-비동기처리
	public void write(@ModelAttribute UserDTO userDTO) {
		userService.write(userDTO);
		
	}
}
