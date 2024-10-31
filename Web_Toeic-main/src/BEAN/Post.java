package BEAN;

public class Post {
	private String content,image,title,describe,time;
	public Post(String content, String image, String title, String describe, String time, int id) {
		super();
		this.content = content;
		this.image = image;
		this.title = title;
		this.describe = describe;
		this.time = time;
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	private int id;
	public Post(String content, String image, String title, String describe) {
		super();
		this.content = content;
		this.image = image;
		this.title = title;
		this.describe = describe;
	}
	public Post(String content, String image, String title, String describe, int id) {
		super();
		this.content = content;
		this.image = image;
		this.title = title;
		this.describe = describe;
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Post() {
		super();
	};
	
}
