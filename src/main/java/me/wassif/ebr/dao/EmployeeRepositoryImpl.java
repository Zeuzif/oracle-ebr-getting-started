package me.wassif.ebr.dao;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import me.wassif.ebr.model.Employee;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

	@Autowired
	private JdbcTemplate template;

	@Override
	public Long save(Employee employee) {
		SimpleJdbcCall caller = new SimpleJdbcCall(template).withCatalogName("EMP_PKG").withFunctionName("add");
		SqlParameterSource in = new MapSqlParameterSource().addValue("name", employee.getName())
				.addValue("phone_number", employee.getPhone());
		return caller.executeFunction(BigDecimal.class, in).longValue();
	}

}
