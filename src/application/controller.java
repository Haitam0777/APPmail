package application;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import User.UserDAO;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import User.User;

public class controller implements Initializable {
	@FXML
	private TextField iden;
	@FXML
	private PasswordField mdp;
	@FXML
	private TextField mail;
	@FXML
	private TextField tel;
	@FXML
	private TextField nom;
	@FXML
	private TextField prenom;
	@FXML
	private ChoiceBox<String> appart;
	@FXML
	private Button register;
	@FXML
	private Button main;
	@FXML
	private CheckBox admin;

	
	
	
	private UserDAO userdao = new UserDAO();
	
	String identifiant;
	String nom1;
	String prenom1;
	String email;
	String tel1;
	String appart1;
	String passwd;
	Boolean val;
	
	String[] section = {"grp1","grp2","grp3"};
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	
	public void submit(ActionEvent e) throws SQLException, IOException{
		identifiant = iden.getText();
		passwd = mdp.getText();
		email = mail.getText();
		tel1 = tel.getText();
		nom1 = nom.getText();
		prenom1 = prenom.getText();
		appart1 = appart.getValue();
		val = admin.isSelected();
		
		User user1 = new User(identifiant,passwd,nom1,prenom1,email,tel1,appart1,val);
		userdao.saveUser(user1);
	
	
	}
	public void log(ActionEvent e) throws IOException{
		root = FXMLLoader.load(getClass().getResource("/main.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		appart.getItems().addAll(section);
	}
}
