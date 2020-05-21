package hatewait.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hatewait.vo.ClientVo;
import hatewait.vo.MemberVo;
import hatewait.vo.QueueInfoVo;
import hatewait.vo.QueueVo;
import hatewait.vo.StoreVo;

public class SettingVoUtil {

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
			if (rs != null)
				rs.close();
			else {}
		} catch (SQLException e) {
			System.out.println("hatewait.util.SettingVoUtil::ResultSet setting error:: " + e);
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

	public QueueVo setQueueVo(String sid, String cid, int turn) {
		QueueVo qvo = new QueueVo();
		// sid, cid가 실존하는지 확인하고 없으면 에러 출력하는 코드 추가
		qvo.setCid(cid);
		qvo.setSid(sid);
		qvo.setTurn(turn);
		return qvo;
	}

	public QueueVo setQueueVo(ResultSet rs) {
		QueueVo qvo = new QueueVo();
		try {
			rs.next();
			qvo.setCid(rs.getString("cid"));
			qvo.setSid(rs.getString("sid"));
			qvo.setTurn(rs.getInt("turn"));
			if (rs != null)
				rs.close();
			else {}
		} catch (SQLException e) {
			System.out.println("hatewait.util.SettingVoUtil::ResultSet setting error:: " + e);
		}
		return qvo;
	}

	public StoreVo setStoreVo(String id, String name, String info, String time, int anum) {
		StoreVo svo = new StoreVo();
		svo.setId(id);
		svo.setName(name);
		svo.setInfo(info);
		svo.setTime(time);
		svo.setAnum(anum);
		return svo;
	}

	public StoreVo setStoreVo(String id, String info, String time, int anum) {
		StoreVo svo = new StoreVo();
		svo.setId(id);
		svo.setInfo(info);
		svo.setTime(time);
		svo.setAnum(anum);
		return svo;
	}

	public List<QueueInfoVo> setQueueInfoVoList(ResultSet rs) {
		List<QueueInfoVo> qivo = new ArrayList<>();
		try {
			while (rs.next()) {
				QueueInfoVo q = new QueueInfoVo();
				q.setId(rs.getString("id"));
				q.setPhone(rs.getInt("phone"));
				q.setName(rs.getString("name"));
				q.setPeopleNum(rs.getInt("peopleNum"));
				q.setTurn(rs.getInt("turn"));
				qivo.add(q);
			}
			if (rs != null)
				rs.close();
			else {}
		} catch (SQLException e) {
			System.out.println("hatewait.util.SettingVoUtil::ResultSet List setting error:: " + e);
		}
		return qivo;
	}

}
