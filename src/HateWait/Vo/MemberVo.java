package HateWait.Vo;

public class MemberVo {
	String id;
	String name;
	int phone;
	MemberVo(){
		
	}
	public String column() {
		return "id, name, phone";
	}
	public String value() {
		return id+", "+name+", "+phone;
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
