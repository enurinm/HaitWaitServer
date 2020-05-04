package HateWait.Data;

public class StoreDao {
	HateWaitDBAccess db;
	
	StoreDao(){
		db.connect();
	}
}
