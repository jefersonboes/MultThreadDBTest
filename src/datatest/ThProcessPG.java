package datatest;

/**
 *
 * @author Jeferson
 */
public class ThProcessPG extends Thread implements Runnable {

    @Override
    public void run() {
        DataTestPG dataTestPG = new DataTestPG();
        dataTestPG.test();
    }
}
