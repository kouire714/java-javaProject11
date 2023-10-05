package project11;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Main extends JFrame {
	
	private JPanel contentPane;
	
	PensionReservationVO vo;
	PensionReservationDAO dao;
	
	String mid;

	public Main(String mid) {
		this.mid = mid;
		
		setTitle("메인화면");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);
		
		setVisible(true);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 10, 218, 425);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnReservationMake = new JButton("방보기");
		btnReservationMake.setFont(new Font("굴림", Font.PLAIN, 15));
		btnReservationMake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReservationMake.setBounds(33, 33, 145, 65);
		panel.add(btnReservationMake);
		
		JButton btnReservationEdit = new JButton("예약변경");
		btnReservationEdit.setFont(new Font("굴림", Font.PLAIN, 15));
		btnReservationEdit.setBounds(33, 131, 145, 65);
		panel.add(btnReservationEdit);
		
		JButton btnMemberEdit = new JButton("회원정보수정");
		btnMemberEdit.setFont(new Font("굴림", Font.PLAIN, 15));
		btnMemberEdit.setBounds(33, 229, 145, 65);
		panel.add(btnMemberEdit);
		
		JButton btnLogout = new JButton("로그아웃");
		btnLogout.setFont(new Font("굴림", Font.PLAIN, 15));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogout.setBounds(33, 327, 145, 65);
		panel.add(btnLogout);
		
		/* =============================================== */
		
		btnReservationMake.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new RoomCheck(mid);
			}
		});
		
		btnReservationEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dao = new PensionReservationDAO();
				vo = dao.getReservationSearch(mid);
				if (vo.getrName() == null)
					JOptionPane.showMessageDialog(null, "예약정보가 존재하지 않습니다. ");
				else
					new EditReservation(vo, mid);
			}
		});
		
		btnMemberEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dao = new PensionReservationDAO();
				vo = dao.getMemberSearch(mid);
				new EditMember(vo);
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
