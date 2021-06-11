package controller.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.EmployeeCommand;
import service.employees.EmployeeDeleteService;
import service.employees.EmployeeInfoService;
import service.employees.EmployeeListService;
import service.employees.EmployeeModifyService;
import service.employees.EmployeeNoService;
import service.employees.EmployeeService;

@Controller
@RequestMapping("emp")
public class EmployeeController {
	@Autowired EmployeeService employeeservice;
	@Autowired EmployeeNoService employeeNoService;
	@Autowired EmployeeListService employeeListService;
	@Autowired EmployeeInfoService employeeInfoService;
	@Autowired EmployeeModifyService employeeModifyService;
	@Autowired EmployeeDeleteService employeeDeleteService;
	@RequestMapping("emplist")
	public String emplist(Model model)
	{	employeeListService.empList(model);
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
	@RequestMapping("empInfo")
	public String empInfo(@RequestParam(value="empNo") String empNo, Model model)
	{	employeeInfoService.empInfo(empNo,model);
		System.out.println(empNo);
		return "employee/employeeInfo";
	}
	@RequestMapping("empModify")
	public String empModify(@RequestParam(value="empNo") String empNo, Model model)
	{	employeeInfoService.empInfo(empNo,model);
		return "employee/employeeModify";
	}
	
	@RequestMapping("empNodifyOk")
	public String empNodifyOk(EmployeeCommand employeecommand)
	{	employeeModifyService.empModify(employeecommand);
		return "redirect:empInfo?empNo="+employeecommand.getEmpNo();	
	}
	@RequestMapping("empDelete")
	public String empDelete(@RequestParam(value="empNo") String empNo)
	{	employeeDeleteService.empDelete(empNo);
		return "redirect:empList";
	}
	
}
