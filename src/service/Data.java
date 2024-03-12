package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public interface Data {
	
	public static String FILE_PATH = "src/service/dataRegister.json";
	
	public static JSONArray getUsers() throws JSONException {
		
		JSONArray usersList = null;
				
		try {
			
			// Lire le contenu du fichier en tant que chaîne
			String jsonContent = new String(Files.readAllBytes(Paths.get(FILE_PATH)));
			
			// Convertir la chaîne JSON en un objet JSONArray
			usersList = new JSONArray(jsonContent);
			
		} catch (IOException | JSONException e) {
			e.printStackTrace();
		}
		
		return usersList;
	}
	
	public static void updateAndSaveUsers(JSONArray updatedUsers) {
		try {
			// Convertir le JSONArray mis à jour en chaîne JSON
			String updatedJsonContent = updatedUsers.toString();
			
			// Écrire la chaîne JSON mise à jour dans le fichier
			Files.write(Paths.get(FILE_PATH), updatedJsonContent.getBytes());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateUserData(String login, JSONArray loginManagement, JSONArray passwordManagement, JSONArray urlManagement) {
		try {
			// Obtenez la liste d'utilisateurs actuelle
			JSONArray users = getUsers();
			
			// Parcourez les utilisateurs pour trouver celui avec le login spécifié
			for (int i = 0; i < users.length(); i++) {
				JSONObject user = users.getJSONObject(i);
				if (user.getString("login").equals(login)) {
					// Mettez à jour les données spécifiques pour cet utilisateur
					user.getJSONObject("data").put("loginManagement", loginManagement);
					user.getJSONObject("data").put("passwordManagement", passwordManagement);
					user.getJSONObject("data").put("urlManagement", urlManagement);
					break; // Sortez de la boucle une fois que l'utilisateur est trouvé
				}
			}
			
			// Mettez à jour et enregistrez le fichier
			updateAndSaveUsers(users);
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
}
