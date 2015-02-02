package datatest;

/**
 *
 * @author Jeferson
 */
public class ThProcessFB extends Thread implements Runnable {

    @Override
    public void run() {        
        DataTestFB dataTestFB = new DataTestFB();
        dataTestFB.test();
    }
}
