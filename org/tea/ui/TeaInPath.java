package org.tea.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import org.tea.utils.MyUtils;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TeaInPath {

	private JFrame frame;
	private JTextField textField;

	public void setFrame(JFrame frame) {
		this.frame=frame;
		
	}
	
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Create the application.
	 */
	public TeaInPath() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(720, 300, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("请输入文件的路径");
		label.setFont(new Font("宋体", Font.PLAIN, 24));
		label.setBounds(53, 13, 264, 63);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 24));
		textField.setBounds(53, 99, 264, 50);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		//输入路径信息，并提交txt文件到db
		JButton btnNewButton = new JButton("确认");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String filepath=textField.getText();
				//调用录入学生信息的方法
				boolean state=MyUtils.inStu(filepath);
				if (state==true) {
					frame.dispose();
				}else {
					String errString="路径不合理或者文件不存在！";
					TeaError teaError=new TeaError(errString);
					teaError.getFrame().setVisible(true);
				}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 28));
		btnNewButton.setBounds(46, 185, 120, 44);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 28));
		btnNewButton_1.setBounds(242, 185, 120, 44);
		frame.getContentPane().add(btnNewButton_1);
	}
}
