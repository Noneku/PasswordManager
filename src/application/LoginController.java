package application;

import org.json.JSONArray;
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
    	
    	try {
    		
    		JSONArray users = Data.getUsers();
    		
    		for (int i = 0; i < users.length(); i++) {
    			
    			//Récupération du mon objet user 
    		    JSONObject userObject = users.getJSONObject(i);

    		    // Accès aux champs spécifiques du JSON
    		    String loginJSON = userObject.getString("login");
    		    String passwordJSON = userObject.getString("password");
    		    
    		    //Vérification de l'identité de l'utilisateur comparer aux utilisateurs dans mon fichier JSON 
    		    if(loginUsername.getText().equals(loginJSON) && loginPassword.getText().equals(passwordJSON)) {
    		    	
    		    	User.setCurrentUser(users.get(i));
    		    	
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
    		  		
    	}catch(JSONException e) {
    		
    	}
    }
}
