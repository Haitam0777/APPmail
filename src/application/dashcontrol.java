package application;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import Courier.ConsigneDAO;
import Courier.Courier;
import Courier.CourierDAO;
import User.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class dashcontrol implements Initializable{
	
	@FXML
	private TableView<Courier> mailtable;
	@FXML
	private TableColumn<Courier, String> from;
	@FXML
	private TableColumn<Courier, String> date;
	@FXML
	private TableColumn<Courier, String> object;
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
	
	@FXML
	private ListView<String> conlist;
	
	private User usernow;
	
	private CourierDAO maildao = new CourierDAO();
	private ConsigneDAO condao = new ConsigneDAO();
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	
	public void Ref(ActionEvent e) throws IOException{
		ObservableList<Courier> list = FXCollections.observableArrayList(maildao.mail(usernow.getIdentifiant()));
		from.setCellValueFactory(new PropertyValueFactory<Courier,String>("expedit"));
		date.setCellValueFactory(new PropertyValueFactory<Courier,String>("date_envoi"));
		object.setCellValueFactory(new PropertyValueFactory<Courier,String>("objet"));
		
		mailtable.setItems(list);
		
		conlist.getItems().clear();
	}
	
	
	
	public void send(ActionEvent e) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/newmail.fxml"));	
		root = loader.load();	
		
		newmail dash = loader.getController();
		dash.setUsernow(usernow);
		dash.set(1);
		
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


	

	
	
	public User getUsernow() {
		return usernow;
	}



	public void setUsernow(User usernow) {
		this.usernow = usernow;
	}



	@SuppressWarnings("unlikely-arg-type")
	public void table(String name) throws IOException {
		ObservableList<Courier> list = FXCollections.observableArrayList(maildao.mail(name));
		from.setCellValueFactory(new PropertyValueFactory<Courier,String>("expedit"));
		date.setCellValueFactory(new PropertyValueFactory<Courier,String>("date_envoi"));
		object.setCellValueFactory(new PropertyValueFactory<Courier,String>("objet"));
		
		mailtable.setItems(list);
		
		mailtable.setOnMouseClicked(event -> {
			if (event.getClickCount() == 1) {
				if (conlist.getItems().contains(condao.listcon(mailtable.getSelectionModel().getSelectedItem().getNum()))) {
					return;
				}else {
					conlist.getItems().clear();
					conlist.getItems().addAll(condao.listcon(mailtable.getSelectionModel().getSelectedItem().getNum()));
				}
			}
		});
		
	}
	
	public void click(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/mail.fxml"));	
		root = loader.load();
		mail dash = loader.getController();
		dash.setUsernow(usernow);
		dash.setCouriernow(mailtable.getSelectionModel().getSelectedItem());
			
			
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
}
