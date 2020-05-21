package hatewait.service;

import java.util.List;

import hatewait.data.StoreDao;
import hatewait.util.SettingVoUtil;
import hatewait.vo.QueueInfoVo;
import hatewait.vo.StoreVo;

public class StoreService {
	StoreDao sd;
	SettingVoUtil settingVoUtil;
	ClientService cs;
	QueueService qs;

	public StoreService() {
		sd = new StoreDao();
		settingVoUtil = new SettingVoUtil();
		cs = new ClientService();
		qs = new QueueService();
	}

	public void insertStore(String id, String name, String info, String time, int anum) {
		StoreVo svo = settingVoUtil.setStoreVo(id, name, info, time, anum);
		System.out.println("StoreVo:::::::::::" + svo.toString());

		sd.insertStore(svo);
		return;
	}

	public void modifyStore(String id, String info, String time, int anum) {
		StoreVo svo = settingVoUtil.setStoreVo(id, info, time, anum);
		System.out.println("StoreVo:::::::::::" + svo.toString());

		sd.modifyStore(svo);
		return;
	}

	public void addQueue(String sid, String cid, int peopleNum) { //대기열에 손님 추가-회원전용
		// 클라이언트가 없을 경우 클라이언트 등록(회원 전용)
		cs.insertClient(cid, null, -1, peopleNum, true);
		
		// 큐등록
		// 현재 큐에 turn이 몇번째까지 있는지 turn의 최대값 구하기 -> 몇명인지 구해서 +1함
		// max(turn)+1 한 값 입력
		int turn=qs.countQueue(sid)+1;
		qs.insertQueue(sid, cid, turn);
		return;
	}
	
	public void addQueue(String sid, String name, int phone, int peopleNum) { //대기열에 손님 추가-비회원전용
		// 클라이언트가 없을 경우 클라이언트 등록(회원 전용)
		// 비회원일 경우 n0000으로 아이디 생성하게 하는 것 추가
		String cid="n"+String.format("%04d", cs.countNonMemverClient());
		cs.insertClient(cid, name, phone, peopleNum, false);
		
		// 큐등록
		// 현재 큐에 turn이 몇번째까지 있는지 turn의 최대값 구하기 -> 몇명인지 구해서 +1함
		// max(turn)+1 한 값 입력
		int turn=qs.countQueue(sid)+1;
		qs.insertQueue(sid, cid, turn);
		return;
	}
	
	public List<QueueInfoVo> getStoreQueueList(String sid){
		List<QueueInfoVo> qivo=sd.getClientListFromQueue(sid);
		System.out.println("::::::::"+qivo.toString());
		return qivo;
	}

}
