package hatewait.data;

import hatewait.util.SettingUtil;
import hatewait.vo.QueueVo;

public class QueueDao {
	HateWaitDBAccess db;
	String dbCommand;
	SettingUtil settingUtil;

	public QueueDao() {
		dbCommand = "";
		this.db = new HateWaitDBAccess();
		settingUtil = new SettingUtil();
	}

	// ��⿭ ���
	public void insertQueue(QueueVo qvo) {
		// dbCommand ����
		dbCommand = "INSERT INTO queue (" + qvo.column() + ") VALUES (" + qvo.value() + ");";
		System.out.println("dbcommand::::::::::" + dbCommand);
		// dbȣ��
		db.insert(dbCommand);
		return;
	}

	// ��⿭ ����
	public void deleteQueue(QueueVo qvo) {
		// dbCommand ����
		dbCommand = "DELETE FROM queue WHERE cid='"+qvo.getCid()+"' AND sid='"+qvo.getSid()+"';";
		System.out.println("dbcommand::::::::::" + dbCommand);
		db.delete(dbCommand);
		return;
	}
}
