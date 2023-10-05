package project11;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;

public class EditMember extends JFrame {

	private JPanel contentPane;
	private JTextField textName, textMid, textPassword, textAddress, textPhone;
	private JComboBox comboBoxY, comboBoxM, comboBoxD;
	private ButtonGroup buttonGroup = new ButtonGroup();
	
	PensionReservationVO vo;
	PensionReservationDAO dao;

	int res;
	
	public EditMember(PensionReservationVO vo) {
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
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(12, 93, 595, 326);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JLabel lblName = new JLabel("이름");
		lblName.setFont(new Font("굴림", Font.PLAIN, 15));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(12, 22, 61, 55);
		pn1.add(lblName);
		
		JLabel lblMid = new JLabel("아이디");
		lblMid.setFont(new Font("굴림", Font.PLAIN, 15));
		lblMid.setHorizontalAlignment(SwingConstants.CENTER);
		lblMid.setBounds(28, 99, 61, 55);
		pn1.add(lblMid);
		
		JLabel lblPassword = new JLabel("비밀번호");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("굴림", Font.PLAIN, 15));
		lblPassword.setBounds(28, 176, 61, 55);
		pn1.add(lblPassword);
		
		JLabel lblGender = new JLabel("성별");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("굴림", Font.PLAIN, 15));
		lblGender.setBounds(12, 253, 61, 55);
		pn1.add(lblGender);
		
		JLabel lblBirth = new JLabel("생일");
		lblBirth.setFont(new Font("굴림", Font.PLAIN, 15));
		lblBirth.setHorizontalAlignment(SwingConstants.CENTER);
		lblBirth.setBounds(191, 22, 61, 55);
		pn1.add(lblBirth);
		
		JLabel lblAddress = new JLabel("주소");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setFont(new Font("굴림", Font.PLAIN, 15));
		lblAddress.setBounds(229, 99, 79, 55);
		pn1.add(lblAddress);
		
		JLabel lblPhone = new JLabel("전화번호");
		lblPhone.setFont(new Font("굴림", Font.PLAIN, 15));
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setBounds(229, 176, 79, 55);
		pn1.add(lblPhone);
		
		textName = new JTextField();
		textName.setFont(new Font("굴림", Font.PLAIN, 15));
		textName.setBounds(72, 22, 116, 55);
		textName.setText(vo.getName());
		pn1.add(textName);
		textName.setColumns(10);
		
		textMid = new JTextField();
		textMid.setFont(new Font("굴림", Font.PLAIN, 15));
		textMid.setEditable(false);
		textMid.setColumns(10);
		textMid.setBounds(101, 99, 116, 55);
		textMid.setText(vo.getmId());
		pn1.add(textMid);
		
		textPassword = new JTextField();
		textPassword.setFont(new Font("굴림", Font.PLAIN, 15));
		textPassword.setColumns(10);
		textPassword.setBounds(101, 176, 116, 55);
		textPassword.setText(vo.getPassword());
		pn1.add(textPassword);
		
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
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-M-d");	// 초기값은 앞자리 0이 없으므로 형식지정
		LocalDate date = LocalDate.parse(vo.getBirth().substring(0, 10),dtf);	//	형식지정을 적용하기 위해 date타입으로 전환
//		System.out.println(date);	// 2019-07-10
		String strDate = date.format(dtf);	// format으로 형식 변경 및 String 타입으로 저장 (format은 date 타입만 사용가능)
//		System.out.println(strDate);	// 2019-7-10
		
		String[] ymds = strDate.split("-"); 	// -로 구분하여 배열타입으로 저장
		
		comboBoxY = new JComboBox(yy);
		comboBoxY.setFont(new Font("굴림", Font.PLAIN, 15));
		comboBoxY.setBounds(252, 22, 79, 55);
		comboBoxY.setSelectedItem(ymds[0]);
		pn1.add(comboBoxY);
		
		comboBoxM = new JComboBox(mm);
		comboBoxM.setFont(new Font("굴림", Font.PLAIN, 15));
		comboBoxM.setBounds(372, 22, 64, 55);
		comboBoxM.setSelectedItem(ymds[1]);
		pn1.add(comboBoxM);
		
		comboBoxD = new JComboBox(dd);
		comboBoxD.setFont(new Font("굴림", Font.PLAIN, 15));
		comboBoxD.setBounds(476, 22, 64, 55);
		comboBoxD.setSelectedItem(ymds[2]);
		pn1.add(comboBoxD);
		
		textAddress = new JTextField();
		textAddress.setFont(new Font("굴림", Font.PLAIN, 15));
		textAddress.setBounds(320, 99, 153, 55);
		textAddress.setText(vo.getAddress());
		pn1.add(textAddress);
		textAddress.setColumns(10);
		
		textPhone = new JTextField();
		textPhone.setFont(new Font("굴림", Font.PLAIN, 15));
		textPhone.setBounds(320, 176, 153, 55);
		textPhone.setText(vo.getPhone());
		pn1.add(textPhone);
		textPhone.setColumns(10);
		
		JLabel lblY = new JLabel("년");
		lblY.setHorizontalAlignment(SwingConstants.CENTER);
		lblY.setFont(new Font("굴림", Font.PLAIN, 15));
		lblY.setBounds(331, 22, 41, 55);
		pn1.add(lblY);
		
		JLabel lblM = new JLabel("월");
		lblM.setFont(new Font("굴림", Font.PLAIN, 15));
		lblM.setHorizontalAlignment(SwingConstants.CENTER);
		lblM.setBounds(436, 22, 41, 55);
		pn1.add(lblM);
		
		JLabel lblD = new JLabel("일");
		lblD.setFont(new Font("굴림", Font.PLAIN, 15));
		lblD.setHorizontalAlignment(SwingConstants.CENTER);
		lblD.setBounds(542, 22, 41, 55);
		pn1.add(lblD);
		
		JRadioButton rdbtnMale = new JRadioButton("남자");
		rdbtnMale.setFont(new Font("굴림", Font.PLAIN, 15));
		rdbtnMale.setHorizontalAlignment(SwingConstants.CENTER);
		if (vo.getGender().equals("남자"))
			rdbtnMale.setSelected(true);
		else
			rdbtnMale.setSelected(false);
		rdbtnMale.setBounds(72, 253, 76, 55);
		buttonGroup.add(rdbtnMale);
		pn1.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("여자");
		rdbtnFemale.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnFemale.setFont(new Font("굴림", Font.PLAIN, 15));
		if (vo.getGender().equals("여자"))
			rdbtnFemale.setSelected(true);
		else
			rdbtnFemale.setSelected(false);
		rdbtnFemale.setBounds(152, 253, 76, 55);
		buttonGroup.add(rdbtnFemale);
		pn1.add(rdbtnFemale);
		
		JButton btnEdit = new JButton("정보수정");
		btnEdit.setFont(new Font("굴림", Font.PLAIN, 15));
		btnEdit.setBounds(229, 253, 107, 55);
		pn1.add(btnEdit);
		
		JButton btnCancel = new JButton("나가기");
		btnCancel.setFont(new Font("굴림", Font.PLAIN, 15));
		btnCancel.setBounds(467, 253, 107, 55);
		pn1.add(btnCancel);
		
		JButton btnDelete = new JButton("회원삭제");
		btnDelete.setFont(new Font("굴림", Font.PLAIN, 15));
		btnDelete.setBounds(348, 253, 107, 55);
		pn1.add(btnDelete);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 10, 595, 82);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("회원 정보 수정");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(166, 10, 247, 62);
		panel.add(lblNewLabel);
		
		/* ==================================== */
		
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {		
				String name = textName.getText();
				String mid = textMid.getText();
				String password = textPassword.getText();
				String birth = comboBoxY.getSelectedItem() + "-" + comboBoxM.getSelectedItem() + "-" + comboBoxD.getSelectedItem();
				String gender;
				String address = textAddress.getText();
				String phone = textPhone.getText();
				
				if(name.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "성명을 입력하세요?");
					textName.requestFocus();
				}
				else if(mid.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "아이디를 입력하세요?");
					textMid.requestFocus();
				}
				else if(password.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요?");
					textPassword.requestFocus();
				}
				else if(phone.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "전화번호를 입력하세요?");
					textPhone.requestFocus();
				}
				else {
					if(rdbtnMale.isSelected()) gender = "남자";
					else gender = "여자";
					
					PensionReservationVO vo = new PensionReservationVO();
					dao = new PensionReservationDAO();
					
					vo.setName(name);
					vo.setmId(mid);
					vo.setPassword(password);
					vo.setBirth(birth);
					vo.setGender(gender);
					vo.setAddress(address);
					vo.setPhone(phone);
					
					res = dao.EditMember(vo);
					if (res == 0) {
						JOptionPane.showMessageDialog(null, "정보 수정 실패, 다시 가입하세요. ");
						textName.requestFocus();
					}
					else {
						JOptionPane.showMessageDialog(null, "회원 정보가 수정되었습니다. ");
						dispose();
					}
				}
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				dao = new PensionReservationDAO();
				String mid = textMid.getText();

				int ans = JOptionPane.showConfirmDialog(null, mid + "회원을 삭제하시겠습니까? ","회원 삭제",JOptionPane.YES_NO_OPTION);
				if(ans == 0) {
					res = dao.DeleteMember(mid);
					if (res == 0) JOptionPane.showConfirmDialog(null, "회원 삭제 실패. ");
					else {
						JOptionPane.showMessageDialog(null, "회원정보가 삭제되었습니다. ");
						dispose();
					}
				}
				else JOptionPane.showMessageDialog(null, "회원삭제 취소");
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
