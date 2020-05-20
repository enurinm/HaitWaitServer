package hatewait.service;

import hatewait.data.StoreDao;
import hatewait.util.SettingUtil;
import hatewait.vo.StoreVo;

public class StoreService {
	StoreDao sd;
	SettingUtil settingUtil;

	public StoreService() {
		sd = new StoreDao();
		settingUtil = new SettingUtil();
	}

	public void insertStore(String id, String name, String info, String time, int anum) {
		StoreVo svo = settingUtil.setStoreVo(id, name, info, time, anum);
		System.out.println("StoreVo:::::::::::" + svo.toString());

		sd.insertStore(svo);
		return;
	}
	
	public void modifyStore(String id, String info, String time, int anum) {
		StoreVo svo = settingUtil.setStoreVo(id, info, time, anum);
		System.out.println("StoreVo:::::::::::" + svo.toString());
		
		sd.modifyStore(svo);
		return;
	}

}
