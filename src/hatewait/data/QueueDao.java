package hatewait.data;

import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	// ��⿭ ��ȸ �Լ���
	// Ŭ���̾�Ʈ id�� ��⿭ ��ȸ
	public QueueVo getQueue(String cid) {
		dbCommand = "SELECT * FROM queue WHERE cid='"+cid+"';";
		System.out.println("dbcommand::::::::::" + dbCommand);
		QueueVo qvo=settingUtil.setQueueVo(db.select(dbCommand));
		return qvo;
	}
	
	//���� id�� ��⿭ ��ü ��ȸ > list
	
	//���� id�� ��⿭ �� ���� > count
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
