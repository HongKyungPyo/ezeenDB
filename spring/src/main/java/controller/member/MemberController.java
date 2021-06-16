package controller.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.MemberCommand;
import model.AuthInfo;
import service.member.MemberDeleteOkService;
import service.member.MemberDetailService;
import service.member.MemberInfoService;
import service.member.MemberJoinService;
import service.member.MemberListService;
import service.member.MemberModifyService;
import service.member.MemberPwChangeService;
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
	@Autowired MemberDeleteOkService memberDeleteOkService;
	@Autowired MemberPwChangeService memberPwChangeService;
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
	@RequestMapping("memDelete")
	public String memDelete()
	{
		return "member/memDelete";
	}
	@RequestMapping ("memDeleteOk")
	public String memDeleteOk(@RequestParam(value="membPw")String memPw,
								HttpSession session)
	{	memberDeleteOkService.del(session,memPw);
		session.invalidate();//세션데이터 모두삭제
		return "redirect:/";//첫페이지로
	}
	@RequestMapping("pwchange")
	public String pwchange()
	{
		return "member/pwChange";
	}
	@Autowired BCryptPasswordEncoder bcryptPasswordEncoder;
	@RequestMapping ("pwChangeCnf")
	public String pwChangeCnf(HttpSession session,@RequestParam(value="membPw")String membPw)
	{	AuthInfo authInfo=(AuthInfo)session.getAttribute("authInfo");
		String userPw=authInfo.getUserPw();
		if(bcryptPasswordEncoder.matches(membPw, userPw))
			return "member/pwChangeCnf";
		else return "member/pwChange";
	}
	
	@RequestMapping("pwChangeOk")
	public String pwChangeOk(HttpSession session,@RequestParam(value="membPw")String membPw,
							@RequestParam(value="newPw")String newPw,
							@RequestParam(value="newPwCon")String newPwCon)
	{	AuthInfo authInfo=(AuthInfo)session.getAttribute("authInfo");
		String userId=authInfo.getUserId();
		String pw=authInfo.getUserPw();
		if(bcryptPasswordEncoder.matches(membPw, pw))
		{	newPw=bcryptPasswordEncoder.encode(newPw);
			memberPwChangeService.pwOk(userId, newPw);
			if(newPw.equals(newPwCon)) return "redirect:/";
			else return"member/pwChangeCnf";
		}
		else return"member/pwChangeCnf";
	}
	
}
