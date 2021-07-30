
import java.awt.Color;

/**
 * The class that stores all the data from GUI.
 *
 * @author Romero J.H. Hutappea
 * @version 6/7/2020
 */
public class FractalData {
    
    //------------------------------------------------
    // INSTANCE VARIABLES
    //------------------------------------------------
    
    /** cactus color for fractal the drawing    **/
    public Color cactusColor;
    
    /** pear color for the fractal drawing      **/
    public Color pearColor;
    
    /** Child ratio for the fractal drawing     **/
    public double childRatio;
    
    /** Child angle for the fractal drawing     **/
    public double childAngle;
    
    /** Parent size for the fractal drawing     **/
    public double parentSize;
    
    /** Recursion depth for the fractal drawing **/
    public int recursionDepth;
    
    /** Indicator to have more fractals or not  **/
    public boolean moreFractal;
   
    //------------------------------------------------
    // CONTRUCTORS
    //------------------------------------------------
    
    /**
     * Construct this class
     */
    public FractalData() {
        // Set the fields to zero equivalent values
    }

}
