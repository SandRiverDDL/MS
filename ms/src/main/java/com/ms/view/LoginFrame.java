/*
 * Created by JFormDesigner on Mon May 30 21:18:08 CST 2022
 */

package com.ms.view;

import com.ms.dao.UserDao;
import com.ms.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * @author unknown
 */
public class LoginFrame extends JFrame {
    public LoginFrame() {
        initComponents();
        this.setResizable(false);
    }

    private void loginBtnMouseClicked(MouseEvent e) {
        // TODO add your code here
        String username = this.nameField.getText();
        char[] arr= this.adminPassword.getPassword();
        String password=new String(arr);
        User user =new User();
        UserDao userDao=new UserDao();
        if(userDao.selectuser(username,password))
        {
            JOptionPane.showMessageDialog(this,"登陆成功");
        }
        else
        {
            JOptionPane.showMessageDialog(this,"用户名密码错误");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("LoginFrame");
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        adminPassword = new JPasswordField();
        nameField = new JFormattedTextField();
        loginBtn = new JButton();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        label4 = new JLabel();

        //======== this ========
        setFont(new Font(Font.DIALOG, Font.PLAIN, 15));
        setTitle("\u767b\u5f55");
        setIconImage(new ImageIcon(getClass().getResource("/image/apple.png")).getImage());
        setBackground(new Color(238, 238, 238));
        setMinimumSize(new Dimension(400, 280));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText(bundle.getString("LoginFrame.label1.text"));
        label1.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 15));
        label1.setIcon(new ImageIcon(getClass().getResource("/image/\u7528\u6237\u540d.png")));

        //---- label2 ----
        label2.setText(bundle.getString("LoginFrame.label2.text"));
        label2.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 15));
        label2.setIcon(new ImageIcon(getClass().getResource("/image/\u5bc6\u7801.png")));

        //---- label3 ----
        label3.setText(bundle.getString("LoginFrame.label3.text"));
        label3.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 30));
        label3.setHorizontalAlignment(SwingConstants.CENTER);

        //---- adminPassword ----
        adminPassword.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 15));

        //---- nameField ----
        nameField.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 15));

        //---- loginBtn ----
        loginBtn.setText(bundle.getString("LoginFrame.loginBtn.text"));
        loginBtn.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 15));
        loginBtn.setIcon(null);
        loginBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loginBtnMouseClicked(e);
            }
        });

        //---- radioButton1 ----
        radioButton1.setText(bundle.getString("LoginFrame.radioButton1.text"));

        //---- radioButton2 ----
        radioButton2.setText(bundle.getString("LoginFrame.radioButton2.text"));

        //---- label4 ----
        label4.setText(bundle.getString("LoginFrame.label4.text"));
        label4.setForeground(Color.darkGray);
        label4.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 12));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(80, 80, 80)
                            .addComponent(label3))
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(loginBtn, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))
                            .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(label1)
                                    .addComponent(label2))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                        .addComponent(radioButton1)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(radioButton2))
                                    .addComponent(adminPassword, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                    .addComponent(nameField, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(label4)))
                    .addContainerGap(81, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(label3)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(22, 22, 22)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(adminPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(radioButton2)
                        .addComponent(radioButton1, GroupLayout.Alignment.TRAILING))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(loginBtn)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(label4)
                    .addContainerGap(10, Short.MAX_VALUE))
        );
        setSize(400, 280);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JPasswordField adminPassword;
    private JFormattedTextField nameField;
    private JButton loginBtn;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JLabel label4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        LoginFrame loginFrame=new LoginFrame();
        loginFrame.setVisible(true);
    }
}
