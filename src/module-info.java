module SceneBuilderVoorbeeld {
	exports gui;
	exports main;
	
	requires javafx.base;
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires java.sql;
	requires org.junit.jupiter.api;
	requires org.junit.jupiter.params;
	
	opens gui to javafx.graphics, javafx.fxml;
}
