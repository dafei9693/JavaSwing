package windows;

import JDBC.SqlControl;
import com.mysql.cj.x.protobuf.MysqlxCrud;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class WorkerLogin extends JFrame implements ActionListener{
    SqlControl sqlControl = new SqlControl();
    javax.swing.JFrame jf = new javax.swing.JFrame();
    javax.swing.JLabel label = new JLabel("员工登录");
    javax.swing.JTextField uname = new javax.swing.JTextField("username");
    javax.swing.JTextField pword = new javax.swing.JTextField("password");
    javax.swing.JButton jbu1 = new javax.swing.JButton("登录");
    public void init(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setTitle("员工登录");
        jf.setSize(800, 400);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setLocationRelativeTo(null);

        jf.setLayout(null);

        label.setFont(new Font("",Font.ITALIC,28));
        label.setBounds(300,100,200,40);

        uname.setBounds(100,200,150,25);

        pword.setBounds(280,200,150,25);

        jbu1.setBounds(500,200,100,25);
        jbu1.addActionListener((ActionListener) this);

        jf.add(label);
        jf.add(uname);
        jf.add(pword);
        jf.add(jbu1);

        jf.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (sqlControl.getPword(this.uname.getText()).size()==0) {
                JOptionPane.showConfirmDialog(null, "账号或密码错误", "Confirm",
                        JOptionPane.OK_CANCEL_OPTION);
            }
            else {
                if (this.pword.getText().equals(sqlControl.getPword(this.uname.getText()).get(0))) {
                    new User_id().set(this.uname.getText());
                    new WorkerMain().init();
                } else
                    JOptionPane.showConfirmDialog(null, "账号或密码错误", "Confirm",
                            JOptionPane.OK_CANCEL_OPTION);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
    }
}
