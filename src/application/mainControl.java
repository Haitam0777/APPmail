package application;

import java.io.IOException;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import User.User;
import User.UserDAO;


public class mainControl {
	
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML
	private Hyperlink reg;
	@FXML
	private Button login;
	@FXML
	private Label error;

	
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	String name;
	String passwd;
	
	private UserDAO userdao = new UserDAO();
	
	
	public void Switch(ActionEvent e,String fxml) throws IOException{
		root = FXMLLoader.load(getClass().getResource("/"+fxml));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	
	
	public void register(ActionEvent e) throws IOException{
		Switch(e,"form.fxml");
		
	}
	
	public void search(ActionEvent e) throws IOException{
		name=username.getText();
		passwd = password.getText();
		
		List<User> user = userdao.search(name, passwd);
		if (user.size() == 0) {
			error.setText("User not found ! Try again.");
		}else {
			if(user.get(0).getFtoken() == false ) {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/formPass.fxml"));	
				root = loader.load();	
				
				Passcontrol dash = loader.getController();
				dash.getuser(user.get(0));
				
				stage = (Stage)((Node)e.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			}else {
				if (user.get(0).getVal()== true) {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/dashAdmin.fxml"));	
					root = loader.load();	
					
					Admincontrol dash = loader.getController();
					dash.displayUser(user.get(0));
					dash.setUserid(user.get(0).getIdentifiant());
					
					stage = (Stage)((Node)e.getSource()).getScene().getWindow();
					scene = new Scene(root);
					stage.setScene(scene);
					stage.show();
				}else {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/dash.fxml"));	
					root = loader.load();	
					
					dashcontrol dash = loader.getController();
					dash.displayUser(user.get(0));
					dash.table(user.get(0).getIdentifiant());
					dash.setUsernow(user.get(0));
					
					stage = (Stage)((Node)e.getSource()).getScene().getWindow();
					scene = new Scene(root);
					stage.setScene(scene);
					stage.show();
				}
			}
		}
		
	}
}
