package com.scotia.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.scotia.entity.ArticleRowMapper;
import com.scotia.entity.User;
@Transactional
@Repository
public class UserDAO implements IUserDAO {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<User> getAllUsers() {
		String sql = "select id,firstname,companyname,username,email,street,suite,city,zipcode,lat,lng,phone,website,catchPhrase,\r\n" + 
				"bs from sampledb.user u,sampledb.address a,sampledb.company c,sampledb.geo g where u.id=a.addressid and \r\n" + 
				"a.addressid=c.companyid and c.companyid=g.goeid";
        //RowMapper<Article> rowMapper = new BeanPropertyRowMapper<Article>(Article.class);
		RowMapper<User> rowMapper = new ArticleRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}	
	
	@Override
	public void updateUser(User user) {
		
		String sql = "UPDATE sampledb.user SET firstname=?, email =?, phone= ? WHERE id=?";
		jdbcTemplate.update(sql, user.getFirstname(),user.getEmail(),user.getPhoneNumber(), user.getId());
	}

	@Override
	public void deleteUser(int id) {
		String sql = "DELETE FROM sampledb.user WHERE id=?";
		jdbcTemplate.update(sql, id);
	}
	@Override
	public boolean articleExists(String title, String category) {
		String sql = "SELECT count(*) FROM articles WHERE title = ? and category=?";
		int count = jdbcTemplate.queryForObject(sql, Integer.class, title, category);
		if(count == 0) {
    		return false;
		} else {
			return true;
		}
	}
	
	@Override
	public void addUser(User user)
	{
		System.out.println(">>>>>>>>>>>>>ID>>>>>>>>>"+user);
		String userdata = "insert into sampledb.user (id,firstname,username,email,phone,website) values(?,?,?,?,?,?)";
		String addressdata = "insert into sampledb.address (addressid,street,suite,city,zipcode) values(?,?,?,?,?)";
		String geodata = "insert into sampledb.geo (goeid,lat,lng) values(?,?,?)";
		String companydata = "insert into sampledb.company(companyid,companyname,catchPhrase,bs) values(?,?,?,?)";
		jdbcTemplate.update(userdata,user.getId(),user.getFirstname(),user.getUsername(),user.getEmail(),user.getPhoneNumber(),user.getWebSite());
		jdbcTemplate.update(addressdata,user.getId(),user.getAddress().getStreet(),user.getAddress().getSuite(),user.getAddress().getCity(),user.getAddress().getZipcode());
		jdbcTemplate.update(geodata,user.getId(),user.getAddress().getGeo().getLat(),user.getAddress().getGeo().getLng());
		jdbcTemplate.update(companydata,user.getId(),user.getCompany().getCompanyname(),user.getCompany().getCatchPhrase(),user.getCompany().getBs());
		
	}

	
	@Override
	public void getUser(Integer id) {
		String sql = "select firstname,companyname,username,email,street,suite,city,zipcode,lat,lng,phone,website,catchPhrase,\r\n" + 
				"bs from sampledb.user u,sampledb.address a,sampledb.company c,sampledb.geo g where u.id=? and  u.id=a.addressid and \r\n" + 
				"a.addressid=c.companyid and c.companyid=g.goeid";
		jdbcTemplate.update(sql, id);
		
	}

}
