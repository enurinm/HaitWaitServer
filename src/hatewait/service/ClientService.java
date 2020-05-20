package hatewait.service;

import hatewait.data.ClientDao;
import hatewait.util.SettingUtil;
import hatewait.vo.ClientVo;

public class ClientService {
	ClientDao cd;
	SettingUtil settingUtil;

	public ClientService() {
		cd = new ClientDao();
		settingUtil = new SettingUtil();
	}

	public void insertClient(String id, String name, int phone, int peopleNum, boolean isMember) {
		ClientVo cvo = settingUtil.setClientVo(id, phone, name, peopleNum, isMember);
		System.out.println("ClientVo::::::::::::::" + cvo.toString());

		cd.insertClient(cvo);
		return;
	}
	
	public ClientVo getClient(String id) {
		ClientVo cvo=cd.getClient(id);
		return cvo;
	}

}
