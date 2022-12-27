package com.springboot.SpringbootJDBC.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import com.springboot.SpringbootJDBC.DTO.SpringJDBCDTO;

@Repository
public class JdbcRepository {

	private static Connection connection;

	public Connection getConnection() throws SQLException {

		if (!ObjectUtils.isEmpty(connection)) {
			/*
			 * Connection con = DriverManager.getConnection(
			 * "jdbc:mysql://101.53.155.156:3306/mysql_demo_tnj", "mysql_demo_tnj",
			 * "Ebrain@20");
			 * 
			 * return con;
			 */
		}
		Connection con = DriverManager.getConnection("jdbc:mysql://101.53.155.156:3306/mysql_demo_tnj",
				"mysql_demo_tnj", "Ebrain@20");
		return con;

	}

	public void save(SpringJDBCDTO dto) throws SQLException {
		Connection con = getConnection();
		String sql = "insert into tb_dhanasekaran_spring_jdbc(user_id,user_name,email,phone) values(?,?,?,?)";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, dto.getUserid());
		ps.setString(2, dto.getusername());
		ps.setString(3, dto.getEmail());
		ps.setString(4, dto.getPhone());
		ps.executeUpdate();
	}

	public void Update(SpringJDBCDTO dto) throws SQLException {

		Connection con = getConnection();
		String insertQuery = "update tb_dhanasekaran_spring_jdbc set user_name = ?,email = ?,phone = ? where user_id = ?";
		PreparedStatement ps = con.prepareStatement(insertQuery);
		ps.setString(1, dto.getusername());
		ps.setString(2, dto.getEmail());
		ps.setString(3, dto.getPhone());
		ps.setInt(4, dto.getUserid());
		ps.executeUpdate();

	}

	public void deletevalue(SpringJDBCDTO dto) throws SQLException {

		Connection con = getConnection();
		String insertQuery = "delete from tb_dhanasekaran_spring_jdbc where user_id = ?";
		PreparedStatement ps = con.prepareStatement(insertQuery);
		ps.setInt(1, dto.getUserid());
		ps.executeUpdate();
		ps.close();
		con.close();
	}

	public List<SpringJDBCDTO> getall() throws SQLException {
		Connection con = getConnection();
		String selectQuery = "select * from tb_dhanasekaran_spring_jdbc";

		PreparedStatement ps = con.prepareStatement(selectQuery);

		ResultSet resultSet = ps.executeQuery();

		List<SpringJDBCDTO> obj = new ArrayList<SpringJDBCDTO>();
		SpringJDBCDTO user = null;
		while (resultSet.next()) {
			user = new SpringJDBCDTO();
			user.setUserid(resultSet.getInt(1));
			user.setusername(resultSet.getString(2));
			user.setEmail(resultSet.getString(3));
			user.setPhone(resultSet.getString(4));
			obj.add(user);
		}
		return obj;
	}

	public SpringJDBCDTO getById(Integer userId) throws SQLException {
		Connection con = getConnection();
		String sql = "select user_id,user_name,email,phone from tb_dhanasekaran_spring_jdbc where user_id=?";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, userId);

		ResultSet resultSet = ps.executeQuery();

		SpringJDBCDTO user = null;
		while (resultSet.next()) {
			user = new SpringJDBCDTO();
			user.setUserid(resultSet.getInt(1));
			user.setusername(resultSet.getString(2));
			user.setEmail(resultSet.getString(3));
			user.setPhone(resultSet.getString(4));

		}

		return user;

	}

}
