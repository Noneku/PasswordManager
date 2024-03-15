package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import application.User;

public interface Data {

    // Définissez les informations de connexion à la base de données
    String DB_URL = "jdbc:mysql://localhost:3306/PasswordManager";
    String USER = "root";
    String PASSWORD = "1234";

    // Méthode pour obtenir une connexion à la base de données
    static Connection getConnection() {
        try {
        	System.out.println("Connexion réussie.");
            return DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            // Gestion de l'erreur de connexion
            return null;
        }
    }

    // Méthode pour fermer une connexion à la base de données
    static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                // Gestion de l'erreur de fermeture de connexion
            }
        }
    }
    
    // Méthode pour créer un enregistrement dans la base de données
    static void createRecord(String username, String password) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            String query = "INSERT INTO TableName (username, password) VALUES (?, ?)";
            statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.executeUpdate();
            System.out.println("Enregistrement créé avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
            // Gestion de l'erreur de création d'enregistrement
        } finally {
            closeConnection(connection);
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //Méthode pour récupérer les informations de l'ituilisateur identifié
    static Map<String, ArrayList<String>> currentUser(String Name, String Password) {
    	Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        Map<String, ArrayList<String>> DATA_Management = new HashMap<>();
        ArrayList<String> Login_user = new ArrayList<>();
        ArrayList<String> Identifiants_Management = new ArrayList<>();
        ArrayList<String> Password_Management = new ArrayList<>();
        ArrayList<String> URL_Management = new ArrayList<>();
        
        try {
            connection = getConnection();
            String query = "SELECT U.*,L.*  FROM User U "
                          + "JOIN LoginManagement L ON U.id_user = L.id_user "
                          + "WHERE U.name_user = ? AND U.password_user = ?";
                           
            
            statement = connection.prepareStatement(query);
            statement.setString(1, Name);
            statement.setString(2, Password);
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                
                Identifiants_Management.add(resultSet.getString("identifiant_management"));
                Password_Management.add(resultSet.getString("password_management"));
                URL_Management.add(resultSet.getString("url_management"));
                Login_user.add(resultSet.getString("id_user"));
                Login_user.add(resultSet.getString("name_user"));
                

                DATA_Management.put("Login", Login_user);
                DATA_Management.put("Identifiants", Identifiants_Management);
                DATA_Management.put("Passwords", Password_Management);
                DATA_Management.put("URLs", URL_Management);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    	return DATA_Management;
    }
    // Méthode pour lire un enregistrement de la base de données
	static boolean readRecord(String Name, String Password) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        boolean found = false;
        try {
            connection = getConnection();
            String query = "SELECT * FROM User WHERE name_user = ? AND password_user = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, Name);
            statement.setString(2, Password);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
            	found = true;
            	
                String username = resultSet.getString("name_user");
                String password = resultSet.getString("password_user");
                int id = resultSet.getInt("id_user");
                
                
                System.out.println("Username: " + username + ", Password: " + password + ", ID : " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
            try {
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return found;
    }

    // Méthode pour mettre à jour un enregistrement dans la base de données
    static void updateRecord(int id, String newPassword) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            String query = "UPDATE TableName SET password=? WHERE id=?";
            statement = connection.prepareStatement(query);
            statement.setString(1, newPassword);
            statement.setInt(2, id);
            statement.executeUpdate();
            System.out.println("Enregistrement mis à jour avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
            // Gestion de l'erreur de mise à jour d'enregistrement
        } finally {
            closeConnection(connection);
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Méthode pour supprimer un enregistrement de la base de données
    static void deleteRecord(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            String query = "DELETE FROM TableName WHERE id=?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Enregistrement supprimé avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
            // Gestion de l'erreur de suppression d'enregistrement
        } finally {
            closeConnection(connection);
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
