package org.example.rubyfinal;


public class Cubie {

    //Store x, y, and z positions of a cubie
    private int x;
    private int y;
    private int z;
    private boolean corner;
    private boolean edge;
    //Store the set of colors associated with a cubie; accessible to all subclasses
    protected CubieColor[] colors;

    /**
     * Constructs a Cubie object
     * Sets the location of the cubie
     */
    public Cubie (int xPos, int yPos, int zPos, CubieColor[] nColors, boolean isCorner,
                  boolean isEdge) {
        x = xPos;
        y = yPos;
        z = zPos;
        corner = isCorner;
        edge = isEdge;
        colors = nColors;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public int getZ() {
        return z;
    }


    public char getDirOfColor(char color) {
        for(int i = 0; i<colors.length; i++) {
            if(colors[i].getColor() == color)
                return colors[i].getDir();
        }
        return 'A';
    }


    public char getColorOfDir(char dir) {
        for(int i = 0; i<colors.length; i++) {
            if(colors[i].getDir() == dir)
                return colors[i].getColor();
        }
        return 'A';
    }


    public CubieColor[] getColors() {
        return colors;
    }


    public void setColors(CubieColor[] newColors) {
        this.colors = newColors;
    }


    public void setColorOfDir(char dir, char ncolor) {
        for(int i = 0; i<colors.length; i++) {
            if(colors[i].getDir() == dir)
                colors[i].setColor(ncolor);
        }
    }


    public boolean isCornerCubie() {
        return corner;
    }


    public boolean isEdgeCubie() {
        return edge;
    }


    public char verticalFace(int x, int y) {
        if(edge) {
            if(x == 0) return 'L';
            else if(x == 1) {
                if(y == 0) {
                    return 'F';
                }
                else return 'B';
            }
            else return 'R';
        }
        return 'A';

    }


    public boolean isWhiteCorner() {
        if(corner) {
            return (colors[0].getColor()=='W'|| colors[1].getColor()=='W' || colors[2].getColor()=='W');
        }
        return false;
    }

}
