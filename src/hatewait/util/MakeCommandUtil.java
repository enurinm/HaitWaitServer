package hatewait.util;

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

}
