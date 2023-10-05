package project11;

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
	
	PensionReservationVO vo;
	String sql = "";
	int res;
	
	public PensionReservationDAO() {
		String url = "jdbc:mysql://localhost:3306/javaproject11";
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
		vo = new PensionReservationVO();
		res = 0;
		try {
			sql = "select * from customer where mid = ? and password = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			 
			if(rs.next()) res = 1;
			
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return res;
	}
	
	// 회원 조회
	public PensionReservationVO getMemberSearch(String mid) {
		try {
			vo = new PensionReservationVO();
			sql = "select * from customer where mid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo.setName(rs.getString("name"));
				vo.setmId(rs.getString("mId"));
				vo.setPassword(rs.getString("password"));
				vo.setBirth(rs.getString("birth"));
				vo.setGender(rs.getString("gender"));
				vo.setAddress(rs.getString("address"));
				vo.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			System.out.println("SQL 문장 오류 : " + e.getMessage());
		} finally {
			rsClose();
			}
		return vo;
	}

	// 회원 가입
	public int JoinMembership(PensionReservationVO vo) {
		int res = 0;
		try {
		sql = "insert into customer values (default, ?, ?, ?, ?, ?, ?, ?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getName());
		pstmt.setString(2, vo.getmId());
		pstmt.setString(3, vo.getPassword());
		pstmt.setString(4, vo.getBirth());
		pstmt.setString(5, vo.getGender());
		pstmt.setString(6, vo.getAddress());
		pstmt.setString(7, vo.getPhone());
		res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}
	
	// 회원 정보 수정
	public int EditMember(PensionReservationVO vo) {
		int res = 0;
		try {
		sql = "update customer set name=?, password=? ,birth=? ,gender=? ,address=?, phone=? where mId = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getName());
		pstmt.setString(2, vo.getPassword());
		pstmt.setString(3, vo.getBirth());
		pstmt.setString(4, vo.getGender());
		pstmt.setString(5, vo.getAddress());
		pstmt.setString(6, vo.getPhone());
		pstmt.setString(7, vo.getmId());
		res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}
	
	// 회원 정보 삭제
	public int DeleteMember(String mid) {
		int res = 0;
		try {
			sql = "delete from customer where mId = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}
	
	//	예약 조회
		public PensionReservationVO getReservationSearch(String mid) {
			vo = new PensionReservationVO();
			try {
				sql = "select * from roomRes where mId = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, mid);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					vo.setmId(rs.getString("mId"));
					vo.setrName(rs.getString("rName"));
					vo.setCheckInDate(rs.getDate("inDate"));
					vo.setCheckOutDate(rs.getDate("outDate"));
					vo.setAnimalExperience(rs.getBoolean("animalExperience"));
					vo.setBreakfast(rs.getBoolean("breakfast"));
					vo.setBbq(rs.getBoolean("bbq"));
				}
			} catch (SQLException e) {
				System.out.println("SQL 오류 : " + e.getMessage());
			} finally {
				pstmtClose();
			}
			return vo;
		}
	
	// 전체 예약 목록
	public Vector getReservationList() {
		Vector rsList = new Vector<>();
		try {
			sql = "select * from roomRes";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector vo = new Vector<>();
				vo.add(rs.getString("rName"));
				vo.add(rs.getDate("inDate"));
				vo.add(rs.getDate("outDate"));
				rsList.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return rsList;
	}
	
	// 전체 예약 목록(로그인 아이디 제외)
		public Vector getReservationListTwo(String mid) {
			//seo
			Vector rsList = new Vector<>();
			try {
				sql = "select * from roomRes WHERE mId NOT IN ( ? );";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, mid);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					Vector vo = new Vector<>();
					vo.add(rs.getString("rName"));
					vo.add(rs.getDate("inDate"));
					vo.add(rs.getDate("outDate"));
					rsList.add(vo);
				}
			} catch (SQLException e) {
				System.out.println("SQL 오류 : " + e.getMessage());
			} finally {
				rsClose();
			}
			return rsList;
		}

	// 예약 가입
	public int joinReservation(PensionReservationVO vo) {
		int res = 0;
		try {
			sql = "insert into roomRes value (?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getmId());
			pstmt.setString(2, vo.getrName());
			pstmt.setDate(3, vo.getCheckInDate());
			pstmt.setDate(4, vo.getCheckOutDate());
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
	
	// 예약 정보 수정
	public int EditReservation(PensionReservationVO vo) {
		res = 0;
		try {
			sql = "update roomRes set rName=? ,inDate=? ,outDate=? ,animalExperience=?, breakfast=?, bbq=? where mId = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getrName());
			pstmt.setDate(2, vo.getCheckInDate());
			pstmt.setDate(3, vo.getCheckOutDate());
			pstmt.setBoolean(4, vo.isAnimalExperience());
			pstmt.setBoolean(5, vo.isBreakfast());
			pstmt.setBoolean(6, vo.isBbq());
			pstmt.setString(7, vo.getmId());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		//	System.out.println(res); // 다중 예약시 res가 1을 초과하며 모든 정보가 변경됨
		return res;
	}

	// 예약 정보 삭제
	public int deleteReservation(String mid) {
		res = 0;
		try {
			sql = "DELETE FROM roomRes WHERE mId = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}
}
