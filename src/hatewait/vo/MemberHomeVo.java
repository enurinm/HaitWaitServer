package hatewait.vo;

public class MemberHomeVo {
	String mname;
	String sname;
	int turn;
	@Override
	public String toString() {
		return "MemberHomeVo [mname=" + mname + ", sname=" + sname + ", turn=" + turn + "]";
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getTurn() {
		return turn;
	}
	public void setTurn(int turn) {
		this.turn = turn;
	}	
}
