package hatewait.data;

import java.sql.ResultSet;
import java.util.List;

import hatewait.util.MakeCommandUtil;
import hatewait.util.SettingVoUtil;
import hatewait.vo.QueueInfoVo;
import hatewait.vo.StoreVo;

public class StoreDao {
	HateWaitDBAccess db;
	String dbCommand;
	MakeCommandUtil makeCommandUtil;
	SettingVoUtil settingVoUtil;

	public StoreDao() {
		dbCommand = "";
		this.db = new HateWaitDBAccess();
		makeCommandUtil = new MakeCommandUtil();
		settingVoUtil = new SettingVoUtil();
	}

	// ���� ���� ���
	public void insertStore(StoreVo svo) {
		// dbCommand ����
		dbCommand = "INSERT INTO store (" + svo.column() + ") VALUES (" + svo.value() + ");";
		System.out.println("dbcommand::::::::::" + dbCommand);
		// dbȣ��
		db.insert(dbCommand);
		return;
	}

	// ���� ���� ����
	public void modifyStore(StoreVo svo) {
		String set = "";
		set = makeCommandUtil.setString(svo.getInfo(), set, "info");
		set = makeCommandUtil.setString(svo.getTime(), set, "time");
		set = makeCommandUtil.setString(svo.getAnum(), set, "anum");
		dbCommand = "UPDATE store set " + set + " where id='" + svo.getId() + "';";
		System.out.println("dbcommand::::::::::" + dbCommand);
		db.update(dbCommand);
		return;
	}

	// ���� id�� ��⿭ ��ü ��ȸ > list
	public List<QueueInfoVo> getClientListFromQueue(String sid) {
		dbCommand = "SELECT id, phone, name, peopleNum, turn FROM client, queue " + "WHERE queue.sid='" + sid
				+ "' and queue.cid=client.id;";
		System.out.println("dbcommand::::::::::" + dbCommand);
		ResultSet rs = db.select(dbCommand);
		List<QueueInfoVo> qivo = settingVoUtil.setQueueInfoVoList(rs);
		return qivo;
	}

}
