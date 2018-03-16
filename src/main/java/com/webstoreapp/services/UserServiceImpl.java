package com.webstoreapp.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.webstoreapp.antity.User;

public class UserServiceImpl implements UserService{
	
	private Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/store", "postgres", "postgres");
			System.out.println("GET");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	@Override
	public User loginUser(String login, String password) {
		User user = null;
		Connection con = getConnection();
		try {
			PreparedStatement pr = con.prepareStatement("select * from users where login=? and password=?");
			pr.setString(1, login);
			pr.setString(2, password);
			ResultSet rs = pr.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setUserId(rs.getInt(1));
				user.setLogin(rs.getString(2));
				user.setName(rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		if (login.equals("admin") && password.equals("admin")) {
//			user = new User();
//			user.setLogin(login);
//		}
		return user;
	}

}
