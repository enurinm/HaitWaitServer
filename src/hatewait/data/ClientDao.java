package hatewait.data;

import hatewait.util.SettingUtil;
import hatewait.vo.ClientVo;

public class ClientDao {
	HateWaitDBAccess db;
	String dbCommand;
	SettingUtil settingUtil;

	public ClientDao() {
		dbCommand = "";
		this.db = new HateWaitDBAccess();
		settingUtil = new SettingUtil();
	}

	// client ���
	public void insertClient(ClientVo cvo) {
		// dbCommand ����
		dbCommand = "INSERT INTO client (" + cvo.column() + ") VALUES (" + cvo.value() + ");";
		System.out.println("dbcommand::::::::::" + dbCommand);
		// dbȣ��
		db.insert(dbCommand);
		return;
	}

	/*
	 * client ��ȸ -���� -����Ʈ //select
	 */
	public ClientVo getClient(String id) {
		dbCommand = "SELECT * FROM client WHERE id='"+id+"';";
		System.out.println("dbcommand::::::::::" + dbCommand);
		ClientVo cvo = settingUtil.setClientVo(db.select(dbCommand));
		System.out.println("return value::::::::::"+cvo.toString());
		return cvo;
	}

//	List<ClientVo> getClientList() {
//		dbCommand = "SELECT * FROM client";
//		List<ClientVo> cvo = new ArrayList<>();
//		return cvo;
//	}

}
