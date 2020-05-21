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
		if(cd.isExistClient(id)) { //만약 해당 id의 클라이언트가 있을 경우 peoplenum확인
			if(peopleNum>0) { //peoplenum>0일 경우 그것만 업데이트
				cd.modifyClientPeopleNum(cvo);
			}else {}
		}else { //해당 id의 클라이언트가 없을 경우 insert
			cd.insertClient(cvo);
		}
		return;
	}
	
	public ClientVo getClient(String id) {
		ClientVo cvo=cd.getClient(id);
		return cvo;
	}
	
	public int countNonMemverClient() {
		return cd.countNonMemverClient();
	}

}
