package application;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;

public class ManagementController {
	
	public Object userConnected = User.getCurrentUser();
	
	@FXML
    private TableView<?> tableView;

    @FXML
    private TableColumn<User, String> PasswordColumn;

    @FXML
    private TableColumn<User, String> URLColumn;

    @FXML
    private TableColumn<User, String> UserNameColumn;

    @FXML
    private Button managementAddButton;

    @FXML
    private PasswordField managementPassword;

    @FXML
    private TextField managementUrl;

    @FXML
    private TextField managementUsername;

    @FXML
    void initialize(){
    	
    	
    	
    }
    
    @FXML
    void onClickAddButton(ActionEvent event) throws JSONException {
    	
    	JSONObject currentUserData = User.getCurrentUser().getJSONObject("data");
    	
    	//Get propertys of User
    	
    	
    	//Update My Object User
    	
    	User.setLoginManagement(this.managementUsername.getText());
		User.setUrlManagement(this.managementUrl.getText());
		User.setPasswordManagement(this.managementPassword.getText());
		 
    	
    	
    	System.out.println(User.getCurrentUser());
    }
    
}
