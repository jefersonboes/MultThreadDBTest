package datatest;

/**
 *
 * @author Jeferson
 */
public class Main {

    private static void createThreads(String arg) {
        int numThreads;
        
        if (arg.contains("-p") || arg.contains("-u"))
            numThreads = 1;
        else
            numThreads = 10;
        
        for (int i = 0; i < numThreads; i++) {
            new Thread(() -> {
                DataTestBase dataTest = null;

                if (arg.contains("fb25")) {
                    dataTest = new DataTestFB25();
                } else if (arg.contains("fb3")) {
                    dataTest = new DataTestFB3();
                } else if (arg.contains("pg")) {
                    dataTest = new DataTestPG();
                }

                if (dataTest != null) {
                    if (arg.contains("-i")) {
                        dataTest.testInsert();
                    }
                    if (arg.contains("-s")) {
                        dataTest.testSelect();
                    }
                    if (arg.contains("-p")) {
                        dataTest.prepareTest();                        
                    }
                    if (arg.contains("-u")) {
                        dataTest.unPrepareTest();                        
                    }
                }
            }).start();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i;

        if (args.length == 0) {
            System.out.println(
                    "Help\n"
                    + "fb25 fb3 pg\n"
                    + "-p Create tables\n"
                    + "-u Drop tables\n"
                    + "-i Insert test\n"
                    + "-s Select test\n");
        }

        if (args.length > 0) {
            for (String arg : args) {
                createThreads(arg);
            }
        }
    }
}
