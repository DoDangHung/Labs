package BEAN;

public class Exam {
	public Exam() {
		super();
	}
	int exam_id,group_question,part,questionnumber;
	String image,audio,question,anwser1,anwser2,anwser3,anwser4,correct_anwser;
	public int getExam_id() {
		return exam_id;
	}
	public void setExam_id(int exam_id) {
		this.exam_id = exam_id;
	}
	public int getGroup_question() {
		return group_question;
	}
	public void setGroup_question(int group_question) {
		this.group_question = group_question;
	}
	public int getPart() {
		return part;
	}
	public void setPart(int part) {
		this.part = part;
	}
	public int getQuestionnumber() {
		return questionnumber;
	}
	public void setQuestionnumber(int questionnumber) {
		this.questionnumber = questionnumber;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getAudio() {
		return audio;
	}
	public void setAudio(String audio) {
		this.audio = audio;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnwser1() {
		return anwser1;
	}
	public void setAnwser1(String anwser1) {
		this.anwser1 = anwser1;
	}
	public String getAnwser2() {
		return anwser2;
	}
	public void setAnwser2(String anwser2) {
		this.anwser2 = anwser2;
	}
	public String getAnwser3() {
		return anwser3;
	}
	public void setAnwser3(String anwser3) {
		this.anwser3 = anwser3;
	}
	public String getAnwser4() {
		return anwser4;
	}
	public void setAnwser4(String anwser4) {
		this.anwser4 = anwser4;
	}
	public String getCorrect_anwser() {
		return correct_anwser;
	}
	public void setCorrect_anwser(String correct_anwser) {
		this.correct_anwser = correct_anwser;
	}
	public Exam(int exam_id, int group_question, int part, int questionnumber, String image, String audio,
			String question, String anwser1, String anwser2, String anwser3, String anwser4, String correct_anwser) {
		super();
		this.exam_id = exam_id;
		this.group_question = group_question;
		this.part = part;
		this.questionnumber = questionnumber;
		this.image = image;
		this.audio = audio;
		this.question = question;
		this.anwser1 = anwser1;
		this.anwser2 = anwser2;
		this.anwser3 = anwser3;
		this.anwser4 = anwser4;
		this.correct_anwser = correct_anwser;
	}
	
}
