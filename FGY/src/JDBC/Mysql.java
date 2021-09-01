package JDBC;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Mysql {
    public void insert(String sql) throws SQLException, ClassNotFoundException;
    public void delete(String sql) throws SQLException, ClassNotFoundException;
    public void update(String sql) throws SQLException, ClassNotFoundException;
    public ArrayList search(String sql) throws SQLException, ClassNotFoundException;
}