package HateWait.Service;

import HateWait.Data.StoreDao;
import HateWait.Vo.StoreVo;

public class StoreService {
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
		StoreDao sd=new StoreDao();
		
		sd.insertStore(svo);
		return ;
	}

}
