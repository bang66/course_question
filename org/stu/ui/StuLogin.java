package org.stu.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StuLogin {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Create the application.
	 */
	public StuLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(700, 320, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("课堂提问器(学生端)");
		lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 28));
		lblNewLabel.setBounds(69, 13, 260, 44);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("学号");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(88, 113, 72, 29);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 20));
		textField.setBounds(174, 115, 86, 32);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("登录");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//从textfield中获取到id的值
				String id=textField.getText();
				//通过含参构造器传入id到StuChang界面
				StuChange stuChange=new StuChange(id);
				stuChange.getFrame().setVisible(true);
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		button.setBounds(130, 191, 113, 29);
		frame.getContentPane().add(button);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
