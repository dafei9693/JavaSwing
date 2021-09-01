package windows;

import JDBC.SqlControl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SwitchPrice extends JFrame implements ActionListener {
    SqlControl sqlControl = new SqlControl();
    JFrame jf = new JFrame();
    TextField tf1 = new TextField("菜品编号");
    TextField tf2 =new TextField("新价格");
    JButton btn = new JButton("修改");

    public void init(){
        jf.setTitle("修改价格");
        jf.setSize(400, 600);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setLayout(null);

        tf1.setFont(new Font("",Font.ITALIC,16));
        tf1.setBounds(100,100,200,40);

        tf2.setFont(new Font("",Font.ITALIC,16));
        tf2.setBounds(100,200,200,40);

        btn.setFont(new Font("",Font.ITALIC,16));
        btn.setBounds(100,300,200,40);
        btn.addActionListener(this::actionPerformed);

        jf.add(tf1);
        jf.add(tf2);
        jf.add(btn);

        jf.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            sqlControl.SwitchPrice(tf1.getText(),tf2.getText());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
    }
}
