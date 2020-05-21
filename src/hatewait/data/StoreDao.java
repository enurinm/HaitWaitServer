package hatewait.data;

import hatewait.util.MakeCommandUtil;
import hatewait.vo.StoreVo;

public class StoreDao {
	HateWaitDBAccess db;
	String dbCommand;
	MakeCommandUtil makeCommandUtil;

	public StoreDao() {
		dbCommand = "";
		this.db = new HateWaitDBAccess();
		makeCommandUtil=new MakeCommandUtil();
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

}
