package hatewait.test;

import hatewait.service.ClientService;
import hatewait.service.MemberService;
import hatewait.service.QueueService;
import hatewait.service.StoreService;
import hatewait.vo.ClientVo;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ClientService cs = new ClientService();
		MemberService ms = new MemberService();
		StoreService ss=new StoreService();
		QueueService qs=new QueueService();
		
//		cs.insertClient("m0000", "김실장", 1012345678, 3, true);// 010 오류나네.. 10으로 넘겨야함
//		ms.insertMember("m0000", "김실장", 1012345678);
//		ss.insertStore("s0000", "맛있는 가게", "맛있습니다.", "평일 09:00-17:00", 7);
//		qs.insertQueue("s0000", "m0000", 1);
		
		ClientVo cvo= cs.getClient("m0000");
		System.out.println("select end at main::::::::::::"+cvo.toString());
		
		ss.modifyStore("s0000", "아주맛있다", null, 5);

	}

}
