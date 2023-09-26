package javaProject11;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class ReservationStatus extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservationStatus frame = new ReservationStatus();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ReservationStatus() {
		setTitle("예약현황확인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 657, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 84, 617, 240);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 334, 617, 119);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblExit = new JLabel("나가기");
		lblExit.setBounds(12, 10, 167, 99);
		panel.add(lblExit);
	}
}
