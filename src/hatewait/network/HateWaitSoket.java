package hatewait.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HateWaitSoket {
	ServerSocket serverSocket;
	private static int PORT = 3000;
	
	
	public HateWaitSoket(){
		try {
			serverSocket = new ServerSocket(PORT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean soketOpen() {
		Socket socket;
		SoketThread st;
		try {
			System.out.println("접속 대기 중...");
			while(true) {
				socket = serverSocket.accept();
				System.out.println("::::::클라이언트 "+socket.getInetAddress()+" 접속 완료!");
				st=new SoketThread(socket);
				st.start();
			}
		} catch (IOException e) {
			System.err.println("hatewait.network.HateWaitSoket::soketOpen() - 해당 포트가 열려 있습니다. "+e);
		}
		return true;
	}
}
