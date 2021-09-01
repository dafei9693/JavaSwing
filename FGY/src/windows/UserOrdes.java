package windows;

import JDBC.SqlControl;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserOrdes extends JFrame {
    JFrame jf = new JFrame();
    SqlControl sqlControl = new SqlControl();
    String use_id;

    public void init() throws SQLException, ClassNotFoundException {
        this.use_id=new User_id().get();
        ArrayList orders = sqlControl.UserOrders(use_id);
        jf.setTitle("订单");
        jf.setSize(700, 400);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setLayout(null);

        for(int i=-1;i<orders.size();i++){
            if(i==-1){
                JLabel label = new JLabel("菜品编号");
                label.setFont(new Font("",Font.ITALIC,12));
                label.setBounds(150,50+i*40,100,40);

                JLabel label1 = new JLabel("菜名");
                label1.setFont(new Font("",Font.ITALIC,12));
                label1.setBounds(290,50+i*40,100,40);

                JLabel label2 = new JLabel("用户编号");
                label2.setFont(new Font("",Font.ITALIC,12));
                label2.setBounds(430,50+i*40,100,40);

                JLabel label3 = new JLabel("价格/元");
                label3.setFont(new Font("",Font.ITALIC,12));
                label3.setBounds(570,50+i*40,100,40);

                jf.add(label);
                jf.add(label1);
                jf.add(label2);
                jf.add(label3);
            }
            else {
                ArrayList row = (ArrayList) orders.get(i);
                JLabel label = new JLabel((String) row.get(0));
                label.setFont(new Font("", Font.ITALIC, 12));
                label.setBounds(150, 50 + i * 40, 100, 40);

                JLabel label1 = new JLabel((String) row.get(1));
                label1.setFont(new Font("", Font.ITALIC, 12));
                label1.setBounds(290, 50 + i * 40, 100, 40);

                JLabel label2 = new JLabel((String) row.get(2));
                label2.setFont(new Font("", Font.ITALIC, 12));
                label2.setBounds(430, 50 + i * 40, 100, 40);

                JLabel label3 = new JLabel((String) row.get(3));
                label3.setFont(new Font("", Font.ITALIC, 12));
                label3.setBounds(570, 50 + i * 40, 100, 40);

                jf.add(label);
                jf.add(label1);
                jf.add(label2);
                jf.add(label3);
            }

        }

        jf.setVisible(true);
    }
}
