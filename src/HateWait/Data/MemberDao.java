package HateWait.Data;

import HateWait.Vo.MemberVo;

public class MemberDao {
	HateWaitDBAccess db;
	String dbCommand;

	MemberDao() {
		db.connect();
	}

	// Queue ���
	void insertMember(MemberVo mvo) {
		// dbCommand ����
		dbCommand = "INSERT INTO client (" + mvo.column() + ") VALUES (" + mvo.value() + ");";
		// dbȣ��
		db.insert(dbCommand);
	}
}
