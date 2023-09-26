package javaProject11;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class RoomCheck extends JFrame {

	private JPanel contentPane;

	public RoomCheck() {
		setTitle("방선택하기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 668, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setVisible(true);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 304, 626, 135);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnRoom2 = new JButton("2인실");
		btnRoom2.setBounds(38, 10, 146, 92);
		panel.add(btnRoom2);
		
		JButton btnRoom4 = new JButton("4인실");
		btnRoom4.setBounds(244, 10, 141, 92);
		panel.add(btnRoom4);
		
		JButton btnRoom6 = new JButton("6인실");
		btnRoom6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRoom6.setBounds(428, 10, 137, 92);
		panel.add(btnRoom6);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 50, 626, 244);
		contentPane.add(scrollPane);
		
		/* ==================================== */
		
		btnRoom2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RoomReservation();
				
			}
		});
	}

}
