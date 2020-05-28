package hatewait.data;

import hatewait.util.MakeCommandUtil;
import hatewait.vo.MemberVo;

public class MemberDao {
	HateWaitDBAccess db;
	String dbCommand;
	MakeCommandUtil makeCommandUtil;

	public MemberDao() {
		dbCommand = "";
		this.db = new HateWaitDBAccess();
		makeCommandUtil = new MakeCommandUtil();
	}

	// ȸ�� ���
	public void insertMember(MemberVo mvo) {
		// dbCommand ����
		dbCommand = "INSERT INTO member (" + mvo.column() + ") VALUES (" + mvo.value() + ");";
		System.out.println("dbcommand::::::::::" + dbCommand);
		// dbȣ��
		db.insert(dbCommand);
		return;
	}
	
	//ȸ�� ����
	public void modifyMember(MemberVo mvo) {
		String set = "";
		set = makeCommandUtil.setMemberString(mvo, set);
		dbCommand = "UPDATE member set " + set + " where id='" + mvo.getId() + "';";
		System.out.println("dbcommand::::::::::" + dbCommand);
		db.update(dbCommand);
		return;
	}
}
