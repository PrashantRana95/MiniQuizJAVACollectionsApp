package quizappCollection.helper;

import java.util.HashSet;
import java.util.Iterator;

import quizappCollection.dto.QuestionDTO;

public class QuestionOperation {

	//LAZY WAY of the SIngleton class
	//This is actually set to the null
	private static QuestionOperation questionOperation;
	//HashSet has been chosen for the Questions as all the Questions we need are sorted and Random
	HashSet<QuestionDTO> questionSet = new HashSet<>();
	
	public HashSet<QuestionDTO> getQuestionSet() {
		return questionSet;
	}

	public void setQuestionSet(HashSet<QuestionDTO> questionSet) {
		this.questionSet = questionSet;
	}

	//One private constructor for the Singleton Implementation
	private QuestionOperation() {
		
	}
	
	//One getInstance method for the Singleton class
	public static QuestionOperation getInstance() {
		if(questionOperation==null) {
			questionOperation = new QuestionOperation(); 
		}
		return questionOperation;
	}
	
	//To add the question here 
	public void addQuestion(QuestionDTO questionObject) {
		questionSet.add(questionObject);
	}
	
	//To get questionname  by the index 
	public QuestionDTO getQuestionByIndex(int index) {
		int start = 0;
		//Sets the currentQuestion to the null
		QuestionDTO currentQuestion = null;
		//This iterator will iterate in the Questionset and iterate through that index
		Iterator<QuestionDTO> questionItr = questionSet.iterator();
		//Will move through the next questionset
		while(questionItr.hasNext()) {
			currentQuestion = questionItr.next();
			if(start==index) {
				break;
			}
			start++;
		}
		return currentQuestion;
	}
}
