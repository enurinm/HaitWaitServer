package hatewait.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import hatewait.vo.QueueListSerializable;

public class TestClient2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Socket sock=new Socket("127.0.0.1",3000);
			BufferedReader keyboard=new BufferedReader(new InputStreamReader(System.in));
			OutputStream out=sock.getOutputStream();
			
			ObjectInputStream ois=new ObjectInputStream(sock.getInputStream()); //객체 받는 스트림
			
			PrintWriter pw=new PrintWriter(new OutputStreamWriter(out));
			String line=null; //단순 명령어입력.. 보내실 땐 그냥 프로토콜에 있는 대로 문자열로 보내시면 됩니당
			while((line=keyboard.readLine())!=null) {
				//명령어 보내는 파트(필요없음)
				pw.println(line);
				pw.flush();
				
				//객체 받는 파트(QueueListSerializable 객체로 받아와요! 객체 코드 참조!
				QueueListSerializable qls=(QueueListSerializable) ois.readObject();
				
				//이건 그냥 잘 받아왔는지 출력하는 코드.
				System.out.println("서버한테서 받은거::::: "+qls.toString()); 
			}
			pw.close();
			ois.close();
			sock.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
	}

}
