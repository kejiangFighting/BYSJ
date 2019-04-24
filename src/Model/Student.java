package Model;

public class Student {

    private String StuNo;
    private String Name;
    private String Major;
    private String Password;
    private String ComNo;
    
    public Student(String stuNo, String stupsw) {
        this.StuNo = stuNo;
        this.Password = stupsw;
	}
	public Student() {
	}
	public Student(String StuNo, String Name, String Major, String Password,String ComNo) {
        this.StuNo = StuNo;
        this.Name = Name;
        this.Major = Major;
        this.Password = Password;
        this.ComNo = ComNo;
	}
	public Student(String stuno, String name, String major, String comno) {
        this.StuNo = stuno;
        this.Name = name;
        this.Major = major;
        this.ComNo = comno;
	}
	public Student(String stuno, String name, String major) {
        this.StuNo = stuno;
        this.Name = name;
        this.Major = major;
	}
	public String getStuNo() {
        return StuNo;
    }
    public void setStuNo(String StuNo) {
        this.StuNo = StuNo;
    }
    public String getName() {
        return Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    public String getMajor() {
        return Major;
    }
    public void setMajor(String Major) {
        this.Major = Major;
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
