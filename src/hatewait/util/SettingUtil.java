package hatewait.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import hatewait.vo.ClientVo;
import hatewait.vo.MemberVo;
import hatewait.vo.QueueVo;
import hatewait.vo.StoreVo;

public class SettingUtil {
	
	public ClientVo setClientVo(String id, int phone, String name, int peopleNum, boolean isMember) {
		ClientVo cvo = new ClientVo();
		cvo.setId(id);
		cvo.setMember(isMember);
		cvo.setName(name);
		cvo.setPeopleNum(peopleNum);
		cvo.setPhone(phone);
		return cvo;
	}
	
	public ClientVo setClientVo(ResultSet rs) {
		ClientVo cvo = new ClientVo();
		try {
			rs.next();
			cvo.setId(rs.getString("id"));
			cvo.setMember(rs.getBoolean("isMember"));
			cvo.setName(rs.getString("name"));
			cvo.setPeopleNum(rs.getInt("peopleNum"));
			cvo.setPhone(rs.getInt("phone"));
		}catch (SQLException e){
			System.out.println("hatewait.util.SettingUtil::ResultSet setting error:: "+e);
		}
		return cvo;
	}
	
	public MemberVo setMemberVo(String id, String name, int phone) {
		MemberVo mvo = new MemberVo();
		mvo.setId(id);
		mvo.setName(name);
		mvo.setPhone(phone);
		return mvo;
	}
	
	public QueueVo setQueueVo(String sid,String cid,int turn) {
		QueueVo qvo=new QueueVo();
		//sid, cid가 실존하는지 확인하고 없으면 에러 출력하는 코드 추가
		qvo.setCid(cid);
		qvo.setSid(sid);
		qvo.setTurn(turn);
		return qvo;
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
	
	public StoreVo setStoreVo(String id, String info, String time, int anum) {
		StoreVo svo=new StoreVo();
		svo.setId(id);
		svo.setInfo(info);
		svo.setTime(time);
		svo.setAnum(anum);
		return svo;
	}

}
