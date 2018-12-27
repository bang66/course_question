package org.tea.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JTextField;

import org.tea.utils.Server;

import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JComboBox;

public class TeaAsk {

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	private JFrame frame;
	private JTextField textField;

	

	/**
	 * Create the application.
	 */
	public TeaAsk() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(660, 220, 621, 525);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("提问");
		lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 45));
		lblNewLabel.setBounds(225, 13, 99, 58);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(222, 129, 72, 32);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		//生成随机学号
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
					lblNewLabel_1.setText(String.valueOf(id));
				}
				
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 23));
		btnNewButton.setBounds(38, 129, 127, 43);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u8BE5\u751F\u7F3A\u52E4");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id=lblNewLabel_1.getText();
				
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
		btnNewButton_1.setBounds(374, 126, 153, 49);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("课程名称");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(38, 218, 121, 43);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 24));
		textField.setBounds(189, 218, 192, 43);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("提问情况");
		label.setFont(new Font("宋体", Font.PLAIN, 24));
		label.setBounds(38, 289, 127, 43);
		frame.getContentPane().add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("宋体", Font.PLAIN, 24));
		comboBox.setToolTipText("");
		comboBox.setBounds(189, 289, 192, 43);
		comboBox.addItem("非常好");
		comboBox.addItem("良好");
		comboBox.addItem("一般");
		
		frame.getContentPane().add(comboBox);
		
		
		//提交信息到db
		JButton btnNewButton_2 = new JButton("提交");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String sid=lblNewLabel_1.getText();
				String cname=textField.getText();
				String quest_state=String.valueOf( comboBox.getSelectedItem());
				
				if (!sid.equals("")&&sid!=null&&cname!=null&&!cname.equals("")) {

					Server server=new Server();
					server.insertAsk(cname, sid,quest_state);
					frame.dispose();
					
					
				}else {
					String errString="信息不完整，无法提交！";
					TeaError teaError=new TeaError(errString);
					teaError.getFrame().setVisible(true);
					
					
				}
				
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 24));
		btnNewButton_2.setBounds(83, 397, 121, 43);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton button = new JButton("返回");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 24));
		button.setBounds(341, 397, 121, 43);
		frame.getContentPane().add(button);
		
	}
}
