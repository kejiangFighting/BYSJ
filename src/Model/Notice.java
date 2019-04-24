package Model;

public class Notice {

    private String NoticeNo;
    private String Title;
    private String Content;
    private String Time;
    private int ClickNum;
    private String Department;
    private String Name;
    
    public Notice(String noticeno, String title, String name, String depar,
			String time) {
        this.NoticeNo = noticeno;
        this.Title = title;
        this.Name = name;
        this.Department = depar;
        this.Time = time;
	}
	public Notice() {
		// TODO Auto-generated constructor stub
	}
	public Notice(String noticeid, String title, String content,
			String time, String department, String name) {
        this.NoticeNo = noticeid;
        this.Title = title;
        this.Name = name;
        this.Department = department;
        this.Time = time;
        this.Content = content;
	}
	public String getNoticeNo() {
        return NoticeNo;
    }
    public void setNoticeNo(String NoticeNo) {
        this.NoticeNo = NoticeNo;
    }
    public String getTitle() {
        return Title;
    }
    public void setTitle(String Title) {
        this.Title = Title;
    }
    public String getContent() {
        return Content;
    }
    public void setContent(String Content) {
        this.Content = Content;
    }
    public String getTime() {
        return Time;
    }
    public void setTime(String Time) {
        this.Time = Time;
    }
    public int getClickNum() {
        return ClickNum;
    }
    public void setClickNum(int ClickNum) {
        this.ClickNum = ClickNum;
    }
    public String getDepartment() {
        return Department;
    }
    public void setDepartment(String Department) {
        this.Department = Department;
    }
    public String getName() {
        return Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
}
