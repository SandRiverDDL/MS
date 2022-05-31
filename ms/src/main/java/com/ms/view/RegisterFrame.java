/*
 * Created by JFormDesigner on Tue May 31 17:06:10 CST 2022
 */

package com.ms.view;

import com.ms.dao.BaseDao;
import com.ms.model.User;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.plaf.*;

/**
 * @author unknown
 */
public class RegisterFrame extends JFrame {
    public RegisterFrame() {
        initComponents();
        this.setResizable(false);
    }

    public static void main(String[] args) {
        RegisterFrame registerFrame=new RegisterFrame();
        registerFrame.setVisible(true);
    }

    private void registerBtnMouseClicked(MouseEvent e)  {
        String username = this.nameField2.getText();
        char[] arr= this.adminPassword2.getPassword();
        String password=new String(arr);
        User user =new User();
        BaseDao baseDao=new BaseDao();
        String sql = "select * from user where username=?";
        List<User> list = baseDao.getInstanceList(User.class,sql,username);
        if(list.isEmpty()){
            try {
                BaseDao baseDao1 = new BaseDao();
                String sql1 = "insert into user(username, password) values(?,?)";
                baseDao1.update(sql1, username, password);
                JOptionPane.showMessageDialog(this,"注册成功");
                //跳转主页
            }catch(Exception a){
                a.printStackTrace();
                JOptionPane.showMessageDialog(this,"注册失败");
                RegisterFrame registerFrame=new RegisterFrame();
                registerFrame.setVisible(true);
                this.dispose();
        }}
        else{
            JOptionPane.showMessageDialog(this,"用户已存在");
            RegisterFrame registerFrame=new RegisterFrame();
            registerFrame.setVisible(true);
            this.dispose();
        }

        // TODO add your code here
    }

    private void loginBtnMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("LoginFrame");
        label5 = new JLabel();
        nameField2 = new JFormattedTextField();
        label6 = new JLabel();
        label7 = new JLabel();
        adminPassword2 = new JPasswordField();
        registerBtn = new JButton();

        //======== this ========
        setMinimumSize(new Dimension(400, 270));
        setTitle("\u6ce8\u518c");
        setIconImage(new ImageIcon(getClass().getResource("/image/bg.jpg")).getImage());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setName("frame2");
        setMaximizedBounds(new Rectangle(0, 0, 400, 270));
        var contentPane = getContentPane();

        //---- label5 ----
        label5.setText(bundle.getString("RegisterFrame.label5.text"));
        label5.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 30));
        label5.setHorizontalAlignment(SwingConstants.CENTER);

        //---- nameField2 ----
        nameField2.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 15));

        //---- label6 ----
        label6.setText(bundle.getString("RegisterFrame.label6.text"));
        label6.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 15));
        label6.setIcon(new ImageIcon(getClass().getResource("/image/\u7528\u6237\u540d.png")));

        //---- label7 ----
        label7.setText(bundle.getString("RegisterFrame.label7.text"));
        label7.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 15));
        label7.setIcon(new ImageIcon(getClass().getResource("/image/\u5bc6\u7801.png")));

        //---- adminPassword2 ----
        adminPassword2.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 15));

        //---- registerBtn ----
        registerBtn.setText("\u6ce8\u518c");
        registerBtn.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 15));
        registerBtn.setIcon(new ImageIcon(getClass().getResource("/image/\u65b0\u589e.png")));
        registerBtn.setSelectedIcon(new ImageIcon(getClass().getResource("/image/\u65b0\u589e.png")));
        registerBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loginBtnMouseClicked(e);
                registerBtnMouseClicked(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(47, 47, 47)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addComponent(label5))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label6)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(nameField2, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(registerBtn, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addComponent(label7)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(adminPassword2, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(79, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(label5)
                    .addGap(15, 15, 15)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(nameField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(20, 20, 20)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label7)
                        .addComponent(adminPassword2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(registerBtn)
                    .addContainerGap(40, Short.MAX_VALUE))
        );
        setSize(400, 280);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label5;
    private JFormattedTextField nameField2;
    private JLabel label6;
    private JLabel label7;
    private JPasswordField adminPassword2;
    private JButton registerBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
