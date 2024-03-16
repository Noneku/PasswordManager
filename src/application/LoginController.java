package application;

import java.util.ArrayList;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.Data;

public class LoginController implements Data {

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField loginPassword;

    @FXML
    private TextField loginUsername;

    @FXML
    void onClickConnect(ActionEvent event) {
    	
    	//Vérification de l'identité de l'utilisateur
		if(Data.readRecord(loginUsername.getText(), loginPassword.getText())) {
			
			//J'enregistre L'utilisateur
			
			User user = User.getInstance(Data.currentUser(loginUsername.getText(), loginPassword.getText()));

			
		    // Récupération de la référence à la scène depuis l'événement
		    Scene currentScene = ((Button) event.getSource()).getScene();
		    Stage currentStage = (Stage) currentScene.getWindow();
		    
		    System.out.println("Identification Work !");
		    currentStage.close();
		    
		    try {
		        Parent root;
				root = FXMLLoader.load(getClass().getResource("Management.fxml"));
				Scene scene = new Scene(root);
				
				currentStage.setScene(scene);
				currentStage.show();
			
		    }catch(Exception e){
		    	e.printStackTrace();
		    }  		    	
			
		}else {
			System.out.println("Identification Failed !");
		}
    }
}
