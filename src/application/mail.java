package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Courier.ConsigneDAO;
import Courier.Courier;
import Courier.CourierDAO;
import User.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class mail implements Initializable{
	@FXML
	private TextField from;
	@FXML
	private TextField ob;
	@FXML
	private TextField body;
	@FXML
	private Button ret;
	@FXML
	private Button trans;
	@FXML
	private Button add;
	@FXML
	private Button res;
	@FXML
	private ListView<String> con;
	
	private User usernow;
	private Courier couriernow;
	
	private CourierDAO maildao = new CourierDAO();
	private ConsigneDAO condao = new ConsigneDAO();
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public User getUsernow() {
		return usernow;
	}

	public void setUsernow(User usernow) {
		this.usernow = usernow;
	}

	public Courier getCouriernow() {
		return couriernow;
	}

	public void setCouriernow(Courier couriernow) {
		this.couriernow = couriernow;
	}
	
	public void respond1(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/newmail.fxml"));	
		root = loader.load();	
		
		newmail dash = loader.getController();
		dash.setUsernow(usernow);
		dash.set(2);
		
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void returndash(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/dash.fxml"));	
		root = loader.load();	
		
		dashcontrol dash = loader.getController();
		dash.displayUser(usernow);
		dash.table(usernow.getIdentifiant());
		dash.setUsernow(usernow);
		
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		from.setText(couriernow.getExpedit());
		ob.setText(couriernow.getObjet());
		body.setText(couriernow.getContenu());
		
		con.getItems().addAll(condao.listcon(couriernow.getNum()));
	}
	
}
