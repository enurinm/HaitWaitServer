package HateWait.Data;

import HateWait.Vo.MemberVo;

public class MemberDao {
	HateWaitDBAccess db;
	String dbCommand;

	public MemberDao() {
		dbCommand = "";
		this.db = new HateWaitDBAccess();
	}

	// Queue ���
	public void insertMember(MemberVo mvo) {
		// dbCommand ����
		dbCommand = "INSERT INTO member (" + mvo.column() + ") VALUES (" + mvo.value() + ");";
		System.out.println("dbcommand::::::::::"+dbCommand);
		// dbȣ��
		db.insert(dbCommand);
	}
}
