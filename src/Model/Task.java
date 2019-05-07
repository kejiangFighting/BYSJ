package Model;

public class Task {
	private String Name;
	private String FromNo;
	private String ToNo;
	private String Neirong;
	private String Time;

	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getFromNo() {
		return FromNo;
	}
	public void setFromNo(String fromNo) {
		FromNo = fromNo;
	}
	public String getToNo() {
		return ToNo;
	}
	public void setToNo(String toNo) {
		ToNo = toNo;
	}
	public String getNeirong() {
		return Neirong;
	}
	public void setNeirong(String neirong) {
		Neirong = neirong;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	
	public Task() {
		// TODO Auto-generated constructor stub
	}
	 public Task(String name, String fromNo, String Tono,String time,String neirong) {
	   
	       this.Name=name;
	       this.FromNo=fromNo;
	       this.ToNo=Tono;
	       this.Time=time;
	       this.Neirong=neirong;
		}
	
}
