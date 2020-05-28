package hatewait.util;

import hatewait.vo.ClientVo;
import hatewait.vo.MemberVo;
import hatewait.vo.StoreVo;

public class MakeCommandUtil {

	public String setString(String s, String set, String column) {
		if (s == null) {
		} else {
			if ((!s.isEmpty()) && (!s.isBlank())) {
				if (!set.isBlank()) {
					set = set.concat(", " + column + "='" + s + "'");
				} else {
					set = set.concat(column + "='" + s + "'");
				}
			} else {}
		}
		return set;
	}

	public String setString(int n, String set, String column) {
		if (n > 0) {
			if (!set.isBlank()) {
				set = set.concat(", " + column + "='" + n + "'");
			} else {
				set = set.concat(column + "='" + n + "'");
			}
		} else {}
		return set;
	}
	
	public String setStringMinus(int n, String set, String column) {
		if (n <= 0) {
			if (!set.isBlank()) {
				set = set.concat(", " + column + "='" + n + "'");
			} else {
				set = set.concat(column + "='" + n + "'");
			}
		} else {}
		return set;
	}
	
	public String setStoreString(StoreVo svo, String set) {
		set=setString(svo.getName(),set,"name");
		set=setString(svo.getInfo(),set,"info");
		set=setString(svo.getTime(),set,"time");
		set=setString(svo.getMaxpeople(),set,"maxpeople");
		set=setString(svo.getAutonum(),set,"autonum");
		set=setString(svo.getAddress(),set,"address");
		set=setString(svo.getPhone(),set,"phone");
		set=setString(svo.getPw(),set,"pw");
		return set;
	}
	
	public String setMemberString(MemberVo mvo, String set) {
		set=setString(mvo.getName(),set,"name");
		set=setString(mvo.getPhone(),set,"phone");
		set=setString(mvo.getPw(),set,"pw");
		return set;
	}
	
	public String setClientStringNP(ClientVo cvo, String set) {
		set=setString(cvo.getName(),set,"name");
		set=setString(cvo.getPhone(),set,"phone");
		return set;
	}

}
