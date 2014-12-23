package main;
import java.io.UnsupportedEncodingException;
import java.sql.*;

public class JDBCTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, UnsupportedEncodingException {



        JdbcService jdbcService = new JdbcService();
        jdbcService.insert("sdfsdf");


//            ResultSet rs = jdbcService.getAll();

//            System.out.println("-----------------");
//            System.out.println("执行结果如下所示:");
//            System.out.println("-----------------");
//            System.out.println(" 学号" + "\t" + " 姓名");
//            System.out.println("-----------------");
//
//            String name = null;
//
//            while(rs.next()) {
//
//                // 选择sname这列数据
//                name = rs.getString("sname");
//
//                // 首先使用ISO-8859-1字符集将name解码为字节序列并将结果存储新的字节数组中。
//                // 然后使用GB2312字符集解码指定的字节数组
//                name = new String(name.getBytes("ISO-8859-1"),"GB2312");
//
//                // 输出结果
//                System.out.println(rs.getString("sno") + "\t" + name);
//            }

    }
}