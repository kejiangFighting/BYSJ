package Dao;

import java.util.List;

import Model.Message;



public interface MsgDao {

	public int addMsg(Message m);//�����Ϣ
	public int ChangeStatus(int msgid);
	public int deleteMsg(String id) throws Exception;
	public List<Message> ReadedMsg(String id) throws Exception;
	public List<Message> findAllFromAdm() throws Exception;
	public List<Message> NeverRead(String id) throws Exception;
	
}
