module PasswordManager {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires java.json;
	requires javafx.base;
	
	opens application to javafx.graphics, javafx.fxml;
	opens service to java.json;
}
