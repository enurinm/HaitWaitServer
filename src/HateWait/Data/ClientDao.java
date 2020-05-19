package HateWait.Data;

import HateWait.Vo.ClientVo;

public class ClientDao {
	HateWaitDBAccess db;
	String dbCommand;

	public ClientDao() {
		dbCommand = "";
		this.db = new HateWaitDBAccess();
	}

	// client 등록
	public void insertClient(ClientVo cvo) {
		// dbCommand 수정
		dbCommand = "INSERT INTO client (" + cvo.column() + ") VALUES (" + cvo.value() + ");";
		System.out.println("dbcommand::::::::::"+dbCommand);
		// db호출
		db.insert(dbCommand);
	}

	/*
	 * client 조회 -개인 -리스트
	 */
//	ClientVo readClient() {
//		ClientVo cvo;
//		return cvo;
//	}
//	
//	ClientVo[] readClientList() {
//		ClientVo[] cvo;
//		return cvo;
//	}

}
