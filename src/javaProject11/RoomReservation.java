package javaProject11;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

public class RoomReservation extends JFrame {

	private JPanel contentPane;
	PensionReservationDAO dao = new PensionReservationDAO();
	PensionReservationVO vo;
	
	String mid;
	
	private JTable table;
	private Vector title, reservationList;

	@SuppressWarnings("unchecked")
	public RoomReservation(String mid) {
		this.mid = mid;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setVisible(true);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(12, 224, 590, 278);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
		JLabel lblCheckIn = new JLabel("체크인날짜");
		lblCheckIn.setBounds(15, 87, 103, 63);
		pn3.add(lblCheckIn);
		
		JLabel lblCheckOut = new JLabel("체크아웃날짜");
		lblCheckOut.setBounds(15, 146, 103, 63);
		pn3.add(lblCheckOut);
		
		JLabel lblService = new JLabel("서비스항목");
		lblService.setHorizontalAlignment(SwingConstants.CENTER);
		lblService.setBounds(15, 205, 66, 63);
		pn3.add(lblService);
		
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
		comboBoxInY.setBounds(120, 95, 82, 46);
		pn3.add(comboBoxInY);
		
		JComboBox comboBoxInM = new JComboBox(inMm);
		comboBoxInM.setBounds(261, 95, 82, 46);
		pn3.add(comboBoxInM);
		
		JComboBox comboBoxInD = new JComboBox(inDd);
		comboBoxInD.setBounds(403, 95, 82, 46);
		pn3.add(comboBoxInD);
		
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
		comboBoxOutY.setBounds(120, 154, 82, 46);
		pn3.add(comboBoxOutY);
		
		JComboBox comboBoxOutM = new JComboBox(outMm);
		comboBoxOutM.setBounds(261, 163, 82, 46);
		pn3.add(comboBoxOutM);
		
		JComboBox comboBoxOutD = new JComboBox(outDd);
		comboBoxOutD.setBounds(403, 155, 82, 46);
		pn3.add(comboBoxOutD);
		
		String[] service = new String[2];
		service[0] = "아침식사";
		service[1] = "바베큐";
		
		JLabel labelInY = new JLabel("년");
		labelInY.setBounds(211, 95, 49, 46);
		pn3.add(labelInY);
		
		JLabel labelInM = new JLabel("월");
		labelInM.setBounds(355, 95, 49, 46);
		pn3.add(labelInM);
		
		JLabel labelInD = new JLabel("일");
		labelInD.setBounds(497, 95, 49, 46);
		pn3.add(labelInD);
		
		JLabel labelOutD = new JLabel("일");
		labelOutD.setBounds(514, 155, 49, 46);
		pn3.add(labelOutD);
		
		JLabel labelOutM = new JLabel("월");
		labelOutM.setBounds(367, 155, 49, 46);
		pn3.add(labelOutM);
		
		JLabel labelOutY = new JLabel("년");
		labelOutY.setHorizontalAlignment(SwingConstants.CENTER);
		labelOutY.setBounds(200, 163, 49, 46);
		pn3.add(labelOutY);
		
		JButton btnReservationMake = new JButton("예약하기");
		btnReservationMake.setBounds(369, 214, 82, 54);
		pn3.add(btnReservationMake);
		
		JRadioButton rdbtnAnimalExperience = new JRadioButton("동물먹이체험");
		rdbtnAnimalExperience.setBounds(89, 213, 97, 46);
		pn3.add(rdbtnAnimalExperience);
		
		JRadioButton rdbtnBreakfast = new JRadioButton("아침식사");
		rdbtnBreakfast.setBounds(187, 213, 73, 46);
		pn3.add(rdbtnBreakfast);
		
		JRadioButton rdbtnBbq = new JRadioButton("바베큐그릴");
		rdbtnBbq.setBounds(264, 213, 97, 46);
		pn3.add(rdbtnBbq);
		
		JButton btnCancel = new JButton("나가기");
		btnCancel.setBounds(463, 213, 82, 55);
		pn3.add(btnCancel);
		
		JComboBox comboBoxRoomChoice = new JComboBox();
		comboBoxRoomChoice.setBounds(261, 28, 220, 46);
		comboBoxRoomChoice.setModel(new DefaultComboBoxModel(new String[] {"2인실", "4인실", "4인실(반려동물)", "6인실"}));
		pn3.add(comboBoxRoomChoice);
		
		JLabel lblRoomChoice = new JLabel("펜션 선택");
		lblRoomChoice.setHorizontalAlignment(SwingConstants.CENTER);
		lblRoomChoice.setBounds(109, 26, 97, 51);
		pn3.add(lblRoomChoice);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(12, 59, 590, 167);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(12, 10, 590, 51);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		/* ========================================= */
		
		title = new Vector<>();
		title.add("아 이 디");
		title.add("체크인 날짜");
		title.add("체크아웃 날짜");
		
		reservationList = dao.getReservationList(/*dao.getReservationList("체크인 날짜","체크아웃 날짜")*/);
		
		System.out.println("reservationList : " + reservationList);
		
		DefaultTableModel dtm = new DefaultTableModel(reservationList, title);
		table = new JTable(dtm);
		JScrollPane scrollPaneReservationList = new JScrollPane(table);
		scrollPaneReservationList.setBounds(0, 10, 590, 151);
		pn2.add(scrollPaneReservationList);
		
		// 예약하기
		btnReservationMake.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String roomChoice = comboBoxRoomChoice.getSelectedItem().toString();
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
				vo.setrName(roomChoice);
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
		
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}
