package HateWait.Service;

import HateWait.Data.QueueDao;
import HateWait.Vo.QueueVo;

public class QueueService {
	public QueueVo setQueueVo(String sid,String cid,int turn) {
		QueueVo qvo=new QueueVo();
		//sid, cid가 실존하는지 확인하고 없으면 에러 출력하는 코드 추가
		qvo.setCid(cid);
		qvo.setSid(sid);
		qvo.setTurn(turn);
		return qvo;
	}
	
	public void insertQueue(String sid,String cid,int turn) {
		QueueVo qvo=setQueueVo(sid, cid, turn);
		System.out.println("QueueVo:::::::::::"+qvo.toString());
		QueueDao qd=new QueueDao();
		
		qd.insertQueue(qvo);
		return;
	}
}
