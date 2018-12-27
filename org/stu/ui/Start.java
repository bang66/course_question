package org.stu.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.tea.ui.TeaLogin;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Start {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start window = new Start();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Start() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(700, 320, 541, 375);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("课堂提问器");
		lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 45));
		lblNewLabel.setBounds(123, 13, 236, 52);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("教师端");
		//监听鼠标事件
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				TeaLogin teaLogin=new TeaLogin();
				teaLogin.getFrame().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 28));
		btnNewButton.setBounds(41, 189, 141, 52);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("学生端");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				StuLogin stuLogin=new StuLogin();
				stuLogin.getFrame().setVisible(true);
				
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 28));
		btnNewButton_1.setBounds(347, 189, 131, 52);
		frame.getContentPane().add(btnNewButton_1);
	}

}
