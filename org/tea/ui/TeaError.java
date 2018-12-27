package org.tea.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TeaError {

	private JFrame frame;
	

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	

	/**
	 * Create the application.
	 */
	public TeaError() {
		String errString="";
		initialize(errString);
		
	}
	public TeaError(String errString) {
		initialize(errString);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String errString) {
		frame = new JFrame();
		frame.setBounds(700, 370, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//把外界传进来的errString填入Lable标签
		JLabel lblNewLabel = new JLabel(errString);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 17));
		lblNewLabel.setBounds(31, 79, 369, 108);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.setBounds(127, 213, 113, 27);
		frame.getContentPane().add(btnNewButton);
	}
	


}
