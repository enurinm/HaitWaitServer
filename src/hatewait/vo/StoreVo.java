package hatewait.vo;

public class StoreVo {
	String id;
	String name;
	String info;
	String time;
	int maxpeople;
	int autonum;
	String address;
	int phone;
	String pw;
	public StoreVo() {
		maxpeople=-1;
		autonum=-1;
	}
	
	@Override
	public String toString() {
		return "StoreVo [id=" + id + ", name=" + name + ", info=" + info + ", time=" + time + ", maxpeople=" + maxpeople
				+ ", autonum=" + autonum + ", address=" + address + ", phone=" + phone + ", pw=" + pw + "]";
	}

	public String column() {
		return "id, name, info, time, maxpeople, autonum, address, phone, pw";
	}
	public String value() {
		return "'"+id+"', '"+name+"', '"+info+"', '"+time+"', "+maxpeople+", "+autonum
				+", '"+address+"', "+phone+", '"+pw+"'";
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
	public int getMaxpeople() {
		return maxpeople;
	}
	public void setMaxpeople(int maxpeople) {
		this.maxpeople = maxpeople;
	}
	public int getAutonum() {
		return autonum;
	}
	public void setAutonum(int autonum) {
		this.autonum = autonum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	
	
}
