package hatewait.service;

import hatewait.data.MemberDao;
import hatewait.util.SettingVoUtil;
import hatewait.vo.MemberHomeVo;
import hatewait.vo.MemberVo;

public class MemberService {
	MemberDao md;
	SettingVoUtil settingVoUtil;
	ClientService cs;
	QueueService qs;

	public MemberService() {
		md = new MemberDao();
		settingVoUtil = new SettingVoUtil();
		cs = new ClientService();
		qs = new QueueService();
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
	
	public MemberHomeVo loadMemberHome(String id) { //MAIN;MEMBER;이름;대기중인 가게이름;내순서
//		String home="";
		//이름(memeber);대기중인 가게이름(queue.sid->store);내순서(queue)
		MemberHomeVo mhvo=md.memberHomeInfo(id);
		System.out.println("::::::::::::"+mhvo.toString());
		return mhvo;
	}

}
