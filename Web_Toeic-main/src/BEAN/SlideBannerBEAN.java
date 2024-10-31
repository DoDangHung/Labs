package BEAN;

public class SlideBannerBEAN {
	private String sb_name,sb_content,sb_image;

	public SlideBannerBEAN(String sb_name, String sb_content, String sb_image) {
		super();
		this.sb_name = sb_name;
		this.sb_content = sb_content;
		this.sb_image = sb_image;
	}

	public SlideBannerBEAN() {
		super();
	}

	public String getSb_name() {
		return sb_name;
	}

	public void setSb_name(String sb_name) {
		this.sb_name = sb_name;
	}

	public String getSb_content() {
		return sb_content;
	}

	public void setSb_content(String sb_content) {
		this.sb_content = sb_content;
	}

	public String getSb_image() {
		return sb_image;
	}

	public void setSb_image(String sb_image) {
		this.sb_image = sb_image;
	}
	
}
