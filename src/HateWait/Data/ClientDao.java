package HateWait.Data;

import java.util.ArrayList;
import java.util.List;

import HateWait.Util.SettingUtil;
import HateWait.Vo.ClientVo;

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
	}

	/*
	 * client ��ȸ -���� -����Ʈ //select
	 */
	ClientVo getClient(String id) {
		ClientVo cvo = new ClientVo();
		dbCommand = "SELECT * FROM client WHERE id="+id;
		
		return cvo;
	}

	List<ClientVo> getClientList() {
		List<ClientVo> cvo = new ArrayList<>();
		return cvo;
	}

}
