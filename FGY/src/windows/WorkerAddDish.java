package windows;

import JDBC.SqlControl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class WorkerAddDish extends JFrame implements ActionListener {
    SqlControl sqlControl = new SqlControl();
    JFrame jf = new JFrame();
    TextField tf1 = new TextField("菜品编号");
    TextField tf2 =new TextField("菜品名");
    TextField tf3 = new TextField("价格");
    JButton btn = new JButton("增加");

    public void init(){
        jf.setTitle("增加菜品");
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

        btn.setFont(new Font("",Font.ITALIC,16));
        btn.setBounds(100,400,200,40);
        btn.addActionListener(this::actionPerformed);

        jf.add(tf1);
        jf.add(tf2);
        jf.add(tf3);
        jf.add(btn);

        jf.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            ArrayList data = sqlControl.addDish(tf1.getText(),tf2.getText(),tf3.getText());
            if(data.get(0).equals("Success"))
                JOptionPane.showConfirmDialog(null, "增加成功", "Confirm",
                        JOptionPane.OK_CANCEL_OPTION);
            if(data.get(0).equals("AllReadyExists"))
                JOptionPane.showConfirmDialog(null, "已经存在", "Confirm",
                        JOptionPane.OK_CANCEL_OPTION);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
    }
}
