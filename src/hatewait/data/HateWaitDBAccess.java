package hatewait.data;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HateWaitDBAccess {
	// ����
	private java.sql.Connection conn;
	private java.sql.Statement stmt;
	private java.sql.ResultSet rs;
	private String dbInfo = "jdbc:mysql://127.0.0.1:3307/hate_wait?&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
	private String dbID = "root";
	private String dbPW = "root";
	private String jdbcDriver = "com.mysql.cj.jdbc.Driver"; // com.mysql.jdbc.Driver

	// ������
	HateWaitDBAccess() {
		connect();
	}

	/*
	 * HateWaitDBAccess(String dbUrl, String dbId, String dbPw){ this.dbInfo=dbUrl;
	 * this.dbID=dbId; this.dbPW=dbPw; connect(); }
	 */

	/*
	 * connect - mysql ����
	 */
	void connect() {
		try {
			Class.forName(jdbcDriver);
			this.conn = java.sql.DriverManager.getConnection(dbInfo, dbID, dbPW);
			this.stmt = this.conn.createStatement();
		} catch (Exception e) {
			System.err.println("hatewait.data.HateWaitDBAccess::connection error:: " + e);
		}
		return;
	}

	/*
	 * add - ��� �Լ� - member ��� - client ��� - store ��� - queue ���
	 */
	void insert(String dbCommand) {
		try {
			this.stmt.executeUpdate(dbCommand);
		} catch (SQLException e) {
			System.err.println("hatewait.data.HateWaitDBAccess::insert error:: " + e);
		}
		return;
	}

	/*
	 * read - ��ȸ �Լ� - client ��ȸ - queue ��ȸ --
	 */
	ResultSet select(String dbCommand) {
		try {
			this.rs = this.stmt.executeQuery(dbCommand);
		} catch (SQLException e) {
			System.err.println("hatewait.data.HateWaitDBAccess::select error:: " + e);
		}
		return this.rs;
	}

	/*
	 * delete - ���� �Լ� - queue ����
	 */
	void delete(String dbCommand) {
		try {
			this.stmt.executeUpdate(dbCommand);
		} catch (SQLException e) {
			System.err.println("hatewait.data.HateWaitDBAccess::delete error:: " + e);
		}
		return;
	}

	/*
	 * update - ���� �Լ� - store ����
	 */
	void update(String dbCommand) {
		try {
			this.stmt.executeUpdate(dbCommand);
		} catch (SQLException e) {
			System.err.println("hatewait.data.HateWaitDBAccess::update error:: " + e);
		}
		return;
	}

	// close - ���� �Լ�
	void close() {
		try {
			conn.close();
		} catch (Exception e) {
			System.err.println("hatewait.data.HateWaitDBAccess::close error:: " + e);
		}
		return;
	}
}
