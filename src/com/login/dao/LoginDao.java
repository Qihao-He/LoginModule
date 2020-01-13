package com.login.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import com.mysql.jdbc.Connection;

public class LoginDao {
	private static final String url = "jdbc:mysql://localhost:3306/sales";
	private static final String sqluser = "root";
	private static final String sqlpass = "qihaohe";
	String sql = "select * from login where username=? and password=?";
	public boolean check(String username, String pass) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection(url, sqluser, sqlpass);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, username);
			st.setString(2, pass);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
}
