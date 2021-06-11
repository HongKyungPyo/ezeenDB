package command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class EmployeeCommand {
	long empNo;
	String empID;
	String empPw;
	String empPwCon;
	String empName;
	String empDeptNumber;
	String empEmail;
	String empPhoneNumber;
	@DateTimeFormat(pattern="yyyy-mm-dd")
	Date hire_date;
	long salary;
	private Date hireDate;
	public long getEmpNo() {
		return empNo;
	}
	public void setEmpNo(long empNo) {
		this.empNo = empNo;
	}
	public String getEmpID() {
		return empID;
	}
	public void setEmpID(String empID) {
		this.empID = empID;
	}
	public String getEmpPw() {
		return empPw;
	}
	public void setEmpPw(String empPw) {
		this.empPw = empPw;
	}
	public String getEmpPwCon() {
		return empPwCon;
	}
	public void setEmpPwCon(String empPwCon) {
		this.empPwCon = empPwCon;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpDeptNumber() {
		return empDeptNumber;
	}
	public void setEmpDeptNumber(String empDeptNumber) {
		this.empDeptNumber = empDeptNumber;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public String getEmpPhoneNumber() {
		return empPhoneNumber;
	}
	public void setEmpPhoneNumber(String empPhoneNumber) {
		this.empPhoneNumber = empPhoneNumber;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHire_date(Date hireDate) {
		this.hireDate = hireDate;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public boolean isEmpPwqualsEmpPwCon()
	{
		if(empPw.equals(empPwCon))return true;
		else return false;
	}
}
