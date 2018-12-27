package org.stu.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;

import org.tea.ui.TeaError;
import org.tea.utils.Server;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StuChange {

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
	public StuChange(String id) {
		initialize(id);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String id) {
		frame = new JFrame();
		frame.setBounds(700, 320, 490, 365);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("请选择要修改的信息");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel.setBounds(120, 13, 226, 49);
		frame.getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("宋体", Font.PLAIN, 24));
		comboBox.setBounds(33, 121, 133, 43);
		comboBox.addItem("名字");
		comboBox.addItem("班级");
		comboBox.addItem("照片Url");
		
		frame.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("提交");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//获取下拉菜单的值
				String key=String.valueOf(comboBox.getSelectedItem());
				//从textField获取值
				String value=textField.getText();
				if (!key.equals("")&&key!=null&&!value.equals("")&&value!=null) {
					Server server=new Server();
					switch (key) {
					case "名字":
						server.changeStuName(id, value);
						break;
					case "班级":
						server.changeStuClass(id, value);
						break;
					case "照片Url":
						server.changeStuPic(id, value);
						break;	
					}
					//关闭当前界面
					frame.dispose();
					
				}else {
					String errString="信息不完整，无法提交！";
					TeaError teaError=new TeaError(errString);
					teaError.getFrame().setVisible(true);
				}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.setBounds(93, 243, 113, 33);
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 24));
		textField.setBounds(202, 121, 144, 43);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("返回");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.dispose();
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		button.setBounds(267, 243, 113, 33);
		frame.getContentPane().add(button);
	}
}
