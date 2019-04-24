package Model;

public class Teacher {


    private String TeaNo;
    private String Name;
    private String Password;
    private String ComNo;
    
    public Teacher(String teaNo, String teaPsw) {
        this.TeaNo = teaNo;
        this.Password = teaPsw;
	}
    public Teacher() {
	}
	public Teacher(String teano, String teaname, String teapsw, String comno) {
        this.TeaNo = teano;
        this.Password = teapsw;
        this.Name = teaname;
        this.ComNo = comno;
	}
	public String getTeaNo() {
        return TeaNo;
    }
    public void setTeaNo(String TeaNo) {
        this.TeaNo = TeaNo;
    }
    public String getName() {
        return Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    public String getPassword() {
        return Password;
    }
    public void setPassword(String Password) {
        this.Password = Password;
    }
    public String getComNo() {
        return ComNo;
    }
    public void setComNo(String ComNo) {
        this.ComNo = ComNo;
    }
}
