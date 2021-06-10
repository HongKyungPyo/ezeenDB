package repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeRepository {
	@Autowired
	SqlSession sqlsession;
	
}
