package hatewait.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import hatewait.util.SettingVoUtil;
import hatewait.vo.QueueVo;

public class QueueDao {
	HateWaitDBAccess db;
	String dbCommand;
	SettingVoUtil settingVoUtil;

	public QueueDao() {
		dbCommand = "";
		this.db = new HateWaitDBAccess();
		settingVoUtil = new SettingVoUtil();
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
	
	// 대기열 조회 함수들
	// 클라이언트 id로 대기열 조회
	public QueueVo getQueue(String cid) {
		dbCommand = "SELECT * FROM queue WHERE cid='"+cid+"';";
		System.out.println("dbcommand::::::::::" + dbCommand);
		QueueVo qvo=settingVoUtil.setQueueVo(db.select(dbCommand));
		return qvo;
	}
	
	//가게 id로 대기열 수 세기 > count
	public int countQueue(String sid) {
		int count=0;
		dbCommand = "SELECT COUNT(*) as count FROM queue WHERE sid='"+sid+"';";
		System.out.println("dbcommand::::::::::" + dbCommand);
		ResultSet rs=db.select(dbCommand);
		try {
			rs.next();
			count=rs.getInt("count");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
}
