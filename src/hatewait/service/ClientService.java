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
		if(cd.isExistClient(id)) { //���� �ش� id�� Ŭ���̾�Ʈ�� ���� ��� peoplenumȮ��
			if(peopleNum>0) { //peoplenum>0�� ��� �װ͸� ������Ʈ
				cd.modifyClientPeopleNum(cvo);
			}else {}
		}else { //�ش� id�� Ŭ���̾�Ʈ�� ���� ��� insert
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
