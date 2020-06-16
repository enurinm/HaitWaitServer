package hatewait.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hatewait.vo.ClientVo;
import hatewait.vo.MemberHomeVo;
import hatewait.vo.MemberVo;
import hatewait.vo.QueueInfoVo;
import hatewait.vo.QueueVo;
import hatewait.vo.StoreHomeVo;
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
			System.err.println("hatewait.util.SettingVoUtil::ResultSet setting error:: " + e);
		}
		return cvo;
	}

	public MemberVo setMemberVo(String id, String name, int phone, String pw) {
		MemberVo mvo = new MemberVo();
		mvo.setId(id);
		mvo.setName(name);
		mvo.setPhone(phone);
		mvo.setPw(pw);
		return mvo;
	}

	public QueueVo setQueueVo(String sid, String cid, int turn) {
		QueueVo qvo = new QueueVo();
		// sid, cid�� �����ϴ��� Ȯ���ϰ� ������ ���� ����ϴ� �ڵ� �߰�
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
			System.err.println("hatewait.util.SettingVoUtil::ResultSet setting error:: " + e);
		}
		return qvo;
	}

	public StoreVo setStoreVo(String id, String name, String info, String time, int maxpeople,
			int autonum, String address, int phone, String pw) {
		StoreVo svo = new StoreVo();
		svo.setId(id);
		svo.setName(name);
		svo.setInfo(info);
		svo.setTime(time);
		svo.setMaxpeople(maxpeople);
		svo.setAutonum(autonum);
		svo.setAddress(address);
		svo.setPhone(phone);
		svo.setPw(pw);
		return svo;
	}

//	public StoreVo setStoreVo(String id, String info, String time, int autonum) {
//		StoreVo svo = new StoreVo();
//		svo.setId(id);
//		svo.setInfo(info);
//		svo.setTime(time);
//		svo.setAutonum(autonum);
//		return svo;
//	}

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
			System.err.println("hatewait.util.SettingVoUtil::ResultSet List setting error:: " + e);
		}
		return qivo;
	}
	
	public MemberHomeVo setMemberHomeVo(ResultSet rs) {
		MemberHomeVo mhvo=new MemberHomeVo();
		try {
			rs.next();
			mhvo.setMname(rs.getString("mname"));
			mhvo.setSname(rs.getString("sname"));
			mhvo.setTurn(rs.getInt("turn"));
			if (rs != null)
				rs.close();
			else {}
		} catch (SQLException e) {
			System.err.println("hatewait.util.SettingVoUtil::ResultSet setting error:: " + e);
		}
		return mhvo;
	}
	
	public StoreHomeVo setStoreHomeVo(ResultSet rs) {
		StoreHomeVo shvo=new StoreHomeVo();
		try {
			rs.next();
			shvo.setSname(rs.getString("sname"));
//			shvo.setAllNum(rs.getInt("allnum"));
			shvo.setCname(rs.getString("cname"));
			shvo.setPeopleNum(rs.getInt("peopleNum"));
			if (rs != null)
				rs.close();
			else {}
		} catch (SQLException e) {
			System.err.println("hatewait.util.SettingVoUtil::ResultSet setting error:: " + e);
		}
		return shvo;
	}
	
	public StoreHomeVo setStoreHomeVoAllNum(ResultSet rs, StoreHomeVo shvo) {
		try {
			rs.next();
			shvo.setAllNum(rs.getInt("allnum"));
			if (rs != null)
				rs.close();
			else {}
		} catch (SQLException e) {
			System.err.println("hatewait.util.SettingVoUtil::ResultSet setting error:: " + e);
		}
		return shvo;
	}
}
