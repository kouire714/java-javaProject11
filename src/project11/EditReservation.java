package project11;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;

public class EditReservation extends JFrame {

	private JPanel contentPane;
	PensionReservationDAO dao = new PensionReservationDAO();
	PensionReservationVO vo;
	
	private JTable table;
	private Vector title, reservationList;
	
	String mid;
	int res;

	@SuppressWarnings("unchecked")
	public EditReservation(PensionReservationVO vo, String mid) {
		this.mid = mid;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);
		
		setVisible(true);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(12, 252, 608, 262);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
		JLabel lblCheckIn = new JLabel("체크인날짜");
		lblCheckIn.setFont(new Font("굴림", Font.PLAIN, 15));
		lblCheckIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckIn.setBounds(15, 74, 100, 50);
		pn3.add(lblCheckIn);
		
		JLabel lblCheckOut = new JLabel("체크아웃날짜");
		lblCheckOut.setFont(new Font("굴림", Font.PLAIN, 15));
		lblCheckOut.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckOut.setBounds(15, 136, 100, 50);
		pn3.add(lblCheckOut);
		
		JLabel lblService = new JLabel("서비스항목");
		lblService.setFont(new Font("굴림", Font.PLAIN, 15));
		lblService.setHorizontalAlignment(SwingConstants.CENTER);
		lblService.setBounds(15, 198, 100, 50);
		pn3.add(lblService);
		
		LocalDate inDay = LocalDate.now();
		
		String[] inYy = new String[1];
		String[] inMm = new String[12 - (inDay.getMonthValue()-1)];
		String[] inDd = new String[31];
		
		for (int i=0; i<inYy.length; i++)
			inYy[i] = inDay.getYear() + i + "";
		
		for (int i=0; i<inMm.length; i++)
		{
			inMm[i] = (inDay.getMonthValue()+i) + "";
		}
		
		for (int i=inDay.getDayOfMonth(); i<inDd.length; i++)
		{
			inDd[i] = (i + 1) + "";
		}
		
		JComboBox comboBoxInY = new JComboBox(inYy);
		comboBoxInY.setFont(new Font("굴림", Font.PLAIN, 15));
		comboBoxInY.setBounds(143, 74, 100, 50);
		pn3.add(comboBoxInY);
		
		JComboBox comboBoxInM = new JComboBox(inMm);
		comboBoxInM.setFont(new Font("굴림", Font.PLAIN, 15));
		comboBoxInM.setBounds(317, 74, 50, 50);
		pn3.add(comboBoxInM);
		
		JComboBox comboBoxInD = new JComboBox(inDd);
		comboBoxInD.setFont(new Font("굴림", Font.PLAIN, 15));
		comboBoxInD.setBounds(441, 74, 50, 50);
		pn3.add(comboBoxInD);
		
		LocalDate outDay = LocalDate.now();
		
		String[] outYy = new String[4];
		String[] outMm = new String[12 - (outDay.getMonthValue()-1)];
		String[] outDd = new String[31];
		
		for (int i=0; i<outYy.length; i++)
			outYy[i] = outDay.getYear() + i + "";
		
		for (int i=0; i<outMm.length; i++)
		{
			outMm[i] = (outDay.getMonthValue()+i) + "";
		}
		
		for (int i=outDay.getDayOfMonth(); i<outDd.length; i++)
		{
			outDd[i] = (i + 2) + "";
		}
		
		JComboBox comboBoxOutY = new JComboBox(outYy);
		comboBoxOutY.setFont(new Font("굴림", Font.PLAIN, 15));
		comboBoxOutY.setBounds(143, 136, 100, 50);
		pn3.add(comboBoxOutY);
		
		JComboBox comboBoxOutM = new JComboBox(outMm);
		comboBoxOutM.setFont(new Font("굴림", Font.PLAIN, 15));
		comboBoxOutM.setBounds(317, 136, 50, 50);
		pn3.add(comboBoxOutM);
	
		JComboBox comboBoxOutD = new JComboBox(outDd);
		comboBoxOutD.setFont(new Font("굴림", Font.PLAIN, 15));
		comboBoxOutD.setBounds(441, 136, 50, 50);
		pn3.add(comboBoxOutD);
		
		String[] service = new String[4];
		service[0] = "아침식사";
		service[1] = "바베큐";
		
		JLabel labelInY = new JLabel("년");
		labelInY.setFont(new Font("굴림", Font.PLAIN, 15));
		labelInY.setHorizontalAlignment(SwingConstants.CENTER);
		labelInY.setBounds(255, 74, 50, 50);
		pn3.add(labelInY);
		
		JLabel labelInM = new JLabel("월");
		labelInM.setFont(new Font("굴림", Font.PLAIN, 15));
		labelInM.setHorizontalAlignment(SwingConstants.CENTER);
		labelInM.setBounds(379, 74, 50, 50);
		pn3.add(labelInM);
		
		JLabel labelInD = new JLabel("일");
		labelInD.setFont(new Font("굴림", Font.PLAIN, 15));
		labelInD.setHorizontalAlignment(SwingConstants.CENTER);
		labelInD.setBounds(503, 74, 50, 50);
		pn3.add(labelInD);
		
		JLabel labelOutD = new JLabel("일");
		labelOutD.setFont(new Font("굴림", Font.PLAIN, 15));
		labelOutD.setHorizontalAlignment(SwingConstants.CENTER);
		labelOutD.setBounds(503, 136, 50, 50);
		pn3.add(labelOutD);
		
		JLabel labelOutM = new JLabel("월");
		labelOutM.setFont(new Font("굴림", Font.PLAIN, 15));
		labelOutM.setHorizontalAlignment(SwingConstants.CENTER);
		labelOutM.setBounds(379, 136, 50, 50);
		pn3.add(labelOutM);
		
		JLabel labelOutY = new JLabel("년");
		labelOutY.setFont(new Font("굴림", Font.PLAIN, 15));
		labelOutY.setHorizontalAlignment(SwingConstants.CENTER);
		labelOutY.setBounds(255, 136, 50, 50);
		pn3.add(labelOutY);
		
		JButton btnReservationMake = new JButton("예약하기");
		btnReservationMake.setFont(new Font("굴림", Font.PLAIN, 15));
		btnReservationMake.setBounds(265, 12, 91, 50);
		pn3.add(btnReservationMake);
		
		JRadioButton rdbtnAnimalExperience = new JRadioButton("동물먹이체험");
		rdbtnAnimalExperience.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnAnimalExperience.setFont(new Font("굴림", Font.PLAIN, 15));
		if (vo.isAnimalExperience() == true)
			rdbtnAnimalExperience.setSelected(true);
		else
			rdbtnAnimalExperience.setSelected(false);
		rdbtnAnimalExperience.setBounds(143, 198, 142, 50);
		pn3.add(rdbtnAnimalExperience);
		
		JRadioButton rdbtnBreakfast = new JRadioButton("아침식사");
		rdbtnBreakfast.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnBreakfast.setFont(new Font("굴림", Font.PLAIN, 15));
		if (vo.isBreakfast() == true)
			rdbtnBreakfast.setSelected(true);
		else
			rdbtnBreakfast.setSelected(false);
		rdbtnBreakfast.setBounds(306, 198, 100, 50);
		pn3.add(rdbtnBreakfast);
		
		JRadioButton rdbtnBbq = new JRadioButton("바베큐그릴");
		rdbtnBbq.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnBbq.setFont(new Font("굴림", Font.PLAIN, 15));
		if (vo.isBbq() == true)
			rdbtnBbq.setSelected(true);
		else
			rdbtnBbq.setSelected(false);
		rdbtnBbq.setBounds(426, 198, 100, 50);
		pn3.add(rdbtnBbq);
		
		JButton btnCancel = new JButton("나가기");
		btnCancel.setFont(new Font("굴림", Font.PLAIN, 15));
		btnCancel.setBounds(478, 12, 91, 50);
		pn3.add(btnCancel);
		
		JComboBox comboBoxRoomChoice = new JComboBox();
		comboBoxRoomChoice.setFont(new Font("굴림", Font.PLAIN, 15));
		comboBoxRoomChoice.setBounds(123, 12, 120, 50);
		comboBoxRoomChoice.setModel(new DefaultComboBoxModel(new String[] {"2인실", "4인실", "4인실(반려동물)", "6인실"}));
		comboBoxRoomChoice.setSelectedItem(vo.getrName());
		pn3.add(comboBoxRoomChoice);
		
		
		JLabel lblRoomChoice = new JLabel("펜션 선택");
		lblRoomChoice.setFont(new Font("굴림", Font.PLAIN, 15));
		lblRoomChoice.setHorizontalAlignment(SwingConstants.CENTER);
		lblRoomChoice.setBounds(15, 12, 100, 50);
		pn3.add(lblRoomChoice);
		
		JButton btnReservationDelete = new JButton("예약삭제");
		btnReservationDelete.setFont(new Font("굴림", Font.PLAIN, 15));
		btnReservationDelete.setBounds(375, 12, 91, 50);
		pn3.add(btnReservationDelete);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(12, 93, 608, 154);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(12, 10, 608, 78);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JLabel lblReservation = new JLabel("예약 현황 / 예약 변경");
		lblReservation.setFont(new Font("굴림", Font.BOLD, 30));
		lblReservation.setHorizontalAlignment(SwingConstants.CENTER);
		lblReservation.setBounds(85, 10, 415, 58);
		pn1.add(lblReservation);
		
		// 전체 예약 리스트 출력(로그인 아이디 제외)
		title = new Vector<>();
		title.add("방 목록");
		title.add("체크인 날짜");
		title.add("체크아웃 날짜");
		System.out.println(mid);
		reservationList = dao.getReservationListTwo(mid);
				
		DefaultTableModel dtm = new DefaultTableModel(reservationList, title);
		table = new JTable(dtm);
		JScrollPane scrollPaneReservationList = new JScrollPane(table);
		scrollPaneReservationList.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPaneReservationList.setBounds(0, 10, 608, 141);
		pn2.add(scrollPaneReservationList);
				
		
		/* ========================================= */
		
		btnReservationMake.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String roomChoice = comboBoxRoomChoice.getSelectedItem().toString();
				boolean animalExperience = false;
				boolean breakfast = false;
				boolean bbq = false;
				
				if (rdbtnAnimalExperience.isSelected())
					animalExperience = true;
				if (rdbtnBreakfast.isSelected())
					breakfast = true;
				if (rdbtnBbq.isSelected())
					bbq = true;
				
				reservationList = dao.getReservationListTwo(mid);

				Date checkInDate = new Date(Integer.valueOf(comboBoxInY.getSelectedItem().toString())-1900 ,Integer.valueOf(comboBoxInM.getSelectedItem().toString())-1 , Integer.valueOf(comboBoxInD.getSelectedItem().toString()) );
				System.out.println(checkInDate.toString());
				Date checkOutDat = new Date(Integer.valueOf(comboBoxOutY.getSelectedItem().toString())-1900 ,Integer.valueOf(comboBoxOutM.getSelectedItem().toString())-1 , Integer.valueOf(comboBoxOutD.getSelectedItem().toString()) );
				
				for (int i=0; i < reservationList.size(); i++) {
							
					if (((Vector)reservationList.get(i)).get(0).equals(roomChoice)) {
							
						Date dateInDayReservation  = (Date)((Vector)reservationList.get(i)).get(1);
						Date dateOutDayReservation  = (Date)((Vector)reservationList.get(i)).get(2);
							
						System.out.println("dateInDayReservation : " + dateInDayReservation);
						
						if (checkOutDat.after(checkInDate)) {
							if (dateInDayReservation.after(checkInDate)) {
								if (dateInDayReservation.after(checkOutDat))
									System.out.println("예약 날짜 통과");
								else {
									JOptionPane.showMessageDialog(null, "이미 예약된 날짜입니다, 다른 날짜를 선택해주세요. ");
									return;	}
							}
							else if (dateInDayReservation.before(checkInDate)) {
								if(dateOutDayReservation.before(checkInDate)) 
									System.out.println("예약 날짜 통과 2");
								else {
									JOptionPane.showMessageDialog(null, "이미 예약된 날짜입니다, 다른 날짜를 선택해주세요. ");
									return;	}
							}
							else {
								JOptionPane.showMessageDialog(null, "이미 예약된 날짜입니다, 다른 날짜를 선택해주세요. ");
								return;	}
						}
						else {
							JOptionPane.showMessageDialog(null, "체크아웃날짜가 체크인 날짜보다 빠릅니다 다시 설정해 주세요. ");
							return;	}
					}
				}
	
				PensionReservationVO vo = new PensionReservationVO();
				
				vo.setmId(mid);
				vo.setrName(roomChoice);
				vo.setCheckInDate(checkInDate);
				vo.setCheckOutDate(checkOutDat);
				vo.setAnimalExperience(animalExperience);
				vo.setBreakfast(breakfast);
				vo.setBbq(bbq);
				
				
				res = dao.EditReservation(vo);
				if (res == 1) 
					JOptionPane.showMessageDialog(null, "예약 변경 성공. ");
				else
					JOptionPane.showMessageDialog(null, "예약 변경 실패, 다시 가입하세요. ");
			}
		});
		
		btnReservationDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				res = dao.deleteReservation(mid);
				if (res == 1) 
					JOptionPane.showMessageDialog(null, "예약 삭제 성공. ");
				else
					JOptionPane.showMessageDialog(null, "예약 삭제 실패, 다시 가입하세요. ");
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