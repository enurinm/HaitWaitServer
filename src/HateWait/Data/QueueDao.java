package HateWait.Data;

import HateWait.Util.SettingUtil;
import HateWait.Vo.QueueVo;

public class QueueDao {
	HateWaitDBAccess db;
	String dbCommand;
	SettingUtil settingUtil;

	public QueueDao() {
		dbCommand = "";
		this.db = new HateWaitDBAccess();
		settingUtil = new SettingUtil();
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
