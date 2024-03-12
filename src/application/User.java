package application;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {
	
	public static JSONObject currentUser;
	
	public static JSONArray loginManagement;
	
	public static JSONArray urlManagement;
	
	public static JSONArray passwordManagement;
	
	public static JSONObject getCurrentUser() {
		return currentUser;
	}
	
		
	public static void setCurrentUser(Object object) {
		User.currentUser = (JSONObject) object;
	}
	
    public StringProperty loginManagementProperty() {
    	 try {
             JSONArray jsonArray = User.currentUser.getJSONObject("data").getJSONArray("loginManagement");
             StringBuilder result = new StringBuilder();

             for (int i = 0; i < jsonArray.length(); i++) {
                 result.append(jsonArray.getString(i));
                 if (i < jsonArray.length() - 1) {
                     result.append(", "); // Ajoutez le séparateur que vous souhaitez
                 }
             }

             return new SimpleStringProperty(result.toString());
         } catch (JSONException e) {
             e.printStackTrace();
             return new SimpleStringProperty(""); // ou autre gestion d'erreur
         }
    }
	
	public static JSONArray getLoginManagement() throws JSONException {
		return User.currentUser.getJSONObject("data").getJSONArray("loginManagement");
	}

	public static void setLoginManagement(String loginManagement) throws JSONException {
		User.loginManagement = User.getLoginManagement();
		
		User.loginManagement.put(loginManagement);
	}
	
    public StringProperty urlManagementProperty() {
    	 try {
             JSONArray jsonArray = User.currentUser.getJSONObject("data").getJSONArray("urlManagement");
             StringBuilder result = new StringBuilder();

             for (int i = 0; i < jsonArray.length(); i++) {
                 result.append(jsonArray.getString(i));
                 if (i < jsonArray.length() - 1) {
                     result.append(", "); // Ajoutez le séparateur que vous souhaitez
                 }
             }

             return new SimpleStringProperty(result.toString());
         } catch (JSONException e) {
             e.printStackTrace();
             return new SimpleStringProperty(""); // ou autre gestion d'erreur
         }
    }

	public static JSONArray getUrlManagement() throws JSONException {
		return User.currentUser.getJSONObject("data").getJSONArray("urlManagement");
	}

	public static void setUrlManagement(String urlManagement) throws JSONException {
		User.urlManagement = User.getUrlManagement();
		
		User.urlManagement.put(urlManagement);
	}
	
	public StringProperty passwordManagementProperty() {
        try {
            JSONArray jsonArray = User.currentUser.getJSONObject("data").getJSONArray("passwordManagement");
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < jsonArray.length(); i++) {
                result.append(jsonArray.getString(i));
                if (i < jsonArray.length() - 1) {
                    result.append(", "); // Ajoutez le séparateur que vous souhaitez
                }
            }

            return new SimpleStringProperty(result.toString());
        } catch (JSONException e) {
            e.printStackTrace();
            return new SimpleStringProperty(""); // ou autre gestion d'erreur
        }
    }

	public static JSONArray getPasswordManagement() throws JSONException {
		return User.currentUser.getJSONObject("data").getJSONArray("passwordManagement");
	}

	public static void setPasswordManagement(String passwordManagement) throws JSONException {
		User.passwordManagement = User.getPasswordManagement();
		
		User.passwordManagement.put(passwordManagement);
	}


}
