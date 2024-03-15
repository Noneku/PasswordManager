package application;

import java.util.ArrayList;
import java.util.Map;

public class User {


	String id;
	String name;
	ArrayList<String> identifiant_management = new ArrayList<>();
	ArrayList<String> password_management = new ArrayList<>();
	ArrayList<String> url_management = new ArrayList<>();
	//, String password_management, String url_management
	
	public User(Map<String, ArrayList<String>> User) {
		super();
		this.id = User.get("Login").get(0);
		this.name = User.get("Login").get(1);
		this.identifiant_management = User.get("Identifiants");
		this.password_management = User.get("Passwords");
		this.url_management = User.get("URLs");
	}
	
	public String getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public ArrayList<String> getIdentifiant_management() {
		return identifiant_management;
	}


	public void setIdentifiant_management(ArrayList<String> identifiant_management) {
		this.identifiant_management = identifiant_management;
	}


	public ArrayList<String> getPassword_management() {
		return password_management;
	}


	public void setPassword_management(ArrayList<String> password_management) {
		this.password_management = password_management;
	}


	public ArrayList<String> getUrl_management() {
		return url_management;
	}


	public void setUrl_management(ArrayList<String> url_management) {
		this.url_management = url_management;
	}
}
