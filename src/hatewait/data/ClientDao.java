package hatewait.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import hatewait.util.MakeCommandUtil;
import hatewait.util.SettingVoUtil;
import hatewait.vo.ClientVo;

public class ClientDao {
	HateWaitDBAccess db;
	String dbCommand;
	SettingVoUtil settingVoUtil;
	MakeCommandUtil makeCommandUtil;

	public ClientDao() {
		dbCommand = "";
		this.db = new HateWaitDBAccess();
		settingVoUtil = new SettingVoUtil();
		makeCommandUtil = new MakeCommandUtil();
	}

	// client ���
	public void insertClient(ClientVo cvo) {
		// dbCommand ����
		dbCommand = "INSERT INTO client (" + cvo.column() + ") VALUES (" + cvo.value() + ");";
		System.out.println("dbcommand::::::::::" + dbCommand);
		// dbȣ��
		db.insert(dbCommand);
		return;
	}

	/*
	 * client ��ȸ -���� //select
	 */
	public ClientVo getClient(String id) {
		dbCommand = "SELECT * FROM client WHERE id='" + id + "';";
		System.out.println("dbcommand::::::::::" + dbCommand);
		ClientVo cvo = settingVoUtil.setClientVo(db.select(dbCommand));
		System.out.println("return value::::::::::" + cvo.toString());
		return cvo;
	}

	public int countNonMemverClient() {
		int count = 0;
		dbCommand = "SELECT COUNT(*) as count FROM client WHERE isMember=false;";
		System.out.println("dbcommand::::::::::" + dbCommand);
		ResultSet rs = db.select(dbCommand);
		try {
			rs.next();
			count = rs.getInt("count");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public boolean isExistClient(String id) {
		boolean isEC = false;
		dbCommand = "SELECT EXISTS (SELECT * FROM client WHERE id='" + id + "') as success;";
		System.out.println("dbcommand::::::::::" + dbCommand);
		ResultSet rs = db.select(dbCommand);
		try {
			rs.next();
			isEC = rs.getBoolean("success");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isEC;
	}

	public void modifyClientPeopleNum(ClientVo cvo) {
		String set = "";
		set = makeCommandUtil.setString(cvo.getPeopleNum(), set, "peopleNum");
		dbCommand = "UPDATE client set " + set + " where id='" + cvo.getId() + "';";
		System.out.println("dbcommand::::::::::" + dbCommand);
		db.update(dbCommand);
		return;
	}
	
	public void modifyClientPeopleNum(String id, int peopleNum) {
		String set = "";
		set = makeCommandUtil.setStringMinus(peopleNum, set, "peopleNum");
		dbCommand = "UPDATE client set " + set + " where id='" + id + "';";
		System.out.println("dbcommand::::::::::" + dbCommand);
		db.update(dbCommand);
		return;
	}

	public void modifyClient(ClientVo cvo) {
		String set = "";
		set = makeCommandUtil.setClientStringNP(cvo, set);
		dbCommand = "UPDATE client set " + set + " where id='" + cvo.getId() + "';";
		System.out.println("dbcommand::::::::::" + dbCommand);
		db.update(dbCommand);
		return;
	}

	public boolean isClientMember(String id) {
		dbCommand = "SELECT isMember FROM client WHERE id='" + id + "';";
		System.out.println("dbcommand::::::::::" + dbCommand);
		ResultSet rs = db.select(dbCommand);
		boolean ismem = true;
		try {
			rs.next();
			ismem = rs.getBoolean("isMember");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ismem;
	}

	public void deleteClient(String id) {
		// dbCommand ����
		dbCommand = "DELETE FROM client WHERE id='" + id + "';";
		System.out.println("dbcommand::::::::::" + dbCommand);
		db.delete(dbCommand);
		return;
	}

}
