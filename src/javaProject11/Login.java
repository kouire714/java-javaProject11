package javaProject11;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textId;
	private JTextField textPw;
	
	PensionReservationDAO dao = new PensionReservationDAO();
	PensionReservationVO vo;

	/**
	 * Launch the application.
	 */
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

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setVisible(true);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(12, 115, 560, 238);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JLabel lblId = new JLabel("아이디");
		lblId.setBounds(27, 60, 96, 47);
		pn2.add(lblId);
		
		JLabel lblPassword = new JLabel("비밀번호");
		lblPassword.setBounds(27, 119, 96, 47);
		pn2.add(lblPassword);
		
		textId = new JTextField();
		textId.setBounds(135, 60, 176, 47);
		pn2.add(textId);
		textId.setColumns(10);
		
		textPw = new JTextField();
		textPw.setColumns(10);
		textPw.setBounds(135, 119, 176, 47);
		pn2.add(textPw);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(12, 363, 560, 88);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
		JButton btnLogin = new JButton("로그인");
		btnLogin.setBounds(12, 10, 144, 68);
		pn3.add(btnLogin);
		
		JButton btnMemberShip = new JButton("회원가입");
		btnMemberShip.setBounds(192, 10, 149, 68);
		pn3.add(btnMemberShip);
		
		JButton btnExit = new JButton("종료");
		btnExit.setBounds(377, 10, 149, 68);
		pn3.add(btnExit);
		
		textId.setText("kouire");
		textPw.setText("1234");
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(12, 10, 560, 95);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JLabel lblTitle = new JLabel("펜션 예약 사이트");
		lblTitle.setFont(new Font("굴림", Font.BOLD, 24));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(12, 10, 536, 75);
		pn1.add(lblTitle);
		
		
		/* ======================================= */
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mid = textId.getText();
				String password = textPw.getText();
				System.out.println("mid:" + mid);
				System.out.println("password:" + password);
				dao.loginIdPassword(mid, password);
				System.out.println("vo :" + vo);
				if(dao.loginIdPassword(mid, password) == 1) {
					System.out.println("로그인에 성공하였습니다.");
					new Main(mid);//(new getIdSearch(textId))
					dispose();
				} else {
					System.out.println("존재하지 않는 회원입니다.");
				}
			}
		});
		
		btnMemberShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Membership();
			}
		});
		
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
	}
}
