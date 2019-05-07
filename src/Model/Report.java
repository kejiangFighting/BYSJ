package Model;


public class Report {
 
    private String Name;
    private String Time;
    private String StuNo;
    private String TeaNO;
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
	private String Neirong;
    private String Pingyu;
    public String getStuNo() {
		return StuNo;
	}
	public void setStuNo(String stuNo) {
		StuNo = stuNo;
	}
	public String getTeaNO() {
		return TeaNO;
	}
	public void setTeaNO(String teaNO) {
		TeaNO = teaNO;
	}
	public String getNeirong() {
		return Neirong;
	}
	public void setNeirong(String neirong) {
		Neirong = neirong;
	}
	public String getPingyu() {
		return Pingyu;
	}
	public void setPingyu(String pingyu) {
		Pingyu = pingyu;
	}
	
  
    public Report(){
        super();
    }
    public Report(String name, String teano, String  stuno, String time, String neirong,String pingyu){
       this.Name=name;
       this.TeaNO=teano;
       this.StuNo=stuno;
       this.Time=time;
       this.Neirong=neirong;
       this.Pingyu=pingyu;
    } 
}
