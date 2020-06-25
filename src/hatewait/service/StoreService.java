package hatewait.service;

import java.util.List;

import hatewait.data.StoreDao;
import hatewait.util.SettingVoUtil;
import hatewait.vo.QueueInfoVo;
import hatewait.vo.QueueListSerializable;
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

	public String addQueue(String sid, String cid, int peopleNum) {
		// add to queue - for member
		// add to client
		cs.insertClient(cid, null, -1, peopleNum, true);

		// add to queue
		// get max turn -> max turn+1
		int turn = qs.countQueue(sid) + 1;
		String name=cs.getClient(cid).getName();
		qs.insertQueue(sid, cid, turn);
		String returnValue="INSQUE;MEMBER;"+name+";"+turn;
		System.out.println("::::::::::"+returnValue);
		return returnValue;
	}

	public String addQueue(String sid, String name, int phone, int peopleNum) { 
		// add to queue - for non-member
		// add to client
		// if non-member, make id (n0000)
		String cid = "n" + String.format("%08d", cs.countClient()+1);
		cs.insertClient(cid, name, phone, peopleNum, false);

		// add to queue
		// get max turn -> max turn+1	
		int turn = qs.countQueue(sid) + 1;
		qs.insertQueue(sid, cid, turn);
		String returnValue="INSQUE;NONMEM;"+turn;
		System.out.println("::::::::::"+returnValue);
		return returnValue;
	}

	public QueueListSerializable getStoreQueueList(String sid) {
		List<QueueInfoVo> qivo = sd.getClientListFromQueue(sid);
		int autonum=sd.getAutonum(sid);
		QueueListSerializable qls=new QueueListSerializable();
		qls.autonum=autonum;
		qls.qivo=qivo;
		System.out.println("::::::::" + qls.toString());
		return qls;
	}
	
	public String loadStoreHome(String id) {
		StoreHomeVo shvo=sd.storeHomeInfo(id);
		System.out.println(":::::::::::"+shvo.toString());
		String returnValue="MAIN;STORE;"+shvo.getSname()+";"+shvo.getAllNum()+";"+shvo.getCname()+";"+shvo.getPeopleNum();
		return returnValue;
	}

}
