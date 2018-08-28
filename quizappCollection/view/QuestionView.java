package quizappCollection.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import quizappCollection.dto.QuestionDTO;
import quizappCollection.helper.QuestionOperation;

public class QuestionView extends JFrame {

	private JPanel contentPane;
	//This is the button group
	ButtonGroup buttonGroup = new ButtonGroup();
	private int totalQuestions;
	private int index = 0;
	Object o;
	private void printQuestion(int index) {
		//This will pick the Questions by the order of the index from the Question class
		QuestionDTO currentQuestion = QuestionOperation.getInstance().getQuestionByIndex(index);
		System.out.println(currentQuestion.hashCode());
		System.out.println(System.identityHashCode(currentQuestion));
		StringBuilder question = new StringBuilder();
		question.append("Q").append(index+1).append(" ").append(currentQuestion.getQuestion());
		questionlbl.setText(question.toString());
		buttonGroup.add(ans1rb);
		ans1rb.setText(currentQuestion.getOptions()[0]);
		buttonGroup.add(ans2rb);
		ans2rb.setText(currentQuestion.getOptions()[1]);
		buttonGroup.add(ans3rb);
		ans3rb.setText(currentQuestion.getOptions()[2]);
		buttonGroup.add(ans4rb);
		ans4rb.setText(currentQuestion.getOptions()[3]);
//		This line suggests that if your answer is not equal to the null and if ans greater than zero then enter into the loop
		if(!(currentQuestion.getYourAnswer()!=null && currentQuestion.getYourAnswer().trim().length()>0)){
			clearAnswers();
		}
		else
		{
			switch(currentQuestion.getYourAnswer()) {
			case "a":
				ans1rb.setSelected(true);
				break;
			case "b":
				ans2rb.setSelected(true);
				break;
			case "c":
				ans3rb.setSelected(true);
				break;
			case "d":
				ans4rb.setSelected(true);
				break;
			}
		}
	}
	
//	This ClearAnswer will actually clear the answer...means will clear the racio button and move to the next radio button
	private void clearAnswers() {
		buttonGroup.clearSelection();
	}
	
	//This will print the Updated Answer...and check it by index by index 
	private void updateAns(ActionEvent e) {
		QuestionDTO currentQuestion = QuestionOperation.getInstance().getQuestionByIndex(index);
		if(e.getSource()==ans1rb) {
			currentQuestion.setYourAnswer("a");
		}
		else
		if(e.getSource()==ans2rb){
			currentQuestion.setYourAnswer("b");
		}
		else
		if(e.getSource()==ans3rb) {
			currentQuestion.setYourAnswer("c");
		}
		else
		if(e.getSource()==ans4rb) {
			currentQuestion.setYourAnswer("d");
		}
		System.out.println("Update...."+currentQuestion.getYourAnswer());
		
		if(currentQuestion.getYourAnswer().equals(currentQuestion.getRightAnswer())) {
			System.out.println("This is Checking Answers");
			computeMarks();
		}
	}
	
	
	private void loadQuestions() {
		QuestionOperation questionOperation = QuestionOperation.getInstance();
		QuestionDTO questionDTO = new QuestionDTO();
		questionDTO.setId(1);
		questionDTO.setQuestion("JVM Stands For");
		//These are all the options set here 
		String answers [] = {"Java Vital Machine","Java Virtual Machine","Both","None of these"};
		questionDTO.setOptions(answers);
		questionDTO.setRightAnswer("b");
		questionDTO.setScore(5);
		questionOperation.addQuestion(questionDTO);
		
		questionDTO = new QuestionDTO();
		questionDTO.setId(2);
		questionDTO.setQuestion("JRE Stands For");
		//These are all the options set here 
		String answers0 [] = {"Java Runtime Environment","Java Virtual Machine","Both","None of these"};
		questionDTO.setOptions(answers0);
		questionDTO.setRightAnswer("a");
		questionDTO.setScore(5);
		questionOperation.addQuestion(questionDTO);
		
		
		questionDTO = new QuestionDTO();
		questionDTO.setId(3);
		questionDTO.setQuestion("Java is Developed By");
		//These are all the options set here 
		String answers1 [] = {"Sun MicroSystem","Oracle","Microsoft","None of these"};
		questionDTO.setOptions(answers1);
		questionDTO.setRightAnswer("a");
		questionDTO.setScore(5);
		questionOperation.addQuestion(questionDTO);
		
		questionDTO = new QuestionDTO();
		questionDTO.setId(4);
		questionDTO.setQuestion("Which component is used to compile, debug and execute java program?");
		//These are all the options set here 
		String answers2 [] = {"JVM","JDK","JIT","JRE"};
		questionDTO.setOptions(answers2);
		questionDTO.setRightAnswer("b");
		questionDTO.setScore(5);
		questionOperation.addQuestion(questionDTO);
		
		
		questionDTO = new QuestionDTO();
		questionDTO.setId(5);
		questionDTO.setQuestion("Which component is responsible to run java program?");
		//These are all the options set here 
		String answers3 [] = {"Java Virtual Machine","JDK","JIT","JRE"};
		questionDTO.setOptions(answers3);
		questionDTO.setRightAnswer("b");
		questionDTO.setScore(5);
		questionOperation.addQuestion(questionDTO);
		
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuestionView frame = new QuestionView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	

	JLabel questionlbl = new JLabel("");
	JRadioButton ans1rb = new JRadioButton("");
	JRadioButton ans2rb = new JRadioButton("");
	JRadioButton ans3rb = new JRadioButton("");
	JRadioButton ans4rb = new JRadioButton("");
	
	/**
	 * Create the frame.
	 */
	public QuestionView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 722, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		questionlbl.setBounds(24, 29, 657, 98);
		contentPane.add(questionlbl);
		loadQuestions();
		printQuestion(this.index);
		enableDisable();
		makeGroup();
		this.totalQuestions = QuestionOperation.getInstance().getQuestionSet().size();
		
		buttonGroup.add(ans1rb);
		ans1rb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateAns(e);
			}
		});
		ans1rb.setBounds(24, 155, 188, 23);
		contentPane.add(ans1rb);
		buttonGroup.add(ans2rb);
		ans2rb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateAns(e);
			}
		});
		
		ans2rb.setBounds(24, 208, 188, 23);
		contentPane.add(ans2rb);
		buttonGroup.add(ans3rb);
		ans3rb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateAns(e);
			}
		});
		
		ans3rb.setBounds(24, 263, 188, 23);
		contentPane.add(ans3rb);
		buttonGroup.add(ans4rb);
		ans4rb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateAns(e);
			}
		});
		
		ans4rb.setBounds(24, 310, 188, 23);
		contentPane.add(ans4rb);
		
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prev();
			}
		});
		btnPrevious.setBounds(10, 382, 89, 23);
		contentPane.add(btnPrevious);
		
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				next();
			}
		});
		btnNext.setBounds(447, 382, 89, 23);
		contentPane.add(btnNext);
		
		JButton btnTestCompleted = new JButton("Test Completed");
		btnTestCompleted.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				testCompleted();
			}
		});
		btnTestCompleted.setBounds(246, 382, 127, 23);
		contentPane.add(btnTestCompleted);
		
		
		
	}
	JButton btnPrevious = new JButton("Previous");
	JButton btnNext = new JButton("Next");
	private void prev() {
		if(index>0) {
			index--;
			btnPrevious.setEnabled(true);
		}
		printQuestion(index);
		enableDisable();
	}
	
	private void enableDisable() {
		btnPrevious.setEnabled(index==0?false:true);
		btnNext.setEnabled(index==totalQuestions-1?false:true);
	}
	
	//For the next button
	private void next() {
		if(index<totalQuestions){
			index++;
		}
		enableDisable();
		printQuestion(index);
	}
	
	QuestionDTO questionDTO = new QuestionDTO();
	
	int totalMarks ; 
	private void computeMarks() {
//		QuestionDTO currentQuestion = QuestionOperation.getInstance().getQuestionByIndex(index);
		this.totalMarks = questionDTO.getScore();
		this.totalMarks=totalMarks+5;
		questionDTO.setScore(totalMarks);
		System.out.println(questionDTO.getScore());
		
	}
	
	private void testCompleted() {
//		QuestionDTO currentQuestion = QuestionOperation.getInstance().getQuestionByIndex(index);
//		QuestionDTO questionDTO = new QuestionDTO();
		this.setVisible(false);
		ResultView resultView = new ResultView();
		resultView.setVisible(true);
//		resultView.marksDisplay.setText
		resultView.marksDisplay.setText(String.valueOf(questionDTO.getScore()));
		System.out.println(questionDTO.getScore());
		resultView.noofquestionAttempts.setText(String.valueOf(totalQuestions));
		int percentage=questionDTO.getScore()/totalQuestions*20;
		resultView.percentagelbl.setText(String.valueOf(percentage));
	}
	
	private void makeGroup() {
		
	}
}
