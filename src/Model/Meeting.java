package Model;

public class Meeting {
	private String UserID;
	private String Time;
	private String StartTime;
	private String EndTime;
	private String Title;
	private String Equip;
	private int Num;
	private String Names;
	private String Phone;
	private String Status;
	private int ID ;
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public Meeting(){
		
	}
	public Meeting(String status,String userID,String time,String startTime,String endTime,String title,String names,String equip,int num,String phone){
		this.UserID=userID;
		this.Status=status;
		this.Time=time;
		this.StartTime=startTime;
		this.EndTime=endTime;
		this.Title=title;
		this.Equip=equip;
		this.Names=names;
		this.Phone=phone;
		this.Num=num;
		
	}
	public Meeting(int id,String status,String userID,String time,String startTime,String endTime,String title,String names,String equip,int num,String phone){
		this.UserID=userID;
		this.Status=status;
		this.Time=time;
		this.StartTime=startTime;
		this.EndTime=endTime;
		this.Title=title;
		this.Equip=equip;
		this.Names=names;
		this.Phone=phone;
		this.Num=num;
		this.ID=id;
		
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	public String getStartTime() {
		return StartTime;
	}
	public void setStartTime(String startTime) {
		StartTime = startTime;
	}
	public String getEndTime() {
		return EndTime;
	}
	public void setEndTime(String endTime) {
		EndTime = endTime;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getEquip() {
		return Equip;
	}
	public void setEquip(String equip) {
		Equip = equip;
	}
	public int getNum() {
		return Num;
	}
	public void setNum(int num) {
		Num = num;
	}
	public String getNames() {
		return Names;
	}
	public void setNames(String names) {
		Names = names;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	
	

}
