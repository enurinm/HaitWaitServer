package HateWait.Data;

import HateWait.Vo.StoreVo;

public class StoreDao {
	HateWaitDBAccess db;
	String dbCommand;

	StoreDao() {
		db.connect();
	}

	// client 등록
	void insertStore(StoreVo svo) {
		// dbCommand 수정
		dbCommand = "INSERT INTO client (" + svo.column() + ") VALUES (" + svo.value() + ");";
		// db호출
		db.insert(dbCommand);
	}
}
