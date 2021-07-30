
import java.awt.Graphics;

/**
 * The interface for a shape component
 *
 * @author Romero J.H. Hutapea
 * @version 6/6/2020
 */
public interface Shape {
    
    /**
     * Draw this shape into the output pabel
     * 
     * @param outputWidth the output width
     * @param outputHeight the output height
     * @param g The Graphics object for drawing into the output panel
     */
    public void draw(int outputWidth, int outputHeight, Graphics g);
    
}
