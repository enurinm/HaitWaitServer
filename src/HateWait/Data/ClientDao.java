package HateWait.Data;

import HateWait.Vo.ClientVo;

public class ClientDao {
	HateWaitDBAccess db;
	String dbCommand;

	public ClientDao() {
		dbCommand = "";
		this.db = new HateWaitDBAccess();
	}

	// client ���
	public void insertClient(ClientVo cvo) {
		// dbCommand ����
		dbCommand = "INSERT INTO client (" + cvo.column() + ") VALUES (" + cvo.value() + ");";
		System.out.println("dbcommand::::::::::"+dbCommand);
		// dbȣ��
		db.insert(dbCommand);
	}

	/*
	 * client ��ȸ -���� -����Ʈ
	 */
//	ClientVo readClient() {
//		ClientVo cvo;
//		return cvo;
//	}
//	
//	ClientVo[] readClientList() {
//		ClientVo[] cvo;
//		return cvo;
//	}

}
