package HateWait.Data;

import HateWait.Vo.StoreVo;

public class StoreDao {
	HateWaitDBAccess db;
	String dbCommand;

	public StoreDao() {
		dbCommand = "";
		this.db = new HateWaitDBAccess();
	}

	// client ���
	public void insertStore(StoreVo svo) {
		// dbCommand ����
		dbCommand = "INSERT INTO store (" + svo.column() + ") VALUES (" + svo.value() + ");";
		System.out.println("dbcommand::::::::::" + dbCommand);
		// dbȣ��
		db.insert(dbCommand);
	}
}
