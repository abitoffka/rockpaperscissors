import jaco.mp3.player.MP3Player;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Color;
import java.io.File;
import java.util.Random;
import javax.swing.border.EtchedBorder;


public class Field extends JFrame {

    private DrawingPanel drawingPanel;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Field frame = new Field();
                frame.setVisible(true);
                frame.addContents();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Field() {
        super("Battle Field");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 800);
        drawingPanel = new DrawingPanel();
        drawingPanel.setBackground(Color.white);
        drawingPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        drawingPanel.setLayout(new BorderLayout(0, 0));
        setContentPane(drawingPanel);

        Animator animator = new Animator(this);
        Timer timer = new Timer(200, animator);
        timer.start();
    }

    public void addContents() {
        DrawingPanel dPanel = this.getDrawingPanel();

        Random rand1 = new Random();
        int amount1 = rand1.nextInt(5,10);
        for (int i = 0; i < amount1; i++) {
            dPanel.addElement(new Element(dPanel, "earth.gif", 10, 1));
        }

        Random rand2 = new Random();
        int amount2 = rand2.nextInt(5,10);
        for (int i = 0; i < amount2; i++) {
            dPanel.addElement(new Element(dPanel, "air.gif", 10, 2));
        }

        Random rand3 = new Random();
        int amount3 = rand3.nextInt(5,10);
        for (int i = 0; i < amount3; i++) {
            dPanel.addElement(new Element(dPanel, "water.gif", 10, 3));
        }
        new MP3Player(new File("battle.mp3")).play();
        dPanel.addDrawableImage(new Appa(dPanel, "appa.gif", 2, true));
        dPanel.addDrawableImage(new Zuko(dPanel, "zuko.gif", 2, true));
        dPanel.initializeEverything();
    }

    public DrawingPanel getDrawingPanel() {
        return drawingPanel;
    }

    public void setDrawingPanel(DrawingPanel drawingPanel) {
        this.drawingPanel = drawingPanel;
    }
}
