package hatewait.data;

import java.sql.ResultSet;
import java.util.List;

import hatewait.util.MakeCommandUtil;
import hatewait.util.SettingVoUtil;
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

	// 가게 정보 등록
	public void insertStore(StoreVo svo) {
		// dbCommand 수정
		dbCommand = "INSERT INTO store (" + svo.column() + ") VALUES (" + svo.value() + ");";
		System.out.println("dbcommand::::::::::" + dbCommand);
		// db호출
		db.insert(dbCommand);
		return;
	}

	// 가게 정보 수정
	public void modifyStore(StoreVo svo) {
		String set = "";
		set = makeCommandUtil.setStoreString(svo, set);
		dbCommand = "UPDATE store set " + set + " where id='" + svo.getId() + "';";
		System.out.println("dbcommand::::::::::" + dbCommand);
		db.update(dbCommand);
		return;
	}

	// 가게 id로 대기열 전체 조회 > list
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

}
