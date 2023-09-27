package javaProject11;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.Font;

public class EditReservation extends JFrame {
	
	PensionReservationDAO dao = new PensionReservationDAO();
	PensionReservationVO vo;
	
	String mid;

	private JPanel contentPane;

	public EditReservation(String mid) {
		this.mid = mid;
		
		setTitle("예약현황확인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 657, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setVisible(true);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(27, 355, 588, 98);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnReservationChange = new JButton("예약 변경");
		btnReservationChange.setBounds(43, 21, 138, 59);
		panel.add(btnReservationChange);
		
		JButton btnReservationCancel = new JButton("예약 취소");
		btnReservationCancel.setBounds(224, 21, 138, 59);
		panel.add(btnReservationCancel);
		
		JButton btnCancel = new JButton("나가기");
		btnCancel.setBounds(405, 21, 138, 59);
		panel.add(btnCancel);
		
		JPanel pn2 = new JPanel();
		pn2.setLayout(null);
		pn2.setBounds(25, 121, 590, 224);
		contentPane.add(pn2);
		
		JLabel lblCheckIn = new JLabel("체크인날짜");
		lblCheckIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckIn.setBounds(15, 23, 103, 63);
		pn2.add(lblCheckIn);
		
		JLabel lblCheckOut = new JLabel("체크아웃날짜");
		lblCheckOut.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckOut.setBounds(15, 91, 103, 63);
		pn2.add(lblCheckOut);
		
		JLabel lblService = new JLabel("서비스항목");
		lblService.setBounds(30, 164, 88, 63);
		pn2.add(lblService);
		
		String[] inYy = new String[20];
		String[] inMm = new String[12];
		String[] inDd = new String[31];
		
		for (int i=0; i<inYy.length; i++)
			inYy[i] = i + 2023 + "";
		
		for (int i=0; i<inMm.length; i++)
		{
			inMm[i] = (i + 1) + "";
			if (Integer.parseInt(inMm[i]) < 10) 
				inMm[i] = "0" + (i+1);
		}
		
		for (int i=0; i<inDd.length; i++)
		{
			inDd[i] = (i + 1) + "";
			if (Integer.parseInt(inDd[i]) < 10)
				inDd[i] = "0" + (i+1);
		}
		
		JComboBox comboBoxInY = new JComboBox(inYy);
		comboBoxInY.setSelectedIndex(1);
		comboBoxInY.setBounds(153, 31, 116, 46);
		pn2.add(comboBoxInY);
		
		JComboBox comboBoxInM = new JComboBox(inMm);
		comboBoxInM.setSelectedIndex(1);
		comboBoxInM.setBounds(281, 31, 116, 46);
		pn2.add(comboBoxInM);
		
		JComboBox comboBoxInD = new JComboBox(inDd);
		comboBoxInD.setSelectedIndex(1);
		comboBoxInD.setBounds(409, 31, 116, 46);
		pn2.add(comboBoxInD);
		
		String[] outYy = new String[20];
		String[] outMm = new String[12];
		String[] outDd = new String[31];
		
		for (int i=0; i<outYy.length; i++)
			outYy[i] = i + 2023 + "";
		
		for (int i=0; i<outMm.length; i++)
		{
			outMm[i] = (i + 1) + "";
			if (Integer.parseInt(outMm[i]) < 10) 
				outMm[i] = "0" + (i+1);
		}
		
		for (int i=0; i<outDd.length; i++)
		{
			outDd[i] = (i + 1) + "";
			if (Integer.parseInt(outDd[i]) < 10)
				outDd[i] = "0" + (i+1);
		}
		
		JComboBox comboBoxOutY = new JComboBox(outYy);
		comboBoxOutY.setBounds(153, 99, 116, 46);
		pn2.add(comboBoxOutY);
		
		JComboBox comboBoxOutM = new JComboBox(outMm);
		comboBoxOutM.setBounds(281, 99, 116, 46);
		pn2.add(comboBoxOutM);
		
		JComboBox comboBoxOutD = new JComboBox(outDd);
		comboBoxOutD.setBounds(409, 99, 116, 46);
		pn2.add(comboBoxOutD);
		
		JRadioButton rdbtnAnimalExperience = new JRadioButton("동물먹이체험");
		rdbtnAnimalExperience.setBounds(153, 172, 116, 46);
		pn2.add(rdbtnAnimalExperience);
		
		JRadioButton rdbtnBreakfast = new JRadioButton("아침식사");
		rdbtnBreakfast.setBounds(273, 172, 88, 46);
		pn2.add(rdbtnBreakfast);
		
		JRadioButton rdbtnBbq = new JRadioButton("바베큐그릴");
		rdbtnBbq.setBounds(365, 172, 116, 46);
		pn2.add(rdbtnBbq);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(27, 10, 588, 109);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("예약 변경");
		label.setFont(new Font("굴림", Font.BOLD, 22));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(79, 23, 417, 76);
		panel_1.add(label);
		
		/* ==================================================================== */
		
		btnReservationChange.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String checkInDate = comboBoxInY.getSelectedItem().toString()+comboBoxInM.getSelectedItem()+comboBoxInD.getSelectedItem();
				String checkOutDate = comboBoxOutY.getSelectedItem().toString()+comboBoxOutM.getSelectedItem()+comboBoxOutD.getSelectedItem();
				boolean animalExperience = false;
				boolean breakfast = false;
				boolean bbq = false;
				
				if (rdbtnAnimalExperience.isSelected())
					animalExperience = true;
				if (rdbtnBreakfast.isSelected())
					breakfast = true;
				if (rdbtnBbq.isSelected())
					bbq = true;
				
				vo = new PensionReservationVO();
				vo.setmId(mid);
				vo.setCheckInDate(checkInDate);
				vo.setCheckOutDate(checkOutDate);
				vo.setAnimalExperience(animalExperience);
				vo.setBreakfast(breakfast);
				vo.setBbq(bbq);
				int res = dao.updateReservation(vo);
				if (res == 1)
					System.out.println("예약 변경에 성공하셨습니다. ");
				else
					System.out.println("예약 변경에 실패하였습니다.. ");

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
