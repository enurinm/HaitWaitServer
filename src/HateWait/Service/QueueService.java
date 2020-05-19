package HateWait.Service;

import HateWait.Data.QueueDao;
import HateWait.Vo.QueueVo;

public class QueueService {
	public QueueVo setQueueVo(String sid,String cid,int turn) {
		QueueVo qvo=new QueueVo();
		//sid, cid�� �����ϴ��� Ȯ���ϰ� ������ ���� ����ϴ� �ڵ� �߰�
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
