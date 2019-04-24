
package Model;

public class Company {

    private String ComNo;
    private String Name;
    private String Introduction;
    private String Plan;
    private String TeaNo;
    
    public Company(String comno, String name, String intro, String plan, String teano) {
        this.ComNo = comno;
        this.Name = name;
        this.Introduction = intro;
        this.Plan = plan;
        this.TeaNo = teano;
	}
	public Company() {
		// TODO Auto-generated constructor stub
	}
	public String getComNo() {
        return ComNo;
    }
    public void setComNo(String ComNo) {
        this.ComNo = ComNo;
    }
    public String getName() {
        return Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    public String getIntroduction() {
        return Introduction;
    }
    public void setIntroduction(String Introduction) {
        this.Introduction = Introduction;
    }
    public String getPlan() {
        return Plan;
    }
    public void setPlan(String Plan) {
        this.Plan = Plan;
    }
    public String getTeaNo() {
        return TeaNo;
    }
    public void setTeaNo(String TeaNo) {
        this.TeaNo = TeaNo;
    }
}
