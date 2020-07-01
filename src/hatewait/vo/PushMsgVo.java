package hatewait.vo;

public class PushMsgVo {
	int phone;
	String name;
	int turn;
	
	@Override
	public String toString() {
		return "PushMsgVo [phone=" + phone + ", name=" + name + ", turn=" + turn + "]";
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTurn() {
		return turn;
	}
	public void setTurn(int turn) {
		this.turn = turn;
	}
}
