package windows;

import JDBC.SqlControl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UserSetOrder extends JFrame implements ActionListener{
    SqlControl sqlControl = new SqlControl();
    JFrame jf = new JFrame();
    JTextField jt = new JTextField("菜品编号");
    JTextField jt1 = new JTextField("用户ID");
    JButton btn = new JButton("提交");

    public void init(){
        jf.setTitle("下单");
        jf.setSize(500, 400);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setLayout(null);

        jt.setBounds(200,80,150,40);
        jt.setFont(new Font("",Font.ITALIC,16));

        jt1.setBounds(200,150,150,40);
        jt1.setFont(new Font("",Font.ITALIC,16));

        btn.setBounds(200,210,70,40);
        btn.setFont(new Font("",Font.ITALIC,16));
        btn.addActionListener(this);

        jf.add(jt);
        jf.add(btn);
        jf.add(jt1);

        jf.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            this.sqlControl.addOrder(this.jt1.getText(),this.jt.getText());
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}
