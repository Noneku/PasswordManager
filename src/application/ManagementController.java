package application;

import org.json.JSONException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.beans.property.SimpleStringProperty;

public class ManagementController {
	
	// Remplacez Object par votre classe User réelle
    private ObservableList<String> PasswordManagementObservable = FXCollections.observableArrayList();
    private ObservableList<String> IdentifiantManagementObservable = FXCollections.observableArrayList();
    private ObservableList<String> URLManagementObservable = FXCollections.observableArrayList();
	
	@FXML
    private TableView<String> tableView;

    @FXML
    private TableColumn<String, String> PasswordColumn;

    @FXML
    private TableColumn<String, String> URLColumn;

    @FXML
    private TableColumn<String, String> UserNameColumn;

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
    	
    	//UserManagementObservable.add(User.getPasswordManagement());
    	//UserManagementObservable.add(User.getUrlManagement());
//       	for (String element : User.getPassword_management()) {    		
//    		
//    		PasswordManagementObservable.addAll(element);
//    		
//    		PasswordColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()));
//    		
//    		}
//       	
//       	for (String element : User.getIdentifiant_management()) {    		
//    		
//    		IdentifiantManagementObservable.addAll(element);
//    		
//    		UserNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()));
//    		
//    		}
//       	
//       	for (String element : User.getUrl_management()) {    		
//    		
//    		URLManagementObservable.addAll(element);
//    		
//    		URLColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()));
//    		
//    		}
    	PasswordManagementObservable.addAll(User.getPassword_management());
        IdentifiantManagementObservable.addAll(User.getIdentifiant_management());
        URLManagementObservable.addAll(User.getUrl_management());
        
        // Configurez chaque colonne de la TableView pour afficher les données correspondantes
     // Pour la colonne des mots de passe
        PasswordColumn.setCellValueFactory(cellData -> {
            int index = cellData.getTableView().getItems().indexOf(cellData.getValue());
            return new SimpleStringProperty(User.getPassword_management().get(index));
        });
        
     // Pour la colonne des identifiants
        UserNameColumn.setCellValueFactory(cellData -> {
            int index = cellData.getTableView().getItems().indexOf(cellData.getValue());
            return new SimpleStringProperty(User.getIdentifiant_management().get(index));
        });

        // Pour la colonne des URLs
        URLColumn.setCellValueFactory(cellData -> {
            int index = cellData.getTableView().getItems().indexOf(cellData.getValue());
            return new SimpleStringProperty(User.getUrl_management().get(index));
        });
        UserNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()));
        //URLColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()));
        
        // Définissez les éléments de votre TableView avec les listes observables correspondantes
        tableView.setItems(PasswordManagementObservable);
        tableView.setItems(IdentifiantManagementObservable);
        tableView.setItems(URLManagementObservable);
    		
    	}
    	

    //}
    
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
