
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JCheckBox;

import javax.swing.JSlider;
import javax.swing.JLabel;

import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Color;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

/**
 * Gui Class that interact with user
 *
 * @author Romero J.H. Hutappea
 * @version 6/7/2020
 */
public class Gui extends JFrame {

    //--------------------------------------------------
    /** The slider for recursion depth              **/
    private JSlider recursionDepthSlider;
    
    /** The name label for recursion depth          **/
    private JLabel recursionDepthLabel;
    
    /** The amount label for the recursion depth    **/
    private JLabel depthAmountLabel;
    //--------------------------------------------------
    /** The slider for child ratio                  **/
    private JSlider childRatioSlider;
    
    /** The name label for child ratio              **/
    private JLabel childRatioLabel;
    
    /** The amount label for child ratio            **/
    private JLabel ratioAmountLabel;
    //--------------------------------------------------
    /** The slider for child angle                  **/
    private JSlider childAngleSlider;
    
    /** The name label for child angle              **/
    private JLabel childAngleLabel;
    
    /** The amount label for child angle            **/
    private JLabel angleAmountLabel;
    //--------------------------------------------------
    /** The slider for parent size                  **/
    private JSlider parentSizeSlider;
    
    /** The name label for parent size              **/
    private JLabel parentSizeLabel;
    
    /** The amount label for parent size            **/
    private JLabel parentSizeAmountLabel;
    //--------------------------------------------------
    /** The button for cactus color                 **/
    private JButton cactusColorButton;
    
    /** The button for pear color                   **/
    private JButton pearColorButton;

    /** The button for draw button                  **/
    private JButton drawButton;
    
    /** The button for resetting all the state      **/
    private JButton resetButton;
    
    /** The checkbox for requesting more fractals   **/
    private JCheckBox moreFractalCheck;
    
    /** The subject of this class                   **/
    private Subject subject;
    
    /** The data retrieved from this GUI            **/
    private FractalData data;
    
    /** The toolkit for this GUI                    **/
    private Toolkit toolkit;
    //--------------------------------------------------
    /** The default color for cactus                **/
    public static final Color CACTUS_COLOR_DEFAULT = Color.GREEN;
    
    /** The default color for pear                  **/
    public static final Color PEAR_COLOR_DEFAULT = Color.PINK;
    
    /** The default amount for recursion depth      **/
    public static final int RECURSION_DEPTH_DEFAULT = 10;
    
    /** The default amount for child ratio          **/
    public static final int CHILD_RATIO_DEFAULT = 60;
    
    /** The default amount for child angle          **/
    public static final int CHILD_ANGLE_DEFAULT = 45;
    
    /** The default amount for parent size          **/
    public static final int PARENT_SIZE_DEFAULT = 15;
    
    /** Default state for more fractal              **/
    public static final boolean MORE_FRACTAL_DEFAULT = false;
    

    /**
     * Constructs the Gui
     *
     * @param subject the subject for the gui
     */
    public Gui(Subject subject) {
        
        //-------------Set Up-------------
        data = new FractalData();       
        this.subject = subject;
        toolkit = getToolkit();
        setSize(440, 460);
        setTitle("Prickly Pear Drawing Tool");
        Dimension screenSize = toolkit.getScreenSize();
        setLocation((screenSize.width - getWidth()) / 2,
            (screenSize.height - getHeight()) / 2);
        setResizable(false);

        //--------------construct components--------------

        // Sliders
        recursionDepthSlider = new JSlider (2, 10, RECURSION_DEPTH_DEFAULT);
        recursionDepthLabel = new JLabel ("Recursion Depth");
        depthAmountLabel = new JLabel ("" + RECURSION_DEPTH_DEFAULT);
        
        childRatioSlider = new JSlider (40, 70, CHILD_RATIO_DEFAULT);
        childRatioLabel = new JLabel ("Child Ratio");
        ratioAmountLabel = new JLabel ("" + CHILD_RATIO_DEFAULT);
        
        childAngleSlider = new JSlider (30, 60, CHILD_ANGLE_DEFAULT);        
        childAngleLabel = new JLabel ("Child Angle");
        angleAmountLabel = new JLabel ("" + CHILD_ANGLE_DEFAULT);
        
        parentSizeSlider = new JSlider (1, 20, PARENT_SIZE_DEFAULT);
        parentSizeLabel = new JLabel ("Parent Size");
        parentSizeAmountLabel = new JLabel ("" + PARENT_SIZE_DEFAULT);

        // Buttons
        cactusColorButton = new JButton ("Cactus Color");
        cactusColorButton.setActionCommand("Cactus");
        pearColorButton = new JButton ("Pear Color");
        pearColorButton.setActionCommand("Pear");
        drawButton = new JButton ("Draw!");
        resetButton = new JButton ("Reset");
        
        // Check Box
        moreFractalCheck = new JCheckBox ("More Fractals!", MORE_FRACTAL_DEFAULT);

        //-----------set components properties-----------------
        
        recursionDepthSlider.setOrientation (JSlider.HORIZONTAL);
        recursionDepthSlider.setMinorTickSpacing (0);
        recursionDepthSlider.setMajorTickSpacing (1);
        recursionDepthSlider.setPaintTicks (true);
        recursionDepthSlider.setPaintLabels (false);
        childRatioSlider.setOrientation (JSlider.HORIZONTAL);
        childRatioSlider.setMinorTickSpacing (1);
        childRatioSlider.setMajorTickSpacing (5);
        childRatioSlider.setPaintTicks (true);
        childRatioSlider.setPaintLabels (false);
        childAngleSlider.setOrientation (JSlider.HORIZONTAL);
        childAngleSlider.setMinorTickSpacing (1);
        childAngleSlider.setMajorTickSpacing (5);
        childAngleSlider.setPaintTicks (true);
        childAngleSlider.setPaintLabels (false);
        childAngleLabel.setToolTipText ("in degrees");
        parentSizeSlider.setOrientation (JSlider.HORIZONTAL);
        parentSizeSlider.setMinorTickSpacing (1);
        parentSizeSlider.setMajorTickSpacing (5);
        parentSizeSlider.setPaintTicks (true);
        parentSizeSlider.setPaintLabels (false);

        //--------------adding action listeners-------------
        
        // Sliders
        recursionDepthSlider.addChangeListener(
            new SliderChangeListener(recursionDepthSlider, depthAmountLabel));
        childRatioSlider.addChangeListener(
            new SliderChangeListener(childRatioSlider, ratioAmountLabel));
        childAngleSlider.addChangeListener(
            new SliderChangeListener(childAngleSlider, angleAmountLabel));
        parentSizeSlider.addChangeListener(
            new SliderChangeListener(parentSizeSlider, parentSizeAmountLabel));

        // Buttons
        ColorActionListener cactusColorListener = new ColorActionListener(cactusColorButton);
        ColorActionListener pearColorListener = new ColorActionListener(pearColorButton);
        cactusColorButton.addActionListener(cactusColorListener);
        pearColorButton.addActionListener(pearColorListener);

        resetButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    recursionDepthSlider.setValue(RECURSION_DEPTH_DEFAULT);
                    childRatioSlider.setValue(CHILD_RATIO_DEFAULT);
                    childAngleSlider.setValue(CHILD_ANGLE_DEFAULT);
                    parentSizeSlider.setValue(PARENT_SIZE_DEFAULT);
                    cactusColorListener.reset(CACTUS_COLOR_DEFAULT);
                    pearColorListener.reset(PEAR_COLOR_DEFAULT);
                    moreFractalCheck.setSelected(MORE_FRACTAL_DEFAULT);
                }
            }
        );

        drawButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    data.cactusColor = cactusColorListener.getColor();
                    data.pearColor = pearColorListener.getColor();
                    data.childRatio = childRatioSlider.getValue() / (double)100;
                    data.parentSize = parentSizeSlider.getValue() / (double)100;
                    data.childAngle = Math.toRadians(childAngleSlider.getValue());
                    data.recursionDepth = recursionDepthSlider.getValue();
                    data.moreFractal = moreFractalCheck.isSelected();
                    subject.setData(data);                    
                }
            }
        );
        
        //------------------add components------------------
        
        add (recursionDepthSlider);
        add (recursionDepthLabel);
        add (childRatioSlider);
        add (childRatioLabel);
        add (cactusColorButton);
        add (pearColorButton);
        add (drawButton);
        add (depthAmountLabel);
        add (ratioAmountLabel);
        add (resetButton);
        add (childAngleSlider);
        add (angleAmountLabel);
        add (childAngleLabel);
        add (moreFractalCheck);
        add (parentSizeSlider);
        add (parentSizeLabel);
        add (parentSizeAmountLabel);

        //------------------set component bounds------------------
        
        recursionDepthSlider.setBounds (10, 55, 245, 55);
        recursionDepthLabel.setBounds (80, 30, 100, 25);
        childRatioSlider.setBounds (15, 135, 245, 50);
        childRatioLabel.setBounds (105, 110, 100, 25);
        cactusColorButton.setBounds (310, 100, 110, 25);
        pearColorButton.setBounds (310, 185, 110, 25);
        drawButton.setBounds (250, 370, 100, 25);
        depthAmountLabel.setBounds (260, 65, 20, 25);
        ratioAmountLabel.setBounds (260, 145, 20, 25);
        resetButton.setBounds (110, 370, 100, 25);
        childAngleSlider.setBounds (15, 215, 245, 55);
        angleAmountLabel.setBounds (260, 225, 20, 25);
        childAngleLabel.setBounds (95, 190, 70, 25);
        moreFractalCheck.setBounds (310, 265, 110, 25);
        parentSizeSlider.setBounds (10, 300, 250, 45);
        parentSizeLabel.setBounds (100, 275, 100, 25);
        parentSizeAmountLabel.setBounds (260, 305, 100, 25);
        
        //------------------------------------------------------
        
        setLayout (null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * The listener class for a JSlider
     */
    private class SliderChangeListener implements ChangeListener {
        
        /** The slider that being watched upon    **/
        private JSlider slider;
        
        /** Current slider amount label         **/
        private JLabel sliderAmountLabel;

        /**
         * Constructs the slider listener class
         *
         * @param slider The slider that being watched upon
         * @param sliderAmountLabel Current slider amount label
         */
        public SliderChangeListener(JSlider slider, JLabel sliderAmountLabel) {
            this.slider = slider;
            this.sliderAmountLabel = sliderAmountLabel;
        }

        /**
         * The action that executed everytime the slider changes state
         *
         * @param e event indicator
         */
        public void stateChanged(ChangeEvent e) {
            sliderAmountLabel.setText("" + slider.getValue());
        }
    }

    /**
     * The listener class for the JButton that creates JColorPicker
     */
    private class ColorActionListener implements ActionListener {
        
        /** The button that is being watched upon       **/
        public JButton button;
        
        /** The color chooser for this button           **/
        public JColorChooser colorChooser;

        /**
         * Constructs the button listener that creates JColorPicker
         *
         * @param button The button that is being applied to
         */
        public ColorActionListener(JButton button) {
            this.button = button;
            colorChooser = new JColorChooser();
            if (button.getActionCommand().equals("Cactus")) {
                colorChooser.setColor(CACTUS_COLOR_DEFAULT);
            } else {
                colorChooser.setColor(PEAR_COLOR_DEFAULT);
            }
        }

        /**
         * Resetting the color of the JColorPicker
         *
         * @param color intended color
         */
        public void reset(Color color) {
            button.setBackground(color);
            colorChooser.setColor(color);
        }

        /**
         * Retrieve the color from the Color Picker
         *
         * @return The color from the color picker panel
         */
        public Color getColor() {
            return colorChooser.getColor();
        }

        /**
         * The action that executed everytime the button is pressed
         *
         * @param e event indicator
         */
        public void actionPerformed(ActionEvent e) {
            // Frame set up
            JFrame frame = new JFrame();
            Dimension dimension = toolkit.getScreenSize();
            frame.setTitle("Color Chooser");
            frame.setSize(615, 500);
            frame.setLocation((dimension.width - getWidth()) / 2,
                (dimension.height - getHeight()) / 2);
            frame.setResizable(false);

            // Panel set up
            JPanel panel = new JPanel();
            frame.getContentPane().add(panel);
            panel.setLayout(null);

            //construct components
            JButton okButton = new JButton ("OK");
            JButton cancelButton = new JButton ("Cancel");
            JButton resetButton = new JButton ("Reset");

            //add components
            panel.add (okButton);
            panel.add (cancelButton);
            panel.add (resetButton);

            //set component bounds (only needed by Absolute Positioning)
            okButton.setBounds (120, 405, 100, 20);
            cancelButton.setBounds (270, 405, 100, 20);
            resetButton.setBounds (420, 405, 100, 20);

            // Adding color chooser;

            colorChooser.setBounds(0, 0, 600, 400);

            if (e.getActionCommand().equals("Cactus")) {
                colorChooser.setColor(CACTUS_COLOR_DEFAULT);
            } else {
                colorChooser.setColor(PEAR_COLOR_DEFAULT);
            }

            panel.add(colorChooser);

            // Adding button listener            
            okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        button.setBackground(colorChooser.getColor());
                        frame.setVisible(false);
                    }
                }
            );

            cancelButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frame.setVisible(false);
                    }
                }
            );

            resetButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent a) {
                        if (e.getActionCommand().equals("Cactus")) {
                            colorChooser.setColor(CACTUS_COLOR_DEFAULT);
                        } else {
                            colorChooser.setColor(PEAR_COLOR_DEFAULT);
                        }
                    }
                }
            );

            button.setOpaque(true);
            frame.setVisible(true);
        }
    }
}