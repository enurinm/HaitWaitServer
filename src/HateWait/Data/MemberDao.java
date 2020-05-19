package HateWait.Data;

import HateWait.Vo.MemberVo;

public class MemberDao {
	HateWaitDBAccess db;
	String dbCommand;

	public MemberDao() {
		dbCommand = "";
		this.db = new HateWaitDBAccess();
	}

	// Queue 등록
	public void insertMember(MemberVo mvo) {
		// dbCommand 수정
		dbCommand = "INSERT INTO member (" + mvo.column() + ") VALUES (" + mvo.value() + ");";
		System.out.println("dbcommand::::::::::"+dbCommand);
		// db호출
		db.insert(dbCommand);
	}
}
