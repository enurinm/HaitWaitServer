package HateWait.Test;

import HateWait.Service.ClientService;

public class TestMain {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClientService cs=new ClientService();
		cs.insertClient("m0000", 1012345678, "김실장", 3, true);// 010 오류나네.. 10으로 넘겨야함
	
	}

}
