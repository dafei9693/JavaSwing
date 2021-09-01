package JDBC;

import java.sql.*;
import java.util.ArrayList;

public class SqlUser implements Mysql{
    String database;

    public SqlUser(String database) {
        this.database = database;
    }

    private void execute(String sql) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/"+database+
                "?allowPublicKeyRetrieval=true&useSSL=false&useUnicode=true&serverTimezone=GMT%2B8&characterEncoding=utf8";




        String username = "root";
        String password = "jyf20010121";

        Connection connection = DriverManager.getConnection(url, username, password);

        Statement statement = connection.createStatement();
        statement.execute(sql);


        statement.close();
        connection.close();

    }


    @Override
    public void insert(String sql) throws SQLException, ClassNotFoundException {
        execute(sql);
        System.out.println("插入成功");
    }

    @Override
    public void delete(String sql) throws SQLException, ClassNotFoundException {
        execute(sql);
        System.out.println("删除成功");
    }

    @Override
    public void update(String sql) throws SQLException, ClassNotFoundException {
        execute(sql);
        System.out.println("更新成功");
    }

    @Override
    public ArrayList search(String sql) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/"+database+
                "?allowPublicKeyRetrieval=true&useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";

        String username = "root";
        String password = "jyf20010121";

        Connection connection = DriverManager.getConnection(url, username, password);

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        ArrayList list = new ArrayList();


        resultSet.beforeFirst();
        while(resultSet.next()) {
            for(int i=1;i<=resultSet.getMetaData().getColumnCount();i++){
                list.add(resultSet.getString(i));
            }
        }



        resultSet.close();
        statement.close();
        connection.close();
        return list;
    }
}