package datatest;

/**
 *
 * @author Jeferson
 */
public class DataTestFB3 extends DataTestBase {

    public DataTestFB3() {
        driverName = "org.firebirdsql.jdbc.FBDriver";
        serverName = "localhost:3053";
        database = "E:\\MYDB3.FDB";
        url = "jdbc:firebirdsql://" + serverName + "/" + database;
        userName = "sysdba";
        password = "masterkey";
        name = "FB3";
    }
}
