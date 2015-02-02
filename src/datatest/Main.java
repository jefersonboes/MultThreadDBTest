package datatest;

/**
 *
 * @author Jeferson
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i;

        if (args.length > 0) {
            switch (args[0]) {
                case "fb": {
                    for (i = 0; i < 10; i++) {
                        ThProcessFB thProcessFB = new ThProcessFB();
                        thProcessFB.start();
                    }
                    break;
                }
                case "pg": {
                    for (i = 0; i < 10; i++) {
                        ThProcessPG thProcessPG = new ThProcessPG();
                        thProcessPG.start();
                    }
                    break;
                }
            }
        }
    }
}
