
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;

import java.util.ArrayList;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;

/**
 * This class responsible for displaying the fractal output
 *
 * @author Romero J.H. Hutapea
 * @version 6/7/2020
 */
public class DisplayObserver extends JFrame implements Observer {
    //------------------------------------------------
    // INSTANCE VARIABLES
    //------------------------------------------------
    /** The subject that is being attached to this class    **/
    private Subject subject;
    
    /** The collections of shapes                           **/
    private ArrayList<Shape> fractalElementsColl;
    
    /** The toolkit for the drawing output                  **/
    private Toolkit toolkit;
    
    /** The drawing panel                                   **/
    private DPanel panel;
    
    /** Drawing panel width                                 **/
    public static final int DP_WIDTH = 700;
    
    /** Drawing panel height                                **/
    public static final int DP_HEIGHT = 700;

    //------------------------------------------------
    // CONTRUCTORS
    //------------------------------------------------
    /**
     * Constructor for objects of class DrawingPanel
     * 
     * @param subject the subject that is going to be attached to this class
     */
    public DisplayObserver(Subject subject) {

        this.subject = subject;
        subject.registerObserver(this);

        // Setting up frame

        setSize(DP_WIDTH + 17, DP_HEIGHT + 40);
        setTitle("Drawing Panel");
        toolkit = getToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        setLocation((screenSize.width - getWidth()) / 2,
            (screenSize.height - getHeight()) / 2);
        setResizable(false);

        // Setting up panel 
        panel = new DPanel();
        getContentPane().add(panel);
        panel.setLayout(null);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void update() {
        fractalElementsColl = subject.getFractalElements();
        panel.repaint();
        setVisible(true);
    }

    /**
     * This class responsible for creating the drawing panel
     */
    private class DPanel extends JPanel {
        /**
         * {@inheritDoc}
         */
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);      
            for (Shape aShape : fractalElementsColl) {
                aShape.draw(DP_WIDTH, DP_HEIGHT, g);
            }
        }
    }
}
