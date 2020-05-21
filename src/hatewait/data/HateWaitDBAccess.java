package hatewait.data;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HateWaitDBAccess {
	// 변수
	private java.sql.Connection conn;
	private java.sql.Statement stmt;
	private java.sql.ResultSet rs;
	private String dbInfo = "jdbc:mysql://127.0.0.1:3307/hate_wait?&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
	private String dbID = "root";
	private String dbPW = "root";
	private String jdbcDriver = "com.mysql.cj.jdbc.Driver"; // com.mysql.jdbc.Driver

	// 생성자
	HateWaitDBAccess() {
		connect();
	}

	/*
	 * HateWaitDBAccess(String dbUrl, String dbId, String dbPw){ this.dbInfo=dbUrl;
	 * this.dbID=dbId; this.dbPW=dbPw; connect(); }
	 */

	/*
	 * connect - mysql 연결
	 */
	void connect() {
		try {
			Class.forName(jdbcDriver);
			this.conn = java.sql.DriverManager.getConnection(dbInfo, dbID, dbPW);
			this.stmt = this.conn.createStatement();
		} catch (Exception e) {
			System.out.println("hatewait.data.HateWaitDBAccess::connection error:: " + e);
		}
		return;
	}

	/*
	 * add - 등록 함수 - member 등록 - client 등록 - store 등록 - queue 등록
	 */
	void insert(String dbCommand) {
		try {
			this.stmt.executeUpdate(dbCommand);
		} catch (SQLException e) {
			System.out.println("hatewait.data.HateWaitDBAccess::insert error:: " + e);
		}
		return;
	}

	/*
	 * read - 조회 함수 - client 조회 - queue 조회 --
	 */
	ResultSet select(String dbCommand) {
		try {
			this.rs = this.stmt.executeQuery(dbCommand);
		} catch (SQLException e) {
			System.out.println("hatewait.data.HateWaitDBAccess::select error:: " + e);
		}
		return this.rs;
	}

	/*
	 * delete - 삭제 함수 - queue 삭제
	 */
	void delete(String dbCommand) {
		try {
			this.stmt.executeUpdate(dbCommand);
		} catch (SQLException e) {
			System.out.println("hatewait.data.HateWaitDBAccess::delete error:: " + e);
		}
		return;
	}

	/*
	 * update - 수정 함수 - store 수정
	 */
	void update(String dbCommand) {
		try {
			this.stmt.executeUpdate(dbCommand);
		} catch (SQLException e) {
			System.out.println("hatewait.data.HateWaitDBAccess::update error:: " + e);
		}
		return;
	}

	// close - 종료 함수
	void close() {
		try {
			conn.close();
		} catch (Exception e) {
			System.out.println("hatewait.data.HateWaitDBAccess::close error:: " + e);
		}
		return;
	}
}
