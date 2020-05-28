package hatewait.util;

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

}
