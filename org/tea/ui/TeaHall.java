package org.tea.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import org.tea.utils.MyUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.JLabel;

public class TeaHall {

	private JFrame frame;

	

	/**
	 * Create the application.
	 */
	public TeaHall() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(620, 300, 630, 385);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		
		
		//进入提问系统
		JButton btnNewButton = new JButton("\u968F\u673A\u63D0\u95EE");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TeaAsk teaAsk=new TeaAsk();
				teaAsk.getFrame().setVisible(true);
				
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 28));
		
		btnNewButton.setBounds(71, 87, 190, 62);
		getFrame().getContentPane().add(btnNewButton);
		
		
		//进入点名系统
		JButton btnNewButton_1 = new JButton("\u968F\u673A\u70B9\u540D");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TeaRollCall teaRollCall=new TeaRollCall();
				teaRollCall.getFrame().setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 28));
		btnNewButton_1.setBounds(329, 87, 190, 62);
		getFrame().getContentPane().add(btnNewButton_1);
		
		
		//进入录入学生信息系统
		JButton btnNewButton_2 = new JButton("\u5F55\u5165\u5B66\u751F\u4FE1\u606F");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				TeaInStu teaInStu=new TeaInStu();
				teaInStu.getFrame().setVisible(true);
				
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 24));
		btnNewButton_2.setBounds(71, 208, 190, 62);
		getFrame().getContentPane().add(btnNewButton_2);
		
		
		//进入导出学生情况系统
		JButton btnNewButton_3 = new JButton("\u5BFC\u51FA\u63D0\u95EE\u4FE1\u606F");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//调用导出学生情况的方法
				MyUtils.outAsk();
				TeaOutAsk teaOutAsk=new TeaOutAsk();
				teaOutAsk.getFrame().setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("宋体", Font.PLAIN, 24));
		btnNewButton_3.setBounds(329, 208, 190, 62);
		getFrame().getContentPane().add(btnNewButton_3);
		
		JLabel label = new JLabel("课堂提问器(教师端)");
		label.setFont(new Font("宋体", Font.PLAIN, 26));
		label.setBounds(165, 13, 245, 55);
		frame.getContentPane().add(label);
		
		JButton btnNewButton_4 = new JButton("退出");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.dispose();
			}
		});
		btnNewButton_4.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_4.setBounds(519, 305, 93, 33);
		frame.getContentPane().add(btnNewButton_4);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
