
import java.awt.Color;
import java.awt.Graphics;

/**
 * This class responsible for creating a circle shape
 *
 * @author Romero J.H. Hutappea
 * @version 6/7/2020
 */
public class Circle implements Shape {
    //------------------------------------------------
    // INSTANCE VARIABLES
    //------------------------------------------------
    /** The diameter of the circle              **/
    public double diameter;
    
    /** The radius of the circle                **/
    public double radius;
    
    /** The center x coordinate of the circle   **/
    public double centerX;
    
    /** The center y coordinate of the circle   **/
    public double centerY;
    
    /** The color for the circle                **/
    public Color color;

    //------------------------------------------------
    // CONTRUCTORS
    //------------------------------------------------
    /**
     * Constructs a circle object
     * 
     * @param centerX The center x coordinate of the circle
     * @param centerY The center y coordinate of the circle
     * @param radius The radius of the circle 
     * @param color The color for the circle  
     */
    public Circle( double centerX, double centerY, double radius, Color color) {
       this.diameter = radius * 2;
       this.radius = radius;
       this.centerX = centerX;
       this.centerY = centerY;
       this.color = color;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void draw(int outputWidth, int outputHeight, Graphics g) {
        int small = Math.min(outputWidth, outputHeight);
        
        int rad = (int)Math.round(radius * small);
        
        int x = (int)Math.round((centerX * outputWidth) - rad);     
        
        int y = (int)Math.round((centerY * outputHeight) - rad );  
        
        g.setColor(color);
        
        g.fillOval(x, y, rad * 2, rad * 2);
    }
}
