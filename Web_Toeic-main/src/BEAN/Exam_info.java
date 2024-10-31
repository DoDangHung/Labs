package BEAN;

public class Exam_info {
	private int id;
	private String title,time;
	private boolean check=false;
	public boolean isCheck() {
		return check;
	}
	public void setCheck(boolean check) {
		this.check = check;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Exam_info(int id, String title, String time) {
		super();
		this.id = id;
		this.title = title;
		this.time = time;
	}
	public Exam_info(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
