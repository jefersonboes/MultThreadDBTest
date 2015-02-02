package datatest;

/**
 *
 * @author Jeferson
 */
public class DataTestFB extends DataTestBase {

    public DataTestFB() {
        driverName = "org.firebirdsql.jdbc.FBDriver";
        serverName = "localhost:3050";
        mydatabase = "C:\\Users\\Jeferson\\Desktop\\mydb\\MYDB.fdb";
        url = "jdbc:firebirdsql://" + serverName + "/" + mydatabase;
        username = "sysdba";
        password = "masterkey";
        name = "FB";
    }
}
