package hatewait.vo;

public class MemberVo {
	String id;
	String name;
	int phone;
	String pw;
	@Override
	public String toString() {
		return "MemberVo [id=" + id + ", name=" + name + ", phone=" + phone + ", pw=" + pw + "]";
	}
	public String column() {
		return "id, name, phone, pw";
	}
	public String value() {
		return "'"+id+"', '"+name+"', "+phone+", '"+pw+"'";
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
