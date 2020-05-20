package hatewait.vo;

public class StoreVo {
	String id;
	String name;
	String info;
	String time;
	int anum;
	public StoreVo() {
		anum=-1;
	}
	@Override
	public String toString() {
		return "StoreVo [id=" + id + ", name=" + name + ", info=" + info + ", time=" + time + ", anum=" + anum + "]";
	}
	public String column() {
		return "id, name, info, time, anum";
	}
	public String value() {
		return "'"+id+"', '"+name+"', '"+info+"', '"+time+"', "+anum;
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getAnum() {
		return anum;
	}
	public void setAnum(int anum) {
		this.anum = anum;
	}
	
}
