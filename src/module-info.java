module SceneBuilderVoorbeeld {
	exports gui;
	exports main;


	requires java.sql;
	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires transitive javafx.graphics;
	requires org.junit.jupiter.api;
	requires org.junit.jupiter.params;
	requires javafx.media;
	
	opens gui to javafx.graphics, javafx.fxml;
	//opens main to javafx.graphics, javafx.fxml;
}