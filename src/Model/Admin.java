package Model;

public class Admin {

    private String AdmNo;
    private String Password;
    
    public Admin(String AdmNo, String psw) {
        this.AdmNo = AdmNo;
        this.Password = psw;
	}
	public Admin() {
		// TODO Auto-generated constructor stub
	}
	public String getAdmNo() {
        return AdmNo;
    }
    public void setAdmNo(String AdmNo) {
        this.AdmNo = AdmNo;
    }
    public String getPassword() {
        return Password;
    }
    public void setPassword(String Password) {
        this.Password = Password;
    }
}
