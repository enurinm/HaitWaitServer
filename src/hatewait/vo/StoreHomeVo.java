package hatewait.vo;

public class StoreHomeVo {//가게이름;현재가게대기인원;다음손님이름;다음손님인원수
	String sname;
	int allNum;
	String cname;
	int peopleNum;
	@Override
	public String toString() {
		return "StoreHomeVo [sname=" + sname + ", allNum=" + allNum + ", cname=" + cname + ", peopleNum=" + peopleNum
				+ "]";
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getAllNum() {
		return allNum;
	}
	public void setAllNum(int allNum) {
		this.allNum = allNum;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getPeopleNum() {
		return peopleNum;
	}
	public void setPeopleNum(int peopleNum) {
		this.peopleNum = peopleNum;
	}
}
