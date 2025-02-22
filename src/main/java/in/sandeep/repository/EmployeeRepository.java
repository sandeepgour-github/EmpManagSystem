package in.sandeep.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import in.sandeep.interfac.EmployeeIn;
import in.sandeep.model.Employee;

@Repository
public class EmployeeRepository implements EmployeeIn {
   
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public EmployeeRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}
	
	@Override
	public int insertEmployee(Employee emp ) {
		
		String sql="insert into employees values(?,?,?,?)";
		return jdbcTemplate.update(sql,emp.getEid(),emp.getEname(),emp.getSal(),emp.getDepno());
	}
	
	@Override
    public int updateEmployee(int id,Employee emp ) {
		
		String sql="update employees set ename=?,sal=?,depno=? where eid=?";
		return jdbcTemplate.update(sql,emp.getEname(),emp.getSal(),emp.getDepno(),id);
	}
	@Override
    public int deleteEmployee(int id) {
		
		String sql="delete from employees where eid=?";
		return jdbcTemplate.update(sql,id);
	}
    
	@Override
    public List<Employee> findAllEmployees(){
    	
    	String sql="select * from employees";
    	EmployeeRowMapper emRow=new EmployeeRowMapper();
    	return jdbcTemplate.query(sql, emRow);
    }
   
	@Override
   public Employee findById(int id){
    	
    	String sql="select * from employees where eid=?";
    	EmployeeRowMapper employeeRowMapper=new EmployeeRowMapper();
    	Employee emp=null;
    	try {
    	emp =jdbcTemplate.queryForObject(sql, employeeRowMapper, id);
    	}catch(EmptyResultDataAccessException ex) {
    		System.out.println("error in findById method"+ex.getMessage());
    	}
    	return emp;
    }

}
