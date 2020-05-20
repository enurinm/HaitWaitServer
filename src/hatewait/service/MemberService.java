package hatewait.service;

import hatewait.data.MemberDao;
import hatewait.util.SettingUtil;
import hatewait.vo.MemberVo;

public class MemberService {
	MemberDao md;
	SettingUtil settingUtil;
	
	public MemberService(){
		md=new MemberDao();
		settingUtil = new SettingUtil();
	}
	
	public void insertMember(String id, String name, int phone) {
		MemberVo mvo = settingUtil.setMemberVo(id, name, phone);
		System.out.println("MemberVo::::::::::::"+mvo.toString());
		md.insertMember(mvo);
		return ;
	}

}
