package HateWait.Data;

import HateWait.Vo.QueueVo;

public class QueueDao {
	HateWaitDBAccess db;
	String dbCommand;

	public QueueDao() {
		dbCommand = "";
		this.db = new HateWaitDBAccess();
	}

	// Queue ���
	public void insertQueue(QueueVo qvo) {
		// dbCommand ����
		dbCommand = "INSERT INTO queue (" + qvo.column() + ") VALUES (" + qvo.value() + ");";
		System.out.println("dbcommand::::::::::"+dbCommand);
		// dbȣ��
		db.insert(dbCommand);
	}
}
