package service.member;

import command.MemberCommand;
import model.MemberDTO;
import repository.MemberRepository;

public class MemberModifyService {
	
	public void memUpdate(MemberCommand memberCommand)
	{
		MemberDTO dto=new MemberDTO();
		dto.setDetailAddr(memberCommand.getDetailAddr());
		
	}
}
