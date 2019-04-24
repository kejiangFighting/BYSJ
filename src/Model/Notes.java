package Model;


public class Notes {
    private String notes_id;
    private String title;
    private String start_time;
    private String stop_time;
    private String description;
    private String Writer;
    private String bumen;
    public Notes(){
        super();
    }
    public Notes(String notes_id, String title, String  start_time, String stop_time, String description,String Writer,String bumen){
        this.notes_id = notes_id;
        this.title = title;
        this.start_time = start_time;
        this.stop_time = stop_time;
        this.description = description;
        this.Writer=Writer;
        this.bumen=bumen;
    }

    public String getNotes_id() {
        return notes_id;
    }

    public void setNotes_id(String notes_id) {
        this.notes_id = notes_id;
    }
    public String getWriter() {
        return Writer;
    }

    public void setWriter(String Writer) {
        this.Writer = Writer;
    }
    public String getBumen() {
        return bumen;
    }

    public void setBumen(String bumen) {
        this.bumen = bumen;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getStop_time() {
        return stop_time;
    }

    public void setStop_time(String stop_time) {
        this.stop_time = stop_time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
