package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import model.EmployeeDTO;

public class EmployeeRepository {
	@Autowired
	SqlSession sqlsession;
	private final String namespace="mappers.employeeMapper";
	private String statement;
	
	public void empdelete(String empNo)
	{
		statement= namespace + ".employeeDelete";
		sqlsession.delete(statement, empNo);
		
	}
	
	public void empUpdate(EmployeeDTO dto)
	{
		statement= namespace + ".employeeUpdate";
		sqlsession.update(statement, dto);
	}
	
	
	
	public void insertEmployee(EmployeeDTO dto)
	{
		statement= namespace + ".employeeInsert";
		sqlsession.insert(statement, dto);
	}
	public EmployeeDTO empInfo(String empNo)
	{
		statement= namespace + ".employeeInfo";
		return sqlsession.selectOne(statement, empNo);
	}
	public int getEmpNo()
	{
		statement= namespace + ".empNo";
		return sqlsession.selectOne(statement);

	}
	public List<EmployeeDTO> empAllList()
	{
		statement= namespace+".empAllList";
		return sqlsession.selectList(statement);
	}
}
