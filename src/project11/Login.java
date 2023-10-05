package project11;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textId;
	private JPasswordField textPw;
	
	PensionReservationDAO dao = new PensionReservationDAO();
	PensionReservationVO vo;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		setTitle("로그인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setVisible(true);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(12, 115, 560, 238);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JLabel lblId = new JLabel("아이디");
		lblId.setFont(new Font("굴림", Font.PLAIN, 20));
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(50, 58, 100, 50);
		pn2.add(lblId);
		
		JLabel lblPassword = new JLabel("비밀번호");
		lblPassword.setFont(new Font("굴림", Font.PLAIN, 20));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(50, 118, 100, 50);
		pn2.add(lblPassword);
		
		textId = new JTextField();
		textId.setFont(new Font("굴림", Font.PLAIN, 20));
		textId.setHorizontalAlignment(SwingConstants.LEFT);
		textId.setBounds(190, 59, 180, 50);
		pn2.add(textId);
		textId.setColumns(10);
		
		textPw = new JPasswordField();
		textPw.setFont(new Font("굴림", Font.PLAIN, 20));
		textPw.setColumns(10);
		textPw.setBounds(190, 119, 180, 50);
		pn2.add(textPw);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(12, 363, 560, 88);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
		JButton btnLogin = new JButton("로그인");
		btnLogin.setFont(new Font("굴림", Font.PLAIN, 20));
		btnLogin.setBounds(31, 10, 145, 65);
		pn3.add(btnLogin);
		
		JButton btnMemberShip = new JButton("회원가입");
		btnMemberShip.setFont(new Font("굴림", Font.PLAIN, 20));
		btnMemberShip.setBounds(207, 10, 145, 65);
		pn3.add(btnMemberShip);
		
		JButton btnExit = new JButton("종료");
		btnExit.setFont(new Font("굴림", Font.PLAIN, 20));
		btnExit.setBounds(383, 10, 145, 65);
		pn3.add(btnExit);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(12, 10, 560, 95);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JLabel lblTitle = new JLabel("펜션 예약 사이트");
		lblTitle.setFont(new Font("굴림", Font.BOLD, 30));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(12, 10, 536, 75);
		pn1.add(lblTitle);
		
		
		/* ======================================= */
		
		// 로그인 버튼
		// 유효성 검사
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String mid = textId.getText();
				String password = textPw.getText();
				dao.loginIdPassword(mid, password);
				if(dao.loginIdPassword(mid, password) == 1) {
					new Main(mid);
				} else {
					JOptionPane.showMessageDialog(null, "존재하지 않는 회원입니다. ");
				}
			}
		});
		
		// 회원가입 버튼
		btnMemberShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Membership();
			}
		});
		
		// 종료 버튼
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
	}
}
