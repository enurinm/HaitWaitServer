package hatewait.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HateWaitSoket {
	Socket socket; // Client와 통신하기 위한 Socket
	ServerSocket serverSocket; // 서버 생성을 위한 ServerSocket
	BufferedReader in; // Client로부터 데이터를 읽어들이기 위한 입력스트림
	PrintWriter out; // Client로 데이터를 내보내기 위한 출력 스트림
	private static int PORT = 9999;
	
	public HateWaitSoket(){
		socket=null; 
		serverSocket=null;
		in=null;
		out=null;
	}

	public void soketOpen() {
		try {
			serverSocket = new ServerSocket(PORT);
			socket = serverSocket.accept();
		} catch (IOException e) {
			System.err.println("hatewait.network.HateWaitSoket::soketOpen() - 해당 포트가 열려 있습니다. "+e);
		}
		return;
	}
	
	public String soketRead() {
		String msgFromClient="";
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 입력스트림 생성

			msgFromClient = in.readLine(); // Client로부터 데이터를 읽어옴
			
		} catch (IOException e) {
			System.err.println("hatewait.network.HateWaitSoket::soketRead() "+e);
		}
		return msgFromClient;
	}
	
	public void soketWrite(String msgToClient) {
		try {
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))); // 출력스트림 생성

			out.write(msgToClient);
			out.flush();
		} catch (IOException e) {
			System.err.println("hatewait.network.HateWaitSoket::soketWrite() "+e);
		}
	}

	public void soketClose() {
		try {
			socket.close();
		}catch(IOException e) {
			System.err.println("hatewait.network.HateWaitSoket::soketClose() - 소켓을 닫는데 실패했습니다. "+e);
		}
		return;
	}
}
