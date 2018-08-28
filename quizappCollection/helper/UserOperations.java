package quizappCollection.helper;

import java.util.ArrayList;

import quizappCollection.dto.UserDTO;

public class UserOperations {

	private ArrayList<UserDTO> userList = new ArrayList<>();
	//Getter and setter for the userList
	public ArrayList<UserDTO> getUserList() {
		return userList;
	}


	public void setUserList(ArrayList<UserDTO> userList) {
		this.userList = userList;
	}


	private static UserOperations userOperations;
	//Private Constructor for the Singleton class
	private UserOperations() {
		
	}
	
	//This will the User into the UserList..register part
	public boolean addUser(UserDTO userDTO) {
		this.userList.add(userDTO);
		return true;
	}
	
	//Will print or return the added User
	public ArrayList<UserDTO> getUsers(){
		return userList;
	}
	
	//Will check If the user exist in the userlist...Login part
	public boolean isUserExist(String userid, String password) {
		UserDTO userDTO = new UserDTO();
		userDTO.setUserid(userid);
		userDTO.setPassword(password);
		return userList.contains(userDTO);
	}
	
	
	//getInstance method
	public static UserOperations getInstance() {
		if(userOperations==null) {
			userOperations = new UserOperations();
		}
		return userOperations;
	}
}
