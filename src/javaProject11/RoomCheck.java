package javaProject11;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class RoomCheck extends JFrame {

	private JPanel contentPane;
	String mid;
	private JTextField txtDaf;

	public RoomCheck(String mid) {
		this.mid = mid;
		
		setTitle("방소개 및 선택");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setVisible(true);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 313, 572, 135);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnRoom2 = new JButton("2인실");
		btnRoom2.setBounds(19, 22, 83, 74);
		panel.add(btnRoom2);
		
		JButton btnRoom4 = new JButton("4인실");
		btnRoom4.setBounds(133, 22, 83, 74);
		panel.add(btnRoom4);
		
		JButton btnRoom6 = new JButton("6인실");
		btnRoom6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRoom6.setBounds(247, 22, 83, 74);
		panel.add(btnRoom6);
		
		JButton btnReservation = new JButton("예약하기");
		btnReservation.setBounds(355, 22, 83, 74);
		panel.add(btnReservation);
		
		JButton btnCancel = new JButton("나가기");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancel.setBounds(463, 22, 83, 74);
		panel.add(btnCancel);
		
		JScrollPane scrollPaneIntro2 = new JScrollPane();
		scrollPaneIntro2.setBounds(12, 69, 628, 234);
		contentPane.add(scrollPaneIntro2);
		
		txtDaf = new JTextField();
		txtDaf.setText("2인실 소개");
		scrollPaneIntro2.setColumnHeaderView(txtDaf);
		txtDaf.setColumns(10);
		
		JScrollPane scrollPaneIntro4 = new JScrollPane();
		scrollPaneIntro4.setBounds(12, 69, 628, 234);
		contentPane.add(scrollPaneIntro4);
		
		txtDaf = new JTextField();
		txtDaf.setText("4인실 소개");
		scrollPaneIntro4.setColumnHeaderView(txtDaf);
		txtDaf.setColumns(10);
		
		JScrollPane scrollPaneIntro6 = new JScrollPane();
		scrollPaneIntro6.setBounds(12, 69, 628, 234);
		contentPane.add(scrollPaneIntro6);
		
		txtDaf = new JTextField();
		txtDaf.setText("6인실 소개");
		scrollPaneIntro6.setColumnHeaderView(txtDaf);
		txtDaf.setColumns(10);
		
		/* ==================================== */
		
		btnRoom2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPaneIntro2.setVisible(true);
				scrollPaneIntro4.setVisible(false);
				scrollPaneIntro6.setVisible(false);
			}
		});
		
		btnRoom4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPaneIntro4.setVisible(true);
				scrollPaneIntro2.setVisible(false);
				scrollPaneIntro6.setVisible(false);
			}
		});
		
		btnRoom6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPaneIntro6.setVisible(true);
				scrollPaneIntro2.setVisible(false);
				scrollPaneIntro4.setVisible(false);
			}
		});
		
		
		btnReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RoomReservation(mid);
			}
		});
		
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}
