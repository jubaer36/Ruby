package org.example.rubyfinal;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;


public class MakeCube {
    public
    @FXML
    GridPane frontFace;
    @FXML
    GridPane rightFace;
    @FXML
    GridPane leftFace;
    @FXML
    GridPane botttomFace;
    @FXML
    GridPane backFace;
    @FXML
    GridPane upperFace;
    @FXML
    Button colorChangeButton;
    @FXML
    Polygon fronPoly1;
    @FXML
    Polygon fronPoly2;
    @FXML
    Polygon fronPoly3;
    @FXML
    Polygon fronPoly4;
    @FXML
    Polygon fronPoly5;
    @FXML
    Polygon fronPoly6;
    @FXML
    Polygon fronPoly7;
    @FXML
    Polygon fronPoly8;
    @FXML
    Polygon fronPoly9;
    @FXML
    Polygon rightPoly1;
    @FXML
    Polygon rightPoly2;
    @FXML
    Polygon rightPoly3;
    @FXML
    Polygon rightPoly4;
    @FXML
    Polygon rightPoly5;
    @FXML
    Polygon rightPoly6;
    @FXML
    Polygon rightPoly7;
    @FXML
    Polygon rightPoly8;
    @FXML
    Polygon rightPoly9;
    @FXML
    Polygon upperPoly1;
    @FXML
    Polygon upperPoly2;
    @FXML
    Polygon upperPoly3;
    @FXML
    Polygon upperPoly4;
    @FXML
    Polygon upperPoly5;
    @FXML
    Polygon upperPoly6;
    @FXML
    Polygon upperPoly7;
    @FXML
    Polygon upperPoly8;
    @FXML
    Polygon upperPoly9;



    public boolean flag = true;
    public static int[][][] buttonStates = new int[6][3][3];
    public static int currentColor = 0;


    @FXML
    void initialize()
    {


        for(int sides = 0; sides<6; sides++)
        {
            for(int row=0; row<3; row++)
            {
                for(int col=0; col<3; col++)
                {
                    buttonStates[sides][row][col] = sides;
                    Button button = new Button();
                    button.setPrefSize(50,50);
//                    button.setStyle("-fx-border-color: black; -fx-border-width: 20px;");
                    button.setText("");


                    if(sides == 0) {
                        frontFace.add(button, col, row);
                    } else if (sides == 1) {
                        rightFace.add(button, col, row);
                    }
                    else if (sides == 2) {
                        backFace.add(button, col, row);
                    }
                    else if (sides == 3) {
                        leftFace.add(button, col, row);
                    }
                    else if (sides == 4) {
                        upperFace.add(button, col, row);
                    }
                    else{
                        botttomFace.add(button, col, row);
                    }
                    int rowIndex = row; int colIndex = col; int sideIndex = sides;

                    button.setOnAction(event -> handleButtonClick(rowIndex, colIndex, sideIndex, button));



                }
            }
        }

        colorCube();
        pressColorChange();
        colorChangeButton.setVisible(false);

    }

    private void handleButtonClick(int rowIndex, int colIndex,int sideIndex, Button button){

//        buttonStates[sideIndex][rowIndex][colIndex] = currentColor;
//        colorCube();

    }

    public void pressColorChange()
    {
        currentColor = (currentColor+1)%6;


        if(currentColor == 0)
        {
            colorChangeButton.setStyle("-fx-background-color: rgb(42, 187, 42);"); // green

        } else if (currentColor == 1) {
            colorChangeButton.setStyle("-fx-background-color: rgb(199, 36, 47);"); // red

        }else if (currentColor == 2) {
            colorChangeButton.setStyle("-fx-background-color: rgb(53, 121, 222);"); // blue

        }else if (currentColor == 3) {
            colorChangeButton.setStyle("-fx-background-color: rgb(255, 109, 0);"); // orange

        }else if (currentColor == 4) {
            colorChangeButton.setStyle("-fx-background-color: rgb(255, 255, 255);"); // white

        }else {
            colorChangeButton.setStyle("-fx-background-color: rgb(255, 221, 0);"); // yellow

        }



    }



    public void colorCube()
    {
        for(int sides = 0; sides<6; sides++)
        {
            for(int row=0; row<3; row++)
            {
                for(int col=0; col<3; col++)
                {

                    Button button = new Button();

                    if(sides == 0)
                    {
                        button = (Button) frontFace.getChildren().get(row*3 + col +1);

                    } else if (sides == 1) {
                        button = (Button) rightFace.getChildren().get(row*3 + col +1);

                    }
                    else if (sides == 2) {
                        button = (Button) backFace.getChildren().get(row*3 + col +1);

                    }
                    else if (sides == 3) {
                        button = (Button) leftFace.getChildren().get(row*3 + col +1);

                    }else if (sides == 4) {
                        button = (Button) upperFace.getChildren().get(row*3 + col +1);

                    }else{
                        button = (Button) botttomFace.getChildren().get(row*3 + col +1);

                    }

                    if(buttonStates[sides][row][col] == 0)
                    {
                        button.setStyle("-fx-background-color: rgb(42, 187, 42);"); //green

                    } else if (buttonStates[sides][row][col] == 1) {
                        button.setStyle("-fx-background-color: rgb(199, 36, 47);"); // red

                    }else if (buttonStates[sides][row][col] == 2) {
                        button.setStyle("-fx-background-color: rgb(53, 121, 222);"); //blue

                    }else if (buttonStates[sides][row][col] == 3) {
                        button.setStyle("-fx-background-color: rgb(255, 109, 0);"); // orange

                    }else if (buttonStates[sides][row][col] == 4) {
                        button.setStyle("-fx-background-color: rgb(255, 255, 255);"); // white

                    }else {
                        button.setStyle("-fx-background-color: rgb(255, 221, 0);");  //yellow

                    }

                }
            }
        }
        color3DCube();
    }

    public void color3DCube()
    {
        polycolor(fronPoly1,0,0,0);
        polycolor(fronPoly2,0,0,1);
        polycolor(fronPoly3,0,0,2);
        polycolor(fronPoly4,0,1,0);
        polycolor(fronPoly5,0,1,1);
        polycolor(fronPoly6,0,1,2);
        polycolor(fronPoly7,0,2,0);
        polycolor(fronPoly8,0,2,1);
        polycolor(fronPoly9,0,2,2);


        polycolor(rightPoly1,1,0,0);
        polycolor(rightPoly2,1,0,1);
        polycolor(rightPoly3,1,0,2);
        polycolor(rightPoly4,1,1,0);
        polycolor(rightPoly5,1,1,1);
        polycolor(rightPoly6,1,1,2);
        polycolor(rightPoly7,1,2,0);
        polycolor(rightPoly8,1,2,1);
        polycolor(rightPoly9,1,2,2);

        polycolor(upperPoly1,4,0,0);
        polycolor(upperPoly2,4,0,1);
        polycolor(upperPoly3,4,0,2);
        polycolor(upperPoly4,4,1,0);
        polycolor(upperPoly5,4,1,1);
        polycolor(upperPoly6,4,1,2);
        polycolor(upperPoly7,4,2,0);
        polycolor(upperPoly8,4,2,1);
        polycolor(upperPoly9,4,2,2);


    }

    public void polycolor(Polygon thepoly, int sides, int row, int col)
    {
        if(buttonStates[sides][row][col] == 0)
        {
            thepoly.setFill(Color.rgb(42, 187, 42)); // green


        } else if (buttonStates[sides][row][col] == 1) {
            thepoly.setFill(Color.rgb(199, 36, 47)); // red


        }else if (buttonStates[sides][row][col] == 2) {
            thepoly.setFill(Color.rgb(53, 121, 222)); // blue


        }else if (buttonStates[sides][row][col] == 3) {
            thepoly.setFill(Color.rgb(255, 109, 0)); // orange


        }else if (buttonStates[sides][row][col] == 4) {
            thepoly.setFill(Color.rgb(255, 255, 255)); // white


        }else {
            thepoly.setFill(Color.rgb(255, 221, 0)); // yyellow


        }
    }





    public void pressButtonRotateU_Dash()
    {

        RotateCube.rotateU();
        colorCube();
    }

    public void pressButtonRotateU()
    {

        RotateCube.rotateU_Dash();
        colorCube();
    }

    public void pressButtonRotateD()
    {


        RotateCube.rotateD();
        colorCube();
    }

    public void pressButtonRotateD_Dash()
    {
        RotateCube.rotateD_Dash();
        colorCube();
    }

    public void pressButtonRotateR_Dash()
    {
        RotateCube.rotateR();
        colorCube();
    }

    public void pressButtonRotateR()
    {
        RotateCube.rotateR_Dash();
        colorCube();
    }

    public void pressButtonRotateL()
    {
        RotateCube.rotateL();
        colorCube();
    }

    public void pressButtonRotateL_Dash()
    {
        RotateCube.rotateL_Dash();
        colorCube();
    }

    public void pressRotateX_Axis()
    {
        RotateCube.rotateX_Axis();
        colorCube();
    }
    public void pressRotateX_Axis_Dash()
    {
        RotateCube.rotateX_Axis_Dash();
        colorCube();
    }

    public void pressRotateY_Axis_Dash()
    {
        RotateCube.rotateY_Axis_Dash();
        colorCube();
    }

    public void pressRotateY_Axis()
    {
        RotateCube.rotateY_Axis();
        colorCube();
    }

    public void pressRotateF()
    {
        RotateCube.rotateF();
        colorCube();
    }

    public void pressRotateF_Dash()
    {
        RotateCube.rotateF_Dash();
        colorCube();
    }

    public void pressRotateB_Dash()
    {
        RotateCube.rotateB();
        colorCube();
    }

    public void pressRotateB()
    {
        RotateCube.rotateB_Dash();
        colorCube();
    }

}
