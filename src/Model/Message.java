package Model;

public class Message {

    private int MsgNo;
    private String FromNo;
    private String UserNo;
    private String Content;
    private int Status;
    public Message(int msgno, String userno, String fromno, String content) {
    	this.MsgNo=msgno;
	    this.FromNo = fromno;
	    this.UserNo = userno;
	    this.Content = content;
	}
	public Message() {
	}
	public Message(String userno, String content) {
		this.UserNo=userno;
		this.Content=content;
	}

	public String getFromNo() {
        return FromNo;
    }
    public void setFromNo(String FromNo) {
        this.FromNo = FromNo;
    }
    public String getUserNo() {
        return UserNo;
    }
    public void setUserNo(String userNo) {
        this.UserNo = userNo;
    }
    public String getContent() {
        return Content;
    }
    public void setContent(String Content) {
        this.Content = Content;
    }
    public int getStatus() {
        return Status;
    }
    public void setStatus(int Status) {
        this.Status = Status;
    }
	public int getMsgNo() {
		return MsgNo;
	}
	public void setMsgNo(int msgNo) {
		this.MsgNo = msgNo;
	}
}
