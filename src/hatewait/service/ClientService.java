package hatewait.service;

import hatewait.data.ClientDao;
import hatewait.util.SettingVoUtil;
import hatewait.vo.ClientVo;

public class ClientService {
	ClientDao cd;
	SettingVoUtil settingVoUtil;

	public ClientService() {
		cd = new ClientDao();
		settingVoUtil = new SettingVoUtil();
	}

	public void insertClient(String id, String name, int phone, int peopleNum, boolean isMember) {
		ClientVo cvo = settingVoUtil.setClientVo(id, phone, name, peopleNum, isMember);
		System.out.println("ClientVo::::::::::::::" + cvo.toString());
		if (cd.isExistClient(id)) { // if client exist, check peoplenum
			if (peopleNum > 0) { // if peoplenum > 0, only change that 
				cd.modifyClientPeopleNum(cvo);
			} else {}
		} else { // if client not exist, insert
			cd.insertClient(cvo);
		}
		return;
	}
	
	public boolean isExistClient(String id) {
		return cd.isExistClient(id);
	}

	public ClientVo getClient(String id) {
		ClientVo cvo = cd.getClient(id);
		return cvo;
	}

	public int countClient() {
		return cd.countClient();
	}
	
	public void modifyClient(String id, String name, int phone, int peopleNum, boolean isMember) {
		ClientVo cvo = settingVoUtil.setClientVo(id, phone, name, peopleNum, isMember);
		System.out.println("ClientVo::::::::::::::" + cvo.toString());
		cd.modifyClient(cvo);
		return;
	}

}
