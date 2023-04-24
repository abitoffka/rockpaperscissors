import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.ImageIcon;


public class DrawingPanel extends JPanel {

    private ArrayList<Element> elements = new ArrayList();
    private ArrayList<DrawableImage> drawableImages = new ArrayList();

    public DrawingPanel() { }

    @Override
    protected void paintComponent(Graphics g) {

        ImageIcon img = new ImageIcon("backgroundAang.jpeg");
        super.paintComponent(g);
        g.drawImage(img.getImage(), 0, 0, null);
    }
    public void initializeEverything() {

        // Go through and initialize each item
        for (DrawableImage image : this.getElements()) {
            image.initialize();
        }
        for (DrawableImage image : this.getDrawableImages()) {
            image.initialize();
        }
    }

    public void moveEverythingOneStep() {

        // Go through and move each item one step
        for (Element image : this.getElements()) {
            image.moveOneStep();
        }
        for (DrawableImage image : this.getDrawableImages()) {
            image.moveOneStep();
        }

    }

    public void paint(Graphics g) {

        super.paint(g);

        for (Element image : this.getElements()) {
            image.draw(g);
        }
        for (DrawableImage image : this.getDrawableImages()) {
            image.draw(g);
        }
    }

    public void addElement(Element elem) {
        this.getElements().add(elem);
    }

    public void addDrawableImage(DrawableImage image) {
        this.getDrawableImages().add(image);
    }
    public ArrayList<Element> getElements() {
        return elements;
    }

    public ArrayList<DrawableImage> getDrawableImages() {
        return drawableImages;
    }

    public void setDrawableImages(ArrayList<Element> elements) {
        this.elements = elements;
    }

}
