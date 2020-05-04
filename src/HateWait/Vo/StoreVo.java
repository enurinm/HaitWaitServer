package HateWait.Vo;
import java.sql.Timestamp;

public class StoreVo {
	String id;
	String name;
	String info;
	Timestamp time;
	int anum;
	StoreVo(){}
	public String column() {
		return "id, name, info, time, anum";
	}
	public String value() {
		return id+", "+name+", "+info+", "+time+", "+anum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public int getAnum() {
		return anum;
	}
	public void setAnum(int anum) {
		this.anum = anum;
	}
	
}
