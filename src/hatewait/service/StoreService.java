package hatewait.service;

import hatewait.data.StoreDao;
import hatewait.util.SettingVoUtil;
import hatewait.vo.StoreVo;

public class StoreService {
	StoreDao sd;
	SettingVoUtil settingVoUtil;

	public StoreService() {
		sd = new StoreDao();
		settingVoUtil = new SettingVoUtil();
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
	
	public void addQueue() {
		//Ŭ���̾�Ʈ�� ���� ��� Ŭ���̾�Ʈ ���
		//ť���
		return;
	}

}
