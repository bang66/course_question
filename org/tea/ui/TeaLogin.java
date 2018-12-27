package org.tea.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JTextField;

import org.tea.utils.Connect;
import org.tea.utils.Server;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TeaLogin {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}


	/**
	 * Create the application.
	 */
	public TeaLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(700, 350, 500, 321);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u8BFE\u5802\u63D0\u95EE\u5668(\u6559\u5E08\u7AEF)");
		label.setFont(new Font("黑体", Font.PLAIN, 26));
		label.setBounds(120, 13, 245, 55);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("i d");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(57, 95, 98, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(57, 148, 78, 34);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 18));
		textField.setBounds(148, 94, 178, 34);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("宋体", Font.PLAIN, 18));
		passwordField.setBounds(149, 149, 177, 36);
		frame.getContentPane().add(passwordField);
		
		
		//教师端登录系统
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String id=textField.getText();
				String passwd=passwordField.getText();
				Server server=new Server();
				String jdbcPass=server.getPass(id);
				if (jdbcPass.equals(passwd)) {
					frame.setVisible(false);
					TeaHall teaHall = new TeaHall();
					teaHall.getFrame().setVisible(true);
					
				}else {
					String errString="您的帐号或者密码有误！";
					TeaError teaError=new TeaError(errString);
					teaError.getFrame().setVisible(true);
				}
				
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(80, 211, 113, 29);
		frame.getContentPane().add(btnNewButton);
		
		
		//进入教师端注册
		JButton button = new JButton("\u6CE8\u518C");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				TeaRegist teaRegist=new TeaRegist();
				teaRegist.getFrame().setVisible(true);
				
			}
		});
		button.setBounds(252, 212, 113, 27);
		frame.getContentPane().add(button);
	}
	
	
	
	
	
}
