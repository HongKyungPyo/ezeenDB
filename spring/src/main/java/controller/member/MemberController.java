package controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.MemberCommand;
import service.member.MemberJoinService;
import service.member.MemberListService;
@Controller
@RequestMapping("member")
public class MemberController {
	@Autowired MemberJoinService memberJoinService;
	@Autowired MemberListService memberListService;
	@RequestMapping("agree") //1주소를 넘겨서
	public String agree()
	{
		return "member/agree";//2페이지를 받는다
	}
	@RequestMapping("memReget")//주소넘기기
	public String memReget()
	{
		return"member/memberForm";//페이지받기
		
	}
	@RequestMapping(value ="memJoin", method = RequestMethod.POST)
	public String memJoin(MemberCommand membercommand)
	{	memberJoinService.memberInsert(membercommand);
		return "redirect:..main";
	}
	@RequestMapping("memList")
	public String memList(Model model)
	{	memberListService.memList(model);
		return"member/memberList";
		
	}
}
