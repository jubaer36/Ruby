package org.example.rubyfinal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Tutorial {

    private int currentStep , currentIntermediateStep = 0;
    @FXML
    private Button step1Button , step2Button , step3Button, step4Button , step5Button , step6Button ,step7Button , intStateButton1,intStateButton2,intStateButton5,intStateButton3,intStateButton4,intStateButton6 , tryButton;
    @FXML
    private Label stepNameLabel , intermediateTextLabel;
    @FXML
    private Label descTutorialTextLabel;
    @FXML
    private ImageView tutorialImageView1;

    @FXML
    private ImageView tutorialImageView2;

    @FXML
    private AnchorPane holderAnchorPane;

    private String descTutorial , imageFilePath;
    public static int[][][] tutorialCubeState = new int[6][3][3];
    @FXML
    void initialize(){
        setAllIntStepsButtonInvisible();
        stepNameLabel.setText("");
        resetCubeState();
        imageFilePath = "/images/Step1Int1.png";



    }
    public void setAllIntStepsButtonInvisible(){
        currentIntermediateStep = 0;
        intStateButton1.setVisible(false);
        intStateButton2.setVisible(false);
        intStateButton3.setVisible(false);
        intStateButton4.setVisible(false);
        intStateButton5.setVisible(false);
        intStateButton6.setVisible(false);
        descTutorialTextLabel.setVisible(false);
        intermediateTextLabel.setVisible(false);
        tutorialImageView1.setVisible(false);
        tutorialImageView2.setVisible(false);

        tryButton.setVisible(false);

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
        setAllIntStepsButtonInvisible();
        stepNameLabel.setText("Step: White Cross");
        currentStep = 1;
        readFile();
        descTutorialTextLabel.setText(descTutorial);
        descTutorialTextLabel.setVisible(true);


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
        setAllIntStepsButtonInvisible();
        currentStep = 2;
        readFile();
        descTutorialTextLabel.setText(descTutorial);
        descTutorialTextLabel.setVisible(true);
        stepNameLabel.setText("White Corner");
        intStateButton1.setText("White sticker to the right");
        intStateButton1.setVisible(true);

        intStateButton2.setText("White facing you");
        intStateButton2.setVisible(true);

        intStateButton3.setText("White pointing down");
        intStateButton3.setVisible(true);

        intStateButton4.setText("Good layer, wrong position");
        intStateButton4.setVisible(true);


    }

    public void onStep3ButtonClicked(ActionEvent event) {
        setAllIntStepsButtonInvisible();
        currentStep = 3;
        readFile();
        descTutorialTextLabel.setText(descTutorial);
        descTutorialTextLabel.setVisible(true);
        stepNameLabel.setText("Second Layer (F2L)");
        intStateButton1.setText("Right Algorithm");
        intStateButton1.setVisible(true);

        intStateButton2.setText("Left Algorithm");
        intStateButton2.setVisible(true);

        intStateButton3.setText("Wrong Orientation");
        intStateButton3.setVisible(true);




    }

    public void onStep4ButtonClicked(ActionEvent event) {
        setAllIntStepsButtonInvisible();
        currentStep = 4;
        readFile();
        descTutorialTextLabel.setText(descTutorial);
        descTutorialTextLabel.setVisible(true);
        stepNameLabel.setText("Yellow Cross");
        intStateButton1.setText("One Dot");
        intStateButton1.setVisible(true);
        intStateButton2.setText("L Shape");
        intStateButton2.setVisible(true);;

    }

    public void onStep5ButtonClicked(ActionEvent event) {
        setAllIntStepsButtonInvisible();
        currentStep = 5;
        readFile();
        descTutorialTextLabel.setText(descTutorial);
        descTutorialTextLabel.setVisible(true);
        stepNameLabel.setText("Yellow Edge");
        intStateButton1.setText("Switch Edges");
        intStateButton1.setVisible(true);

    }

    public void onStep6ButtonClicked(ActionEvent event) {
        setAllIntStepsButtonInvisible();
        currentStep = 6;
        readFile();
        descTutorialTextLabel.setText(descTutorial);
        descTutorialTextLabel.setVisible(true);
        stepNameLabel.setText("Yellow Corner");
        intStateButton1.setText("Position Corners");
        intStateButton1.setVisible(true);
    }

    public void onStep7ButtonClicked(ActionEvent event) {
        setAllIntStepsButtonInvisible();
        currentStep = 7;
        readFile();
        descTutorialTextLabel.setText(descTutorial);
        descTutorialTextLabel.setVisible(true);
        stepNameLabel.setText("Last Layer");
        intStateButton1.setText("Next To Each Other");
        intStateButton1.setVisible(true);
        intStateButton2.setText("Three Corners");
        intStateButton2.setVisible(true);
        intStateButton3.setText("Opposite Two Corners");
        intStateButton3.setVisible(true);
        intStateButton4.setText("All Twisted Corners");
        intStateButton4.setVisible(true);
    }


    public void onIntStateButton1Clicked(ActionEvent event) throws IOException {
        currentIntermediateStep = 1;
        readFile();
        descTutorialTextLabel.setText(descTutorial);
        descTutorialTextLabel.setVisible(true);
        resetCubeState();
        tryButton.setVisible(true);
        if(currentStep == 1){
            descTutorial = "The most complicated case is when three edges are done and the last one is oriented wrong. This is the fastest way to flip an edge: F takes the edge to the equator, U' moves the empty spot in place, R moves the edge up in the top again, now well-oriented, U restores the position.";

            tutorialCubeState[0][0][1]=4;
            tutorialCubeState[0][1][1]= 0;

            tutorialCubeState[1][1][1]= 1;
            tutorialCubeState[1][0][1]= 1;

            tutorialCubeState[2][0][1]= 2;
            tutorialCubeState[2][1][1]= 2;

            tutorialCubeState[3][0][1]= 3;
            tutorialCubeState[3][1][1]= 3;

            tutorialCubeState[4][2][1]=0;
            tutorialCubeState[4][1][1]=4;
            tutorialCubeState[4][0][1]=4;
            tutorialCubeState[4][1][0]=4;
            tutorialCubeState[4][1][2]=4;


        }
        else if(currentStep == 2){
            tutorialCubeState[0][0][1]= 0;
            tutorialCubeState[0][1][1]= 0;
            tutorialCubeState[0][0][0]= 0;
            tutorialCubeState[0][2][2]= 0;

            tutorialCubeState[1][1][1]= 1;
            tutorialCubeState[1][0][1]= 1;
            tutorialCubeState[1][0][2]= 1;
            tutorialCubeState[1][2][0]= 4;

            tutorialCubeState[2][0][1]= 2;
            tutorialCubeState[2][0][0]= 2;
            tutorialCubeState[2][0][2]= 2;
            tutorialCubeState[2][1][1]= 2;

            tutorialCubeState[3][0][1]= 3;
            tutorialCubeState[3][0][0]= 3;
            tutorialCubeState[3][0][2]= 3;
            tutorialCubeState[3][1][1]= 3;

            tutorialCubeState[4][0][0]=4;
            tutorialCubeState[4][0][1]=4;
            tutorialCubeState[4][0][2]=4;
            tutorialCubeState[4][1][0]=4;
            tutorialCubeState[4][1][1]=4;
            tutorialCubeState[4][1][2]=4;
            tutorialCubeState[4][2][0]=4;
            tutorialCubeState[4][2][1]=4;

            tutorialCubeState[5][0][2]=1;
            tutorialCubeState[5][1][1]=1;

        }
        else if(currentStep ==3){

            tutorialCubeState[1][2][0] = 2;
            tutorialCubeState[1][2][1] = 2;
            tutorialCubeState[1][2][2] = 2;
            tutorialCubeState[1][1][1] = 2;

            tutorialCubeState[0][2][0] = 3;
            tutorialCubeState[0][2][1] = 3;
            tutorialCubeState[0][2][2] = 3;
            tutorialCubeState[0][0][1] = 3;
            tutorialCubeState[0][1][1] = 3;

            tutorialCubeState[5][0][0]=4;
            tutorialCubeState[5][0][1]=4;
            tutorialCubeState[5][0][2]=4;
            tutorialCubeState[5][1][0]=4;
            tutorialCubeState[5][1][1]=4;
            tutorialCubeState[5][1][2]=4;
            tutorialCubeState[5][2][0]=4;
            tutorialCubeState[5][2][1]=4;
            tutorialCubeState[5][2][2]=4;

            tutorialCubeState[4][1][1] = 5;
            tutorialCubeState[4][2][1] = 2;



        }
        else if(currentStep ==4){
            tutorialCubeState[4][1][1] = 5;
            tutorialCubeState[0][0][1] = 5;
            tutorialCubeState[1][0][1] = 5;
            tutorialCubeState[2][0][1] = 5;
            tutorialCubeState[3][0][1] = 5;


        }
        else if(currentStep ==5){
            tutorialCubeState[1][2][0] = 2;
            tutorialCubeState[1][2][1] = 2;
            tutorialCubeState[1][2][2] = 2;
            tutorialCubeState[1][1][0] = 2;
            tutorialCubeState[1][1][1] = 2;
            tutorialCubeState[1][1][2] = 2;
            tutorialCubeState[1][0][1] = 2;

            tutorialCubeState[0][2][0] = 3;
            tutorialCubeState[0][2][1] = 3;
            tutorialCubeState[0][2][2] = 3;
            tutorialCubeState[0][1][0] = 3;
            tutorialCubeState[0][1][1] = 3;
            tutorialCubeState[0][1][2] = 3;
            tutorialCubeState[0][0][1] = 0;

            tutorialCubeState[2][2][0] = 1;
            tutorialCubeState[2][2][1] = 1;
            tutorialCubeState[2][2][2] = 1;
            tutorialCubeState[2][1][0] = 1;
            tutorialCubeState[2][1][1] = 1;
            tutorialCubeState[2][1][2] = 1;
            tutorialCubeState[2][0][1] = 1;

            tutorialCubeState[3][2][0] = 0;
            tutorialCubeState[3][2][1] = 0;
            tutorialCubeState[3][2][2] = 0;
            tutorialCubeState[3][1][0] = 0;
            tutorialCubeState[3][1][1] = 0;
            tutorialCubeState[3][1][2] = 0;
            tutorialCubeState[3][0][1] = 3;

            tutorialCubeState[4][0][1]=5;
            tutorialCubeState[4][1][1]=5;
            tutorialCubeState[4][2][1]=5;
            tutorialCubeState[4][1][0]=5;
            tutorialCubeState[4][1][2]=5;



            tutorialCubeState[5][0][0]=4;
            tutorialCubeState[5][0][1]=4;
            tutorialCubeState[5][0][2]=4;
            tutorialCubeState[5][1][0]=4;
            tutorialCubeState[5][1][1]=4;
            tutorialCubeState[5][1][2]=4;
            tutorialCubeState[5][2][0]=4;
            tutorialCubeState[5][2][1]=4;
            tutorialCubeState[5][2][2]=4;
        }
        else if(currentStep ==6 ){
            tutorialCubeState[0][2][0] = 3;
            tutorialCubeState[0][2][1] = 3;
            tutorialCubeState[0][2][2] = 3;
            tutorialCubeState[0][1][0] = 3;
            tutorialCubeState[0][1][1] = 3;
            tutorialCubeState[0][1][2] = 3;
            tutorialCubeState[0][0][0] = 2;
            tutorialCubeState[0][0][1] = 3;
            tutorialCubeState[0][0][2] = 3;


            tutorialCubeState[1][2][0] = 2;
            tutorialCubeState[1][2][1] = 2;
            tutorialCubeState[1][2][2] = 2;
            tutorialCubeState[1][1][0] = 2;
            tutorialCubeState[1][1][1] = 2;
            tutorialCubeState[1][1][2] = 2;
            tutorialCubeState[1][0][0] = 2;
            tutorialCubeState[1][0][1] = 2;
            tutorialCubeState[1][0][2] = 5;


            tutorialCubeState[2][2][0] = 1;
            tutorialCubeState[2][2][1] = 1;
            tutorialCubeState[2][2][2] = 1;
            tutorialCubeState[2][1][0] = 1;
            tutorialCubeState[2][1][1] = 1;
            tutorialCubeState[2][1][2] = 1;
            tutorialCubeState[2][0][0] = 1;
            tutorialCubeState[2][0][1] = 1;
            tutorialCubeState[2][0][2] = 5;

            tutorialCubeState[3][2][0] = 0;
            tutorialCubeState[3][2][1] = 0;
            tutorialCubeState[3][2][2] = 0;
            tutorialCubeState[3][1][0] = 0;
            tutorialCubeState[3][1][1] = 0;
            tutorialCubeState[3][1][2] = 0;
            tutorialCubeState[3][0][0] = 0;
            tutorialCubeState[3][0][1] = 0;
            tutorialCubeState[3][0][2] = 5;

            tutorialCubeState[4][0][0]=3;
            tutorialCubeState[4][0][1]=5;
            tutorialCubeState[4][0][2]=0;
            tutorialCubeState[4][1][0]=5;
            tutorialCubeState[4][1][1]=5;
            tutorialCubeState[4][1][2]=5;
            tutorialCubeState[4][2][0]=1;
            tutorialCubeState[4][2][1]=5;
            tutorialCubeState[4][2][2]=5;



            tutorialCubeState[5][0][0]=4;
            tutorialCubeState[5][0][1]=4;
            tutorialCubeState[5][0][2]=4;
            tutorialCubeState[5][1][0]=4;
            tutorialCubeState[5][1][1]=4;
            tutorialCubeState[5][1][2]=4;
            tutorialCubeState[5][2][0]=4;
            tutorialCubeState[5][2][1]=4;
            tutorialCubeState[5][2][2]=4;
        }
        else if(currentStep == 7 ){
            tutorialCubeState[0][2][0] = 3;
            tutorialCubeState[0][2][1] = 3;
            tutorialCubeState[0][2][2] = 3;
            tutorialCubeState[0][1][0] = 3;
            tutorialCubeState[0][1][1] = 3;
            tutorialCubeState[0][1][2] = 3;
            tutorialCubeState[0][0][0] = 0;
            tutorialCubeState[0][0][1] = 3;
            tutorialCubeState[0][0][2] = 2;


            tutorialCubeState[1][2][0] = 2;
            tutorialCubeState[1][2][1] = 2;
            tutorialCubeState[1][2][2] = 2;
            tutorialCubeState[1][1][0] = 2;
            tutorialCubeState[1][1][1] = 2;
            tutorialCubeState[1][1][2] = 2;
            tutorialCubeState[1][0][0] = 5;
            tutorialCubeState[1][0][1] = 2;
            tutorialCubeState[1][0][2] = 2;


            tutorialCubeState[2][2][0] = 1;
            tutorialCubeState[2][2][1] = 1;
            tutorialCubeState[2][2][2] = 1;
            tutorialCubeState[2][1][0] = 1;
            tutorialCubeState[2][1][1] = 1;
            tutorialCubeState[2][1][2] = 1;
            tutorialCubeState[2][0][0] = 1;
            tutorialCubeState[2][0][1] = 1;
            tutorialCubeState[2][0][2] = 5;

            tutorialCubeState[3][2][0] = 0;
            tutorialCubeState[3][2][1] = 0;
            tutorialCubeState[3][2][2] = 0;
            tutorialCubeState[3][1][0] = 0;
            tutorialCubeState[3][1][1] = 0;
            tutorialCubeState[3][1][2] = 0;
            tutorialCubeState[3][0][0] = 0;
            tutorialCubeState[3][0][1] = 0;
            tutorialCubeState[3][0][2] = 5;

            tutorialCubeState[4][0][0]=5;
            tutorialCubeState[4][0][1]=5;
            tutorialCubeState[4][0][2]=5;
            tutorialCubeState[4][1][0]=5;
            tutorialCubeState[4][1][1]=5;
            tutorialCubeState[4][1][2]=5;
            tutorialCubeState[4][2][0]=3;
            tutorialCubeState[4][2][1]=5;
            tutorialCubeState[4][2][2]=3;



            tutorialCubeState[5][0][0]=4;
            tutorialCubeState[5][0][1]=4;
            tutorialCubeState[5][0][2]=4;
            tutorialCubeState[5][1][0]=4;
            tutorialCubeState[5][1][1]=4;
            tutorialCubeState[5][1][2]=4;
            tutorialCubeState[5][2][0]=4;
            tutorialCubeState[5][2][1]=4;
            tutorialCubeState[5][2][2]=4;
        }




    }
    public void onIntStateButton2Clicked(ActionEvent event) {
        currentIntermediateStep = 2;
        readFile();
        descTutorialTextLabel.setText(descTutorial);
        descTutorialTextLabel.setVisible(true);
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
        else if(currentStep == 2){
            // White facing you
            tutorialCubeState[0][0][1]= 0;
            tutorialCubeState[0][1][1]= 0;
            tutorialCubeState[0][0][0]= 0;
            tutorialCubeState[0][2][2]= 4;

            tutorialCubeState[1][1][1]= 1;
            tutorialCubeState[1][0][1]= 1;
            tutorialCubeState[1][0][2]= 1;
            tutorialCubeState[1][2][0]= 1;

            tutorialCubeState[2][0][1]= 2;
            tutorialCubeState[2][0][0]= 2;
            tutorialCubeState[2][0][2]= 2;
            tutorialCubeState[2][1][1]= 2;

            tutorialCubeState[3][0][1]= 3;
            tutorialCubeState[3][0][0]= 3;
            tutorialCubeState[3][0][2]= 3;
            tutorialCubeState[3][1][1]= 3;

            tutorialCubeState[4][0][0]=4;
            tutorialCubeState[4][0][1]=4;
            tutorialCubeState[4][0][2]=4;
            tutorialCubeState[4][1][0]=4;
            tutorialCubeState[4][1][1]=4;
            tutorialCubeState[4][1][2]=4;
            tutorialCubeState[4][2][0]=4;
            tutorialCubeState[4][2][1]=4;

            tutorialCubeState[5][0][2]=0;
            tutorialCubeState[5][1][1]=5;

        }
        else if(currentStep ==3){

            tutorialCubeState[1][2][0] = 2;
            tutorialCubeState[1][2][1] = 2;
            tutorialCubeState[1][2][2] = 2;
            tutorialCubeState[1][1][1] = 2;

            tutorialCubeState[0][2][0] = 3;
            tutorialCubeState[0][2][1] = 3;
            tutorialCubeState[0][2][2] = 3;
            tutorialCubeState[0][0][1] = 3;
            tutorialCubeState[0][1][1] = 3;

            tutorialCubeState[5][0][0]=4;
            tutorialCubeState[5][0][1]=4;
            tutorialCubeState[5][0][2]=4;
            tutorialCubeState[5][1][0]=4;
            tutorialCubeState[5][1][1]=4;
            tutorialCubeState[5][1][2]=4;
            tutorialCubeState[5][2][0]=4;
            tutorialCubeState[5][2][1]=4;
            tutorialCubeState[5][2][2]=4;

            tutorialCubeState[4][1][1] = 5;
            tutorialCubeState[4][2][1] = 0;



        }
        else if(currentStep ==4){
            tutorialCubeState[4][1][1] = 5;
            tutorialCubeState[4][1][0] = 5;
            tutorialCubeState[4][0][1] = 5;
            tutorialCubeState[0][0][1] = 5;
            tutorialCubeState[1][0][1] = 5;



        }
        else if(currentStep == 7 ){
            tutorialCubeState[0][2][0] = 3;
            tutorialCubeState[0][2][1] = 3;
            tutorialCubeState[0][2][2] = 3;
            tutorialCubeState[0][1][0] = 3;
            tutorialCubeState[0][1][1] = 3;
            tutorialCubeState[0][1][2] = 3;
            tutorialCubeState[0][0][0] = 5;
            tutorialCubeState[0][0][1] = 3;
            tutorialCubeState[0][0][2] = 2;


            tutorialCubeState[1][2][0] = 2;
            tutorialCubeState[1][2][1] = 2;
            tutorialCubeState[1][2][2] = 2;
            tutorialCubeState[1][1][0] = 2;
            tutorialCubeState[1][1][1] = 2;
            tutorialCubeState[1][1][2] = 2;
            tutorialCubeState[1][0][0] = 5;
            tutorialCubeState[1][0][1] = 2;
            tutorialCubeState[1][0][2] = 1;


            tutorialCubeState[2][2][0] = 1;
            tutorialCubeState[2][2][1] = 1;
            tutorialCubeState[2][2][2] = 1;
            tutorialCubeState[2][1][0] = 1;
            tutorialCubeState[2][1][1] = 1;
            tutorialCubeState[2][1][2] = 1;
            tutorialCubeState[2][0][0] = 5;
            tutorialCubeState[2][0][1] = 1;
            tutorialCubeState[2][0][2] = 1;

            tutorialCubeState[3][2][0] = 0;
            tutorialCubeState[3][2][1] = 0;
            tutorialCubeState[3][2][2] = 0;
            tutorialCubeState[3][1][0] = 0;
            tutorialCubeState[3][1][1] = 0;
            tutorialCubeState[3][1][2] = 0;
            tutorialCubeState[3][0][0] = 0;
            tutorialCubeState[3][0][1] = 0;
            tutorialCubeState[3][0][2] = 3;

            tutorialCubeState[4][0][0]=5;
            tutorialCubeState[4][0][1]=5;
            tutorialCubeState[4][0][2]=2;
            tutorialCubeState[4][1][0]=5;
            tutorialCubeState[4][1][1]=5;
            tutorialCubeState[4][1][2]=5;
            tutorialCubeState[4][2][0]=0;
            tutorialCubeState[4][2][1]=5;
            tutorialCubeState[4][2][2]=3;



            tutorialCubeState[5][0][0]=4;
            tutorialCubeState[5][0][1]=4;
            tutorialCubeState[5][0][2]=4;
            tutorialCubeState[5][1][0]=4;
            tutorialCubeState[5][1][1]=4;
            tutorialCubeState[5][1][2]=4;
            tutorialCubeState[5][2][0]=4;
            tutorialCubeState[5][2][1]=4;
            tutorialCubeState[5][2][2]=4;
        }

    }

    public void onIntStateButton3Clicked(ActionEvent event) {
        currentIntermediateStep = 3;
        readFile();
        descTutorialTextLabel.setText(descTutorial);
        descTutorialTextLabel.setVisible(true);
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
        else if(currentStep == 2){
            // White pointing down
            tutorialCubeState[0][0][1]= 0;
            tutorialCubeState[0][1][1]= 0;
            tutorialCubeState[0][0][0]= 0;
            tutorialCubeState[0][2][2]= 1;

            tutorialCubeState[1][1][1]= 1;
            tutorialCubeState[1][0][1]= 1;
            tutorialCubeState[1][0][2]= 1;
            tutorialCubeState[1][2][0]= 0;

            tutorialCubeState[2][0][1]= 2;
            tutorialCubeState[2][0][0]= 2;
            tutorialCubeState[2][0][2]= 2;
            tutorialCubeState[2][1][1]= 2;

            tutorialCubeState[3][0][1]= 3;
            tutorialCubeState[3][0][0]= 3;
            tutorialCubeState[3][0][2]= 3;
            tutorialCubeState[3][1][1]= 3;

            tutorialCubeState[4][0][0]=4;
            tutorialCubeState[4][0][1]=4;
            tutorialCubeState[4][0][2]=4;
            tutorialCubeState[4][1][0]=4;
            tutorialCubeState[4][1][1]=4;
            tutorialCubeState[4][1][2]=4;
            tutorialCubeState[4][2][0]=4;
            tutorialCubeState[4][2][1]=4;

            tutorialCubeState[5][0][2]=4;
            tutorialCubeState[5][1][1]=5;

        }
        else if(currentStep ==3){

            tutorialCubeState[1][2][0] = 2;
            tutorialCubeState[1][2][1] = 2;
            tutorialCubeState[1][2][2] = 2;
            tutorialCubeState[1][1][0] = 3;
            tutorialCubeState[1][1][1] = 2;


            tutorialCubeState[0][2][0] = 3;
            tutorialCubeState[0][2][1] = 3;
            tutorialCubeState[0][2][2] = 3;
            tutorialCubeState[0][1][1] = 3;
            tutorialCubeState[0][1][2] = 2;

            tutorialCubeState[5][0][0]=4;
            tutorialCubeState[5][0][1]=4;
            tutorialCubeState[5][0][2]=4;
            tutorialCubeState[5][1][0]=4;
            tutorialCubeState[5][1][1]=4;
            tutorialCubeState[5][1][2]=4;
            tutorialCubeState[5][2][0]=4;
            tutorialCubeState[5][2][1]=4;
            tutorialCubeState[5][2][2]=4;

            tutorialCubeState[4][1][1] = 5;




        }
        else if(currentStep == 7 ){
            tutorialCubeState[0][2][0] = 3;
            tutorialCubeState[0][2][1] = 3;
            tutorialCubeState[0][2][2] = 3;
            tutorialCubeState[0][1][0] = 3;
            tutorialCubeState[0][1][1] = 3;
            tutorialCubeState[0][1][2] = 3;
            tutorialCubeState[0][0][0] = 0;
            tutorialCubeState[0][0][1] = 3;
            tutorialCubeState[0][0][2] = 3;


            tutorialCubeState[1][2][0] = 2;
            tutorialCubeState[1][2][1] = 2;
            tutorialCubeState[1][2][2] = 2;
            tutorialCubeState[1][1][0] = 2;
            tutorialCubeState[1][1][1] = 2;
            tutorialCubeState[1][1][2] = 2;
            tutorialCubeState[1][0][0] = 2;
            tutorialCubeState[1][0][1] = 2;
            tutorialCubeState[1][0][2] = 1;


            tutorialCubeState[2][2][0] = 5;
            tutorialCubeState[2][2][1] = 1;
            tutorialCubeState[2][2][2] = 1;
            tutorialCubeState[2][1][0] = 1;
            tutorialCubeState[2][1][1] = 1;
            tutorialCubeState[2][1][2] = 1;
            tutorialCubeState[2][0][0] = 1;
            tutorialCubeState[2][0][1] = 1;
            tutorialCubeState[2][0][2] = 1;

            tutorialCubeState[3][2][0] = 0;
            tutorialCubeState[3][2][1] = 0;
            tutorialCubeState[3][2][2] = 0;
            tutorialCubeState[3][1][0] = 0;
            tutorialCubeState[3][1][1] = 0;
            tutorialCubeState[3][1][2] = 0;
            tutorialCubeState[3][0][0] = 0;
            tutorialCubeState[3][0][1] = 0;
            tutorialCubeState[3][0][2] = 5;

            tutorialCubeState[4][0][0]=5;
            tutorialCubeState[4][0][1]=5;
            tutorialCubeState[4][0][2]=2;
            tutorialCubeState[4][1][0]=5;
            tutorialCubeState[4][1][1]=5;
            tutorialCubeState[4][1][2]=5;
            tutorialCubeState[4][2][0]=3;
            tutorialCubeState[4][2][1]=5;
            tutorialCubeState[4][2][2]=5;



            tutorialCubeState[5][0][0]=4;
            tutorialCubeState[5][0][1]=4;
            tutorialCubeState[5][0][2]=4;
            tutorialCubeState[5][1][0]=4;
            tutorialCubeState[5][1][1]=4;
            tutorialCubeState[5][1][2]=4;
            tutorialCubeState[5][2][0]=4;
            tutorialCubeState[5][2][1]=4;
            tutorialCubeState[5][2][2]=4;
        }
    }
    public void onIntStateButton4Clicked(ActionEvent event) {
        currentIntermediateStep = 4;
        readFile();
        descTutorialTextLabel.setText(descTutorial);
        descTutorialTextLabel.setVisible(true);
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
        else if(currentStep == 2){
            // Good Layer Wrong Position
            tutorialCubeState[0][0][0]= 1;
            tutorialCubeState[0][0][1]= 0;
            tutorialCubeState[0][1][1]= 0;


            tutorialCubeState[1][1][1]= 1;
            tutorialCubeState[1][0][1]= 1;
            tutorialCubeState[1][0][2]= 1;


            tutorialCubeState[2][0][1]= 2;
            tutorialCubeState[2][0][0]= 2;
            tutorialCubeState[2][0][2]= 2;
            tutorialCubeState[2][1][1]= 2;

            tutorialCubeState[3][0][1]= 3;
            tutorialCubeState[3][0][0]= 3;
            tutorialCubeState[3][0][2]= 0;
            tutorialCubeState[3][1][1]= 3;

            tutorialCubeState[4][0][0]=4;
            tutorialCubeState[4][0][1]=4;
            tutorialCubeState[4][0][2]=4;
            tutorialCubeState[4][1][0]=4;
            tutorialCubeState[4][1][1]=4;
            tutorialCubeState[4][1][2]=4;
            tutorialCubeState[4][2][0]=4;
            tutorialCubeState[4][2][1]=4;


            tutorialCubeState[5][1][1]=5;

        }
        else if(currentStep == 7 ){
            tutorialCubeState[0][2][0] = 3;
            tutorialCubeState[0][2][1] = 3;
            tutorialCubeState[0][2][2] = 3;
            tutorialCubeState[0][1][0] = 3;
            tutorialCubeState[0][1][1] = 3;
            tutorialCubeState[0][1][2] = 3;
            tutorialCubeState[0][0][0] = 5;
            tutorialCubeState[0][0][1] = 3;
            tutorialCubeState[0][0][2] = 5;


            tutorialCubeState[1][2][0] = 2;
            tutorialCubeState[1][2][1] = 2;
            tutorialCubeState[1][2][2] = 2;
            tutorialCubeState[1][1][0] = 2;
            tutorialCubeState[1][1][1] = 2;
            tutorialCubeState[1][1][2] = 2;
            tutorialCubeState[1][0][0] = 3;
            tutorialCubeState[1][0][1] = 2;
            tutorialCubeState[1][0][2] = 5;


            tutorialCubeState[2][2][0] = 1;
            tutorialCubeState[2][2][1] = 1;
            tutorialCubeState[2][2][2] = 1;
            tutorialCubeState[2][1][0] = 1;
            tutorialCubeState[2][1][1] = 1;
            tutorialCubeState[2][1][2] = 1;
            tutorialCubeState[2][0][0] = 2;
            tutorialCubeState[2][0][1] = 1;
            tutorialCubeState[2][0][2] = 0;

            tutorialCubeState[3][2][0] = 0;
            tutorialCubeState[3][2][1] = 0;
            tutorialCubeState[3][2][2] = 0;
            tutorialCubeState[3][1][0] = 0;
            tutorialCubeState[3][1][1] = 0;
            tutorialCubeState[3][1][2] = 0;
            tutorialCubeState[3][0][0] = 5;
            tutorialCubeState[3][0][1] = 0;
            tutorialCubeState[3][0][2] = 3;

            tutorialCubeState[4][0][0]=1;
            tutorialCubeState[4][0][1]=5;
            tutorialCubeState[4][0][2]=1;
            tutorialCubeState[4][1][0]=5;
            tutorialCubeState[4][1][1]=5;
            tutorialCubeState[4][1][2]=5;
            tutorialCubeState[4][2][0]=0;
            tutorialCubeState[4][2][1]=5;
            tutorialCubeState[4][2][2]=2;



            tutorialCubeState[5][0][0]=4;
            tutorialCubeState[5][0][1]=4;
            tutorialCubeState[5][0][2]=4;
            tutorialCubeState[5][1][0]=4;
            tutorialCubeState[5][1][1]=4;
            tutorialCubeState[5][1][2]=4;
            tutorialCubeState[5][2][0]=4;
            tutorialCubeState[5][2][1]=4;
            tutorialCubeState[5][2][2]=4;
        }

    }
    public void onIntStateButton5Clicked(ActionEvent event) {
        currentIntermediateStep = 5;
        readFile();
        descTutorialTextLabel.setText(descTutorial);
        descTutorialTextLabel.setVisible(true);
        resetCubeState();
        tryButton.setVisible(true);
        if(currentStep==1){

            tutorialCubeState[0][1][1]= 0;

            tutorialCubeState[1][1][1]= 1;
            tutorialCubeState[1][0][1]= 1;
            tutorialCubeState[1][1][2]= 0;



            tutorialCubeState[2][0][1]= 2;
            tutorialCubeState[2][1][1]= 2;
            tutorialCubeState[2][1][0]= 4;

            tutorialCubeState[3][0][1]= 3;
            tutorialCubeState[3][1][1]= 3;


            tutorialCubeState[4][1][0]= 4;
            tutorialCubeState[4][0][1]= 4;
            tutorialCubeState[4][1][1]= 4;
            tutorialCubeState[4][1][2]= 4;

            tutorialCubeState[5][1][1]= 5;
        }
    }

    public void onIntStateButton6Clicked(ActionEvent event) {
        currentIntermediateStep = 6;
    }


    public void onTryButtonClicked(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tutorialMakeCube.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle(stepNameLabel.getText());
        stage.setScene(scene);
        stage.show();


    }
    public void readFile(){
        Path filePath = Paths.get("/mnt/Work/Projects/Ruby-Final/src/main/java/org/example/rubyfinal/resources/step"+currentStep+"Int"+currentIntermediateStep+".txt");
        try {
            descTutorial = Files.readString(filePath);
            System.out.println(descTutorial);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Can't read file");
        }

    }
    public void loadImage(){}

}
