package datatest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jeferson
 */
public abstract class DataTestBase {

    protected String driverName = "";
    protected String serverName = "";
    protected String mydatabase = "";
    protected String url = "";
    protected String username = "";
    protected String password = "";
    protected String name = "";

    public void test() {
        loadDriver();
        connect();
        prepare();
        execute();
    }

    void loadDriver() {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    Connection connection = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;

    void connect() {
        try {

            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    void prepare() {
        try {
            stmt = connection.createStatement();

            String sql = "insert into test(test, test2, test3, test4, test5, test6, test7, test8, test9, test10) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = connection.prepareStatement(sql);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    void execute() {
        try {
            int i, count;

            count = 0;

            System.out.println(name + " Start: " + Thread.currentThread().getName());

            for (i = 0; i < 10000; i++) {
                pstmt.setString(1, "teste if string adsf5544635476#@¨%$&wtefds56fd4fgdf4s6g64532&%$¨@# test of string 9164325780");
                pstmt.setString(2, "teste if string adsf5544635476#@¨%$&wtefds56fd4fgdf4s6g64532&%$¨@# test of string 9164325780");
                pstmt.setString(3, "teste if string adsf5544635476#@¨%$&wtefds56fd4fgdf4s6g64532&%$¨@# test of string 9164325780");
                pstmt.setString(4, "teste if string adsf5544635476#@¨%$&wtefds56fd4fgdf4s6g64532&%$¨@# test of string 9164325780");
                pstmt.setString(5, "teste if string adsf5544635476#@¨%$&wtefds56fd4fgdf4s6g64532&%$¨@# test of string 9164325780");
                pstmt.setString(6, "teste if string adsf5544635476#@¨%$&wtefds56fd4fgdf4s6g64532&%$¨@# test of string 9164325780");
                pstmt.setString(7, "teste if string adsf5544635476#@¨%$&wtefds56fd4fgdf4s6g64532&%$¨@# test of string 9164325780");
                pstmt.setString(8, "teste if string adsf5544635476#@¨%$&wtefds56fd4fgdf4s6g64532&%$¨@# test of string 9164325780");
                pstmt.setString(9, "teste if string adsf5544635476#@¨%$&wtefds56fd4fgdf4s6g64532&%$¨@# test of string 9164325780");
                pstmt.setString(10, "teste if string adsf5544635476#@¨%$&wtefds56fd4fgdf4s6g64532&%$¨@# test of string 9164325780");
                pstmt.executeUpdate();

                if (count > 100) {
                    System.out.println(name + " Posted: " + i + " name: " + Thread.currentThread().getName());
                    count = 0;
                }

                count++;
            }

            System.out.println(name + " Finished: " + Thread.currentThread().getName());
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
