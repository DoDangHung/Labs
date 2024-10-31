package BEAN;

public class Comment {
	private String cmt_id,id_post,cmt_content,member_id,member_name,cmt_time;
	int check;

	public Comment(String id_post, String cmt_content, String member_id, String member_name, String cmt_time) {
		super();
		this.id_post = id_post;
		this.cmt_content = cmt_content;
		this.member_id = member_id;
		this.member_name = member_name;
		this.cmt_time = cmt_time;
	}

	public Comment(String cmt_id, String id_post, String cmt_content, String member_id, String member_name,
			String cmt_time, int check) {
		super();
		this.cmt_id = cmt_id;
		this.id_post = id_post;
		this.cmt_content = cmt_content;
		this.member_id = member_id;
		this.member_name = member_name;
		this.cmt_time = cmt_time;
		this.check = check;
	}

	public int getCheck() {
		return check;
	}

	public void setCheck(int check) {
		this.check = check;
	}

	public Comment(String cmt_id, String id_post, String cmt_content, String member_id, String member_name,
			String cmt_time) {
		super();
		this.cmt_id = cmt_id;
		this.id_post = id_post;
		this.cmt_content = cmt_content;
		this.member_id = member_id;
		this.member_name = member_name;
		this.cmt_time = cmt_time;
	}

	public String getCmt_id() {
		return cmt_id;
	}

	public void setCmt_id(String cmt_id) {
		this.cmt_id = cmt_id;
	}

	public String getCmt_time() {
		return cmt_time;
	}

	public void setCmt_time(String cmt_time) {
		this.cmt_time = cmt_time;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public Comment(String id_post, String cmt_content, String member_id, String member_name) {
		super();
		this.id_post = id_post;
		this.cmt_content = cmt_content;
		this.member_id = member_id;
		this.member_name = member_name;
	}

	public Comment(String id_post, String cmt_content, String member_id) {
		super();
		this.id_post = id_post;
		this.cmt_content = cmt_content;
		this.member_id = member_id;
	}

	public Comment() {
		super();
	}

	public String getId_post() {
		return id_post;
	}

	public void setId_post(String id_post) {
		this.id_post = id_post;
	}

	public String getCmt_content() {
		return cmt_content;
	}

	public void setCmt_content(String cmt_content) {
		this.cmt_content = cmt_content;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	
}
