package hatewait.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class TestClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Socket sock=new Socket("127.0.0.1",3000);
			BufferedReader keyboard=new BufferedReader(new InputStreamReader(System.in));
			OutputStream out=sock.getOutputStream();
			InputStream in=sock.getInputStream();
			PrintWriter pw=new PrintWriter(new OutputStreamWriter(out));
			BufferedReader br=new BufferedReader(new InputStreamReader(in));
			String line=null;
			while((line=keyboard.readLine())!=null) {
				pw.println(line);
				pw.flush();
				String echo=br.readLine();
				System.out.println("서버한테서 받은거: "+echo);
			}
			pw.close();
			br.close();
			sock.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
	}

}
