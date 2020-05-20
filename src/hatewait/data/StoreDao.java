package hatewait.data;

import hatewait.vo.StoreVo;

public class StoreDao {
	HateWaitDBAccess db;
	String dbCommand;

	public StoreDao() {
		dbCommand = "";
		this.db = new HateWaitDBAccess();
	}

	// 가게 정보 등록
	public void insertStore(StoreVo svo) {
		// dbCommand 수정
		dbCommand = "INSERT INTO store (" + svo.column() + ") VALUES (" + svo.value() + ");";
		System.out.println("dbcommand::::::::::" + dbCommand);
		// db호출
		db.insert(dbCommand);
		return;
	}

	// 가게 정보 수정
	public void modifyStore(StoreVo svo) {
		String set = "";
		set = setString(svo.getInfo(), set, "info");
		set = setString(svo.getTime(), set, "time");
		set = setString(svo.getAnum(), set);
		dbCommand = "UPDATE store set " + set + " where id='" + svo.getId() + "';";
		System.out.println("dbcommand::::::::::" + dbCommand);
		db.update(dbCommand);
		return;
	}

	String setString(String s, String set, String column) {
		if (s == null) {} 
		else {
			if ((!s.isEmpty()) && (!s.isBlank())) {
				if (!set.isBlank()) {
					set = set.concat(", " + column + "='" + s + "'");
				} else {
					set = set.concat(column + "='" + s + "'");
				}
			} else {}
		}
		return set;
	}

	String setString(int n, String set) {
		if (n > 0) {
			if (!set.isBlank()) {
				set = set.concat(", anum='" + n + "'");
			} else {
				set = set.concat("anum='" + n + "'");
			}
		} else {}
		return set;
	}
}
