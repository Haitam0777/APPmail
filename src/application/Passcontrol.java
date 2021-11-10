package application;

import java.io.IOException;
import java.util.List;

import User.User;
import User.UserDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class Passcontrol {
	@FXML
	private PasswordField pass1;
	@FXML
	private PasswordField pass2;
	
	@FXML
	private Button modifPass;
	@FXML
	private Label error;
	
	User  user1;
	private UserDAO userdao = new UserDAO();
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void Switch(ActionEvent e,String fxml) throws IOException{
		root = FXMLLoader.load(getClass().getResource("/"+fxml));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	

	public void getuser(User user) {
	   user1 = user;
	}
	
	public void updatepass(ActionEvent e) throws IOException {
		String password1 = pass1.getText();
		String password2 = pass2.getText();
		
		if (password1.equals(password2) ) {
			User user = userdao.search(user1.getIdentifiant(),user1.getPassword()).get(0);
			user.setPassword(password1);
			user.setFtoken(true);
			userdao.updateUser(user);
			Switch(e,"main.fxml");
			
		}else {
			error.setText("Password unmatch ");
		}
	}
}
