package datatest;

/**
 *
 * @author Jeferson
 */
public class DataTestPG extends DataTestBase {

    public DataTestPG() {
        driverName = "org.postgresql.Driver";
        serverName = "localhost:5432";
        mydatabase = "test";
        username = "postgres";
        password = "pass";
        url = "jdbc:postgresql://" + serverName + "/" + mydatabase;
        name = "PG";
    }
}
