package javaProject11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class PensionReservationDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = "";
	
	PensionReservationVO vo;
	
	public PensionReservationDAO() {
		String url = "jdbc:mysql://localhost:3306/javaProject11";
		String user = "root";
		String password = "1234";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버검색 실패~~~");
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 실패~~");
			e.printStackTrace();
		}
	}
	
	// connClose()
	public void connClose() {
		try {
			conn.close();
		} catch (SQLException e) {}
	}
	
	// pstmtClose()
	public void pstmtClose() {
		try {
			if(pstmt != null) pstmt.close();
		} catch (Exception e) {}
	}
	
	// rsClose()
	public void rsClose() {
		try {
			if(rs != null) rs.close();
		} catch (Exception e) {}
		pstmtClose();
	}
	
	// 로그인
	public int loginIdPassword(String id, String password) {
		System.out.println("dao 입니다.");
		PensionReservationVO vo = new PensionReservationVO();
		int res = 0;
		try {
			sql = "select * from customer where mid = ? and password = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			 
			if(rs.next()) {
				System.out.println("dao통과...");
				vo.setName(rs.getString("name"));
				res = 1;
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return res;
	}

	// 회원가입
	public int JoinMembership(PensionReservationVO vo) {
		int res = 0;
		try {
		sql = "insert into customer values (default, ?, ?, ?, ?, ?, ?, ?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getmId());
		pstmt.setString(2, vo.getPassword());
		pstmt.setString(3, vo.getName());
		pstmt.setString(4, vo.getBirth());
		pstmt.setString(5, vo.getGender());
		pstmt.setString(6, vo.getAddress());
		pstmt.setString(7, vo.getPhone());
		pstmt.executeUpdate();
		res = 1;
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
		
	}

	// 예약가입
	public int joinReservation(PensionReservationVO vo) {
		int res = 0;
//		try {
//			if(vo.checkInDate < ) sql = "select * from insa order by name";
//				else sql = "insert into roomRes value (?, ?, ?, ?, ?, ?, ?)";
			
		try {
			sql = "insert into roomRes value (?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getmId());
			pstmt.setString(2, vo.getrName());
			pstmt.setString(3, vo.getCheckInDate());
			pstmt.setString(4, vo.getCheckOutDate());
			pstmt.setBoolean(5, vo.isAnimalExperience());
			pstmt.setBoolean(6, vo.isBreakfast());
			pstmt.setBoolean(7, vo.isBbq());
			pstmt.executeUpdate();
			res = 1;
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

	public Vector getReservationList() {
		Vector rsList = new Vector<>();
		try {
			sql = "select * from roomRes";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector vo = new Vector<>();
				vo.add(rs.getString("mid"));
				vo.add(rs.getString("inDate"));
				vo.add(rs.getString("outDate"));
				rsList.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
			// e.printStackTrace();
		} finally {
			rsClose();
		}
		return rsList;
	}

//	@SuppressWarnings({ "unchecked", "rawtypes" })
//	//rsListDay = 예약 리스트에서 있는 방 이름 
//	public Vector getReservationList(Vector rsListDay) {
//		Vector rsList = new Vector<>();
//		try {
//			sql = "select * from roomIntro";
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				Vector vo = new Vector<>();
//				
//				int sw = 1;
//				
//					for(int i = 0; i<rsListDay.size(); i++) {
//						sw = 1;
//					if(rsListDay.get(i).equals(rs.getString("방이름"))){
//						System.out.println("방이름 동일 ");
//						sw = 0;
//						break;
//					}
//
//				}
//
//				if(sw == 1) {
//					System.out.println("예약 가능 방");
//					
//					vo.add(rs.getString("mid"));
//					vo.add(rs.getString("inDate"));
//					vo.add(rs.getString("outDate"));
//					
//					
//					rsList.add(vo);
//				}
//			}
//		} catch (SQLException e) {
//			System.out.println("SQL 오류 : " + e.getMessage());
//		} finally {
//			rsClose();
//		}
//		return rsList;
//	}
//
//	public Vector getReservationList(String S1 , String E1) {
//		
//		Vector vo = new Vector<>();
//		
//		try {
//			sql = "select * from roomRes WHERE outDate > 시작? or 끝 > inDate ";
//			pstmt = conn.prepareStatement(sql);
//			
//			pstmt.execute(S1);
//			pstmt.execute(E1);
//			
//			rs = pstmt.executeQuery();
//					
//			while(rs.next()) {
//				vo.add(rs.getString("mid")); //방이름
//		}	
//		} catch (SQLException e) {
//			System.out.println("SQL 오류 : " + e.getMessage());
//		} finally {
//			rsClose();
//		}
//		return vo;
//	}
	
	public int updateReservation(PensionReservationVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}
}
