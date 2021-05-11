package com.jbd.serviceImpl;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import com.jbd.dao.EmployeeDao;
import com.jbd.model.Employee;
import com.jbd.service.EmployeeService;

@Dependent
public class EmployeeServiceImpl implements EmployeeService {

	@Inject
	private EmployeeDao employeeDao;

	@Override
	public List<Employee> getAllEmployees() throws Exception {

		return employeeDao.getAllEmployees();
	}

}
