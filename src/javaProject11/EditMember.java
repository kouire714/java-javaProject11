package javaProject11;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class EditMember extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	public EditMember() {
		setTitle("회원정보수정");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setVisible(true);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 85, 595, 334);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblId = new JLabel("아이디");
		lblId.setBounds(12, 22, 61, 55);
		panel.add(lblId);
		
		JLabel lblPassword = new JLabel("패스워드");
		lblPassword.setBounds(12, 99, 61, 55);
		panel.add(lblPassword);
		
		JLabel lblName = new JLabel("이름");
		lblName.setBounds(12, 176, 61, 55);
		panel.add(lblName);
		
		JLabel lblGender = new JLabel("성별");
		lblGender.setBounds(12, 253, 61, 55);
		panel.add(lblGender);
		
		JLabel lblBirth = new JLabel("생일");
		lblBirth.setBounds(229, 22, 52, 55);
		panel.add(lblBirth);
		
		JLabel lblAddress = new JLabel("주소");
		lblAddress.setBounds(229, 99, 52, 55);
		panel.add(lblAddress);
		
		JLabel lblPhone = new JLabel("전화번호");
		lblPhone.setBounds(229, 176, 52, 55);
		panel.add(lblPhone);
		
		textField = new JTextField();
		textField.setBounds(101, 22, 116, 55);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(101, 99, 116, 55);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(101, 176, 116, 55);
		panel.add(textField_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(320, 22, 64, 55);
		panel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(421, 22, 64, 55);
		panel.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(519, 22, 64, 55);
		panel.add(comboBox_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(320, 99, 153, 55);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(320, 176, 153, 55);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblY = new JLabel("년");
		lblY.setBounds(292, 22, 28, 55);
		panel.add(lblY);
		
		JLabel lblM = new JLabel("달");
		lblM.setBounds(396, 22, 28, 55);
		panel.add(lblM);
		
		JLabel lblD = new JLabel("일");
		lblD.setBounds(497, 22, 28, 55);
		panel.add(lblD);
		
		JRadioButton rdbtnMale = new JRadioButton("남자");
		rdbtnMale.setBounds(96, 253, 76, 55);
		panel.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("여자");
		rdbtnFemale.setBounds(191, 253, 76, 55);
		panel.add(rdbtnFemale);
		
		JButton btnJoin = new JButton("회원가입");
		btnJoin.setBounds(320, 253, 153, 55);
		panel.add(btnJoin);
	}
}
