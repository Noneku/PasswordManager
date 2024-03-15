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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import service.Data;
import javafx.beans.property.SimpleStringProperty;

public class ManagementController {
	
	// Remplacez Object par votre classe User réelle
    private ObservableList<JSONArray> UserManagementObservable = FXCollections.observableArrayList();
	
	@FXML
    private TableView<JSONArray> tableView;

    @FXML
    private TableColumn<JSONArray, String> PasswordColumn;

    @FXML
    private TableColumn<JSONArray, String> URLColumn;

    @FXML
    private TableColumn<JSONArray, String> UserNameColumn;

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
    	
    	//UserManagementObservable.add(User.getLoginManagement());
    	//UserManagementObservable.add(User.getPasswordManagement());
    	//UserManagementObservable.add(User.getUrlManagement());
    	
    	
    	//for (JSONArray element : UserManagementObservable) {
    		
    		//System.out.println(element.getInt(0));
    		//System.out.println(element.getString(2));
    		
    	     //PasswordColumn.setCellValueFactory(cellData -> cellData.getValue().getString(0));
    	//}
    	

    }
    
    @FXML
    void onClickAddButton(ActionEvent event) throws JSONException {
    	
		/*
		 * JSONObject currentUserData = User.getCurrentUser().getJSONObject("data");
		 * 
		 * //Update My Object User
		 * 
		 * User.setLoginManagement(this.managementUsername.getText());
		 * User.setUrlManagement(this.managementUrl.getText());
		 * User.setPasswordManagement(this.managementPassword.getText());
		 * 
		 * //Update File JSON Data.updateUserData("Taleb", User.getLoginManagement(),
		 * User.getPasswordManagement(), User.getUrlManagement());
		 */
    }
    
}
