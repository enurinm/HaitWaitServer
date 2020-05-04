package HateWait.Data;

import HateWait.Vo.QueueVo;

public class QueueDao {
	HateWaitDBAccess db;
	String dbCommand;

	QueueDao() {
		db.connect();
	}

	// Queue 등록
	void insertQueue(QueueVo qvo) {
		// dbCommand 수정
		dbCommand = "INSERT INTO client (" + qvo.column() + ") VALUES (" + qvo.value() + ");";
		// db호출
		db.insert(dbCommand);
	}
}
