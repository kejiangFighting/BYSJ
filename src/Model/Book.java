package Model;

public class Book {
	private String BookID;//书号
	private String Name;
	private String Time;//资料版号（时间，版本）
	
	private String Introdu;//内容简介
	private String Type;//leibei 
	private int Num;
	
	public int getNum() {
		return Num;
	}
	public void setNum(int num) {
		Num = num;
	}
	public Book(){
		
	}
	public Book(String bookId,String name,String time,String introdu,String type,int num ){
		this.BookID=bookId;
		this.Name=name;
		this.Time=time;
		this.Num=num;
		this.Introdu=introdu;
		this.Type=type;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getBookID() {
		return BookID;
	}
	public void setBookID(String bookID) {
		BookID = bookID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	
	public String getIntrodu() {
		return Introdu;
	}
	public void setIntrodu(String introdu) {
		Introdu = introdu;
	}
	
	

}
