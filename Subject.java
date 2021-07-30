
import java.util.ArrayList;

/**
 * Interface for Subject
 *
 * @author Romero J.H. Hutapea
 * @version 6/7/2020
 */
public interface Subject {
    
    /**
     * Register an observer to this class
     * 
     * @param observer intended observer to add
     */
    public void registerObserver(Observer observer);
    
    /**
     * Remove an observer from this class
     * 
     * @param observer intended observer to remove
     */
    public void removeObserver(Observer observer);
    
    /**
     * Notify all observers that something interesting have happened 
     *
     */
    public void notifyObservers();
    
    /**
     * Set the data needed for a subject
     * 
     * @param data the data subject needed to properly run
     */
    public void setData(FractalData data);
    
    /**
     * Retrieve the collections of shape that is being generated; Which later makes a fractal
     * 
     * @return the collections that have been added with shapes
     */
    public ArrayList<Shape> getFractalElements();
    
}
