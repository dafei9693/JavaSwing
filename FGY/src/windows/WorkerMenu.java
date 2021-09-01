package windows;

import JDBC.SqlControl;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class WorkerMenu extends JFrame {
    SqlControl sqlControl = new SqlControl();
    JFrame jf = new JFrame();



    public void init() throws SQLException, ClassNotFoundException {
        ArrayList menu = sqlControl.getMenu();
        jf.setTitle("菜单");
        jf.setSize(800, 600);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setLayout(null);


        for(int i=-1;i<menu.size();i++){
            if(i==-1){
                JLabel label = new JLabel("菜品编号");
                label.setFont(new Font("",Font.ITALIC,12));
                label.setBounds(150,50+i*40,100,40);

                JLabel label1 = new JLabel("菜名");
                label1.setFont(new Font("",Font.ITALIC,12));
                label1.setBounds(290,50+i*40,100,40);

                JLabel label2 = new JLabel("价格/元");
                label2.setFont(new Font("",Font.ITALIC,12));
                label2.setBounds(430,50+i*40,100,40);

                jf.add(label);
                jf.add(label1);
                jf.add(label2);
            }
            else {
                ArrayList row = (ArrayList) menu.get(i);
                JLabel label = new JLabel((String) row.get(0));
                label.setFont(new Font("", Font.ITALIC, 12));
                label.setBounds(150, 50 + i * 40, 100, 40);

                JLabel label1 = new JLabel((String) row.get(1));
                label1.setFont(new Font("", Font.ITALIC, 12));
                label1.setBounds(290, 50 + i * 40, 100, 40);

                JLabel label2 = new JLabel((String) row.get(2));
                label2.setFont(new Font("", Font.ITALIC, 12));
                label2.setBounds(430, 50 + i * 40, 100, 40);

                jf.add(label);
                jf.add(label1);
                jf.add(label2);
            }

        }
        jf.setVisible(true);
    }
}
