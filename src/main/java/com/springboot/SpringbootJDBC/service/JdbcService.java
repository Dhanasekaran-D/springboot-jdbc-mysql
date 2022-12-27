package com.springboot.SpringbootJDBC.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.SpringbootJDBC.DTO.SpringJDBCDTO;
import com.springboot.SpringbootJDBC.repository.JdbcRepository;

@Service
public class JdbcService {
	@Autowired
	public JdbcRepository jdbcRepository;

	public void save(SpringJDBCDTO dto) throws SQLException {
		jdbcRepository.save(dto);
	}

	public void Update(SpringJDBCDTO dto) throws SQLException {
		jdbcRepository.Update(dto);
	}

	public void deletevalue(SpringJDBCDTO dto) throws SQLException {
		jdbcRepository.deletevalue(dto);
	}

	public List<SpringJDBCDTO> getall() throws SQLException {

		return jdbcRepository.getall();
	}

	public SpringJDBCDTO getById(Integer userId) throws SQLException {

		return jdbcRepository.getById(userId);
	}

}
