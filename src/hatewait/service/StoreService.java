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

	public void addQueue(String sid, String cid, int peopleNum) { //��⿭�� �մ� �߰�-ȸ������
		// Ŭ���̾�Ʈ�� ���� ��� Ŭ���̾�Ʈ ���(ȸ�� ����)
		cs.insertClient(cid, null, -1, peopleNum, true);
		
		// ť���
		// ���� ť�� turn�� ���°���� �ִ��� turn�� �ִ밪 ���ϱ� -> ������� ���ؼ� +1��
		// max(turn)+1 �� �� �Է�
		int turn=qs.countQueue(sid)+1;
		qs.insertQueue(sid, cid, turn);
		return;
	}
	
	public void addQueue(String sid, String name, int phone, int peopleNum) { //��⿭�� �մ� �߰�-��ȸ������
		// Ŭ���̾�Ʈ�� ���� ��� Ŭ���̾�Ʈ ���(ȸ�� ����)
		// ��ȸ���� ��� n0000���� ���̵� �����ϰ� �ϴ� �� �߰�
		String cid="n"+String.format("%04d", cs.countNonMemverClient());
		cs.insertClient(cid, name, phone, peopleNum, false);
		
		// ť���
		// ���� ť�� turn�� ���°���� �ִ��� turn�� �ִ밪 ���ϱ� -> ������� ���ؼ� +1��
		// max(turn)+1 �� �� �Է�
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
