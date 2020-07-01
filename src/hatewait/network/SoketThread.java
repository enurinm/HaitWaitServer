package hatewait.network;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import hatewait.vo.QueueListSerializable;

public class SoketThread extends Thread {
	private Socket socket;
	private MessageParser mp;
	
	public SoketThread(Socket socket) {
		this.socket=socket;
		mp=new MessageParser();
	}
	
	public void run() {
		System.out.println("스레드 시작");
		try {
			OutputStream out=socket.getOutputStream();
			InputStream in=socket.getInputStream();
			PrintWriter pw=new PrintWriter(new OutputStreamWriter(out));
			BufferedReader br=new BufferedReader(new InputStreamReader(in));
			
			ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
//			ObjectInputStream ois=new ObjectInputStream(socket.getInputStream());
			
			String msgFromClient=null;
			String answer=null;
			
			while((msgFromClient=br.readLine())!=null) {
				System.out.println("전송받은 문자열:::::::"+msgFromClient);
				answer=mp.parseMessage(msgFromClient);
			
				if(answer.equals("SERIALIZE")) {
					answer=answer+";"+msgFromClient;
					String[] message;
					message = answer.split(";");
					QueueListSerializable qls=mp.strque(message);
					oos.writeObject(qls);
					oos.flush();
				}else {
					System.out.println("보내는 문자열::::::::"+answer);
					pw.println(answer);
					pw.flush();
				}
			} // end while
			
			oos.close();
			pw.close();
			br.close();
			socket.close();
		}catch(Exception e) {
			System.out.println("SoketThread.run:::::::::::: "+e);
		}finally {
			
		}
	}
}
