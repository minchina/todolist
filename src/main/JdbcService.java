package main;


import java.sql.*;
import java.sql.Statement;

public class JdbcService {
    private final String driver = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://127.0.0.1:3306/scutcs";
    private final String user = "root";
    private final String password = "";


    private Connection getConnection(){
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void insert(String value) throws SQLException, ClassNotFoundException {
        String sqlString = "INSERT INTO list(name) VALUE ('"+value+"')";
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        try {
            statement.executeUpdate(sqlString);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                statement.close();
                connection.close();
            }catch (SQLException e){
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
