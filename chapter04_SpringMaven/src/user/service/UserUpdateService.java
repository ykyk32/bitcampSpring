package user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.bean.UserDTO;
import user.dao.UserDAO;

@Service
public class UserUpdateService implements UserService {
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public void execute() {
		System.out.println();
		Scanner scan = new Scanner(System.in);
		
		//데이터
		System.out.print("수정할 아이디 입력 : ");
		String id = scan.next();
		
		
		//DB		
		UserDTO userDTO = userDAO.getUser(id); //1명만 받아오니까 dto
		
		if(userDTO == null) {
			System.out.println("찾고자 하는 아이디가 없습니다.");
		
			return;
			
		}
		System.out.println(userDTO.getName() + "\t" 
							 + userDTO.getId() + "\t" 
							 + userDTO.getPwd());
		System.out.println();
		System.out.println("삭제할 이름 입력 : ");
		String name= scan.next();
		System.out.println("삭제할 비밀번호 입력 : ");
		String pwd=scan.next();
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("name", name);
		map.put("pwd", pwd);
		
		userDAO.update(map);
		
		System.out.println("DB의 내용을 수정하엿습니다.");
	}

}

/*
수정할 아이디 입력 : banana
찾고자 하는 아이디가 없습니다.

------------------

수정할 아이디 입력 : angel
천사 angel 111

수정할 이름 입력 : 천사
수정할 비밀번호 입력 : 1004

DB의 내용을 수정하였습니다.
*/