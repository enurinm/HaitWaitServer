package HateWait.Service;

import HateWait.Data.StoreDao;
import HateWait.Vo.StoreVo;

public class StoreService {
	StoreDao sd;
	
	public StoreService() {
		sd=new StoreDao();
	}
	
	public StoreVo setStoreVo(String id, String name, String info, String time, int anum) {
		StoreVo svo=new StoreVo();
		svo.setId(id);
		svo.setName(name);
		svo.setInfo(info);
		svo.setTime(time);
		svo.setAnum(anum);
		return svo;
	}
	
	public void insertStore(String id, String name, String info, String time, int anum) {
		StoreVo svo=setStoreVo(id, name, info, time, anum);
		System.out.println("StoreVo:::::::::::"+svo.toString());
		
		sd.insertStore(svo);
		return ;
	}

}
