package com.jbd.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.context.Dependent;
import javax.sql.DataSource;

import com.jbd.dao.EmployeeDao;
import com.jbd.model.Employee;
import com.jbd.util.Constants;

@Dependent
public class EmployeeDaoImpl implements EmployeeDao {

	@Resource(lookup = "jdbc/mysql")
	private DataSource dataSource;

	@Override
	public List<Employee> getAllEmployees() {

		PreparedStatement ps = null;
		List<Employee> dhCustAddressList = new ArrayList<Employee>();

		try (Connection connection = dataSource.getConnection()) {
			ps = connection.prepareStatement(Constants.GETALL);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				Employee employee = new Employee();

				employee.setEmployeeId(rs.getInt(""));
				employee.setEmployeeName(rs.getString(""));
				employee.setEmail(rs.getString(""));
				employee.setCountry(rs.getString(""));

				dhCustAddressList.add(employee);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dhCustAddressList;
	}

}
