package HateWait.Service;

import HateWait.Data.ClientDao;
import HateWait.Vo.ClientVo;

public class ClientService {
	ClientDao cd;
	
	public ClientService() {
		cd = new ClientDao();
	}

	public ClientVo setClientVo(String id, int phone, String name, int peopleNum, boolean isMember) {
		ClientVo cvo = new ClientVo();
		cvo.setId(id);
		cvo.setMember(isMember);
		cvo.setName(name);
		cvo.setPeopleNum(peopleNum);
		cvo.setPhone(phone);
		return cvo;
	}

	public void insertClient(String id, String name, int phone, int peopleNum, boolean isMember) {
		ClientVo cvo = setClientVo(id, phone, name, peopleNum, isMember);
		System.out.println("ClientVo::::::::::::::"+cvo.toString());
		
		cd.insertClient(cvo);
		return ;
	}

}
