package HateWait.Data;

import HateWait.Vo.MemberVo;

public class MemberDao {
	HateWaitDBAccess db;
	String dbCommand;

	MemberDao() {
		db.connect();
	}

	// Queue 등록
	void insertMember(MemberVo mvo) {
		// dbCommand 수정
		dbCommand = "INSERT INTO client (" + mvo.column() + ") VALUES (" + mvo.value() + ");";
		// db호출
		db.insert(dbCommand);
	}
}
