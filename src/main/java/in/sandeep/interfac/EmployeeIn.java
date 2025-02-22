package in.sandeep.interfac;

import java.util.List;

import in.sandeep.model.Employee;

public interface EmployeeIn {

	public int insertEmployee(Employee emp);
	public int updateEmployee(int id,Employee emp);
	public int deleteEmployee(int id);
	public List<Employee> findAllEmployees();
	public Employee findById(int id);
}
