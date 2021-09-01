package windows;

import JDBC.SqlControl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AddNewUser extends JFrame implements ActionListener {
    SqlControl sqlControl = new SqlControl();
    JFrame jf = new JFrame();
    TextField tf1 = new TextField("用户名");
    TextField tf2 =new TextField("姓名");
    TextField tf3 = new TextField("手机号");
    TextField tf4 = new TextField("登陆密码");
    JButton btn = new JButton("确定");

    public void init(){
        jf.setTitle("用户注册");
        jf.setSize(400, 600);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setLayout(null);

        tf1.setFont(new Font("",Font.ITALIC,16));
        tf1.setBounds(100,100,200,40);

        tf2.setFont(new Font("",Font.ITALIC,16));
        tf2.setBounds(100,200,200,40);

        tf3.setFont(new Font("",Font.ITALIC,16));
        tf3.setBounds(100,300,200,40);

        tf4.setFont(new Font("",Font.ITALIC,16));
        tf4.setBounds(100,400,200,40);

        btn.setFont(new Font("",Font.ITALIC,16));
        btn.setBounds(100,500,200,40);
        btn.addActionListener(this::actionPerformed);

        jf.add(tf1);
        jf.add(tf2);
        jf.add(tf3);
        jf.add(tf4);
        jf.add(btn);

        jf.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            sqlControl.AddNewUser(tf1.getText(),tf2.getText(),tf4.getText(),tf3.getText());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
    }
}
