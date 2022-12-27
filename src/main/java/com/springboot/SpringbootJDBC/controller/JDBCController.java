package com.springboot.SpringbootJDBC.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.SpringbootJDBC.DTO.GenericResponse;
import com.springboot.SpringbootJDBC.DTO.SpringJDBCDTO;
import com.springboot.SpringbootJDBC.service.JdbcService;

@RestController
@RequestMapping("/springjdbc")
public class JDBCController {
	@Autowired
	private JdbcService JdbcService;

	@GetMapping(value = "/getall")
	public GenericResponse<SpringJDBCDTO> getvalue() throws SQLException {

		List<SpringJDBCDTO> obj = JdbcService.getall();
		GenericResponse<SpringJDBCDTO> responce = new GenericResponse<SpringJDBCDTO>();
		responce.setStatus("value GET success");
		responce.setData(null);
		responce.setDataList(obj);
		responce.setMessage("Get successfully");
		return responce;

	}

	@PostMapping(value = "/create")
	public GenericResponse<SpringJDBCDTO> postvalue(@RequestBody SpringJDBCDTO data) throws SQLException {
		JdbcService.save(data);
		GenericResponse<SpringJDBCDTO> responce = new GenericResponse<SpringJDBCDTO>();
		responce.setStatus("value save success");
		responce.setData(data);
		responce.setDataList(null);
		responce.setMessage("Store successfully");
		return responce;

	}

	@PutMapping(value = "/update")
	public GenericResponse<SpringJDBCDTO> updatevalue(@RequestBody SpringJDBCDTO data) throws SQLException {
		JdbcService.Update(data);

		GenericResponse<SpringJDBCDTO> responce = new GenericResponse<SpringJDBCDTO>();
		responce.setStatus("value Update success");
		responce.setData(data);
		responce.setDataList(null);
		responce.setMessage("Updated successfully");
		return responce;

	}

	@DeleteMapping(value = "/delete")
	public GenericResponse<SpringJDBCDTO> deletevalue(@RequestBody SpringJDBCDTO data) throws SQLException {
		JdbcService.deletevalue(data);

		GenericResponse<SpringJDBCDTO> responce = new GenericResponse<SpringJDBCDTO>();
		responce.setStatus("value delete success");
		responce.setData(null);
		responce.setDataList(null);
		responce.setMessage("deletd successfully");
		return responce;

	}

	@GetMapping(value = "/get/{userId}")
	public GenericResponse<SpringJDBCDTO> get(@PathVariable Integer userId) throws SQLException {
		SpringJDBCDTO user = JdbcService.getById(userId);

		GenericResponse<SpringJDBCDTO> responce = new GenericResponse<SpringJDBCDTO>();
		responce.setStatus("value GetById success");
		responce.setData(user);
		responce.setDataList(null);
		responce.setMessage("GetById successfully");
		return responce;

	}

}
