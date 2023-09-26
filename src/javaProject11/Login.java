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

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("로그인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setVisible(true);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(153, 26, 347, 142);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JLabel lblId = new JLabel("아이디");
		lblId.setBounds(12, 10, 96, 47);
		pn1.add(lblId);
		
		JLabel lblPassword = new JLabel("비밀번호");
		lblPassword.setBounds(12, 69, 96, 47);
		pn1.add(lblPassword);
		
		textId = new JTextField();
		textId.setBounds(120, 10, 176, 47);
		pn1.add(textId);
		textId.setColumns(10);
		
		textPw = new JTextField();
		textPw.setColumns(10);
		textPw.setBounds(120, 69, 176, 47);
		pn1.add(textPw);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(153, 186, 347, 73);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JButton btnLogin = new JButton("로그인");
		btnLogin.setBounds(38, 10, 116, 53);
		pn2.add(btnLogin);
		
		JButton btnMemberShip = new JButton("회원가입");
		btnMemberShip.setBounds(192, 10, 116, 53);
		pn2.add(btnMemberShip);
		
		/* ======================================= */
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mid = textId.getText();
				String password = textPw.getText();
				System.out.println("id:" + mid);
				System.out.println("password:" + password);
				int res = dao.loginIdPassword(mid, password);
				System.out.println("vo :" + vo);
				if(dao.loginIdPassword(mid, password) == 1) {
					System.out.println("로그인에 성공하였습니다.");
					new Main(mid);//(new getIdSearch(textId))
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
		
	}
}
