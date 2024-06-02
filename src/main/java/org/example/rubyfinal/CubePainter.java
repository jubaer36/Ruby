package org.example.rubyfinal;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class CubePainter extends JPanel implements ActionListener, ChangeListener, MouseListener {

//    All the variables , buttons and Jpanel Stuffs
    private JButton start, stop, applyScramble, randomize;
    private JButton skip, rewind;
    private JButton resetCubeInputs, setInputs;
    private JSlider animSpeed;
    private JLabel scrambleText;
    private JComboBox<String> sideChoser;
    private String[] instructions;
    private JTextField inputScramble ;


    private Timer frameTimer;
    //Stroke for bold outline along edges of cubie colors
    final static BasicStroke s = new BasicStroke(3.0f, BasicStroke.CAP_BUTT,
            BasicStroke.JOIN_MITER, 10.0f);
    private final static Font font = new Font("Roboto", Font.BOLD, 30);
    public final static int DELAY = 1500;
    final static int CUBIE_SIZE = 50;


    private String mode = new String();
    public final static String TEXT_SCRAMBLE = "Text Scramble";
    public final static String COLOR_SELECTION = "Color Selection";
    private char colorSelected; //The color selected while in color input mode
    private char sideChosen; //The side for which the user is entering colors

    private char[][][] colorsInputed; //Holds all inputed colors
//    If in solution mode
    private boolean inSolution;

    private Cube cube = new Cube();
    //Default scramble
    private final String DEFAULT_SCRAMBLE = "";
    private String scramble = new String(DEFAULT_SCRAMBLE),
            sunflower = new String(), whiteCross = new String(),
            whiteCorners = new String(), secondLayer = new String(),
            yellowCross = new String(), OLL = new String(), PLL = new String();
    private String movesToPerform = new String(), movesPerformed = new String();

    /*
     * Respective Phase Variables
     * 0 = sunflower
     * 1 = whiteCross
     * 2 = whiteCorners
     * 3 = secondLayer
     * 4 = yellowCross
     * 5 = OLL
     * 6 = PLL
     * The phase is updated in updatePhase() to reflect the stage at which the solution is
     */
    private int phase = 0;
    private String phaseString;
    //Helps keep track of moves to perform, and allows for painting of moves
    private int movesIndex = 0;

//  Initialization
    public CubePainter() {
        setLayout(null);
        setSize(getPreferredSize());
        setBackground(new Color(31,	40	,51));
        setIgnoreRepaint(true);
        setVisible(true);
        mode = TEXT_SCRAMBLE;
        inSolution = true;
        phaseString = "Sunflower";
        colorSelected = 'R';
        instructions = new String[] {"Red", "Yellow", "White"};
        sideChosen = 'L';
        colorsInputed = new char[6][3][3];
        resetCubeInputs();
        addMouseListener(this);

        initializeComponents();
        resetScramble(inputScramble.getText());
        //Initialize the frame timer
        frameTimer = new javax.swing.Timer(CubePainter.DELAY, new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(inSolution) {
                    performNextMove();
                    repaint();
                }
            }
        });
        start.doClick();
        animSpeed.setValue(10);
        frameTimer.setDelay((DELAY)/animSpeed.getValue());
    }


    public void resetCubeInputs() {
        for(int i = 0; i<3; i++) {
            Arrays.fill(colorsInputed[0][i], 'R');
            Arrays.fill(colorsInputed[1][i], 'Y');
            Arrays.fill(colorsInputed[2][i], 'G');
            Arrays.fill(colorsInputed[3][i], 'B');
            Arrays.fill(colorsInputed[4][i], 'O');
            Arrays.fill(colorsInputed[5][i], 'W');
        }
    }


    public void initializeComponents() {
        Font customFont = new Font("Arial", Font.BOLD, 14);
        start = new JButton("Start");
        start.setLocation(50, 10); start.setSize(80,20);
        start.setFont(customFont);
        add(start);
        start.addActionListener(this);
        start.setBackground(new Color(11,12,16));
        start.setBorder(new LineBorder(new Color(102,252,241)));
        start.setForeground(new Color(197,198,199));


        stop = new JButton("Stop");
        stop.setLocation(140, 10); stop.setSize(80,20);
        stop.setFont(customFont);
        add(stop);
        stop.setBackground(new Color(11,12,16));
        stop.setBorder(new LineBorder(new Color(102,252,241)));
        stop.setForeground(new Color(197,198,199));
        stop.addActionListener(this);

        scrambleText = new JLabel("Scramble");
        scrambleText.setLocation(10,40); scrambleText.setSize(150,30);
        scrambleText.setFont(new Font("Arial", Font.BOLD, 25));
        scrambleText.setForeground(new Color(	197,198,199));
        add(scrambleText);
        scrambleText.setVisible(false);









        skip = new JButton("-->");
        skip.setLocation(320, 8);
        skip.setFont(customFont);
        skip.setSize(60,20);
        skip.addActionListener(this);
        skip.setBackground(new Color(11,12,16));
        skip.setBorder(new LineBorder(new Color(102,252,241)));
        skip.setForeground(new Color(197,198,199));
        add(skip);

        rewind = new JButton("<--");
        rewind.setFont(customFont);
        rewind.setLocation(240, 8);
        rewind.setSize(60,20);
        rewind.addActionListener(this);
        rewind.setBackground(new Color(11,12,16));
        rewind.setBorder(new LineBorder(new Color(102,252,241)));
        rewind.setForeground(new Color(197,198,199));
        add(rewind);

        animSpeed = new JSlider(1, 10); animSpeed.setValue(1); //Slider values range from 1 to 10
        animSpeed.setMinorTickSpacing(1); animSpeed.setPaintTicks(true);
        animSpeed.setSnapToTicks(true);
        animSpeed.setBackground(new Color(31,40,51));


        animSpeed.setLocation(500, 0); animSpeed.setSize(200, 40);
        add(animSpeed);
        animSpeed.addChangeListener(this);

        inputScramble = new JTextField(scramble);

        inputScramble.setLocation(150, 40); inputScramble.setSize(410, 40);
        inputScramble.setFocusable(true);
        inputScramble.setBackground(new Color(	11	,12,	16));
        inputScramble.setBorder(BorderFactory.createLineBorder(new Color(	197	,198	,199)));
        inputScramble.setFont(customFont);
        inputScramble.setForeground(new Color(	102	,252,	241));

        add(inputScramble);

        applyScramble = new JButton("APPLY");
        applyScramble.setFont(customFont);
        applyScramble.setLocation(580, 40); applyScramble.setSize(120,20);
        add(applyScramble);
        applyScramble.setBackground(new Color(11,12,16));
        applyScramble.setBorder(new LineBorder(new Color(102,252,241)));
        applyScramble.setForeground(new Color(197,198,199));
        applyScramble.addActionListener(this);

        randomize = new JButton("RANDOM");
        randomize.setFont(customFont);
        randomize.setLocation(580, 70); randomize.setSize(120,20);
        randomize.setBackground(new Color(11,12,16));
        randomize.setBorder(new LineBorder(new Color(102,252,241)));
        randomize.setForeground(new Color(197,198,199));
        add(randomize);
        randomize.addActionListener(this);

        sideChoser = new JComboBox<String>(new String[]{"Left", "Up", "Back", "Front", "Right", "Down"} );
        sideChoser.setLocation(270, 50); sideChoser.setSize(100, 30);
        add(sideChoser);
        sideChoser.addActionListener(this);
        sideChoser.setVisible(false); sideChoser.setEnabled(false);

        resetCubeInputs = new JButton("RESET");
        resetCubeInputs.setFont(customFont);
        resetCubeInputs.setLocation(200, 650); resetCubeInputs.setSize(100, 30);
        add(resetCubeInputs);
        resetCubeInputs.addActionListener(this);
        resetCubeInputs.setVisible(false); resetCubeInputs.setEnabled(false);

        setInputs = new JButton("PROCEED");
        setInputs.setLocation(300, 650); setInputs.setSize(100, 30);
        add(setInputs);
        setInputs.addActionListener(this);
        setInputs.setVisible(false); setInputs.setEnabled(false);




    }

//   On pressing Buttons
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start) {
            frameTimer.start();
        } else if(e.getSource() == stop) {
            frameTimer.stop();
        } else if(e.getSource() == skip) {
            performNextMove();
            repaint();
        } else if(e.getSource() == rewind) {
            boolean flag = false;
            int prevIndex = movesIndex;
            while(movesIndex > 1 && !flag) {
                movesIndex--;
                if(movesToPerform.substring(movesIndex - 1, movesIndex).equals(" ")) {
                    flag = !flag;
                }
                System.out.println(movesIndex);
            }
            if(movesIndex == 1) {
                movesIndex = 0;
            }
            movesPerformed = movesToPerform.substring(0, movesIndex);
            if(movesPerformed.length() >= 35) {
                movesPerformed = movesPerformed.substring(movesPerformed.length()-33);
            }
            cube.reverseMoves(movesToPerform.substring(movesIndex, prevIndex));
            repaint();
        } else if(e.getSource() == sideChoser) {
            sideChosen = ((String)sideChoser.getSelectedItem()).charAt(0);
            instructions = getInstructions();
            repaint();
        } else if(e.getSource() == applyScramble) {
            frameTimer.stop();
            //While the cube is being scrambled, screen will show nonsensical colors, such as black, so set as invisible
            setVisible(false);
            resetScramble(inputScramble.getText());
            inSolution = true;
            updateElements();
            repaint();
            setVisible(true);
        } else if(e.getSource() == randomize) {
            cube = new Cube();
            inputScramble.setText(cube.randScramble());
            scramble = inputScramble.getText();
            setVisible(false);
            resetScramble(inputScramble.getText());
            inSolution = true;
            updateElements();
            repaint();
            setVisible(true);
        } else if(e.getSource() == resetCubeInputs) {
            resetCubeInputs();
            repaint();
        } else if(e.getSource() == setInputs) {
            frameTimer.stop();
            //While the cube is being scrambled, screen will show nonsensical colors, such as black, so set as invisible
            setVisible(false);
            cube.setAllColors(colorsInputed);
            resetScrambleByColorInputs();
            inSolution = true;
            updateElements();
            repaint();
            setVisible(true);
        }
    }


    public void stateChanged(ChangeEvent e) {
        if(e.getSource() == animSpeed) {
            frameTimer.setDelay(DELAY/animSpeed.getValue());
        }
    }


    public Dimension getPreferredSize(){
        return new Dimension(700,770);
    }

//    Paints the Jpanel
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if(mode.equals(TEXT_SCRAMBLE)) {
//            g.setFont(new Font("Arial", Font.BOLD, 25));
//            g.drawString("Scramble: ", 20, 70);
            scrambleText.setVisible(true);
        }

        if(!inSolution) {
            //Paint the color selection boxes
            ((Graphics2D)g).setStroke(s);
            int xVal = 100; int yVal = 450;
            for(int i = 0; i<6; i++) {
                switch(i) {
                    case(0): g.setColor(Color.RED); 		break;
                    case(1): g.setColor(Color.GREEN); 	break;
                    case(2): g.setColor(Color.BLUE); 	break;
                    case(3): g.setColor(Color.YELLOW); 	break;
                    case(4): g.setColor(Color.ORANGE); 	break;
                    case(5): g.setColor(Color.WHITE); 	break;
                }
                g.fillRect(xVal, yVal, CUBIE_SIZE, CUBIE_SIZE);
                g.setColor(Color.BLACK);
                g.drawRect(xVal, yVal, CUBIE_SIZE, CUBIE_SIZE);
                xVal += CUBIE_SIZE*1.5;
            }

            //Paint the chosen cube side
            xVal = 250; yVal = 200;
            char[][] sideColors = colorsInputed[getIndexOfSide(sideChosen)];
            for(int i = 0; i<3; i++){
                for(int j = 0; j<3; j++) {
                    g.setColor(getColor(sideColors[i][j]));
                    g.fillRect(xVal + j*CUBIE_SIZE, yVal+ i*CUBIE_SIZE, CUBIE_SIZE, CUBIE_SIZE);
                    g.setColor(Color.BLACK);
                    g.drawRect(xVal + j*CUBIE_SIZE, yVal+ i*CUBIE_SIZE, CUBIE_SIZE, CUBIE_SIZE);
                }
            }

            //Paint the instructions for holding the cube
            g.setColor(Color.BLACK);
            g.drawString("Hold the cube such that " + instructions[0] + " is facing up, " +
                            instructions[1] + " is to the back, and " + instructions[2] + " is in front.",
                    50, 130);
            g.drawString("Enter the top colors.",
                    50, 150);

            //Paint the color that is selected so user is sure to paint correct color
            g.setFont(font);
            g.drawString("Selected Color:", 100, 500 + CUBIE_SIZE*2);
            g.setColor(getColor(colorSelected));
            g.fillRect(400, 465 + CUBIE_SIZE*2, CUBIE_SIZE, CUBIE_SIZE);
            g.setColor(Color.BLACK);
            g.drawRect(400, 465 + CUBIE_SIZE*2, CUBIE_SIZE, CUBIE_SIZE);
        }


        else if(inSolution) {
            //Display the phase of a solution
            g.setFont(new Font("Arial", Font.BOLD, 25));
            g.setColor(new Color(	197,198,199));
            g.drawString("Phase: " + phaseString, 10, 120);


            g.setFont(font);
            g.setColor(new Color(69	,162	,158));
            g.drawString(movesPerformed, 50, 700); //Draw the moves that have already been performed

            //Draw the moves that are yet to be performed
            g.setColor(Color.BLACK);
            if(movesIndex <= movesToPerform.length()-1) { //Avoid index out of bounds error
                if(movesToPerform.substring(movesIndex).length() >= 33) {
                    g.drawString(movesToPerform.substring(movesIndex, movesIndex + 33), 40, 650);
                }
                else {
                    g.drawString(movesToPerform.substring(movesIndex), 40, 650);
                }
            }

            //Paint the cube itself now
            ((Graphics2D)g).setStroke(s);
            cube.paintComponent(g);

        }

    }

//    Returns The Color
    private Color getColor(char color) {
        switch(color) {
            case 'W': return Color.WHITE;
            case 'Y': return Color.YELLOW;
            case 'B': return Color.BLUE;
            case 'G': return Color.GREEN;
            case 'R': return Color.RED;
            case 'O': return Color.ORANGE;
        }
        return Color.BLACK;
    }


    private int getIndexOfSide(char side) {
        switch(side) {
            case('L'): return 0;
            case('U'): return 1;
            case('F'): return 2;
            case('B'): return 3;
            case('R'): return 4;
            case('D'): return 5;
        }
        return 6;
    }


//      Retrieves the colors of the faces to be printed in the instructions in the paintComponent() method.
//     If String[] colors = getInstructions(), color[0] is the color to hold on top, colors[1] is the color
//    to hold in the back, and colors[2] is the color to hold in front.
//

    private String[] getInstructions() {
        String[] colors = new String[3];
        switch(sideChosen) {
            case('L'): 	colors[0] = "Red";
                colors[1] = "Yellow";
                colors[2] = "White"; break;
            case('U'): 	colors[0] = "Yellow";
                colors[1] = "Blue";
                colors[2] = "Green"; break;
            case('F'): 	colors[0] = "Green";
                colors[1] = "Yellow";
                colors[2] = "White"; break;
            case('B'): 	colors[0] = "Blue";
                colors[1] = "Yellow";
                colors[2] = "White"; break;
            case('R'): 	colors[0] = "Orange";
                colors[1] = "Yellow";
                colors[2] = "White"; break;
            case('D'): 	colors[0] = "White";
                colors[1] = "Green";
                colors[2] = "Blue";
        }
        return colors;
    }

//    Scramble to be applied
    public void resetScramble(String s) {
        scramble = s;
        cube = new Cube();
        cube.scramble(scramble);
        sunflower = cube.makeSunflower();
        whiteCross = cube.makeWhiteCross();
        whiteCorners = cube.finishWhiteLayer();
        secondLayer = cube.insertAllEdges();
        yellowCross = cube.makeYellowCross();
        OLL = cube.orientLastLayer();
        PLL = cube.permuteLastLayer();

        movesToPerform = sunflower;
        movesPerformed = new String();

        cube = new Cube();
        cube.scramble(scramble);

        movesIndex = 0; phase = 0;
        phaseString = "Sunflower";
        repaint();
    }


    public void resetScrambleByColorInputs() {
        cube.setAllColors(colorsInputed);
        sunflower = cube.makeSunflower();
        whiteCross = cube.makeWhiteCross();
        whiteCorners = cube.finishWhiteLayer();
        secondLayer = cube.insertAllEdges();
        yellowCross = cube.makeYellowCross();
        OLL = cube.orientLastLayer();
        PLL = cube.permuteLastLayer();

        movesToPerform = sunflower;
        movesPerformed = new String();

        movesIndex = 0; phase = 0;
        phaseString = "Sunflower";
        cube.setAllColors(colorsInputed); //Reset the cube to scrambled state
        repaint();
    }


    /**
     * After updating the phase (if necessary), performs the next move in the String movesToPerform
     * and updates movesPerformed.
     */
    public void performNextMove() {
        updatePhase();

        //Get to a character that is not a space
        while(movesIndex<movesToPerform.length()-1 && movesToPerform.substring(movesIndex, movesIndex+1).compareTo(" ") == 0) {
            movesIndex++;
        }
        //Same logic as in Cube class's performMoves() method
        if(movesToPerform.length()>0 && movesToPerform.substring(movesIndex, movesIndex+1) != " ") {
            if(movesIndex!=movesToPerform.length()-1) {
                if(movesToPerform.substring(movesIndex+1, movesIndex+2).compareTo("2") == 0) {
                    //Turning twice ex. U2
                    cube.turn(movesToPerform.substring(movesIndex, movesIndex+1));
                    cube.turn(movesToPerform.substring(movesIndex, movesIndex+1));
                    movesIndex++;
                }
                else if(movesToPerform.substring(movesIndex+1,movesIndex+2).compareTo("'") == 0) {
                    //Making a counterclockwise turn ex. U'
                    cube.turn(movesToPerform.substring(movesIndex, movesIndex+2));
                    movesIndex++;
                }
                else {
                    //Clockwise turn
                    cube.turn(movesToPerform.substring(movesIndex, movesIndex+1));
                }
            }
            else {
                //Clockwise turn
                cube.turn(movesToPerform.substring(movesIndex, movesIndex+1));
            }
        }
        movesIndex++;
        //Append the moves performed onto the end of movesPerformed
        if(movesToPerform.length()>0) {
            movesPerformed = movesToPerform.substring(0, movesIndex);
        }
        //Ensure that movesPerformed does not overflow out of the graphical interface
        if(movesPerformed.length() >= 35) {
            movesPerformed = movesPerformed.substring(movesPerformed.length()-33);
        }
    }


    /**
     * Updates the UI elements that the user can interact with depending on the current mode and whether
     * a solution is being played.
     */
    public void updateElements() {
        if(mode.equals(TEXT_SCRAMBLE)) {
            start.setEnabled(true); 			start.setVisible(true);
            stop.setEnabled(true); 			stop.setVisible(true);
            animSpeed.setEnabled(true); 		animSpeed.setVisible(true);
            inputScramble.setEnabled(true); 	inputScramble.setVisible(true);
            applyScramble.setEnabled(true); 	applyScramble.setVisible(true);
            skip.setEnabled(true); 			skip.setVisible(true);
            rewind.setEnabled(true); 		rewind.setVisible(true);
            randomize.setEnabled(true); 		randomize.setVisible(true);

            //Disable all components specific to color selection mode
            sideChoser.setVisible(false); 	sideChoser.setEnabled(false);
            resetCubeInputs.setVisible(false);resetCubeInputs.setEnabled(false);
            setInputs.setVisible(false);		setInputs.setEnabled(false);
        }
        else if(mode.equals(COLOR_SELECTION)) {
            if(inSolution) {
                start.setEnabled(true); 			start.setVisible(true);
                stop.setEnabled(true); 			stop.setVisible(true);
                animSpeed.setEnabled(true); 		animSpeed.setVisible(true);
                skip.setEnabled(true); 			skip.setVisible(true);
                rewind.setEnabled(true); 		rewind.setVisible(true);

                randomize.setEnabled(false); 	randomize.setVisible(false);
                sideChoser.setVisible(false); 	sideChoser.setEnabled(false);
                resetCubeInputs.setVisible(false);resetCubeInputs.setEnabled(false);
                setInputs.setVisible(false);		setInputs.setEnabled(false);
            } else if(!inSolution) {
                start.setEnabled(false); 		start.setVisible(false);
                stop.setEnabled(false); 			stop.setVisible(false);
                animSpeed.setEnabled(false); 	animSpeed.setVisible(false);
                randomize.setEnabled(false); 	randomize.setVisible(false);

                skip.setEnabled(false); 			skip.setVisible(false);
                rewind.setEnabled(false); 		rewind.setVisible(false);
                sideChoser.setVisible(true); 	sideChoser.setEnabled(true);
                resetCubeInputs.setVisible(true);resetCubeInputs.setEnabled(true);
                setInputs.setVisible(true);		setInputs.setEnabled(true);
            }
            //Disable all components specific to text scramble mode
            inputScramble.setEnabled(false); inputScramble.setVisible(false);
            applyScramble.setEnabled(false); applyScramble.setVisible(false);
        }
    }

    /**
     * Updates the mode to either text scramble or color selection mode based on the parameter.
     * @param str the mode to change to
     */
    public void updateMode(String str) {
        if(!mode.equals(str)) {
            mode = new String(str);
            cube = new Cube();
            if(mode.equals(TEXT_SCRAMBLE)) {
                scramble = DEFAULT_SCRAMBLE;
                resetScramble(scramble);
                inSolution = true;
            }
            updateElements();
            repaint();
        }
    }


    public void setInSolution(boolean inSoln) {
        inSolution = inSoln;
    }

//   Updates the phase stating Sunflower, Whitecross and such
    public void updatePhase() {
        if(movesIndex >= movesToPerform.length()) {
            switch(phase) {
                case 0:
                    movesToPerform = whiteCross;
                    phaseString = "White Cross"; break;
                case 1:
                    movesToPerform = whiteCorners;
                    phaseString = "White Corners"; break;
                case 2:
                    movesToPerform = secondLayer;
                    phaseString = "Second Layer"; break;
                case 3:
                    movesToPerform = yellowCross;
                    phaseString = "Yellow Cross";break;
                case 4:
                    movesToPerform = OLL;
                    phaseString = "OLL";break;
                case 5:
                    movesToPerform = PLL;
                    phaseString = "PLL";break;
                case 6:
                    movesToPerform = " ";
                    phaseString = "Solved"; phase--;
                    frameTimer.stop();
            }
            phase++; movesIndex = 0;
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        mousePressed(e);
    }

//      Takes in mouse inputs during color selection mode for selecting and inputting colors

    @Override
    public void mousePressed(MouseEvent e) {
        if(mode.equals(COLOR_SELECTION) && !inSolution) {
            if(e.getY() > 200 && e.getY() < 200+CUBIE_SIZE*3) {
                int i = (e.getY() - 200)/CUBIE_SIZE;
                int j = (e.getX() - 250)/CUBIE_SIZE;
                colorsInputed[getIndexOfSide(sideChosen)][i][j] = colorSelected;
                repaint();
            } else if(e.getY() > 450 && e.getY() < 450+CUBIE_SIZE) {
                BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2 = image.createGraphics();
                this.paint(g2);
                int color = image.getRGB(e.getX(), e.getY());
                g2.dispose();
                switch(color) {
                    case(-65536): 		colorSelected = 'R'; break; //Red
                    case(-16711936): 	colorSelected = 'G'; break; //Green
                    case(-16776961): 	colorSelected = 'B'; break; //Blue
                    case(-256): 			colorSelected = 'Y'; break; //Yellow
                    case(-14336): 		colorSelected = 'O'; break; //Orange
                    case(-1): 			colorSelected = 'W'; break; //White
                }
                repaint();
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}



