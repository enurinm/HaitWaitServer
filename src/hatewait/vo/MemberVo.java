package hatewait.vo;

public class MemberVo {
	String id;
	String name;
	int phone;
	@Override
	public String toString() {
		return "MemberVo [id=" + id + ", name=" + name + ", phone=" + phone + "]";
	}
	public String column() {
		return "id, name, phone";
	}
	public String value() {
		return "'"+id+"', '"+name+"', "+phone;
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
}
