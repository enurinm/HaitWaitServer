package hatewait.service;

import hatewait.data.QueueDao;
import hatewait.util.SettingVoUtil;
import hatewait.vo.QueueVo;

public class QueueService {
	QueueDao qd;
	SettingVoUtil settingVoUtil;

	public QueueService() {
		qd = new QueueDao();
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
		
		qd.deleteQueue(qvo);
		return;
	}
	
	public String getClientTurn(String sid, String cid) {
		int turn=0;
		turn=qd.getQueue(cid).getTurn();
		return countQueue(sid)+"명 중 "+turn+"번 째";
	}
	
//	int getClientTurn(String cid) {
//		int turn=0;
//		turn=qd.getQueue(cid).getTurn();
//		return turn;
//	}
	
	public int countQueue(String sid) {
		int count=qd.countQueue(sid);
		return count;
	}
}
