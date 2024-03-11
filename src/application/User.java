package application;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
	
	public static JSONArray getLoginManagement() throws JSONException {
		return User.currentUser.getJSONObject("data").getJSONArray("loginManagement");
	}

	public static void setLoginManagement(String loginManagement) throws JSONException {
		User.loginManagement = User.getLoginManagement();
		
		User.loginManagement.put(loginManagement);
	}

	public static JSONArray getUrlManagement() throws JSONException {
		return User.currentUser.getJSONObject("data").getJSONArray("urlManagement");
	}

	public static void setUrlManagement(String urlManagement) throws JSONException {
		User.urlManagement = User.getUrlManagement();
		
		User.urlManagement.put(urlManagement);
	}

	public static JSONArray getPasswordManagement() throws JSONException {
		return User.currentUser.getJSONObject("data").getJSONArray("passwordManagement");
	}

	public static void setPasswordManagement(String passwordManagement) throws JSONException {
		User.passwordManagement = User.getPasswordManagement();
		
		User.passwordManagement.put(passwordManagement);
	}


}
