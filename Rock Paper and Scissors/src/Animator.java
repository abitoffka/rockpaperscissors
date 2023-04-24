import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Animator implements ActionListener {

    private Field field;

    public Animator(Field field) {
        this.setField(field);
    }

    public void actionPerformed(ActionEvent arg0) {

        Field field = this.getField();
        DrawingPanel dPanel = field.getDrawingPanel();

        dPanel.moveEverythingOneStep();
        for (Element image : field.getDrawingPanel().getElements()) {
            for (Element next : field.getDrawingPanel().getElements()) {
                if (Math.abs(image.getX() - next.getX()) < image.getWidth()*3/4) {
                    if (Math.abs(image.getY() - next.getY()) < image.getHeight()*3/4) {
                        if (image.rank == 3 && next.rank == 2) {
                            image.change(next.imageFile);
                        } else if (image.rank == 3 && next.rank == 1) {
                            next.change(image.imageFile);
                        }
                        if (image.rank == 2 && next.rank == 1) {
                            image.change(next.imageFile);
                        } else if (image.rank == 2 && next.rank == 3) {
                            next.change(image.imageFile);
                        }
                        if (image.rank == 1 && next.rank == 3) {
                            image.change(next.imageFile);
                        } else if (image.rank == 1 && next.rank == 2) {
                            next.change(image.imageFile);
                        }
                        dPanel.repaint();
                    }
                }
            }
        }
        dPanel.repaint();
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }


}

