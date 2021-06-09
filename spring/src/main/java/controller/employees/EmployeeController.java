package controller.employees;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import command.EmployeeCommand;

@Controller
@RequestMapping("emp")
public class EmployeeController {
	@RequestMapping("emplist")
	public String emplist()
	{
		return"employee/emplist";
	}
	@RequestMapping("empreget")
	public String empreget()
	{
		return"employee/employeeForm";
	}
	@RequestMapping(value="empjoin",method=RequestMethod.POST)
	public String empJoin(EmployeeCommand employeecommand)
	{	System.out.println(employeecommand.getEmpID());
		return "redirect:emplist";
	}
}
