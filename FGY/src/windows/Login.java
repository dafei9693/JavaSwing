package windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    javax.swing.JFrame jf = new javax.swing.JFrame();
    public void init(){
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setTitle("餐厅点餐数据库系统");
        jf.setSize(800, 400);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setLayout(null);

        javax.swing.JLabel label = new javax.swing.JLabel("餐厅点餐数据库系统");
        label.setFont(new Font("",Font.BOLD,34));
        label.setBounds(230,100,360,30);

        javax.swing.JButton jbu1 = new javax.swing.JButton("员工");
        jbu1.setBounds(230,200,100,25);
        jbu1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new WorkerLogin().init();
            }
        });
        //按钮
        javax.swing.JButton jbu = new javax.swing.JButton("用户");
        jbu.setBounds(480,200,100,25);
        jbu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UserLogin().init();
            }
        });

        jf.add(label);
        jf.add(jbu1);
        jf.add(jbu);

        jf.setVisible(true);
        jf.repaint();
    }

}


