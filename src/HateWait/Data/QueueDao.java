package HateWait.Data;

import HateWait.Vo.QueueVo;

public class QueueDao {
	HateWaitDBAccess db;
	String dbCommand;

	QueueDao() {
		db.connect();
	}

	// Queue ���
	void insertQueue(QueueVo qvo) {
		// dbCommand ����
		dbCommand = "INSERT INTO client (" + qvo.column() + ") VALUES (" + qvo.value() + ");";
		// dbȣ��
		db.insert(dbCommand);
	}
}
