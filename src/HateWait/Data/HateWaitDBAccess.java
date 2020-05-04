package HateWait.Data;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HateWaitDBAccess {
	//����
	private java.sql.Connection conn;
	private java.sql.Statement stmt;
	private java.sql.ResultSet rs;
	private String dbInfo;
	private String dbID;
	private String dbPW;
	
	//������
	HateWaitDBAccess(){
		dbInfo="jdbc:mysql://localhost:3307/hate_wait";
		dbID="root";
		dbPW="root";
		connect();
	}
	
	HateWaitDBAccess(String dbUrl, String dbId, String dbPw){
		this.dbInfo=dbUrl;
		this.dbID=dbId;
		this.dbPW=dbPw;
		connect();
	}
	
	
	/*
	 * connect - mysql ����
	 */
	void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.conn=java.sql.DriverManager.getConnection(dbInfo, dbID, dbPW);
			this.stmt=this.conn.createStatement();
		}
		catch(Exception e) {
			System.out.println("HateWait.Data.HateWaitDBAccess::connection error::"+e);
		}
	}
	
	
	/*
	 * add - ��� �Լ�
	 * - member ���
	 * - client ���
	 * - store ���
	 * - queue ���
	 */
	void insert(String dbCommand) {
		try {
			this.stmt.executeUpdate(dbCommand);
		}
		catch(SQLException e) {
			System.out.println("HateWait.Data.HateWaitDBAccess::insert error::"+e);
		}
	}
	
	
	/*
	 * read - ��ȸ �Լ�
	 * - client ��ȸ
	 * - queue ��ȸ
	 * --
	 */
	ResultSet select(String dbCommand) {
		try {
			this.rs=this.stmt.executeQuery(dbCommand);
		}
		catch(SQLException e) {
			System.out.println("HateWait.Data.HateWaitDBAccess::select error::"+e);
		}
		return this.rs;
	}
		
	
	/*
	 * delete - ���� �Լ�
	 * - queue ����
	 */
	void delete(String dbCommand) {
		try {
			this.stmt.executeUpdate(dbCommand);
		}
		catch(SQLException e) {
			System.out.println("HateWait.Data.HateWaitDBAccess::delete error::"+e);
		}
	}
		
	
	/*
	 * update - ���� �Լ�
	 * - store ����
	 */
	void update(String dbCommand) {
		try {
			this.stmt.executeUpdate(dbCommand);
		}
		catch(SQLException e) {
			System.out.println("HateWait.Data.HateWaitDBAccess::update error::"+e);
		}
	}
	
	
	//close - ���� �Լ�
	void close() {
		try {
			conn.close();
		}
		catch(Exception e) {
			System.out.println("HateWait.Data.HateWaitDBAccess::close error::"+e);
		}
	}
}
