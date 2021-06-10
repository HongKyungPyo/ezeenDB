package service.employees;

import command.EmployeeCommand;
import model.EmployeeDTO;

public class EmployeeService {

	public void insertEmp(EmployeeCommand employeecommand)
	{
		
			EmployeeDTO dto= new EmployeeDTO();
			dto.setEmpDeptNumber(employeecommand.getEmpDeptNumber());
			dto.setEmpEmail(employeecommand.getEmpEmail());
			dto.setEmpId(employeecommand.getEmpID());
			dto.setEmpName(employeecommand.getEmpName());
			dto.setEmpNo(employeecommand.getEmpNo());
			dto.setEmpPhoneNumber(employeecommand.getEmpPhoneNumber());
			dto.setEmpPw(employeecommand.getEmpPw());
			dto.setHireDate(employeecommand.getHireDate());
			dto.setSalary(employeecommand.getSalary());
		
	}
}
