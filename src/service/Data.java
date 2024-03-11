package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONException;

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
}
