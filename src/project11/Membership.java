package project11;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;

@SuppressWarnings("serial")
public class Membership extends JFrame {

	private JPanel contentPane;
	private JTextField textName, textMid, textPassword, textAddress, textPhone;
	private JComboBox comboBoxY, comboBoxM, comboBoxD;
	private ButtonGroup buttonGroup = new ButtonGroup();
	
	PensionReservationDAO dao = new PensionReservationDAO();
	PensionReservationVO vo;
	
	int res;

	public Membership() {
		setTitle("회원가입");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);
		
		setVisible(true);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(12, 95, 595, 324);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JLabel lblName = new JLabel("이름");
		lblName.setFont(new Font("굴림", Font.PLAIN, 15));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(12, 22, 61, 55);
		pn2.add(lblName);
		
		JLabel lblId = new JLabel("아이디");
		lblId.setFont(new Font("굴림", Font.PLAIN, 15));
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(28, 99, 61, 55);
		pn2.add(lblId);
		
		JLabel lblPassword = new JLabel("비밀번호");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("굴림", Font.PLAIN, 15));
		lblPassword.setBounds(28, 176, 61, 55);
		pn2.add(lblPassword);
		
		JLabel lblGender = new JLabel("성별");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("굴림", Font.PLAIN, 15));
		lblGender.setBounds(28, 253, 61, 55);
		pn2.add(lblGender);
		
		JLabel lblBirth = new JLabel("생일");
		lblBirth.setFont(new Font("굴림", Font.PLAIN, 15));
		lblBirth.setHorizontalAlignment(SwingConstants.CENTER);
		lblBirth.setBounds(191, 22, 61, 55);
		pn2.add(lblBirth);
		
		JLabel lblAddress = new JLabel("주소");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setFont(new Font("굴림", Font.PLAIN, 15));
		lblAddress.setBounds(229, 99, 79, 55);
		pn2.add(lblAddress);
		
		JLabel lblPhone = new JLabel("전화번호");
		lblPhone.setFont(new Font("굴림", Font.PLAIN, 15));
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setBounds(229, 176, 79, 55);
		pn2.add(lblPhone);
		
		textName = new JTextField();
		textName.setBounds(72, 22, 116, 55);
		pn2.add(textName);
		textName.setColumns(10);
		
		textMid = new JTextField();
		textMid.setColumns(10);
		textMid.setBounds(101, 99, 116, 55);
		pn2.add(textMid);
		
		textPassword = new JTextField();
		textPassword.setColumns(10);
		textPassword.setBounds(101, 176, 116, 55);
		pn2.add(textPassword);
		
		String[] yy = new String[91];
		String[] mm = new String[12];
		String[] dd = new String[31];
		
		int imsi;
		for(int i=0; i<yy.length; i++) {
			imsi = i + 1929;
			yy[i] = imsi + "";
		}
		for(int i=0; i<mm.length; i++) {
			mm[i] = (i+1) + "";
		}
		for(int i=0; i<dd.length; i++) {
			dd[i] = (i+1) + "";
		}
		
		comboBoxY = new JComboBox(yy);
		comboBoxY.setBounds(252, 22, 79, 55);
		pn2.add(comboBoxY);
		
		comboBoxM = new JComboBox(mm);
		comboBoxM.setBounds(372, 22, 64, 55);
		pn2.add(comboBoxM);
		
		comboBoxD = new JComboBox(dd);
		comboBoxD.setBounds(476, 22, 64, 55);
		pn2.add(comboBoxD);
		
		textAddress = new JTextField();
		textAddress.setBounds(320, 99, 153, 55);
		pn2.add(textAddress);
		textAddress.setColumns(10);
		
		textPhone = new JTextField();
		textPhone.setBounds(320, 176, 153, 55);
		pn2.add(textPhone);
		textPhone.setColumns(10);
		
		JLabel lblY = new JLabel("년");
		lblY.setHorizontalAlignment(SwingConstants.CENTER);
		lblY.setFont(new Font("굴림", Font.PLAIN, 15));
		lblY.setBounds(331, 22, 41, 55);
		pn2.add(lblY);
		
		JLabel lblM = new JLabel("월");
		lblM.setFont(new Font("굴림", Font.PLAIN, 15));
		lblM.setHorizontalAlignment(SwingConstants.CENTER);
		lblM.setBounds(436, 22, 41, 55);
		pn2.add(lblM);
		
		JLabel lblD = new JLabel("일");
		lblD.setFont(new Font("굴림", Font.PLAIN, 15));
		lblD.setHorizontalAlignment(SwingConstants.CENTER);
		lblD.setBounds(542, 22, 41, 55);
		pn2.add(lblD);
		
		JRadioButton rdbtnMale = new JRadioButton("남자");
		rdbtnMale.setFont(new Font("굴림", Font.PLAIN, 15));
		rdbtnMale.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnMale.setSelected(true);
		rdbtnMale.setBounds(97, 253, 76, 55);
		buttonGroup.add(rdbtnMale);
		pn2.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("여자");
		rdbtnFemale.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnFemale.setFont(new Font("굴림", Font.PLAIN, 15));
		rdbtnFemale.setBounds(191, 253, 76, 55);
		buttonGroup.add(rdbtnFemale);
		pn2.add(rdbtnFemale);
		
		JButton btnJoin = new JButton("회원가입");
		btnJoin.setFont(new Font("굴림", Font.PLAIN, 15));
		btnJoin.setBounds(296, 253, 107, 55);
		pn2.add(btnJoin);
		
		JButton btnCancel = new JButton("취소하기");
		btnCancel.setFont(new Font("굴림", Font.PLAIN, 15));
		btnCancel.setBounds(415, 253, 107, 55);
		pn2.add(btnCancel);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(12, 10, 595, 82);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JLabel lblTitle = new JLabel("회원 가입");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("굴림", Font.BOLD, 30));
		lblTitle.setBounds(163, 10, 247, 62);
		pn1.add(lblTitle);
		
		/* ==================================== */
		
		// 회원가입
		btnJoin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
								
				String name = textName.getText();
				String mid = textMid.getText();
				String password = textPassword.getText();
				// 데이터베이스 birth 필드의 date 타입은 .toString으로 값을 줄 경우 글자수 문제가 발생 "-"로 구분지어 입력해주어야함
				String birth = comboBoxY.getSelectedItem() + "-" + comboBoxM.getSelectedItem() + "-" + comboBoxD.getSelectedItem();
				String gender;
				String address = textAddress.getText();
				String phone = textPhone.getText();
				
				if(name.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "성명을 입력하세요? ");
					textName.requestFocus();
				}
				else if(mid.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "아이디를 입력하세요? ");
					textMid.requestFocus();
				}
				else if(password.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요? ");
					textPassword.requestFocus();
				}
				else if(phone.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "전화번호를 입력하세요? ");
					textPhone.requestFocus();
				}
				else {
					if(rdbtnMale.isSelected()) gender = "남자";
					else gender = "여자";
					
					vo = dao.getMemberSearch(textMid.getText());
					if (vo.getmId() != null) {
						JOptionPane.showMessageDialog(null, "사용하고 있는 아이디 입니다. 다른 아이디를 입력해주세요. ");
						textName.requestFocus();
					} else {
						vo.setName(name);
						vo.setmId(mid);
						vo.setPassword(password);
						vo.setBirth(birth);
						vo.setGender(gender);
						vo.setAddress(address);
						vo.setPhone(phone);
							
						res = dao.JoinMembership(vo);
							
						if (res == 0) {
							JOptionPane.showMessageDialog(null, "회원가입실패, 다시 가입하세요. ");
							textName.requestFocus();
						}
						else {
								JOptionPane.showMessageDialog(null, "회원에 가입되셨습니다. ");
								dispose();
						}
					}
				}
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
