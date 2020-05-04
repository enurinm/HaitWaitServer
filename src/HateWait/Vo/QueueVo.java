package HateWait.Vo;

public class QueueVo {
	String sid;
	String cid;
	int turn;
	QueueVo(){
		
	}
	public String column() {
		return "sid, cid, turn";
	}
	public String value() {
		return sid+", "+cid+", "+turn;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public int getTurn() {
		return turn;
	}
	public void setTurn(int turn) {
		this.turn = turn;
	}	
}
