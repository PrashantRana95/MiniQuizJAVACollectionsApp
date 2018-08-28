package quizappCollection.dto;

import java.util.Arrays;

public class QuestionDTO {

	private int id;
	private String question;
	private String options[] = new String[4];
	private String rightAnswer;
	private String yourAnswer;
	public int score;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + Arrays.hashCode(options);
		result = prime * result + ((question == null) ? 0 : question.hashCode());
		result = prime * result + ((rightAnswer == null) ? 0 : rightAnswer.hashCode());
		result = prime * result + score;
		result = prime * result + ((yourAnswer == null) ? 0 : yourAnswer.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QuestionDTO other = (QuestionDTO) obj;
		if (id != other.id)
			return false;
		if (!Arrays.equals(options, other.options))
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		if (rightAnswer == null) {
			if (other.rightAnswer != null)
				return false;
		} else if (!rightAnswer.equals(other.rightAnswer))
			return false;
		if (score != other.score)
			return false;
		if (yourAnswer == null) {
			if (other.yourAnswer != null)
				return false;
		} else if (!yourAnswer.equals(other.yourAnswer))
			return false;
		return true;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String[] getOptions() {
		return options;
	}
	public void setOptions(String[] options) {
		this.options = options;
	}
	public String getRightAnswer() {
		return rightAnswer;
	}
	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}
	public String getYourAnswer() {
		return yourAnswer;
	}
	public void setYourAnswer(String yourAnswer) {
		this.yourAnswer = yourAnswer;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "Question [id=" + id + ", question name=" + question + ", answers options=" + Arrays.toString(options) + ","
				+ " score=" + score
				+ ", rightAnswer=" + rightAnswer + ", yourAnswer=" + yourAnswer + "]";
	}

}
