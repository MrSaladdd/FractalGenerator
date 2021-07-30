
import java.util.ArrayList;

/**
 * The class that responsible for being subject and generating shapes
 *
 * @author Romero J.H. Hutappea
 * @version 6/7/2020
 */
public class FractalGeneratorSubject implements Subject {
    //------------------------------------------------
    // INSTANCE VARIABLES
    //------------------------------------------------
    /** The subscribers that listen to this class               **/
    private ArrayList<Observer> subscribers;

    /** The data needed for generating the fracta; shapes       **/
    private FractalData data;

    //------------------------------------------------
    // CONTRUCTORS
    //------------------------------------------------
    /**
     * Constructs this class
     */
    public FractalGeneratorSubject() {
        subscribers = new ArrayList<Observer>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void registerObserver(Observer observer) {
        if (observer == null) {
            throw new IllegalArgumentException("Observer can't be null");
        }
        subscribers.add(observer);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeObserver(Observer observer){
        if (observer == null) {
            throw new IllegalArgumentException("Observer can't be null");
        }
        subscribers.remove(observer);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void notifyObservers(){
        for (Observer aSubscriber: subscribers) {
            aSubscriber.update();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setData(FractalData data) {
        if (data == null) {
            throw new IllegalArgumentException("data can't be null");
        }
        this.data = data;
        notifyObservers();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArrayList<Shape> getFractalElements() {
        ArrayList<Shape> shapeColl = new ArrayList<Shape>();

        double centerRatio = 1 + data.childRatio;

        if (data.moreFractal) {
            drawCircle(0.5, 0.5, data.parentSize, Math.toRadians(90), data.recursionDepth, centerRatio, -1, shapeColl); 
            drawCircle(0.5, 0.5, data.parentSize, Math.toRadians(90), data.recursionDepth, centerRatio, 1, shapeColl);
        } else {
            drawCircle(0.5, 1 - data.parentSize, data.parentSize, Math.toRadians(90), 
                data.recursionDepth, centerRatio, -1, shapeColl); 
        }

        return shapeColl;
    }

    /**
     * Generates shape which later becomes a fractal
     * 
     * @param centerX The center x coordinate of the circle
     * @param centerY The center y coordinate of the circle
     * @param radius the radius of the circle
     * @param angle the starting angle for the circle
     * @param recursionDepth the repetition for the drawing
     * @param centerRatio the ratio of the center
     * @param inverse value that makes the circle to be inversed
     * @param shapeColl the collection of shape that will be added upon
     */
    private void drawCircle(double centerX, double centerY, double radius, double angle, 
        int recursionDepth, double centerRatio, int inverse, ArrayList<Shape> shapeColl) {
        if (recursionDepth == 1) {
            Circle childCircle = new Circle(centerX, centerY, radius, data.pearColor);
            shapeColl.add(childCircle);
        } else {
            Circle childCircle = new Circle(centerX, centerY, radius, data.cactusColor);
            shapeColl.add(childCircle);

            // Recurse to the right
            double newAngleRight = angle - data.childAngle;
            double rightX = centerRatio * radius * Math.cos(newAngleRight) + centerX;
            double rightY = inverse * (centerRatio * radius * Math.sin(newAngleRight)) + (centerY);

            drawCircle(rightX, rightY,
                radius * data.childRatio, newAngleRight, recursionDepth - 1, centerRatio, inverse, shapeColl);

            // Recurse to the left
            double newAngleLeft = angle + data.childAngle;
            double leftX = centerRatio * radius * Math.cos(newAngleLeft) + centerX;
            double leftY = inverse * (centerRatio * radius * Math.sin(newAngleLeft)) + (centerY);

            drawCircle(leftX, leftY,
                radius * data.childRatio, newAngleLeft, recursionDepth - 1, centerRatio, inverse, shapeColl);
        }
    }
}
