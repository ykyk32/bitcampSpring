package user.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import lombok.Setter;
import user.bean.UserDTO;

/*
public class UserDAOImpl implements UserDAO {
	@Setter
	private JdbcTemplate jdbcTemplate;
	@Override
//	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//	}
	public void write(UserDTO userDTO) {
		String sql ="insert into usertable values(?,?,?)";
		jdbcTemplate.update(sql, userDTO.getName(),userDTO.getId(),userDTO.getPwd());
		//update(,object....-...매개변수 개수를 자유롭게)
		//Spring은 jdbcTemplate.update() => insert, update, delete
		
	}
	@Override
	public List<UserDTO> getUserList() {
		String sql="select * from usertable";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
		//jdbcTemplate.queryForObject(sql, null) - 1개 가져온다
		//BeanPropertyRowMapper()-한줄당 UserDTO.class로 매핑해준다
	}

}
*/

public class UserDAOImpl extends JdbcDaoSupport implements UserDAO {//JdbcDaoSupport-jdbcTemplate미리 만들어논거
	@Override
	public void write(UserDTO userDTO) {
		String sql ="insert into usertable values(?,?,?)";
		getJdbcTemplate().update(sql, userDTO.getName(),userDTO.getId(),userDTO.getPwd());
		//update(,object....-...매개변수 개수를 자유롭게)
		//Spring은 jdbcTemplate.update() => insert, update, delete
		
	}
	@Override
	public List<UserDTO> getUserList() {
		String sql="select * from usertable";
		return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
		//jdbcTemplate.queryForObject(sql, null) - 1개 가져온다
		//BeanPropertyRowMapper()-한줄당 UserDTO.class로 매핑해준다
	}
	@Override
	public UserDTO getUser(String id) {
		String sql="select * from usertable where id = ?";
		try {
		return getJdbcTemplate().queryForObject(
				sql,
				new BeanPropertyRowMapper<UserDTO>(UserDTO.class),//rs의 역할
				id);
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	@Override
	public void update(Map<String, String> map) {
		String sql="update usertable set name=? ,pwd=? where id=?";
		getJdbcTemplate().update(sql,map.get("name"),map.get("pwd"),map.get("id"));
		
	}
	@Override
	public void delete(UserDTO userDTO) {
		String sql="delete usertable where id=?";
		getJdbcTemplate().update(sql, userDTO.getId());
	}
	
	

}



