package Questions;

import java.util.ArrayList;

public class Question {
	
	public static ArrayList<Question> Questions = new ArrayList<Question>();
	private String[] answers;
	private String question;
	private int correctAnswerIndex;
	private int difficulty;
	
	Question(String question, String answer1, String answer2, String answer3, String answer4, int correctAnswerIndex, int difficulty) {
		this.question = question;
		answers = new String[] {answer1, answer2, answer3, answer4};
		this.correctAnswerIndex = correctAnswerIndex - 1;
		this.difficulty = difficulty;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public String getAnswer(int index) {
		return answers[index];
	}
	
	public int getCorrectAnswerIndex() {
		return correctAnswerIndex;
	}
	
	public String getCorrectAnswerLetter() {
		if(correctAnswerIndex == 0) {
			return "A";
		} else if(correctAnswerIndex == 1) {
			return "B";
		} else if(correctAnswerIndex == 2) {
			return "C";
		} else if(correctAnswerIndex == 3) {
			return "D";
		} else {
			return "-1";
		}
	}
	
	public int getDifficulty() {
		return difficulty;
	}
	
	public String getLabelText() {
		return "<html>" + question + "<br/>"
						+ "A) " + answers[0] + "<br/>" 
						+ "B) " + answers[1] + "<br/>" 
						+ "C) " + answers[2] + "<br/>" 
						+ "D) " + answers[3] + "<br/>" 
						+ "</html>";
	}
	
	public String toString() {
		return "Question:" + question + "Answers:" + answers[0] + "," + answers[1] + "," + answers[2] + "," + answers[3] + "correctAnswerIndex:" + correctAnswerIndex + "difficulty:" + difficulty;
	}
	
	public static Question getQuestion(String s) {
		return null;
	}
}
