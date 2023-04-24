
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;


public abstract class DrawableImage extends DrawableItem {

    private Image image;

    String imageFile;

    private int height;

    private int width;

    private boolean flipHoriz = false;

    private boolean flipVert = false;

    public DrawableImage(DrawingPanel drawArea, String imageFile, int width, int height) {

        super(drawArea);

        Image image = Toolkit.getDefaultToolkit().getImage(imageFile);
        this.imageFile = imageFile;
        this.setImage(image);
        this.setHeight(height);
        this.setWidth(width);
    }

    public void change(String imageFile) {
        Image image = Toolkit.getDefaultToolkit().getImage(imageFile);
        this.imageFile = imageFile;
        this.setImage(image);
    }

    public void draw(Graphics g) {

        int dx1, dy1, dx2, dy2;

        if (this.flipHoriz) {
            dx1 = this.getX() + this.getWidth();
            dx2 = this.getX();
        } else {
            dx1 = this.getX();
            dx2 = this.getX() + this.getWidth();
        }

        if (this.flipVert) {
            dy1 = this.getY() + this.getHeight();
            dy2 = this.getY();
        } else {
            dy1 = this.getY();
            dy2 = this.getY() + this.getHeight();
        }

        g.drawImage(getImage(),
                dx1, dy1, dx2, dy2,
                0 , 0, this.getImage().getWidth(null), this.getImage().getHeight(null),
                null);
    }

    public void horizontalFlip() {
        this.flipHoriz = !this.flipHoriz;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return this.image;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
