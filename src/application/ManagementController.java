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
import service.Data;

public class ManagementController {
		
	public Object userConnected = User.getCurrentUser();
	
	// Remplacez Object par votre classe User réelle
    private ObservableList<User> UserObservable = FXCollections.observableArrayList();
	
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
    void initialize() throws JSONException{
    	
    	// Liez les colonnes aux propriétés de la classe User
    	JSONArray PasswordManager = User.getPasswordManagement();
    	
    	for(int i = 0; i < PasswordManager.length(); i++) {
    		System.out.println("poliaze");
    	}
    
    	
    	// Configurez les colonnes pour éditer le contenu des cellules
        PasswordColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        URLColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        UserNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
        
       // PasswordColumn.setCellValueFactory(cellData -> cellData.getValue());
        //URLColumn.setCellValueFactory(cellData -> cellData.getValue().getUrlManagement());
        //UserNameColumn.setCellValueFactory(cellData -> cellData.getValue().getLoginManagement());
    	
     // Définissez les données pour le TableView
        //tableView.setItems(UserObservable);
    	
    }
    
    @FXML
    void onClickAddButton(ActionEvent event) throws JSONException {
    	
    	JSONObject currentUserData = User.getCurrentUser().getJSONObject("data");
    	
    	//Get propertys of User
    	
    	
    	//Update My Object User
    	
    	User.setLoginManagement(this.managementUsername.getText());
		User.setUrlManagement(this.managementUrl.getText());
		User.setPasswordManagement(this.managementPassword.getText());
		
		Data.updateUserData("Taleb", User.getLoginManagement(), User.getPasswordManagement(), User.getUrlManagement());
    }
    
}
