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
		makeCommandUtil=new MakeCommandUtil();
	}

	// client 등록
	public void insertClient(ClientVo cvo) {
		// dbCommand 수정
		dbCommand = "INSERT INTO client (" + cvo.column() + ") VALUES (" + cvo.value() + ");";
		System.out.println("dbcommand::::::::::" + dbCommand);
		// db호출
		db.insert(dbCommand);
		return;
	}

	/*
	 * client 조회 -개인 //select
	 */
	public ClientVo getClient(String id) {
		dbCommand = "SELECT * FROM client WHERE id='"+id+"';";
		System.out.println("dbcommand::::::::::" + dbCommand);
		ClientVo cvo = settingVoUtil.setClientVo(db.select(dbCommand));
		System.out.println("return value::::::::::"+cvo.toString());
		return cvo;
	}

	public int countNonMemverClient() {
		int count=0;
		dbCommand = "SELECT COUNT(*) as count FROM client WHERE isMember=false;";
		System.out.println("dbcommand::::::::::" + dbCommand);
		ResultSet rs=db.select(dbCommand);
		try {
			rs.next();
			count=rs.getInt("count");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	
	public boolean isExistClient(String id) {
		boolean isEC=false;
		dbCommand = "SELECT EXISTS (SELECT * FROM client WHERE id='"+id+"') as success;";
		System.out.println("dbcommand::::::::::" + dbCommand);
		ResultSet rs=db.select(dbCommand);
		try {
			rs.next();
			isEC=rs.getBoolean("success");
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

}
