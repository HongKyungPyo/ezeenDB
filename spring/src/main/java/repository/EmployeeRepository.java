package repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import model.EmployeeDTO;

public class EmployeeRepository {
	@Autowired
	SqlSession sqlsession;
	private final String namespace="mappers.employeeMapper";
	private String statement;
	public void insertEmployee(EmployeeDTO dto)
	{
		statement= namespace + ".employeeInsert";
		sqlsession.insert(statement, dto);
	}
	public int getEmpNo()
	{
		statement= namespace + ".empNo";
		return sqlsession.selectOne(statement);

	}
}
