package quizappCollection.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import quizappCollection.dto.UserDTO;
import quizappCollection.helper.UserOperations;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
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
	public LoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(LoginView.class.getResource("/Images/Staff-Login.png")));
		label.setBounds(166, 11, 213, 89);
		contentPane.add(label);
		
		JLabel lblUserid = new JLabel("UserID");
		lblUserid.setBounds(87, 144, 46, 14);
		contentPane.add(lblUserid);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(87, 200, 46, 14);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(193, 141, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(193, 197, 86, 20);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkUserAuth();
			}
		});
		btnLogin.setBounds(59, 278, 89, 23);
		contentPane.add(btnLogin);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(326, 278, 89, 23);
		contentPane.add(btnClear);
	}

	private void checkUserAuth() {
		String userid = textField.getText();
		String password = passwordField.getText();
		UserDTO userDTO = new UserDTO(userid,password);
		UserOperations userOperations = UserOperations.getInstance();
		try {
			boolean isUserExist = userOperations.isUserExist(userid, password);
			if(isUserExist) {
				JOptionPane.showMessageDialog(this, "Succefull Login");
				this.setVisible(true);
				this.dispose();
				QuestionView questionView = new QuestionView();
				questionView.setVisible(true);
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Can't Login User does not Exist");
			e.printStackTrace();
		}
	}
	
}
