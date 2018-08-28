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

public class RegisterView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterView frame = new RegisterView();
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
	public RegisterView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(RegisterView.class.getResource("/Images/Register-Button-PNG-Photos.png")));
		label.setBounds(142, 11, 291, 83);
		contentPane.add(label);
		
		JLabel lblLogin = new JLabel("UserID");
		lblLogin.setBounds(83, 158, 46, 17);
		contentPane.add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(83, 209, 46, 14);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(228, 156, 135, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(228, 206, 135, 20);
		contentPane.add(passwordField);
		
		JButton btnRegistyer = new JButton("Register");
		btnRegistyer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doRegister();
			}
		});
		btnRegistyer.setBounds(56, 315, 89, 23);
		contentPane.add(btnRegistyer);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnClear.setBounds(246, 315, 89, 23);
		contentPane.add(btnClear);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				print();
			}
		});
		btnPrint.setBounds(453, 315, 89, 23);
		contentPane.add(btnPrint);
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setBounds(83, 262, 68, 14);
		contentPane.add(lblUsername);
		
		textField_1 = new JTextField();
		textField_1.setBounds(231, 259, 132, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
	
	private void doRegister() {
		String userid = textField.getText();
		String password = passwordField.getText();
		UserDTO userDTO = new UserDTO(userid,password);
		UserOperations userOperations = UserOperations.getInstance();
		try {
			boolean isRegister = userOperations.addUser(userDTO);;
			if(isRegister) {
				JOptionPane.showMessageDialog(this, "U Registered Succesfully");
				this.setVisible(true);
				this.dispose();
				LoginView loginView = new LoginView();
				loginView.setVisible(true);
			}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(this, "Can't Register User Already Exist");
			e.printStackTrace();
		}
	}
	
	private void print() {
		System.out.println(UserOperations.getInstance().getUsers().toString());
	}
}
