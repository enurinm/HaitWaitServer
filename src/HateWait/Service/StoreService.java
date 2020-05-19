package HateWait.Service;

import HateWait.Data.StoreDao;
import HateWait.Util.SettingUtil;
import HateWait.Vo.StoreVo;

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

}
