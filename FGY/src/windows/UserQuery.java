package windows;

import JDBC.SqlControl;
import JDBC.SqlUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserQuery extends JFrame implements ActionListener {
    SqlControl sqlControl = new SqlControl();
    JFrame jf = new JFrame();
    TextField tf1 = new TextField("菜品名");
    JButton btn = new JButton("查询");

    void init(){
        jf.setTitle("查询");
        jf.setSize(400, 300);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setLayout(null);

        tf1.setFont(new Font("",Font.ITALIC,16));
        tf1.setBounds(70,100,150,35);

        btn.setFont(new Font("",Font.ITALIC,16));
        btn.setBounds(70,160,100,30);
        btn.addActionListener(this);


        jf.add(tf1);
        jf.add(btn);

        jf.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            ArrayList data=sqlControl.getSelectedMenu(this.tf1.getText());
            new UserQueryResult().init(data);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
    }
}
