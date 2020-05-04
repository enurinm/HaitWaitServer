package HateWait.Data;

public class MemberDao {
	HateWaitDBAccess db;
	
	MemberDao(){
		db.connect();
	}
}
