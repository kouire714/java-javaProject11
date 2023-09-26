package javaProject11;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;
	
	String mid;

	public Main(String mid) {
		this.mid = mid;
		
		setTitle("메인화면");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setVisible(true);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 10, 218, 425);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnReservationMake = new JButton("예약하기");
		btnReservationMake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReservationMake.setBounds(12, 10, 194, 93);
		panel.add(btnReservationMake);
		
		JButton btnRoomIntro = new JButton("방소개");
		btnRoomIntro.setBounds(12, 113, 194, 93);
		panel.add(btnRoomIntro);
		
		JButton btnMemberEdit = new JButton("회원정보수정");
		btnMemberEdit.setBounds(12, 216, 194, 93);
		panel.add(btnMemberEdit);
		
		JButton btnLogout = new JButton("로그아웃");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogout.setBounds(12, 319, 194, 93);
		panel.add(btnLogout);
		
		/* =============================================== */
		
		btnReservationMake.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new RoomCheck();
			}
		});
		
		btnRoomIntro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//
			}
		});
		
		btnMemberEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new EditMember();
			}
		});
		
		btnLogout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}	
}
