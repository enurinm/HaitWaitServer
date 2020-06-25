package hatewait.data;

import hatewait.util.MakeCommandUtil;
import hatewait.util.SettingVoUtil;
import hatewait.vo.MemberHomeVo;
import hatewait.vo.MemberVo;

public class MemberDao {
	HateWaitDBAccess db;
	String dbCommand;
	MakeCommandUtil makeCommandUtil;
	SettingVoUtil settingVoUtil;

	public MemberDao() {
		dbCommand = "";
		this.db = new HateWaitDBAccess();
		makeCommandUtil = new MakeCommandUtil();
		settingVoUtil = new SettingVoUtil();
	}

	public void insertMember(MemberVo mvo) {
		dbCommand = "INSERT INTO member (" + mvo.column() + ") VALUES (" + mvo.value() + ");";
		System.out.println("dbcommand::::::::::" + dbCommand);
		db.insert(dbCommand);
		return;
	}
	
	public void modifyMember(MemberVo mvo) {
		String set = "";
		set = makeCommandUtil.setMemberString(mvo, set);
		dbCommand = "UPDATE member set " + set + " where id='" + mvo.getId() + "';";
		System.out.println("dbcommand::::::::::" + dbCommand);
		db.update(dbCommand);
		return;
	}
	
	public MemberHomeVo memberHomeInfo(String id) {
		dbCommand = "SELECT member.name AS mname, store.name AS sname, queue.turn "
				+ "FROM member, queue, store "
				+ "WHERE queue.cid='"+id+"' AND member.id=queue.cid AND store.id=queue.sid;";
		System.out.println("dbcommand::::::::::" + dbCommand);
		MemberHomeVo mhvo= settingVoUtil.setMemberHomeVo(db.select(dbCommand));
		return mhvo;
	}
}
