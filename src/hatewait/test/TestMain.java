package hatewait.test;

import hatewait.network.HateWaitSoket;
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
		HateWaitSoket sok=new HateWaitSoket();
		
//		cs.insertClient("m0000", "�����", 1012345678, 3, true);// 010 ��������.. 10���� �Ѱܾ���
//		ms.insertMember("m0000", "�����", 1012345678,"1111");
//		ss.insertStore("s0000", "���ִ°���", "����", "���� 10-15", 30, 3, "������ ȭ�絿 1", 205671200, "1111");
//		qs.insertQueue("s0000", "m0000", 1);
		
//		ClientVo cvo= cs.getClient("m0000");
//		System.out.println("select end at main::::::::::::"+cvo.toString());
		
//		ss.modifyStore("s0000", "���ִ°���", "���� �׷����� ����", "���� 10��-15��", 30, 4, "������ ȭ�絿 1", 205671200, "1111");
		
//		qs.deleteQueue("s0000", "n0000");
//		qs.deleteQueue("s0000", "m0000");
		
//		System.out.println("queue::::::::::::::"+qs.countQueue("s0000"));
//		System.out.println("�� ���ʴ¿� :::::::::::::"+qs.getClientTurn("s0000", "m0000"));
		
//		cs.insertClient("m0000", null, -1, 1, true);
		
//		ss.addQueue("s0000", "�Ż��Ӵ�", 1011111111, 9);
//		ss.addQueue("s0000", "m0000", 20);
//		ss.addQueue("s0000", "��Ȳ", 1022222222, 1);
		
//		ss.getStoreQueueList("s0000");
		
//		ms.modifyMember("m0000", "�����", 1098765432, "0000");
		
//		System.out.println("mem home::::::::::::"+ms.loadMemberHome("m0000"));
//		System.out.println("str home::::::::::::"+ss.loadStoreHome("s0000"));
		
//		qs.deleteQueue("s0000", "n0001");
		
//		MessageParser mp=new MessageParser();
//		
//		String m="";
//		m="SIGNUP;STORE;s1111;��ȸ�����;��ȸ�԰������ ���°���;���� 9��-20��;30;3;����Ư���� ��¼�� ��¼�� 1����;245678903;1111";
//		m="SIGNUP;MEMBER;m0001;���̸�;1098762345;1111";
//		
//		m="MODIFY;STORE;s1111;��ȸ�����;��ȸ�԰������ ���°���;���� 9��-20��;40;3;����Ư���� ��¼�� 1����;245678903;1111";
//		m="MODIFY;MEMBER;m0001;���̸�;1098762345;1111";
//		
//		m="INSQUE;NONMEM;s1111;�ֿ���;1099999999;3";
//		m="INSQUE;MEMBER;s1111;m0001;3";
//		
//		m="MAIN;STORE;s0000";
//		m="MAIN;MEMBER;m0001";
//		
//		m="DELQUE;s1111;n0003";
//		
//		m="STRQUE;s1111";
//		
//		m="";
		
//		System.out.println("::::::::::::"+mp.parseCategory(m));
		
		System.out.println("server start");
		sok.soketOpen();
		
//		ss.getStoreQueueList("s0000");
	}

}
