package hatewait.service;

import hatewait.data.ClientDao;
import hatewait.data.QueueDao;
import hatewait.util.SettingVoUtil;
import hatewait.vo.QueueVo;

public class QueueService {
	QueueDao qd;
	ClientDao cd;
	SettingVoUtil settingVoUtil;

	public QueueService() {
		qd = new QueueDao();
		cd = new ClientDao();
		settingVoUtil = new SettingVoUtil();
	}

	public void insertQueue(String sid, String cid, int turn) {
		QueueVo qvo = settingVoUtil.setQueueVo(sid, cid, turn);
		System.out.println("QueueVo:::::::::::" + qvo.toString());

		qd.insertQueue(qvo);
		return;
	}
	
	public void deleteQueue(String sid, String cid) {
		QueueVo qvo = settingVoUtil.setQueueVo(sid, cid, -1);
		System.out.println("QueueVo:::::::::::" + qvo.toString());
		//turn ����
		int turn=qd.getQueue(cid).getTurn();
		qd.updateTurn(turn, sid);
		qd.deleteQueue(qvo);
		if(cd.isClientMember(cid)) {//ȸ���� ��� client.peoplenum ����,
			cd.modifyClientPeopleNum(cid, -1);
		}else { //��ȸ���� ��� client���� ���� �ڵ� �߰�
			cd.deleteClient(cid);
		}
		return;
	}
	
	public int getClientTurn(String sid, String cid) {
		int turn=0;
		turn=qd.getQueue(cid).getTurn();
		return turn;
	}
	
	int getClientTurn(String cid) {
		int turn=0;
		turn=qd.getQueue(cid).getTurn();
		return turn;
	}
	
	public int countQueue(String sid) {
		int count=qd.countQueue(sid);
		return count;
	}
}
