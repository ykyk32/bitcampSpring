package user.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Service
public class UserInsertService implements UserService {
	@Autowired
	private UserDTO userDTO;
	@Autowired
	private UserDAO userDAO;
	

	@Override
	public void execute() {
		System.out.println();
		Scanner scan = new Scanner(System.in);
		
		//데이터
		System.out.print("이름:");
		String name = scan.next();
		System.out.print("아이디:");
		String id = scan.next();
		System.out.print("비밀번호:");
		String pwd = scan.next();
		
		userDTO.setName(name);
		userDTO.setId(id);
		userDTO.setPwd(pwd);
		
		//DB		
		userDAO.write(userDTO);
		//응답
		System.out.println(name+ "님의 정보를 DB에 저장완료.");
	}

}
