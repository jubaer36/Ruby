package org.example.rubyfinal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class Tutorial {

    private int currentStep;
    @FXML
    private Button step1Button , step2Button , step3Button, step4Button , step5Button , step6Button ,step7Button , intStateButton1,intStateButton2,intStateButton5,intStateButton3,intStateButton4,intStateButton6 , tryButton;
    @FXML
    private Label stepNameLabel;


    public static int[][][] tutorialCubeState = new int[6][3][3];
    @FXML
    void initialize(){
        intStateButton1.setVisible(false);
        intStateButton2.setVisible(false);
        intStateButton3.setVisible(false);
        intStateButton4.setVisible(false);
        intStateButton5.setVisible(false);
        intStateButton6.setVisible(false);
        tryButton.setVisible(false);
        stepNameLabel.setText("");
        resetCubeState();



    }

    public void resetCubeState(){
        for (int i = 0 ; i < 6; i++){
            for (int j = 0 ; j < 3; j++){
                for (int k = 0 ; k < 3; k++){
                    tutorialCubeState[i][j][k] = 7;

                }

            }
        }
    }


    public void onStep1ButtonClicked(ActionEvent event) {
        currentStep = 1;
        stepNameLabel.setText("Step: White Cross");


        intStateButton1.setText("Flip an Edge");
        intStateButton1.setVisible(true);

        intStateButton2.setText("From the Bottom");
        intStateButton2.setVisible(true);

        intStateButton3.setText("From the Middle - 1");
        intStateButton3.setVisible(true);

        intStateButton4.setText("From the Middle - 2");
        intStateButton4.setVisible(true);

        intStateButton5.setText("From the Middle - 3");
        intStateButton5.setVisible(true);

    }

    public void onStep2ButtonClicked(ActionEvent event) {
        stepNameLabel.setText("White Corner");
    }

    public void onStep3ButtonClicked(ActionEvent event) {
        stepNameLabel.setText("");

    }

    public void onStep4ButtonClicked(ActionEvent event) {
        stepNameLabel.setText("White Edge");
    }

    public void onStep5ButtonClicked(ActionEvent event) {
        stepNameLabel.setText("White Edge");
    }

    public void onStep6ButtonClicked(ActionEvent event) {
    }

    public void onStep7ButtonClicked(ActionEvent event) {
    }


    public void onIntStateButton1Clicked(ActionEvent event) throws IOException {
        resetCubeState();
        tryButton.setVisible(true);
        if(currentStep == 1){
            tutorialCubeState[0][0][1]=4;
            tutorialCubeState[0][1][1]= 0;

            tutorialCubeState[1][1][1]= 1;
            tutorialCubeState[1][0][1]= 1;

            tutorialCubeState[4][2][1]=0;
            tutorialCubeState[4][1][1]=4;
            tutorialCubeState[4][0][1]=4;
            tutorialCubeState[4][1][0]=4;
            tutorialCubeState[4][1][2]=4;

        }




    }
    public void onIntStateButton2Clicked(ActionEvent event) {
        resetCubeState();
        tryButton.setVisible(true);
        if(currentStep ==1){
            tutorialCubeState[0][2][1]= 4;
            tutorialCubeState[0][1][1]= 0;

            tutorialCubeState[1][1][1]= 1;
            tutorialCubeState[1][0][1]= 1;

            tutorialCubeState[2][0][1]= 2;
            tutorialCubeState[2][1][1]= 2;

            tutorialCubeState[3][0][1]= 3;
            tutorialCubeState[3][1][1]= 3;

            tutorialCubeState[4][1][0]= 4;
            tutorialCubeState[4][0][1]= 4;
            tutorialCubeState[4][1][1]= 4;
            tutorialCubeState[4][1][2]= 4;

            tutorialCubeState[5][1][1]= 5;
            tutorialCubeState[5][0][1]= 0;


        }

    }

    public void onIntStateButton3Clicked(ActionEvent event) {
        resetCubeState();
        tryButton.setVisible(true);
        if(currentStep==1){
            tutorialCubeState[0][1][1]= 0;
            tutorialCubeState[0][1][2]= 4;

            tutorialCubeState[1][1][1]= 1;
            tutorialCubeState[1][0][1]= 1;
            tutorialCubeState[1][1][0]= 0;

            tutorialCubeState[2][0][1]= 2;
            tutorialCubeState[2][1][1]= 2;

            tutorialCubeState[3][0][1]= 3;
            tutorialCubeState[3][1][1]= 3;

            tutorialCubeState[4][1][0]= 4;
            tutorialCubeState[4][0][1]= 4;
            tutorialCubeState[4][1][1]= 4;
            tutorialCubeState[4][1][2]= 4;
            tutorialCubeState[5][1][1]= 5;


        }
    }
    public void onIntStateButton4Clicked(ActionEvent event) {
        resetCubeState();
        tryButton.setVisible(true);
        if(currentStep==1){
            tutorialCubeState[0][1][0]= 4;
            tutorialCubeState[0][1][1]= 0;

            tutorialCubeState[1][1][1]= 1;
            tutorialCubeState[1][0][1]= 1;


            tutorialCubeState[2][0][1]= 2;
            tutorialCubeState[2][1][1]= 2;

            tutorialCubeState[3][0][1]= 3;
            tutorialCubeState[3][1][1]= 3;
            tutorialCubeState[3][1][2]= 0;

            tutorialCubeState[4][1][0]= 4;
            tutorialCubeState[4][0][1]= 4;
            tutorialCubeState[4][1][1]= 4;
            tutorialCubeState[4][1][2]= 4;

            tutorialCubeState[5][1][1]= 5;
        }

    }
    public void onIntStateButton5Clicked(ActionEvent event) {
    }

    public void onIntStateButton6Clicked(ActionEvent event) {
    }


    public void onTryButtonClicked(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tutorialMakeCube.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Project-Ruby");
        stage.setScene(scene);
        stage.show();

    }
}
