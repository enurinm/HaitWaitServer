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

	// 회원 등록
	public void insertMember(MemberVo mvo) {
		// dbCommand 수정
		dbCommand = "INSERT INTO member (" + mvo.column() + ") VALUES (" + mvo.value() + ");";
		System.out.println("dbcommand::::::::::" + dbCommand);
		// db호출
		db.insert(dbCommand);
		return;
	}
	
	//회원 수정
	public void modifyMember(MemberVo mvo) {
		String set = "";
		set = makeCommandUtil.setMemberString(mvo, set);
		dbCommand = "UPDATE member set " + set + " where id='" + mvo.getId() + "';";
		System.out.println("dbcommand::::::::::" + dbCommand);
		db.update(dbCommand);
		return;
	}
}
