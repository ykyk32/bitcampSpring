package user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import lombok.Setter;
import user.bean.UserDTO;

@Component
//public class UserDAOImpl extends JdbcDaoSupport implements UserDAO {
	//extends JdbcDaoSupport  로 만들어져있어서 setter를 제거했었음
	//ctrl+마우스오버하면 상속관계 볼수 있음

public class UserDAOImpl extends NamedParameterJdbcDaoSupport implements UserDAO {
	
	@Autowired   //setter함수가 호출되로록 autowired. 생성자로 잡으면 안걸어도 자동호출가능.
	public void setDS(DataSource dataSource ) {
		setDataSource(dataSource);
		
	}
	
	@Override
	public void write(UserDTO userDTO) {
		//String sql = "insert into usertable values(?,?,?)";
		//getJdbcTemplate().update(sql, userDTO.getName(), userDTO.getId(), userDTO.getPwd());
		// getJdbcTemplate() 라는 메소드가 제공된다. 
		
		//NamedParameterJdbcDaoSupport 를 상속하면서 :{ } 형태로 사용할 수 있다. 그리고 named 사용할거면 map으로 정보를 줘야함. dao로 전송은 안됨.
		String sql = "insert into usertable values( :name, :id, :pwd)";
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", userDTO.getName());
		map.put("id", userDTO.getId());
		map.put("pwd", userDTO.getPwd());
		
		getNamedParameterJdbcTemplate().update(sql, map);
	}

	@Override
	public List<UserDTO> getUserList() {
		String sql = "select * from usertable";
		return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
		//JdbcTemplate.queryForObject() : 한개만 가져옴 
		//JdbcTemplate.query() : 여러개 가져옴
		//BeanPropertyRowMapper() : 1줄을 dto클래스에 매핑해준다	
	}

	@Override
	public UserDTO getUser(String id) {
		String sql = "select * from usertable where id=:id";
		try {
			return getJdbcTemplate().queryForObject
					(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class), id);
		}catch(EmptyResultDataAccessException e){
			return null;
			
		}
	}

	@Override
	public void update(Map<String, String> map) {
		String sql = "update usertable set name=:name, pwd=:pwd where id=:id";
		//getJdbcTemplate().update(sql, map.get("name"), map.get("pwd"), map.get("id") );
		getNamedParameterJdbcTemplate().update(sql, map);
		
	}
	
	@Override
	public void delete(String id) {
		String sql = "delete usertable where id=:id";
		getJdbcTemplate().update(sql, id);
	
	}

	
	
	
}
