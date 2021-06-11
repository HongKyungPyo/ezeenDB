package service.employees;

import org.springframework.beans.factory.annotation.Autowired;

import command.EmployeeCommand;
import model.EmployeeDTO;
import repository.EmployeeRepository;

public class EmployeeModifyService {
	@Autowired EmployeeRepository employeeRepository;
	public void empModify(EmployeeCommand employeecommand)
	{	EmployeeDTO dto= new EmployeeDTO();
		dto.setEmpNo(employeecommand.getEmpNo());
		dto.setEmpDeptNumber(employeecommand.getEmpDeptNumber());
		dto.setEmpEmail(employeecommand.getEmpEmail());
		dto.setEmpPhoneNumber(employeecommand.getEmpPhoneNumber());
		dto.setHireDate(employeecommand.getHireDate());
		dto.setSalary(employeecommand.getSalary());
		employeeRepository.empUpdate(dto);
	}
}
