package in.sandeep.service;

import java.util.List;
import org.springframework.stereotype.Service;
import in.sandeep.interfac.EmployeeIn;
import in.sandeep.model.Employee;
import in.sandeep.repository.EmployeeRepository;

@Service
public class EmployeeService implements EmployeeIn {

	private EmployeeRepository repository;
	
	public EmployeeService(EmployeeRepository repository) {
		this.repository=repository;
	}
	
	@Override
	public Employee findById(int id) {
		return repository.findById(id);
	}
	@Override
	public int insertEmployee(Employee emp) {
		
		return repository.insertEmployee(emp);
	}
	@Override
	public int updateEmployee(int id, Employee emp) {
		return repository.updateEmployee(id, emp);
	}
	@Override
	public int deleteEmployee(int id) {
		return repository.deleteEmployee(id);
	}
	@Override
	public List<Employee> findAllEmployees() {
		return repository.findAllEmployees();
	}
}
