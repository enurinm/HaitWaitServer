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
