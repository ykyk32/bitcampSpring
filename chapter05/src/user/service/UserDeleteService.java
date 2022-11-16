package user.service;

import java.util.Scanner;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserDeleteService implements UserService {
	@Setter
	private UserDAO userDAO;
	@Override
	public void execute() {
		System.out.println();
		Scanner scan = new Scanner(System.in);
		
		//데이터
		System.out.print("삭제할 아이디 입력 : ");
		String id = scan.next();
		
		//DB
		UserDTO userDTO = userDAO.getUser(id);
		if(userDTO == null) {
			System.out.println("찾고자 하는 아이디가 없습니다.");
		
			return;			
		}else {
		
		System.out.println(userDTO.getName() + "\t" 
				 + userDTO.getId() + "\t" 
				 + userDTO.getPwd());
		System.out.println();
		
		userDAO.delete(id);
		System.out.println("DB의 내용을 삭제하였습니다.");
		}
	}
}

/*
삭제할 아이디 입력 : banana
찾고자 하는 아이디가 없습니다.

삭제할 아이디 입력 : angel
DB의 내용을 삭제하였습니다.
*/	