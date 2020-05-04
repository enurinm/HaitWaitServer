package HateWait.Data;

import HateWait.Vo.ClientVo;

public class ClientDao {
	HateWaitDBAccess db;
	String dbCommand;
	
	ClientDao(){
		dbCommand="";
		db.connect();
	}
	
	//client 등록
	void insertClient(ClientVo cvo) {
		//dbCommand 수정
		
		db.insert(dbCommand);
	}
	
	/*
	 * client 조회
	 * -개인
	 * -리스트
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
