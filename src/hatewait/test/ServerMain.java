package hatewait.test;

import hatewait.network.HateWaitSoket;

public class ServerMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HateWaitSoket sok=new HateWaitSoket();
		
		System.out.println("server start");
		sok.soketOpen();
	}

}
