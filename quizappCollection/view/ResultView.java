package quizappCollection.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import quizappCollection.dto.QuestionDTO;
import quizappCollection.helper.QuestionOperation;

import javax.swing.JLabel;

public class ResultView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResultView frame = new ResultView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ResultView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTotalMarks.setBounds(26, 47, 90, 14);
		contentPane.add(lblTotalMarks);
		
		lblQuestionAttempted.setBounds(26, 98, 122, 14);
		contentPane.add(lblQuestionAttempted);
		
		marksDisplay.setBounds(145, 47, 46, 14);
		contentPane.add(marksDisplay);
		
		noofquestionAttempts.setBounds(168, 98, 46, 14);
		contentPane.add(noofquestionAttempts);
		
		JLabel lblPercentage = new JLabel("Percentage");
		lblPercentage.setBounds(26, 143, 90, 14);
		contentPane.add(lblPercentage);
		
		
		percentagelbl.setBounds(168, 143, 46, 14);
		contentPane.add(percentagelbl);
	}

	JLabel lblTotalMarks = new JLabel("Total Marks");
	JLabel lblQuestionAttempted = new JLabel("Question Attempted");
	public JLabel marksDisplay = new JLabel("");
	public JLabel noofquestionAttempts = new JLabel("");
	public JLabel percentagelbl = new JLabel("");
}
