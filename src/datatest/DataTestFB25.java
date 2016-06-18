package datatest;

/**
 *
 * @author Jeferson
 */
public class DataTestFB25 extends DataTestBase {

    public DataTestFB25() {
        driverName = "org.firebirdsql.jdbc.FBDriver";
        serverName = "localhost:3050";
        database = "E:\\MYDB2_5.FDB";        
        url = "jdbc:firebirdsql://" + serverName + "/" + database;
        userName = "sysdba";
        password = "masterkey";
        name = "FB25";
    }
}
