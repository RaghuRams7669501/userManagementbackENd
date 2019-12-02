package com.scotia.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ArticleRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet row, int rowNum) throws SQLException {
		User user = new User();
		user.setId(row.getInt("id"));
		user.setEmail(row.getString("email"));
		user.setFirstname(row.getString("firstname"));
		user.setUsername(row.getString("username"));
		user.setPhoneNumber(row.getString("phone"));
		user.setWebSite(row.getString("website"));
		Address address=new Address();
		address.setZipcode(row.getString("zipcode"));
		address.setCity(row.getString("city"));
		address.setStreet(row.getString("street"));
		address.setSuite(row.getString("suite"));
		Geo geo =new Geo();
		geo.setLat(row.getString("lat"));
		geo.setLng(row.getString("lat"));
		address.setGeo(geo);
		Company company=new Company();
		company.setCatchPhrase(row.getString("catchPhrase"));
		company.setBs(row.getString("bs"));
		company.setCompanyname(row.getString("companyname"));		
		user.setAddress(address);
		user.setCompany(company);
		
		return user;
	}

}
