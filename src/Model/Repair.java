package Model;



public class Repair {
	private String UserID;
	private String EquipID;
	private String Time;
	private String Describe;
    public Repair() {
		// TODO Auto-generated constructor stub
	}
	     
    public Repair(String UserID, String EquipID, String Time,
			String Describe) {
    	this.Describe=Describe;
    	this.EquipID=EquipID;
    	this.Time=Time;
    	this.UserID=UserID;
        
      
	}
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getEquipID() {
		return EquipID;
	}
	public void setEquipID(String equipID) {
		EquipID = equipID;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	public String getDescribe() {
		return Describe;
	}
	public void setDescribe(String describe) {
		Describe = describe;
	}
	
}
