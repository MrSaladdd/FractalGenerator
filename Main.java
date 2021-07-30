
/**
 * Main Class
 *
 * @author Romero J.H. Hutapea
 * @version 6/7/2020
 */
public class Main {
    
    /**
     * The place where it all begin...
     *
     * @param args required param for main
     */
    public static void main(String[] args) {
        FractalGeneratorSubject fgs = new FractalGeneratorSubject();
        Gui gui = new Gui(fgs);
        DisplayObserver display = new DisplayObserver(fgs);
    }
}
