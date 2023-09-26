package javaProject11;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class RoomReservation extends JFrame {

	private JPanel contentPane;
	PensionReservationDAO dao = new PensionReservationDAO();
	PensionReservationVO vo;

	public RoomReservation() {
		setTitle("예약설정");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setVisible(true);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(8, 75, 590, 290);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JLabel lblCheckIn = new JLabel("체크인날짜");
		lblCheckIn.setBounds(15, 17, 103, 63);
		pn2.add(lblCheckIn);
		
		JLabel lblCheckOut = new JLabel("체크아웃날짜");
		lblCheckOut.setBounds(16, 111, 103, 63);
		pn2.add(lblCheckOut);
		
		JLabel lblService = new JLabel("서비스항목");
		lblService.setBounds(15, 184, 103, 63);
		pn2.add(lblService);
		
		String[] inYy = new String[20];
		String[] inMm = new String[12];
		String[] inDd = new String[31];
		
		int imsi;
		for(int i=0; i<inYy.length; i++) {
			imsi = i + 2023;
			inYy[i] = imsi + "";
		}
		for(int i=0; i<inMm.length; i++) {
			inMm[i] = (i+1) + "";
		}
		for(int i=0; i<inDd.length; i++) {
			inDd[i] = (i+1) + "";
		}
		
		JComboBox comboBoxInY = new JComboBox(inYy);
		comboBoxInY.setBounds(187, 25, 82, 46);
		pn2.add(comboBoxInY);
		
		JComboBox comboBoxInM = new JComboBox(inMm);
		comboBoxInM.setBounds(334, 25, 82, 46);
		pn2.add(comboBoxInM);
		
		JComboBox comboBoxInD = new JComboBox(inDd);
		comboBoxInD.setBounds(487, 25, 82, 46);
		pn2.add(comboBoxInD);
		
		String[] outYy = new String[20];
		String[] outMm = new String[12];
		String[] outDd = new String[31];
		
		for (int i=0; i<outYy.length; i++)
			outYy[i] = i + 2023 + "";
		
		for (int i=0; i<outMm.length; i++)
			outMm[i] = (i+1) + "";
		
		for (int i=0; i<outMm.length; i++)
			outDd[i] = (i+1) + "";
		
		JComboBox comboBoxOutY = new JComboBox(outYy);
		comboBoxOutY.setBounds(188, 119, 82, 46);
		pn2.add(comboBoxOutY);
		
		JComboBox comboBoxOutM = new JComboBox(outMm);
		comboBoxOutM.setBounds(335, 119, 82, 46);
		pn2.add(comboBoxOutM);
		
		JComboBox comboBoxOutD = new JComboBox(outDd);
		comboBoxOutD.setBounds(488, 119, 82, 46);
		pn2.add(comboBoxOutD);
		
		String[] service = new String[2];
		service[0] = "아침식사";
		service[1] = "바베큐";
		
		JLabel labelInY = new JLabel("년");
		labelInY.setBounds(126, 25, 49, 46);
		pn2.add(labelInY);
		
		JLabel labelInM = new JLabel("월");
		labelInM.setBounds(281, 25, 49, 46);
		pn2.add(labelInM);
		
		JLabel labelInD = new JLabel("일");
		labelInD.setBounds(428, 25, 49, 46);
		pn2.add(labelInD);
		
		JLabel labelOutD = new JLabel("일");
		labelOutD.setBounds(427, 119, 49, 46);
		pn2.add(labelOutD);
		
		JLabel labelOutM = new JLabel("월");
		labelOutM.setBounds(282, 111, 49, 46);
		pn2.add(labelOutM);
		
		JLabel labelOutY = new JLabel("년");
		labelOutY.setBounds(127, 111, 49, 46);
		pn2.add(labelOutY);
		
		JButton btnReservationMake = new JButton("에약하기");
		btnReservationMake.setBounds(428, 194, 125, 63);
		pn2.add(btnReservationMake);
		
		JRadioButton rdbtnAnimalExperience = new JRadioButton("동물먹이체험");
		rdbtnAnimalExperience.setBounds(112, 192, 116, 46);
		pn2.add(rdbtnAnimalExperience);
		
		JRadioButton rdbtnBreakfast = new JRadioButton("아침식사");
		rdbtnBreakfast.setBounds(228, 192, 88, 46);
		pn2.add(rdbtnBreakfast);
		
		JRadioButton rdbtnBbq = new JRadioButton("바베큐그릴");
		rdbtnBbq.setBounds(320, 192, 116, 46);
		pn2.add(rdbtnBbq);
		
		/* ========================================= */
		
		btnReservationMake.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String checkInDate = comboBoxInY.getSelectedItem().toString()+comboBoxInY.getSelectedItem()+comboBoxInY.getSelectedItem();
				String checkOutDate = comboBoxOutY.getSelectedItem().toString()+comboBoxOutY.getSelectedItem()+comboBoxOutY.getSelectedItem();
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
				vo.setId("seungsyu");
				vo.setCheckInDate(checkInDate);
				vo.setCheckOutDate(checkOutDate);
				vo.setAnimalExperience(animalExperience);
				vo.setBreakfast(breakfast);
				vo.setBbq(bbq);
				int res = dao.joinReservation(vo);
				if (res == 1)
					System.out.println("예약에 성공하셨습니다. ");
				else
					System.out.println("예약에 실패였습니다.. ");

			}
		});
	}
}
