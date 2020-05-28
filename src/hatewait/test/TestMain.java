package hatewait.test;

import hatewait.service.ClientService;
import hatewait.service.MemberService;
import hatewait.service.QueueService;
import hatewait.service.StoreService;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ClientService cs = new ClientService();
		MemberService ms = new MemberService();
		StoreService ss=new StoreService();
		QueueService qs=new QueueService();
		
//		cs.insertClient("m0000", "김실장", 1012345678, 3, true);// 010 오류나네.. 10으로 넘겨야함
//		ms.insertMember("m0000", "김실장", 1012345678);
//		ss.insertStore("s0000", "맛있는가게", "존맛", "매일 10-15", 30, 3, "광진구 화양동 1", 205671200, "1111");;
//		qs.insertQueue("s0000", "m0000", 1);
		
//		ClientVo cvo= cs.getClient("m0000");
//		System.out.println("select end at main::::::::::::"+cvo.toString());
		
//		ss.modifyStore("s0000", "맛있는가게", "뭔가 그럴듯한 설명", "매일 10시-15시", 30, 4, "광진구 화양동 1", 205671200, "1111");
		
//		qs.deleteQueue("s0000", "n0001");
		
//		System.out.println("queue::::::::::::::"+qs.countQueue("s0000"));
//		System.out.println("제 차례는요 :::::::::::::"+qs.getClientTurn("s0000", "m0000"));
		
//		cs.insertClient("m0000", null, -1, 1, true);
		
//		ss.addQueue("s0000", "m0000", 20);
//		ss.addQueue("s0000", "홍길동", 1098765432, 5);
		
//		ss.getStoreQueueList("s0000");
		
	}

}
