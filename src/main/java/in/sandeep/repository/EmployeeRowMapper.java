package in.sandeep.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import in.sandeep.model.Employee;

public class EmployeeRowMapper implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee emp=null ;
		emp=new Employee();
		emp.setEid(rs.getInt("eid"));
		emp.setEname(rs.getString("ename"));
		emp.setSal(rs.getDouble("sal"));
		emp.setDepno(rs.getInt("depno"));
		
		return emp;
	}

}
