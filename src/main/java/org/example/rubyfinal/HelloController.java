package org.example.rubyfinal;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Button solverButton;
    @FXML
    private Button manualButton;
    @FXML
    private Button tutorialButton;

    @FXML
    protected void onSolverButtonClicked() {
        CubeDisplayer cubeDisplayer = new CubeDisplayer();
    }
    @FXML
    protected void onManualButtonClicked() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("makeCube.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Project-Ruby");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void onTutorialButtonClicked() throws IOException {
        FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource("tutorial.fxml"));
        Scene scene2 = new Scene(fxmlLoader2.load());
        Stage stage2 = new Stage();
        stage2.setTitle("Project-Ruby");
        stage2.setScene(scene2);
        stage2.show();

    }
}