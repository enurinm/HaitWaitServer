package hatewait.service;

import hatewait.data.MemberDao;
import hatewait.util.SettingVoUtil;
import hatewait.vo.MemberVo;

public class MemberService {
	MemberDao md;
	SettingVoUtil settingVoUtil;
	ClientService cs;

	public MemberService() {
		md = new MemberDao();
		settingVoUtil = new SettingVoUtil();
		cs = new ClientService();
	}

	public void insertMember(String id, String name, int phone, String pw) {
		MemberVo mvo = settingVoUtil.setMemberVo(id, name, phone, pw);
		System.out.println("MemberVo::::::::::::" + mvo.toString());
		md.insertMember(mvo);
		cs.insertClient(id, name, phone, -1, true);
		return;
	}
	
	public void modifyMember(String id, String name, int phone, String pw) {
		MemberVo mvo = settingVoUtil.setMemberVo(id, name, phone, pw);
		System.out.println("MemberVo::::::::::::" + mvo.toString());
		md.modifyMember(mvo);
		cs.modifyClient(id, name, phone, -1, true);
		return;
	}

}
