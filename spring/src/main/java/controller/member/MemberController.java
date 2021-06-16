package controller.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.MemberCommand;
import service.member.MemberDetailService;
import service.member.MemberInfoService;
import service.member.MemberJoinService;
import service.member.MemberListService;
import service.member.MemberModifyService;
import service.member.MemberUpdateService;
@Controller
@RequestMapping("member")
public class MemberController {
	@Autowired MemberJoinService memberJoinService;
	@Autowired MemberListService memberListService;
	@Autowired MemberInfoService memberInfoService;
	@Autowired MemberModifyService memberModifyService;
	@Autowired MemberDetailService memberDetailService;
	@Autowired MemberUpdateService memberUpdateService;
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
	@RequestMapping("memInfo")
	public String memInfo(@RequestParam(value="memId")String memId, Model model)
	{	memberInfoService.memInfo(memId,model);
		return "member/memberInfo";
	}
	@RequestMapping("memModify")
	public String memModify(@RequestParam(value="memId")String memId, Model model)
	{
		memberInfoService.memInfo(memId,model);
		return "member/memberModify";
	}
	@RequestMapping("memModifyOk")
	public String memModifyOk(MemberCommand memberCommand)
	{	memberModifyService.memUpdate(memberCommand);
		return "redirect:memInfo?memId="+memberCommand.getMembId();
	}
	@RequestMapping("memMyPage")
	public String myPage()
	{
		return"member/memMyPage";
	}
	@RequestMapping("myInfo")
	public String myInfo(HttpSession session,Model model)
	{	memberDetailService.memInfo(session, model);
		return "member/memDetail";
	}
	@RequestMapping("memUpdate")
	public String memUpdate(HttpSession session,Model model)
	{
		memberDetailService.memInfo(session, model);
		return"member/memUpdate";

	}
	@RequestMapping("memUpdateOk")
	public String UpdateOk(MemberCommand memberCommand, HttpSession session)
	{	int i =memberUpdateService.memUpdate(memberCommand,session);
		if(i==1)//memberUpdateService에서 비번이 같으면 1
		return "redirect:myInfo";
		else return "redirect:memUpdate";
	}
	
}
