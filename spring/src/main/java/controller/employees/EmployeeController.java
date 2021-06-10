package controller.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import command.EmployeeCommand;
import service.employees.EmployeeNoService;
import service.employees.EmployeeService;

@Controller
@RequestMapping("emp")
public class EmployeeController {
	@Autowired EmployeeService employeeservice;
	@Autowired EmployeeNoService employeeNoService;
	@RequestMapping("emplist")
	public String emplist()
	{
		return"employee/emplist";
	}
	@RequestMapping("empreget")
	public String empreget(Model model)
	{	employeeNoService.getEmpNo(model);
		return"employee/employeeForm";
	}
	@RequestMapping(value="empjoin",method=RequestMethod.POST)
	public String empJoin(EmployeeCommand employeecommand)
	{	EmployeeService employeeService= new EmployeeService();
		employeeService.insertEmp(employeecommand);
		//System.out.println(employeecommand.getEmpID());
		return "redirect:emplist";
	}
}
