package HateWait.Data;

import HateWait.Vo.StoreVo;

public class StoreDao {
	HateWaitDBAccess db;
	String dbCommand;

	public StoreDao() {
		dbCommand = "";
		this.db = new HateWaitDBAccess();
	}

	// client 등록
	public void insertStore(StoreVo svo) {
		// dbCommand 수정
		dbCommand = "INSERT INTO store (" + svo.column() + ") VALUES (" + svo.value() + ");";
		System.out.println("dbcommand::::::::::" + dbCommand);
		// db호출
		db.insert(dbCommand);
	}
}
