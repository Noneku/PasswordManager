package application;

import java.util.ArrayList;
import java.util.Map;

public class User {
    private static User instance = null;

    String id;
    String name;
    static ArrayList<String> identifiant_management = new ArrayList<>();
    static ArrayList<String> password_management = new ArrayList<>();
    static ArrayList<String> url_management = new ArrayList<>();
    
    private User(Map<String, ArrayList<String>> userData) {
        this.id = userData.get("Login").get(0);
        this.name = userData.get("Login").get(1);
        User.identifiant_management = userData.get("Identifiants");
        User.password_management = userData.get("Passwords");
        User.url_management = userData.get("URLs");
    }

    public static User getInstance(Map<String, ArrayList<String>> userData) {
        if (instance == null) {
            instance = new User(userData);
        }
        return instance;
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

    public static ArrayList<String> getIdentifiant_management() {
        return identifiant_management;
    }

    public void setIdentifiant_management(ArrayList<String> identifiant_management) {
        User.identifiant_management = identifiant_management;
    }

    public static ArrayList<String> getPassword_management() {
        return password_management;
    }

    public void setPassword_management(ArrayList<String> password_management) {
        User.password_management = password_management;
    }

    public static ArrayList<String> getUrl_management() {
        return url_management;
    }

    public void setUrl_management(ArrayList<String> url_management) {
        User.url_management = url_management;
    }
}
