package HateWait.Test;

import HateWait.Service.ClientService;
import HateWait.Service.MemberService;
import HateWait.Service.QueueService;
import HateWait.Service.StoreService;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ClientService cs = new ClientService();
		cs.insertClient("m0000", "김실장", 1012345678, 3, true);// 010 오류나네.. 10으로 넘겨야함

		MemberService ms = new MemberService();
		ms.insertMember("m0000", "김실장", 1012345678);
		
		StoreService ss=new StoreService();
		ss.insertStore("s0000", "맛있는 가게", "맛있습니다.", "평일 09:00-17:00", 7);
		
		QueueService qs=new QueueService();
		qs.insertQueue("s0000", "m0000", 1);

	}

}
