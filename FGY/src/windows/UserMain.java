package windows;

import JDBC.SqlControl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UserMain extends JFrame{
    SqlControl sqlControl = new SqlControl();
    JFrame jf = new JFrame();
    JButton btn1 = new JButton("查看订单");
    JButton btn2 = new JButton("查看菜品");
    JButton btn3 = new JButton("下单");
    JButton btn4 = new JButton("查询菜品");

    public void init(){
        jf.setTitle("选项");
        jf.setSize(800, 500);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setLayout(null);

        btn1.setFont(new Font("",Font.ITALIC,12));
        btn1.setBounds(325,70,120,40);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new UserOrdes().init();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }
        });

        btn2.setFont(new Font("",Font.ITALIC,12));
        btn2.setBounds(325,130,120,40);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e ) {
                try {
                    new UserMenu().init();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }
        });

        btn3.setFont(new Font("",Font.ITALIC,12));
        btn3.setBounds(325,190,120,40);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UserSetOrder().init();
            }
        });

        btn4.setFont(new Font("",Font.ITALIC,12));
        btn4.setBounds(325,250,120,40);
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UserQuery().init();
            }
        });



        jf.add(btn1);
        jf.add(btn2);
        jf.add(btn3);
        jf.add(btn4);

        jf.setVisible(true);
    }

}
