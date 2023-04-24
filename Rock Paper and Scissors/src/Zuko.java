
import java.util.Random;


public class Zuko extends DrawableImage {

    private int speed;
    private boolean movingRight;

    public Zuko(DrawingPanel drawArea, String imageFile, int speed, boolean facingRight) {

        super(drawArea, imageFile, 140, 150);
        this.setSpeed(speed);
        this.setMovingRight(facingRight);
    }

    public void initialize() {

        int xPos, yPos;
        yPos = this.getWindowHeight() - this.getHeight();
        if (isMovingRight()) {
            xPos = 0;

        } else {
            xPos = this.getWindowWidth() - this.getWidth();
        }
        this.setX(xPos);
        this.setY(yPos);
    }

    public void moveOneStep() {

        int nextX = 0;

        if (this.getX() < 0) {
            reverseDirection();
        } else if (this.getX() > this.getWindowWidth() - this.getWidth()){
            reverseDirection();
        }

        if (this.movingRight) {
            nextX = this.getX() + this.getSpeed();
        } else {
            nextX = this.getX() - this.getSpeed();
        }

        this.setX(nextX);
    }

    protected void reverseDirection() {

        this.horizontalFlip();
        boolean movingRight = this.isMovingRight();
        this.setMovingRight(!movingRight);
    }



    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isMovingRight() {
        return movingRight;
    }

    public void setMovingRight(boolean movingRight) {
        this.movingRight = movingRight;
    }

}
