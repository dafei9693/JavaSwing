import JDBC.SqlControl;
import windows.Login;

import java.io.IOException;
import java.sql.SQLException;

public class index {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        SqlControl sqlControl=new SqlControl();
        new Login().init();
    }
}
