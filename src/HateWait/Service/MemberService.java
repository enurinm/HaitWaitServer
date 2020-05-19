package HateWait.Service;

import HateWait.Data.MemberDao;
import HateWait.Vo.MemberVo;

public class MemberService {
	MemberDao md;
	
	public MemberService(){
		md=new MemberDao();
	}
	
	public MemberVo setMemberVo(String id, String name, int phone) {
		MemberVo mvo = new MemberVo();
		mvo.setId(id);
		mvo.setName(name);
		mvo.setPhone(phone);
		return mvo;
	}

	public void insertMember(String id, String name, int phone) {
		MemberVo mvo = setMemberVo(id, name, phone);
		System.out.println("MemberVo::::::::::::"+mvo.toString());
		
		
		md.insertMember(mvo);
		return ;
	}

}
