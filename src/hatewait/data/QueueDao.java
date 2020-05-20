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

	// 대기열 등록
	public void insertQueue(QueueVo qvo) {
		// dbCommand 수정
		dbCommand = "INSERT INTO queue (" + qvo.column() + ") VALUES (" + qvo.value() + ");";
		System.out.println("dbcommand::::::::::" + dbCommand);
		// db호출
		db.insert(dbCommand);
		return;
	}

	// 대기열 삭제
	public void deleteQueue(QueueVo qvo) {
		// dbCommand 수정
		dbCommand = "DELETE FROM queue WHERE cid='"+qvo.getCid()+"' AND sid='"+qvo.getSid()+"';";
		System.out.println("dbcommand::::::::::" + dbCommand);
		db.delete(dbCommand);
		return;
	}
}
