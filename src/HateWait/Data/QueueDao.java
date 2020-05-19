package HateWait.Data;

import HateWait.Vo.QueueVo;

public class QueueDao {
	HateWaitDBAccess db;
	String dbCommand;

	public QueueDao() {
		dbCommand = "";
		this.db = new HateWaitDBAccess();
	}

	// Queue 등록
	public void insertQueue(QueueVo qvo) {
		// dbCommand 수정
		dbCommand = "INSERT INTO queue (" + qvo.column() + ") VALUES (" + qvo.value() + ");";
		System.out.println("dbcommand::::::::::"+dbCommand);
		// db호출
		db.insert(dbCommand);
	}
}
