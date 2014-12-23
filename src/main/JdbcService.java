package main;


import java.sql.*;

public class JdbcService {
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://127.0.0.1:3306/scutcs";
    private String user = "root";
    private String password = "";

    public void insert(String val) throws SQLException, ClassNotFoundException {
        System.out.println(val);
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(driver);
            conn = DriverManager
                    .getConnection(url,user,password);
            stmt = conn.createStatement();
            String sql = "INSERT INTO list(name) VALUES('nihao')";
            System.out.println(sql);
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public ResultSet getAll() throws SQLException, ClassNotFoundException {
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, user, password);

        if(!conn.isClosed())
            System.out.println("Succeeded connecting to the Database!");
        java.sql.Statement statement = conn.createStatement();

        String sql = "select * from student";
        return statement.executeQuery(sql);

    }
}
