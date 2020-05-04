package HateWait.Data;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HateWaitDBAccess {
	//변수
	private java.sql.Connection conn;
	private java.sql.Statement stmt;
	private java.sql.ResultSet rs;
	private String dbInfo;
	private String dbID;
	private String dbPW;
	
	//생성자
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
	 * connect - mysql 연결
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
	 * add - 등록 함수
	 * - member 등록
	 * - client 등록
	 * - store 등록
	 * - queue 등록
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
	 * read - 조회 함수
	 * - client 조회
	 * - queue 조회
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
	 * delete - 삭제 함수
	 * - queue 삭제
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
	 * update - 수정 함수
	 * - store 수정
	 */
	void update(String dbCommand) {
		try {
			this.stmt.executeUpdate(dbCommand);
		}
		catch(SQLException e) {
			System.out.println("HateWait.Data.HateWaitDBAccess::update error::"+e);
		}
	}
	
	
	//close - 종료 함수
	void close() {
		try {
			conn.close();
		}
		catch(Exception e) {
			System.out.println("HateWait.Data.HateWaitDBAccess::close error::"+e);
		}
	}
}
