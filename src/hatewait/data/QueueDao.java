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

	public void insertQueue(QueueVo qvo) {
		dbCommand = "INSERT INTO queue (" + qvo.column() + ") VALUES (" + qvo.value() + ");";
		System.out.println("dbcommand::::::::::" + dbCommand);
		db.insert(dbCommand);
		return;
	}

	public void deleteQueue(QueueVo qvo) {
		dbCommand = "DELETE FROM queue WHERE cid='" + qvo.getCid() + "' AND sid='" + qvo.getSid() + "';";
		System.out.println("dbcommand::::::::::" + dbCommand);
		db.delete(dbCommand);
		return;
	}

	public QueueVo getQueue(String cid) {
		dbCommand = "SELECT * FROM queue WHERE cid='" + cid + "';";
		System.out.println("dbcommand::::::::::" + dbCommand);
		QueueVo qvo = settingVoUtil.setQueueVo(db.select(dbCommand));
		return qvo;
	}

	public int countQueue(String sid) {
		int count = 0;
		dbCommand = "SELECT COUNT(*) as count FROM queue WHERE sid='" + sid + "';";
		System.out.println("dbcommand::::::::::" + dbCommand);
		ResultSet rs = db.select(dbCommand);
		try {
			rs.next();
			count = rs.getInt("count");
		} catch (SQLException e) {
			System.err.println("hatewait.data.QueueDao::countQueue()");
			e.printStackTrace();
		}
		return count;
	}
	
	public void updateTurn(int turn, String sid) {
		dbCommand = "update queue set turn=turn-1 where turn>"+turn+" and sid='"+sid+"';";
		System.out.println("dbcommand::::::::::" + dbCommand);
		db.update(dbCommand);
		return;
	}
}
