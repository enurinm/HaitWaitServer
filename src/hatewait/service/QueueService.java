package hatewait.service;

import hatewait.data.QueueDao;
import hatewait.util.SettingUtil;
import hatewait.vo.QueueVo;

public class QueueService {
	QueueDao qd;
	SettingUtil settingUtil;

	public QueueService() {
		qd = new QueueDao();
		settingUtil = new SettingUtil();
	}

	public void insertQueue(String sid, String cid, int turn) {
		QueueVo qvo = settingUtil.setQueueVo(sid, cid, turn);
		System.out.println("QueueVo:::::::::::" + qvo.toString());

		qd.insertQueue(qvo);
		return;
	}
}
