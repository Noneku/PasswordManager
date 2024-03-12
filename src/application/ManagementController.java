package application;

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
import service.Data;
import javafx.beans.property.SimpleStringProperty;

public class ManagementController {
	
	// Remplacez Object par votre classe User réelle
    private ObservableList<User> UserObservable = FXCollections.observableArrayList();
	
	@FXML
    private TableView<User> tableView;

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
    void initialize() throws JSONException {
    	
    	UserObservable.add(new User());  // Ajoutez un objet User à titre de test
    	
    	PasswordColumn.setCellValueFactory(cellData -> cellData.getValue().passwordManagementProperty());


        // Configurez la TableView avec la liste observable
        tableView.setItems(UserObservable);

        // Testez si les éléments sont correctement ajoutés à la liste observable


    }
    
    @FXML
    void onClickAddButton(ActionEvent event) throws JSONException {
    	
    	JSONObject currentUserData = User.getCurrentUser().getJSONObject("data");
    	   	
    	//Update My Object User
    	
    	User.setLoginManagement(this.managementUsername.getText());
		User.setUrlManagement(this.managementUrl.getText());
		User.setPasswordManagement(this.managementPassword.getText());
		
		//Update File JSON
		Data.updateUserData("Taleb", User.getLoginManagement(), User.getPasswordManagement(), User.getUrlManagement());
    }
    
}
