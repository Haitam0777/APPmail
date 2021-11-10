package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;

import Courier.Consigne;
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
import javafx.stage.Stage;


public class newmail implements Initializable{
	@FXML
	private TextField sender;
	@FXML
	private TextField to;
	@FXML
	private TextField title;
	@FXML
	private TextArea cont;
	@FXML
	private TextField consigne;
	@FXML
	private Button upload;
	@FXML
	private Label filename;
	
	private User usernow;
	
	private String target;
	
	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public User getUsernow() {
		return usernow;
	}

	public void setUsernow(User usernow) {
		this.usernow = usernow;
	}
	

	String destin;
	String object;
	String body;
	String date;
	List<File> file;
	List<String> consignelist = null;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	
	private CourierDAO maildao = new CourierDAO();
	private ConsigneDAO condao = new ConsigneDAO();
	
	public void Switch(ActionEvent e,String fxml) throws IOException{
		root = FXMLLoader.load(getClass().getResource("/"+fxml));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	public void set(int i) {
		if (i == 1 ) {
			sender.setText(usernow.getIdentifiant());
			sender.setEditable(false);
		}
		else if (i == 2) {
			sender.setText(usernow.getIdentifiant());
			sender.setEditable(false);
			to.setText(target);
			sender.setEditable(false);
		}
	}
	
	public void savemail(ActionEvent e) throws SQLException, IOException {
		destin = to.getText();
		object = title.getText();
		body = cont.getText();
		date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MMM-yy"));
		String con = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MMM-yy")) + " : " +consigne.getText();
		String datelim = null;
		
		Courier mail = new Courier(usernow.getIdentifiant(),destin,date,object,body) ;
		maildao.saveMail(mail);
		Consigne consigne = new Consigne(mail.getNum(),con,date,datelim);
		condao.saveCon(consigne);
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
		sender.setText(usernow.getIdentifiant());
		sender.setEditable(false);
		
	}
}
