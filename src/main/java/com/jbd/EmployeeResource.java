package com.jbd;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jbd.model.Employee;
import com.jbd.service.EmployeeService;

@Path("employee/api")
public class EmployeeResource {

	@Inject
	private EmployeeService employeeService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/v1")
	public String getProperties() {
		return "Hello jbd";
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/v2")
	public List<Employee> getAllEmployees() throws Exception {

		List<Employee> empList = employeeService.getAllEmployees();
		
		return empList;
	}

}
