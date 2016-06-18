package datatest;

/**
 *
 * @author Jeferson
 */
public class DataTestPG extends DataTestBase {

    public DataTestPG() {
        driverName = "org.postgresql.Driver";
        serverName = "localhost:5432";
        database = "test";
        userName = "postgres";
        password = "pass";
        url = "jdbc:postgresql://" + serverName + "/" + database;
        name = "PG";
    }
}
