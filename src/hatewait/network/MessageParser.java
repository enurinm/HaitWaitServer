package hatewait.network;

import hatewait.service.ClientService;
import hatewait.service.MemberService;
import hatewait.service.QueueService;
import hatewait.service.StoreService;

public class MessageParser {
	ClientService cs;
	MemberService ms;
	StoreService ss;
	QueueService qs;

	public MessageParser() {
		cs = new ClientService();
		ms = new MemberService();
		ss = new StoreService();
		qs = new QueueService();
	}

	public String parseCategory(String m) {
		String returnString = "";
		String[] message;
		message = m.split(";");

		if (message[0].equals("SIGNUP")) {
			returnString = signup(message);

		} else if (message[0].equals("MODIFY")) {
			returnString = modify(message);

		} else if (message[0].equals("INSQUE")) {
			returnString = insque(message);

		} else if (message[0].equals("STRQUE")) {
			returnString = strque(message);

		} else if (message[0].equals("MAIN")) {
			returnString = main(message);

		} else if (message[0].equals("DELQUE")) {
			returnString = delque(message);

		} else if (message[0].equals("PUSHALARM")) {
			returnString = pushAlarm(message);

		} else {
			returnString = "syntax error";
		}

		return returnString;
	}

	String signup(String[] message) {
		String returnString = "";
		if (message[1].equals("STORE")) {
			ss.insertStore(message[2], message[3], message[4], message[5], Integer.parseInt(message[6]),
					Integer.parseInt(message[7]), message[8], Integer.parseInt(message[9]), message[10]);
		} else if (message[1].equals("MEMBER")) {
			ms.insertMember(message[2], message[3], Integer.parseInt(message[4]), message[5]);
		}
		return returnString;
	}

	String modify(String[] message) {
		String returnString = "";
		if (message[1].equals("STORE")) {
			ss.modifyStore(message[2], message[3], message[4], message[5], Integer.parseInt(message[6]),
					Integer.parseInt(message[7]), message[8], Integer.parseInt(message[9]), message[10]);
		} else if (message[1].equals("MEMBER")) {
			ms.modifyMember(message[2], message[3], Integer.parseInt(message[4]), message[5]);
		}
		return returnString;
	}

	String insque(String[] message) {
		String returnString = "";
		if(message[1].equals("NONMEM")) {
			returnString=ss.addQueue(message[2], message[3], Integer.parseInt(message[4]), Integer.parseInt(message[5]));
		}else if(message[1].equals("MEMBER")) {
			returnString=ss.addQueue(message[2], message[3], Integer.parseInt(message[4]));
		}
		return returnString;
	}

	String strque(String[] message) {
		String returnString = "";
		return returnString;
	}

	String main(String[] message) {
		String returnString = "";
		if (message[1].equals("STORE")) {
			returnString=ss.loadStoreHome(message[2]);
		} else if (message[1].equals("MEMBER")) {
			returnString=ms.loadMemberHome(message[2]);
		}
		return returnString;
	}

	String delque(String[] message) {
		String returnString = "";
		qs.deleteQueue(message[1], message[2]);
		return returnString;
	}

	String pushAlarm(String[] message) {
		String returnString = "";
		return returnString;
	}
}
