
import java.util.ArrayList;
import java.util.Random;
import java.util.*;


public class Element extends DrawableImage {

    private int speed;
    private boolean movingRight;

    int rank;
    private Random random = new Random();
    int yPos = random.nextInt(this.getWindowHeight() - this.getHeight());
    int xPos = random.nextInt(this.getWindowWidth() - this.getWidth());
    double dxPos = getNextSpeed() * (random.nextBoolean() ? 1 : -1);
    double dyPos = getNextSpeed() * (random.nextBoolean() ? 1 : -1);


    public Element(DrawingPanel drawArea, String imageFile, int speed, int rank) {

        super(drawArea, imageFile, 120, 120);
        this.setSpeed(speed);
        this.rank = rank;
    }

    public void initialize() {

        int xPos, yPos;
        yPos = random.nextInt(this.getWindowHeight() - this.getHeight());
        xPos = random.nextInt(this.getWindowWidth() - this.getWidth());

        this.setX(xPos);
        this.setY(yPos);
    }

    public void moveOneStep() {
        xPos += dxPos;
        yPos += dyPos;
        if (xPos + this.getWidth() > this.getDrawArea().getWidth()) {
            xPos = this.getDrawArea().getWidth() - this.getWidth();
            dxPos = -getNextSpeed();
        } else if (xPos < 0) {
            xPos = 0;
            dxPos = getNextSpeed();
        }
        if (yPos + this.getHeight() > this.getDrawArea().getHeight()) {
            yPos = this.getDrawArea().getHeight() - this.getHeight();
            dyPos = -getNextSpeed();
        } else if (yPos < 0) {
            yPos = 0;
            dyPos = getNextSpeed();
        }
        this.setX(xPos);
        this.setY(yPos);
    }


    private double getNextSpeed() {
        return 2 * Math.PI * (0.5 + random.nextDouble());
    }


    public void setSpeed(int speed) {
        this.speed = speed;
    }



}
