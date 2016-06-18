package datatest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jeferson
 */
public abstract class DataTestBase {

    protected String driverName = "";
    protected String serverName = "";
    protected String database = "";
    protected String url = "";
    protected String userName = "";
    protected String password = "";
    protected String name = "";

    private void createTable() {
        try {
            stmt = connection.createStatement();

            String sql = "create table test(test varchar(128), test2 varchar(128), test3 varchar(128), test4 varchar(128), test5 varchar(128), test6 varchar(128), test7 varchar(128), test8 varchar(128), test9 varchar(128), test10 varchar(128))";
            pstmt = connection.prepareStatement(sql);
            pstmt.execute();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    private void dropTable() {
        try {
            stmt = connection.createStatement();

            String sql = "drop table test";
            pstmt = connection.prepareStatement(sql);
            pstmt.execute();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void unPrepareTest() {
        loadDriver();
        connect();
        dropTable();
    }

    public void prepareTest() {
        loadDriver();
        connect();
        createTable();
    }

    private void executeSelect() {
        try {
            stmt = connection.createStatement();

            String sql = "select * from test";
            pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            String text;

            int i = 1;
            while (rs.next()) {
                text = rs.getString(1);
                text = rs.getString(2);
                text = rs.getString(3);
                text = rs.getString(4);
                text = rs.getString(5);
                text = rs.getString(6);
                text = rs.getString(7);
                text = rs.getString(8);
                text = rs.getString(9);
                text = rs.getString(10);

                if (i % 5000 == 0) {
                    System.out.println(name + " Select: " + i + " name: " + Thread.currentThread().getName());
                }
                i++;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void testSelect() {
        loadDriver();
        connect();
        executeSelect();
    }

    public void testInsert() {
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

            connection = DriverManager.getConnection(url, userName, password);
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
            int i;

            System.out.println(name + " Start: " + Thread.currentThread().getName());

            final String text = "test of string adsf5544635476#@¨%$&wtefds56fd4fgdf4s6g64532&%$¨@# test of string 9164325780";

            for (i = 1; i <= 10000; i++) {
                pstmt.setString(1, text);
                pstmt.setString(2, text);
                pstmt.setString(3, text);
                pstmt.setString(4, text);
                pstmt.setString(5, text);
                pstmt.setString(6, text);
                pstmt.setString(7, text);
                pstmt.setString(8, text);
                pstmt.setString(9, text);
                pstmt.setString(10, text);
                pstmt.executeUpdate();

                if (i % 1000 == 0) {
                    System.out.println(name + " Posted: " + i + " name: " + Thread.currentThread().getName());
                }
            }

            System.out.println(name + " Finished: " + Thread.currentThread().getName());
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
