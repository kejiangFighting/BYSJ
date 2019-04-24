package Model;
public class User {
    private String email;
    private String password;
    private int role;
    private String name;
    public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}

	private String userID;
    private String college;
    private String phone;
    private String major;
    private String team;
    
	public User(){
        super();
    }
    public User (String userID, String password){
        this.userID=userID;
        this.password = password;
    }
    public String getEmail(){

        return email;
    }
    public void setEmail(String email){

        this.email = email;
    }
    public String getPassword(){

        return password;
    }
    public void setPassword(String password){

        this.password = password;
    }
    public int getRole() {
        return role;
    }
    public void setRole(int role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

