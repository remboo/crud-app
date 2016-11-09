package com.johnremboo.dao;

import com.johnremboo.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements BaseDao<User>{
	private Connection connection;
	
	public UserDao(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public List<User> getAll() throws SQLException {
		String sql = "select * from user";
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		User user = null;
		List<User> list = new ArrayList<>();
		while (rs.next()) {
			user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setSurname(rs.getString("surname"));
			user.setYear(rs.getInt("year"));
			list.add(user);
		}
		rs.close();
		ps.close();
		
		return list;
	}

	@Override
	public User getById(int id) throws SQLException {
		String sql = "select * from user where id=?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		User user = new User();
		if (rs.next()) {
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setSurname(rs.getString("surname"));
			user.setYear(rs.getInt("year"));
		}
		rs.close();
		ps.close();
		
		return user;
	}
	@Override
	public void update(User user) throws SQLException {
		String sql = "update user set name=?, surname=?, year=? where id=?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, user.getName());
		ps.setString(2, user.getSurname());
		ps.setInt(3, user.getYear());
		ps.setInt(4, user.getId());
		ps.executeUpdate();
		ps.close();
	}

	@Override
	public boolean add(User user) {
		try {
			String sql = "insert into user (name, surname, year) values (?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getSurname());
			ps.setInt(3, user.getYear());
			ps.executeUpdate();

			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public void delete(int id) {
		//todo realize
	}

	@Override
	public void closeConnection()   {
		try {
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}