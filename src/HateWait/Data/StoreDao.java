package HateWait.Data;

import HateWait.Vo.StoreVo;

public class StoreDao {
	HateWaitDBAccess db;
	String dbCommand;

	StoreDao() {
		db.connect();
	}

	// client ���
	void insertStore(StoreVo svo) {
		// dbCommand ����
		dbCommand = "INSERT INTO client (" + svo.column() + ") VALUES (" + svo.value() + ");";
		// dbȣ��
		db.insert(dbCommand);
	}
}
