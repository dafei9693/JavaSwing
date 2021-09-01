package windows;

import JDBC.SqlControl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class WorkerDelete extends JFrame implements ActionListener {
    SqlControl sqlControl = new SqlControl();
    JFrame jf = new JFrame();
    TextField tf = new TextField("菜品编号");
    JButton btn = new JButton("删除");

    public void init(){
        jf.setTitle("选项");
        jf.setSize(500, 400);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setLayout(null);

        tf.setFont(new Font("",Font.ITALIC,16));
        tf.setBounds(100,100,200,40);

        btn.setFont(new Font("",Font.ITALIC,16));
        btn.setBounds(100,200,200,40);
        btn.addActionListener(this::actionPerformed);

        jf.add(tf);
        jf.add(btn);

        jf.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            sqlControl.deleteDish(tf.getText());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
    }
}
