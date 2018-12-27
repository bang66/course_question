package org.tea.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.tea.utils.Server;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TeaRollCall {

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	private JFrame frame;


	/**
	 * Create the application.
	 */
	public TeaRollCall() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(640, 240, 595, 423);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u70B9\u540D");
		label.setFont(new Font("黑体", Font.PLAIN, 45));
		label.setBounds(231, 13, 193, 73);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		label_1.setBounds(294, 150, 72, 31);
		frame.getContentPane().add(label_1);
		
		
		//点名系统生成随机学号
		JButton btnNewButton = new JButton("\u968F\u673A\u5B66\u53F7");
		btnNewButton.addMouseListener(new MouseAdapter() {
			Server server=new Server();
			@Override
			public void mouseClicked(MouseEvent e) {
				//获取当前学生的数量
				int num=server.getStuNum();
				System.out.println(num+"=============");
				Random random =new Random();
				int id=random.nextInt(num+1);
				if (id!=0) {
					label_1.setText(String.valueOf(id));
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 24));
		btnNewButton.setBounds(65, 143, 153, 49);
		frame.getContentPane().add(btnNewButton);
		
		
		
		//提交点名缺勤信息
		JButton btnNewButton_1 = new JButton("\u8BE5\u751F\u7F3A\u52E4");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String id=label_1.getText();
				if (id.equals("")||id==null) {
					String errString="您还未抽学号，无法提交！";
					TeaError teaError=new TeaError(errString);
					teaError.getFrame().setVisible(true);
					
				}else {
					TeaInTruncy teaInTruncy=new TeaInTruncy(id);
					teaInTruncy.getFrame().setVisible(true);
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 24));
		btnNewButton_1.setBounds(65, 268, 153, 49);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton button = new JButton("返回");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 24));
		button.setBounds(354, 268, 153, 49);
		frame.getContentPane().add(button);
		
		
	}
}
