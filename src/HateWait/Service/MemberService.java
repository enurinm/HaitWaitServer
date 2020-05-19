package HateWait.Service;

import HateWait.Data.MemberDao;
import HateWait.Vo.MemberVo;

public class MemberService {
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
		MemberDao md=new MemberDao();
		
		md.insertMember(mvo);
		return ;
	}

}
