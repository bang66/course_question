package org.tea.ui;



import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.tea.utils.Server;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TeaInTruncy {

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
	public TeaInTruncy(String id) {
		initialize(id);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String sid) {
		frame = new JFrame();
		frame.setBounds(720,300, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("课程名称");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel.setBounds(14, 66, 106, 36);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(156, 65, 173, 36);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		//提交缺勤信息，包括检验信息完整
		JButton button = new JButton("确认");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String cname=textField.getText();
				if (!cname.equals("")&&cname!=null) {
					
					Server server=new Server();
					server.insertTruncy(cname, sid);
					frame.dispose();
				}else {
					String errString="您还未填课程名称，无法提交！";
					TeaError teaError=new TeaError(errString);
					teaError.getFrame().setVisible(true);
				}
				
				
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 24));
		button.setBounds(117, 198, 113, 42);
		frame.getContentPane().add(button);
	}
}
