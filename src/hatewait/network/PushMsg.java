package hatewait.network;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class PushMsg {

	// HttpURLConnection를 실행하는 함수
	public static void getRequest(String phoneNum, String storeName, int autoNum) {
		try {

			// TODO String content = "storeName, autoNum을 이용해 url인코딩한 결과";
			String encodeResult = URLEncoder
					.encode("[HATEWAIT]-" + storeName + "\n" + autoNum + "번째 순서입니다. 가게 앞으로 와주세요.", "UTF-8");

			URL uri = new URL("http://uyttyu7532.cafe24.com/sms.php?num=" + phoneNum + "&content=" + encodeResult);
			// url를 통해 HttpURLConnection 클래스를 생성한다.
			HttpURLConnection connection = (HttpURLConnection) uri.openConnection();
			// 해더의 메소드를 정의한다.
			connection.setRequestMethod("GET");

			// 프로토콜의 반환 코드를 받을 수 있다. (200이면 정상이다.)
			int code = connection.getResponseCode();
			System.out.println(code);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		// localhost에 Get 방식으로 접속해서 파라미터는 param=test이다.
		// http://localhost/index.php?param=test
		getRequest("01093097866", "건국대학교 학식", 3);
	}

}
