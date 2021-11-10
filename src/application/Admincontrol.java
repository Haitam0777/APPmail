package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Courier.Courier;
import Courier.CourierDAO;
import User.User;
import User.UserDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Admincontrol implements Initializable {
	@FXML
	private TableView<Courier> mailtable;
	@FXML
	private TableColumn<Courier, String> from;
	@FXML
	private TableColumn<Courier, String> date;
	@FXML
	private TableColumn<Courier, String> object;
	
	@FXML
	private TableView<User> usertable;
	@FXML
	private TableColumn<User, String> ident;
	@FXML
	private TableColumn<User, String> nom;
	@FXML
	private TableColumn<User, String> prenom;
	@FXML
	private TableColumn<User, String> tel;
	@FXML
	private TableColumn<User, String> mail;
	
	@FXML
	private Button refresh;
	@FXML
	private MenuItem envoi;
	@FXML
	private Button seeed;
	
	
	@FXML
	private TextField nameinf;
	@FXML
	private TextField prenominf;
	@FXML
	private TextField telinf;
	@FXML
	private TextField mailinf;
	
	private String userid;
	
	private CourierDAO maildao = new CourierDAO();
	private UserDAO userdao = new UserDAO();
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	
	
	public void Ref(ActionEvent e) throws IOException{
		ObservableList<Courier> list = FXCollections.observableArrayList(maildao.mailadmin(getUserid()));
		from.setCellValueFactory(new PropertyValueFactory<Courier,String>("expedit"));
		date.setCellValueFactory(new PropertyValueFactory<Courier,String>("date_envoi"));
		object.setCellValueFactory(new PropertyValueFactory<Courier,String>("objet"));
		
		mailtable.setItems(list);
	}
	
	
	public void send(ActionEvent e) throws IOException{
		root = FXMLLoader.load(getClass().getResource("/newmail.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}

	public void displayUser(User user) {
		nameinf.setText(user.getNom());
		nameinf.setEditable(false);
		prenominf.setText(user.getPrenom());
		prenominf.setEditable(false);
		telinf.setText(user.getTel());
		telinf.setEditable(false);
		mailinf.setText(user.getMail());
		mailinf.setEditable(false);
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<Courier> list = FXCollections.observableArrayList(maildao.mailadmin(userid));
		from.setCellValueFactory(new PropertyValueFactory<Courier,String>("expedit"));
		date.setCellValueFactory(new PropertyValueFactory<Courier,String>("date_envoi"));
		object.setCellValueFactory(new PropertyValueFactory<Courier,String>("objet"));
		
		mailtable.setItems(list);
		
		ObservableList<User> list2 = FXCollections.observableArrayList(userdao.useradmin());
		ident.setCellValueFactory(new PropertyValueFactory<User,String>("identifiant"));
		nom.setCellValueFactory(new PropertyValueFactory<User,String>("nom"));
		prenom.setCellValueFactory(new PropertyValueFactory<User,String>("prenom"));
		tel.setCellValueFactory(new PropertyValueFactory<User,String>("tel"));
		mail.setCellValueFactory(new PropertyValueFactory<User,String>("mail"));
		
		usertable.setItems(list2);
		
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}


	
}
