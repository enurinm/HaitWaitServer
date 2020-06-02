package hatewait.service;

import java.util.List;

import hatewait.data.StoreDao;
import hatewait.util.SettingVoUtil;
import hatewait.vo.QueueInfoVo;
import hatewait.vo.StoreHomeVo;
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

	public void insertStore(String id, String name, String info, String time, int maxpeople,
			int autonum, String address, int phone, String pw) {
		StoreVo svo = settingVoUtil.setStoreVo(id, name, info, time, maxpeople, autonum, address, phone, pw);
		System.out.println("StoreVo:::::::::::" + svo.toString());

		sd.insertStore(svo);
		return;
	}

	public void modifyStore(String id, String name, String info, String time, int maxpeople,
			int autonum, String address, int phone, String pw) {
		StoreVo svo = settingVoUtil.setStoreVo(id, name, info, time, maxpeople, autonum, address, phone, pw);
		System.out.println("StoreVo:::::::::::" + svo.toString());

		sd.modifyStore(svo);
		return;
	}

	public String addQueue(String sid, String cid, int peopleNum) { // ��⿭�� �մ� �߰�-ȸ������
		// Ŭ���̾�Ʈ�� ���� ��� Ŭ���̾�Ʈ ���(ȸ�� ����)
		cs.insertClient(cid, null, -1, peopleNum, true);

		// ť���
		// ���� ť�� turn�� ���°���� �ִ��� turn�� �ִ밪 ���ϱ� -> ������� ���ؼ� +1��
		// max(turn)+1 �� �� �Է�
		int turn = qs.countQueue(sid) + 1;
		String name=cs.getClient(cid).getName();
		qs.insertQueue(sid, cid, turn);
		String returnValue="INSQUE;MEMBER;"+name+";"+turn;
		System.out.println("::::::::::"+returnValue);
		return returnValue;
	}

	public void addQueue(String sid, String name, int phone, int peopleNum) { // ��⿭�� �մ� �߰�-��ȸ������
		// Ŭ���̾�Ʈ�� ���� ��� Ŭ���̾�Ʈ ���(ȸ�� ����)
		// ��ȸ���� ��� n0000���� ���̵� �����ϰ� �ϴ� �� �߰�
		String cid = "n" + String.format("%04d", cs.countNonMemverClient());
		cs.insertClient(cid, name, phone, peopleNum, false);

		// ť���
		// ���� ť�� turn�� ���°���� �ִ��� turn�� �ִ밪 ���ϱ� -> ������� ���ؼ� +1��
		// max(turn)+1 �� �� �Է�
		int turn = qs.countQueue(sid) + 1;
		qs.insertQueue(sid, cid, turn);
		String returnValue="INSQUE;MEMBER;"+turn;
		System.out.println("::::::::::"+returnValue);
		return;
	}

	public List<QueueInfoVo> getStoreQueueList(String sid) {
		List<QueueInfoVo> qivo = sd.getClientListFromQueue(sid);
		System.out.println("::::::::" + qivo.toString());
		return qivo;
	}
	
	public StoreHomeVo loadStoreHome(String id) { //MAIN;STORE;�����̸�;���簡�Դ���ο�;�����մ��̸�;�����մ��ο���
		//�����̸�(store);���簡�Դ���ο�(queue);�����մ��̸�(queue.cid->client);�����մ��ο���(queue.cid->client)
		StoreHomeVo shvo=sd.memberHomeInfo(id);
		System.out.println(":::::::::::"+shvo.toString());
		return shvo;
	}

}
