package HateWait.Data;

import HateWait.Vo.ClientVo;

public class ClientDao {
	HateWaitDBAccess db;
	String dbCommand;
	
	ClientDao(){
		dbCommand="";
		db.connect();
	}
	
	//client ���
	void insertClient(ClientVo cvo) {
		//dbCommand ����
		dbCommand="INSERT INTO client ("+cvo.column()+") VALUES ("+cvo.value()+");";
		//dbȣ��
		db.insert(dbCommand);
	}
	
	/*
	 * client ��ȸ
	 * -����
	 * -����Ʈ
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
