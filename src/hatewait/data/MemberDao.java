package hatewait.data;

import hatewait.vo.MemberVo;

public class MemberDao {
	HateWaitDBAccess db;
	String dbCommand;

	public MemberDao() {
		dbCommand = "";
		this.db = new HateWaitDBAccess();
	}

	// 회원 등록
	public void insertMember(MemberVo mvo) {
		// dbCommand 수정
		dbCommand = "INSERT INTO member (" + mvo.column() + ") VALUES (" + mvo.value() + ");";
		System.out.println("dbcommand::::::::::" + dbCommand);
		// db호출
		db.insert(dbCommand);
		return;
	}
}
