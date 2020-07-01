package hatewait.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import hatewait.util.MakeCommandUtil;
import hatewait.util.SettingVoUtil;
import hatewait.vo.PushMsgVo;
import hatewait.vo.QueueInfoVo;
import hatewait.vo.StoreHomeVo;
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

	public void insertStore(StoreVo svo) {
		dbCommand = "INSERT INTO store (" + svo.column() + ") VALUES (" + svo.value() + ");";
		System.out.println("dbcommand::::::::::" + dbCommand);
		db.insert(dbCommand);
		return;
	}

	public void modifyStore(StoreVo svo) {
		String set = "";
		set = makeCommandUtil.setStoreString(svo, set);
		dbCommand = "UPDATE store set " + set + " where id='" + svo.getId() + "';";
		System.out.println("dbcommand::::::::::" + dbCommand);
		db.update(dbCommand);
		return;
	}

	public List<QueueInfoVo> getClientListFromQueue(String sid) {
		dbCommand = "SELECT id, phone, name, peopleNum, turn FROM client, queue " 
				+ "WHERE queue.sid='" + sid	+ "' and queue.cid=client.id;";
		System.out.println("dbcommand::::::::::" + dbCommand);
		ResultSet rs = db.select(dbCommand);
		List<QueueInfoVo> qivo = settingVoUtil.setQueueInfoVoList(rs);
		return qivo;
	}
	
	public StoreHomeVo storeHomeInfo(String id) {
		dbCommand = "SELECT store.name AS sname, client.name AS cname, client.peopleNum FROM store, queue, client "
				+ "WHERE store.id='"+id+"' and queue.sid=store.id and client.id=queue.cid "
				+ "and queue.turn=(SELECT MIN(turn) FROM queue)";
		System.out.println("dbcommand::::::::::" + dbCommand);
		StoreHomeVo shvo= settingVoUtil.setStoreHomeVo(db.select(dbCommand));
		dbCommand = "select count(*) as allNum from queue where sid='"+id+"';";
		System.out.println("dbcommand::::::::::" + dbCommand);
		shvo=settingVoUtil.setStoreHomeVoAllNum(db.select(dbCommand), shvo);
		return shvo;
	}
	
	public int getAutonum(String id) {
		int autonum=-1;
		dbCommand = "SELECT autonum AS autonum FROM store WHERE id='"+id+"';";
		System.out.println("dbcommand::::::::::" + dbCommand);
		ResultSet rs = db.select(dbCommand);
		try {
			rs.next();
			autonum = rs.getInt("autonum");
		} catch (SQLException e) {
			System.err.println("hatewait.data.QueueDao::countQueue()");
			e.printStackTrace();
		}
		return autonum;
	}
	
	public PushMsgVo pushMsg(String cid) {
		dbCommand="SELECT client.phone, store.name, queue.turn FROM queue, store, client WHERE queue.cid='"+cid
				+"' AND client.id=queue.cid AND store.id=queue.sid;";
		System.out.println("dbcommand::::::::::" + dbCommand);
		ResultSet rs = db.select(dbCommand);
		PushMsgVo pmvo=settingVoUtil.setPushMsgVo(rs);
		return pmvo;
	}

}
