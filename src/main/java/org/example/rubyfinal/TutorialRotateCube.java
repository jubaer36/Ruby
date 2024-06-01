package org.example.rubyfinal;



public class TutorialRotateCube {
    public static void rotateU()
    {
        int tempColors[][] = new int[4][3];

        for(int sides=0; sides<4; sides++)
        {
            for(int col=0; col<3; col++)
            {
                tempColors[sides][col] = TutorialMakeCube.buttonStates[sides][0][col];
            }
        }

        TutorialMakeCube.buttonStates[0][0][0] = tempColors[3][0];
        TutorialMakeCube.buttonStates[0][0][1] = tempColors[3][1];
        TutorialMakeCube.buttonStates[0][0][2] = tempColors[3][2];

        for(int sides=1; sides<4; sides++)
        {
            for(int col=0; col<3; col++)
            {
                TutorialMakeCube.buttonStates[sides][0][col] = tempColors[sides-1][col];
            }
        }



        antiClockWiseTurn(4);


    }

    public static void rotateU_Dash()
    {

        int tempColors[][] = new int[4][3];

        for(int sides=0; sides<4; sides++)
        {
            for(int col=0; col<3; col++)
            {
                tempColors[sides][col] = TutorialMakeCube.buttonStates[sides][0][col];
            }
        }

        TutorialMakeCube.buttonStates[3][0][0] = tempColors[0][0];
        TutorialMakeCube.buttonStates[3][0][1] = tempColors[0][1];
        TutorialMakeCube.buttonStates[3][0][2] = tempColors[0][2];

        for(int sides = 2; sides>-1; sides--){
            for(int col=0; col<3; col++)
            {
                TutorialMakeCube.buttonStates[sides][0][col] = tempColors[sides+1][col];
            }
        }

        clockWiseTurn(4);



    }

    public static void rotateD(){
        int tempColors[][] = new int[4][3];

        for(int sides=0; sides<4; sides++)
        {
            for(int col=0; col<3; col++)
            {
                tempColors[sides][col] = TutorialMakeCube.buttonStates[sides][2][col];
            }
        }

        TutorialMakeCube.buttonStates[0][2][0] = tempColors[3][0];
        TutorialMakeCube.buttonStates[0][2][1] = tempColors[3][1];
        TutorialMakeCube.buttonStates[0][2][2] = tempColors[3][2];

        for(int sides=1; sides<4; sides++)
        {
            for(int col=0; col<3; col++)
            {
                TutorialMakeCube.buttonStates[sides][2][col] = tempColors[sides-1][col];
            }
        }

        clockWiseTurn(5);

    }

    public static void rotateD_Dash()
    {
        int tempColors[][] = new int[4][3];

        for(int sides=0; sides<4; sides++)
        {
            for(int col=0; col<3; col++)
            {
                tempColors[sides][col] = TutorialMakeCube.buttonStates[sides][2][col];
            }
        }

        TutorialMakeCube.buttonStates[3][2][0] = tempColors[0][0];
        TutorialMakeCube.buttonStates[3][2][1] = tempColors[0][1];
        TutorialMakeCube.buttonStates[3][2][2] = tempColors[0][2];

        for(int sides=2; sides>-1; sides--)
        {
            for(int col=0; col<3; col++)
            {
                TutorialMakeCube.buttonStates[sides][2][col] = tempColors[sides+1][col];
            }
        }

        antiClockWiseTurn(5);


    }

    public static void rotateR()
    {
        int tempColors[][] = new int[4][3];
        tempColors[0][0] = TutorialMakeCube.buttonStates[0][0][2];
        tempColors[0][1] = TutorialMakeCube.buttonStates[0][1][2];
        tempColors[0][2] = TutorialMakeCube.buttonStates[0][2][2];

        tempColors[1][0] = TutorialMakeCube.buttonStates[5][0][2];
        tempColors[1][1] = TutorialMakeCube.buttonStates[5][1][2];
        tempColors[1][2] = TutorialMakeCube.buttonStates[5][2][2];

        tempColors[2][0] = TutorialMakeCube.buttonStates[2][0][0];
        tempColors[2][1] = TutorialMakeCube.buttonStates[2][1][0];
        tempColors[2][2] = TutorialMakeCube.buttonStates[2][2][0];

        tempColors[3][0] = TutorialMakeCube.buttonStates[4][0][2];
        tempColors[3][1] = TutorialMakeCube.buttonStates[4][1][2];
        tempColors[3][2] = TutorialMakeCube.buttonStates[4][2][2];

        TutorialMakeCube.buttonStates[0][0][2] = tempColors[3][0];
        TutorialMakeCube.buttonStates[0][1][2] = tempColors[3][1];
        TutorialMakeCube.buttonStates[0][2][2] = tempColors[3][2];

        TutorialMakeCube.buttonStates[5][0][2] = tempColors[0][0];
        TutorialMakeCube.buttonStates[5][1][2] = tempColors[0][1];
        TutorialMakeCube.buttonStates[5][2][2] = tempColors[0][2];

        TutorialMakeCube.buttonStates[2][0][0] = tempColors[1][2];
        TutorialMakeCube.buttonStates[2][1][0] = tempColors[1][1];
        TutorialMakeCube.buttonStates[2][2][0] = tempColors[1][0];

        TutorialMakeCube.buttonStates[4][0][2] = tempColors[2][2];
        TutorialMakeCube.buttonStates[4][1][2] = tempColors[2][1];
        TutorialMakeCube.buttonStates[4][2][2] = tempColors[2][0];

        antiClockWiseTurn(1);

    }

    public static void rotateR_Dash(){

        rotateR();
        clockWiseTurn(1);
        rotateR();
        clockWiseTurn(1);
        rotateR();
        clockWiseTurn(1);

        clockWiseTurn(1);

    }

    public static void rotateL()
    {
        int tempColors[][] = new int[4][3];
        tempColors[0][0] = TutorialMakeCube.buttonStates[0][0][0];
        tempColors[0][1] = TutorialMakeCube.buttonStates[0][1][0];
        tempColors[0][2] = TutorialMakeCube.buttonStates[0][2][0];

        tempColors[1][0] = TutorialMakeCube.buttonStates[5][0][0];
        tempColors[1][1] = TutorialMakeCube.buttonStates[5][1][0];
        tempColors[1][2] = TutorialMakeCube.buttonStates[5][2][0];

        tempColors[2][0] = TutorialMakeCube.buttonStates[2][0][2];
        tempColors[2][1] = TutorialMakeCube.buttonStates[2][1][2];
        tempColors[2][2] = TutorialMakeCube.buttonStates[2][2][2];

        tempColors[3][0] = TutorialMakeCube.buttonStates[4][0][0];
        tempColors[3][1] = TutorialMakeCube.buttonStates[4][1][0];
        tempColors[3][2] = TutorialMakeCube.buttonStates[4][2][0];

        TutorialMakeCube.buttonStates[0][0][0] = tempColors[3][0];
        TutorialMakeCube.buttonStates[0][1][0] = tempColors[3][1];
        TutorialMakeCube.buttonStates[0][2][0] = tempColors[3][2];

        TutorialMakeCube.buttonStates[5][0][0] = tempColors[0][0];
        TutorialMakeCube.buttonStates[5][1][0] = tempColors[0][1];
        TutorialMakeCube.buttonStates[5][2][0] = tempColors[0][2];

        TutorialMakeCube.buttonStates[2][0][2] = tempColors[1][2];
        TutorialMakeCube.buttonStates[2][1][2] = tempColors[1][1];
        TutorialMakeCube.buttonStates[2][2][2] = tempColors[1][0];

        TutorialMakeCube.buttonStates[4][0][0] = tempColors[2][2];
        TutorialMakeCube.buttonStates[4][1][0] = tempColors[2][1];
        TutorialMakeCube.buttonStates[4][2][0] = tempColors[2][0];

        clockWiseTurn(3);
    }

    public static void rotateL_Dash()
    {
        rotateL();
        antiClockWiseTurn(3);
        rotateL();
        antiClockWiseTurn(3);
        rotateL();
        antiClockWiseTurn(3);

        antiClockWiseTurn(3);
    }

    public static void rotateMiddle_X_Dash()
    {
        int tempColors[][] = new int[4][3];

        for(int sides=0; sides<4; sides++)
        {
            for(int col=0; col<3; col++)
            {
                tempColors[sides][col] = TutorialMakeCube.buttonStates[sides][1][col];
            }
        }

        TutorialMakeCube.buttonStates[3][1][0] = tempColors[0][0];
        TutorialMakeCube.buttonStates[3][1][1] = tempColors[0][1];
        TutorialMakeCube.buttonStates[3][1][2] = tempColors[0][2];

        for(int sides=2; sides>-1; sides--)
        {
            for(int col=0; col<3; col++)
            {
                TutorialMakeCube.buttonStates[sides][1][col] = tempColors[sides+1][col];
            }
        }
    }
    public static void rotateMiddle_X()
    {
        rotateMiddle_X_Dash();
        rotateMiddle_X_Dash();
        rotateMiddle_X_Dash();
    }

    public static void rotateMiddle_Y()
    {
        int tempColors[][] = new int[4][3];
        tempColors[0][0] = TutorialMakeCube.buttonStates[0][0][1];
        tempColors[0][1] = TutorialMakeCube.buttonStates[0][1][1];
        tempColors[0][2] = TutorialMakeCube.buttonStates[0][2][1];

        tempColors[1][0] = TutorialMakeCube.buttonStates[5][0][1];
        tempColors[1][1] = TutorialMakeCube.buttonStates[5][1][1];
        tempColors[1][2] = TutorialMakeCube.buttonStates[5][2][1];

        tempColors[2][0] = TutorialMakeCube.buttonStates[2][0][1];
        tempColors[2][1] = TutorialMakeCube.buttonStates[2][1][1];
        tempColors[2][2] = TutorialMakeCube.buttonStates[2][2][1];

        tempColors[3][0] = TutorialMakeCube.buttonStates[4][0][1];
        tempColors[3][1] = TutorialMakeCube.buttonStates[4][1][1];
        tempColors[3][2] = TutorialMakeCube.buttonStates[4][2][1];

        TutorialMakeCube.buttonStates[0][0][1] = tempColors[3][0];
        TutorialMakeCube.buttonStates[0][1][1] = tempColors[3][1];
        TutorialMakeCube.buttonStates[0][2][1] = tempColors[3][2];

        TutorialMakeCube.buttonStates[5][0][1] = tempColors[0][0];
        TutorialMakeCube.buttonStates[5][1][1] = tempColors[0][1];
        TutorialMakeCube.buttonStates[5][2][1] = tempColors[0][2];

        TutorialMakeCube.buttonStates[2][0][1] = tempColors[1][2];
        TutorialMakeCube.buttonStates[2][1][1] = tempColors[1][1];
        TutorialMakeCube.buttonStates[2][2][1] = tempColors[1][0];

        TutorialMakeCube.buttonStates[4][0][1] = tempColors[2][2];
        TutorialMakeCube.buttonStates[4][1][1] = tempColors[2][1];
        TutorialMakeCube.buttonStates[4][2][1] = tempColors[2][0];
    }

    public static void rotateMiddle_Y_Dash()
    {
        rotateMiddle_Y();
        rotateMiddle_Y();
        rotateMiddle_Y();
    }

    public static void rotateF()
    {
        rotateY_Axis();
        rotateU_Dash();
        rotateY_Axis_Dash();
    }

    public static void rotateF_Dash()
    {
        rotateY_Axis();
        rotateU();
        rotateY_Axis_Dash();
    }

    public static void rotateB()
    {
        rotateY_Axis_Dash();
        rotateU();
        rotateY_Axis();
    }

    public static void rotateB_Dash()
    {
        rotateY_Axis_Dash();
        rotateU_Dash();
        rotateY_Axis();
    }

    public static void rotateX_Axis()
    {
        rotateU();
        rotateMiddle_X();
        rotateD();
    }

    public static void rotateX_Axis_Dash()
    {
        rotateX_Axis();
        rotateX_Axis();
        rotateX_Axis();
    }

    public static void rotateY_Axis_Dash()
    {
        rotateL();
        rotateMiddle_Y();
        rotateR();
    }

    public static void rotateY_Axis()
    {
        rotateY_Axis_Dash();
        rotateY_Axis_Dash();
        rotateY_Axis_Dash();
    }




    public static void clockWiseTurn(int sides)
    {
        antiClockWiseTurn(sides);
        antiClockWiseTurn(sides);
        antiClockWiseTurn(sides);
    }



    public static void antiClockWiseTurn(int sides)
    {
        int tempColors[][] = new int[3][3];

        for(int row=0; row<3; row++)
        {
            for(int col=0; col<3; col++)
            {
                tempColors[row][col] = TutorialMakeCube.buttonStates[sides][row][col];
            }
        }

        TutorialMakeCube.buttonStates[sides][0][0] = tempColors[0][2];
        TutorialMakeCube.buttonStates[sides][0][1] = tempColors[1][2];
        TutorialMakeCube.buttonStates[sides][0][2] = tempColors[2][2];

        TutorialMakeCube.buttonStates[sides][0][0] = tempColors[0][2];
        TutorialMakeCube.buttonStates[sides][1][0] = tempColors[0][1];
        TutorialMakeCube.buttonStates[sides][2][0] = tempColors[0][0];

        TutorialMakeCube.buttonStates[sides][2][0] = tempColors[0][0];
        TutorialMakeCube.buttonStates[sides][2][1] = tempColors[1][0];
        TutorialMakeCube.buttonStates[sides][2][2] = tempColors[2][0];

        TutorialMakeCube.buttonStates[sides][0][2] = tempColors[2][2];
        TutorialMakeCube.buttonStates[sides][1][2] = tempColors[2][1];
        TutorialMakeCube.buttonStates[sides][2][2] = tempColors[2][0];

    }
}
