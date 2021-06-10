package service.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import command.EmployeeCommand;
import model.EmployeeDTO;
import repository.EmployeeRepository;

public class EmployeeService {
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	@Autowired
	EmployeeRepository employeeRepository;
	public void insertEmp(EmployeeCommand employeecommand)
	{	
				
			EmployeeDTO dto= new EmployeeDTO();
			dto.setEmpDeptNumber(employeecommand.getEmpDeptNumber());
			dto.setEmpEmail(employeecommand.getEmpEmail());
			dto.setEmpId(employeecommand.getEmpID());
			dto.setEmpName(employeecommand.getEmpName());
			dto.setEmpNo(employeecommand.getEmpNo());
			dto.setEmpPhoneNumber(employeecommand.getEmpPhoneNumber());
			dto.setEmpPw(bcryptPasswordEncoder.encode(
					employeecommand.getEmpPw()));
			dto.setHireDate(employeecommand.getHireDate());
			dto.setSalary(employeecommand.getSalary());
			employeeRepository.insertEmployee(dto);
			
		
	}
}
