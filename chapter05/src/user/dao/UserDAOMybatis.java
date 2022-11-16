package user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.transaction.annotation.Transactional;

import lombok.Setter;
import user.bean.UserDTO;

@Transactional
public class UserDAOMybatis implements UserDAO {
	@Setter
	private SqlSession sqlSession;
	
	@Override
	public void write(UserDTO userDTO) {
		sqlSession.insert("userSQL.write",userDTO);

	}

	@Override
	public List<UserDTO> getUserList() {
		
		return sqlSession.selectList("userSQL.getList");
	}

	@Override
	public UserDTO getUser(String id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("userSQL.getList", id);
	}

	@Override
	public void update(Map<String, String> map) {
		sqlSession.selectList("userSQL.update",map);

	}

	@Override
	public void delete(String id) {
		sqlSession.selectList("userSQL.delete", id);

	}

}
