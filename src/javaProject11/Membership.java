package javaProject11;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;

@SuppressWarnings("serial")
public class Membership extends JFrame {

	private JPanel contentPane;
	private JTextField text1;
	private JTextField text2;
	private JTextField text3;
	private JTextField text4;
	private JTextField text5;
	
	PensionReservationDAO dao = new PensionReservationDAO();
	PensionReservationVO vo;

	public Membership() {
		setTitle("회원가입");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setVisible(true);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(12, 95, 595, 324);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JLabel lblId = new JLabel("아이디");
		lblId.setBounds(12, 22, 61, 55);
		pn2.add(lblId);
		
		JLabel lblPassword = new JLabel("패스워드");
		lblPassword.setBounds(12, 99, 61, 55);
		pn2.add(lblPassword);
		
		JLabel lblName = new JLabel("이름");
		lblName.setBounds(12, 176, 61, 55);
		pn2.add(lblName);
		
		JLabel lblGender = new JLabel("성별");
		lblGender.setBounds(12, 253, 61, 55);
		pn2.add(lblGender);
		
		JLabel lblBirth = new JLabel("생일");
		lblBirth.setBounds(229, 22, 52, 55);
		pn2.add(lblBirth);
		
		JLabel lblAddress = new JLabel("주소");
		lblAddress.setBounds(229, 99, 52, 55);
		pn2.add(lblAddress);
		
		JLabel lblPhone = new JLabel("전화번호");
		lblPhone.setBounds(229, 176, 52, 55);
		pn2.add(lblPhone);
		
		text1 = new JTextField();
		text1.setBounds(101, 22, 116, 55);
		pn2.add(text1);
		text1.setColumns(10);
		
		text2 = new JTextField();
		text2.setColumns(10);
		text2.setBounds(101, 99, 116, 55);
		pn2.add(text2);
		
		text3 = new JTextField();
		text3.setColumns(10);
		text3.setBounds(101, 176, 116, 55);
		pn2.add(text3);
		
		String[] yy = new String[24];
		String[] mm = new String[12];
		String[] dd = new String[31];
		
		int imsi;
		for(int i=0; i<yy.length; i++) {
			imsi = i + 2000;
			yy[i] = imsi + "";
		}
		for(int i=0; i<mm.length; i++) {
			mm[i] = (i+1) + "";
		}
		for(int i=0; i<dd.length; i++) {
			dd[i] = (i+1) + "";
		}
		
		JComboBox comboBoxY = new JComboBox(yy);
		comboBoxY.setBounds(320, 22, 64, 55);
		pn2.add(comboBoxY);
		
		JComboBox comboBoxM = new JComboBox(mm);
		comboBoxM.setBounds(421, 22, 64, 55);
		pn2.add(comboBoxM);
		
		JComboBox comboBoxD = new JComboBox(dd);
		comboBoxD.setBounds(519, 22, 64, 55);
		pn2.add(comboBoxD);
		
		text4 = new JTextField();
		text4.setBounds(320, 99, 153, 55);
		pn2.add(text4);
		text4.setColumns(10);
		
		text5 = new JTextField();
		text5.setBounds(320, 176, 153, 55);
		pn2.add(text5);
		text5.setColumns(10);
		
		JLabel lblY = new JLabel("년");
		lblY.setBounds(292, 22, 28, 55);
		pn2.add(lblY);
		
		JLabel lblM = new JLabel("달");
		lblM.setBounds(396, 22, 28, 55);
		pn2.add(lblM);
		
		JLabel lblD = new JLabel("일");
		lblD.setBounds(497, 22, 28, 55);
		pn2.add(lblD);
		
		JRadioButton rdbtnMale = new JRadioButton("남자");
		rdbtnMale.setBounds(96, 253, 76, 55);
		pn2.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("여자");
		rdbtnFemale.setBounds(191, 253, 76, 55);
		pn2.add(rdbtnFemale);
		
		JButton btnJoin = new JButton("회원가입");
		btnJoin.setBounds(320, 253, 107, 55);
		pn2.add(btnJoin);
		
		JButton btnCancel = new JButton("취소하기");
		btnCancel.setBounds(450, 253, 107, 55);
		pn2.add(btnCancel);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(12, 10, 595, 82);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JLabel lblTitle = new JLabel("회원가입");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("굴림", Font.PLAIN, 22));
		lblTitle.setBounds(158, 10, 247, 62);
		pn1.add(lblTitle);
		
		/* ==================================== */
		
		btnJoin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = text1.getText();
				String password = text2.getText();
				String name = text3.getText();
				String birth = comboBoxY.getSelectedItem().toString() + comboBoxM.getSelectedItem() + comboBoxD.getSelectedItem();
				String gender;
				String address = text4.getText();
				String phone = text5.getText();
				
				if (rdbtnMale.isSelected()) gender = "남자";
				else gender = "여자";
				
				vo = new PensionReservationVO();
				
				vo.setmId(id);
				vo.setPassword(password);
				vo.setName(name);
				vo.setBirth(birth);
				vo.setGender(gender);
				vo.setAddress(address);
				vo.setPhone(phone);
				
				dao.JoinMembership(vo);
				
				if (dao.JoinMembership(vo) == 1) 
				{
					System.out.println("회원가입이 완료되었습니다.");
					dispose();
				}
				else 
					System.out.println("회원가입에 실패했습니다. ");
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
