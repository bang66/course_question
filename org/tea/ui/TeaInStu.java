package org.tea.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import org.tea.utils.Server;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TeaInStu {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	

	/**
	 * Create the application.
	 */
	public TeaInStu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(640, 260, 612, 504);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5F55\u5165\u5B66\u751F\u4FE1\u606F");
		lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 28));
		lblNewLabel.setBounds(206, 13, 224, 69);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("学   号");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 26));
		lblNewLabel_1.setBounds(53, 102, 111, 30);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("姓   名");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 26));
		lblNewLabel_2.setBounds(53, 156, 91, 28);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("班   级");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 26));
		lblNewLabel_3.setBounds(53, 209, 111, 28);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u7167\u7247url");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 26));
		lblNewLabel_4.setBounds(53, 262, 111, 26);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 20));
		textField.setBounds(231, 103, 213, 39);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_1.setBounds(231, 156, 213, 39);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_2.setBounds(231, 208, 213, 41);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_3.setBounds(231, 263, 213, 35);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		
		//录入学生信息并判断信息完整
		JButton btnNewButton = new JButton("\u5F55\u5165");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String id=textField.getText();
				String name=textField_1.getText();
				String classString=textField_2.getText();
				String url=textField_3.getText();
				
				if (id!=null&&!id.equals("")&&name!=null&&!name.equals("")&&classString!=null&&!classString.equals("")&&url!=null&&!url.equals("")) {
					Server server=new Server();
					server.insertStu(id, name, classString, url);
					frame.dispose();
				}else {
					String errString="学生信息不能为空！";
					TeaError teaError=new TeaError(errString);
					teaError.getFrame().setVisible(true);
				}
				
			}
		});
		
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.setBounds(32, 395, 124, 35);
		frame.getContentPane().add(btnNewButton);
		
		
		//进入输入路径界面
		JButton btnNewButton_1 = new JButton("\u4ECE\u6587\u4EF6\u5BFC\u5165");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				TeaInPath teaInPath=new TeaInPath();
				teaInPath.getFrame().setVisible(true);
				
			}
		});
		
		
		
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_1.setBounds(206, 395, 165, 35);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton button = new JButton("返回");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.dispose();
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		button.setBounds(428, 395, 124, 35);
		frame.getContentPane().add(button);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
