package Model;


public class report {
    private String school_num;
    private String name;
    private String gradeP;
    private String gradeK;
    private String gradeZ;
    private String major;
    private String tel;
    private String teacher;
    private String department;
    private String time;
    private String summary;
   
    public report(){
        super();
    }
    public report(String school_num, String name, String  gradeP, String gradeK, String gradeZ,String major,String tel,String teacher,String department,String time,String summary){
        this.department=department;
    	this.gradeK=gradeK;
    	this.gradeP=gradeP;
    	this.gradeZ=gradeZ;
    	this.major=major;
    	this.name=name;
    	this.school_num=school_num;
    	this.summary=summary;
    	this.teacher=teacher;
    	this.time=time;
    	this.tel=tel;
    }
    public String getSchool_num() {
		return school_num;
	}
	public void setSchool_num(String school_num) {
		this.school_num = school_num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGradeP() {
		return gradeP;
	}
	public void setGradeP(String gradeP) {
		this.gradeP = gradeP;
	}
	public String getGradeK() {
		return gradeK;
	}
	public void setGradeK(String gradeK) {
		this.gradeK = gradeK;
	}
	public String getGradeZ() {
		return gradeZ;
	}
	public void setGradeZ(String gradeZ) {
		this.gradeZ = gradeZ;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	

   
}
