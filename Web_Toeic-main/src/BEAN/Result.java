package BEAN;

public class Result {
	private int result_score,exam_id;
	private String result_time;
	public int getResult_score() {
		return result_score;
	}
	public void setResult_score(int result_score) {
		this.result_score = result_score;
	}
	public int getExam_id() {
		return exam_id;
	}
	public void setExam_id(int exam_id) {
		this.exam_id = exam_id;
	}
	public String getResult_time() {
		return result_time;
	}
	public void setResult_time(String result_time) {
		this.result_time = result_time;
	}
	public Result(int result_score, int exam_id, String result_time) {
		super();
		this.result_score = result_score;
		this.exam_id = exam_id;
		this.result_time = result_time;
	}
	
}
