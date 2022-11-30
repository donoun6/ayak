package com.ayak.phms.membership;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/jvx330?serverTimezone=Asia/Seoul";
	private static final String JDBC_USER = "jvx330";
	private static final String JDBC_PASSWORD = "jvx330";
	
	  public UserDao() {
			try {
				Class.forName(JDBC_DRIVER); //JDBC 드라이버 로딩
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
	  }
	  }	  
	  
//	  =============================================== 회원가입 ====================================================
	  public void addUser(User user) {
		  String sql = "INSERT INTO User (userId, userPassWd, userName, dateOfBirth, userGender, userEmail, userphone)" //SQL문을 sql이라는 변수에 넣는다.
		  		+ "VALUES (?,?,?,?,?,?,?)";
		  try {
			  Connection con = null;
				PreparedStatement pstmt = null;
		 try {
			  con = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD); //BDMS 접속 
			  pstmt = con.prepareStatement(sql); // 연결된 DB에 SQL문을 실행한 후 결괏값을 가져오는 메서드 Statement와 같은 기능을 수행하지만 가독성과 유지보수가 좋다.
			  pstmt.setString(1, user.getUserId()); //위 SQL문 1번째 인자값으로 user에 저장된 userId값을 가져온다.
			  pstmt.setString(2, user.getUserPassWd());
			  pstmt.setString(3, user.getUserName());
			  pstmt.setString(4, user.getDateOfBirth());
			  pstmt.setString(5, user.getUserGender());
			  pstmt.setString(6, user.getUserEmail());
			  pstmt.setString(7, user.getUserphone());
			  pstmt.executeUpdate(); //데이터베이스에서 데이터를 추가(Insert), 삭제(Delete), 수정(Update)하는 결과 값이 나와 되지않는 SQL 문을 실행합니다. 
			  //만약 DB에 저장되어있는 결과 값을 불러오기 위해서는 executeQuery()메서드를 사용한다. ex)SELECT와 같은 결과값이 필요한 SQL문을 실행할때.
			  
			  pstmt.close(); //자원 해제, DB처리 작업이 완료되면 사용한 객체들을 메모리에서 해제해줘야한다.
			  con.close();
		  }finally { //자원 해제를 두번단 이유는 나도 잘 모르겠다 finally에만 달면 되는거같은데 건들기 무서워서.. 문제가 없어서 내버려둔당
			  pstmt.close();
			  con.close();
		  }
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
	 }

//	  ===============================================phone 중복확인 ====================================================	  
		
	  public int checkUserPhone (String phone) {
			String sql = "SELECT userphone FROM User WHERE userphone = ?"; 
			System.out.println(phone+"1");
			try {
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null; 
				try {
					con = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, phone); 
					rs = pstmt.executeQuery(); // select 구문을 수행할때 쓰임 값을 가져오는 용도?
					if(rs.next()) { //
						if(rs.getString(1).contentEquals(phone)) { //Equals는 인스턴스객체도 비교하지만 contentEquals는 문자열의 값만 비교
							//즉, String 객체를 StringBuffer / StringBuilder / Char Array 객체들과 비교 가능
							System.out.println(rs.getString(1)+"2");
							System.out.println("아이디 중복");
							return 1;					
						}
					}
					System.out.println("아이디 중복 없음");
					return 2;
				}finally {
					rs.close();
					pstmt.close();
					con.close();				
				}
			}catch(SQLException e) {
					e.printStackTrace();
				}
			return 3;	//DB오류
			}
	  
//	  ===============================================ID 중복확인 ====================================================
		public int checkUserId (String id) {
			String sql = "SELECT userId FROM User WHERE userId = ?"; //addUser 테이블의 id(입력) 데이터에 맞는 passwd를 찾는다.
			System.out.println(id+"1");
			try {
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null; // select 구문을 수행할때 쓰임 값을 가져오는 용도? ResultSet객체에 결과값을 담는다.
				try {
					con = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, id); // 쿼리문의 ? 에 인자값으로 넣은 id를 넣어 찾아낸다. 
					rs = pstmt.executeQuery(); // select 구문을 수행할때 쓰임 값을 가져오는 용도?
					if(rs.next()) { //
						if(rs.getString(1).contentEquals(id)) { //Equals는 인스턴스객체도 비교하지만 contentEquals는 문자열의 값만 비교
							//즉, String 객체를 StringBuffer / StringBuilder / Char Array 객체들과 비교 가능
							System.out.println(rs.getString(1)+"2");
							System.out.println("아이디 중복");
							return 1;					
						}
					}
					System.out.println("아이디 중복 없음");
					return 2;
				}finally {
					rs.close();
					pstmt.close();
					con.close();				
				}
			}catch(SQLException e) {
					e.printStackTrace();
				}
			return 3;	//DB오류
			}
		
		
//		  ===============================================Email 중복확인 ====================================================
		public int checkUserEmail (String email) {
			String sql = "SELECT userEmail FROM User WHERE userEmail = ?"; //addUser 테이블의 id(입력) 데이터에 맞는 passwd를 찾는다.
			System.out.println(email +"1");
			try {
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null; // select 구문을 수행할때 쓰임 값을 가져오는 용도? ResultSet객체에 결과값을 담는다.
				try {
					con = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, email); // 쿼리문의 ? 에 인자값으로 넣은 id를 넣어 찾아낸다. 
					rs = pstmt.executeQuery(); // select 구문을 수행할때 쓰임 값을 가져오는 용도?
					if(rs.next()) { //
						if(rs.getString(1).contentEquals(email)) { //Equals는 인스턴스객체도 비교하지만 contentEquals는 문자열의 값만 비교
							//즉, String 객체를 StringBuffer / StringBuilder / Char Array 객체들과 비교 가능
							System.out.println(rs.getString(1)+"2");
							System.out.println("이메일 중복");
							return 1;					
						}
					}
					System.out.println("이메일 중복 없음");
					return 2;
				}finally {
					rs.close();
					pstmt.close();
					con.close();				
				}
			}catch(SQLException e) {
					e.printStackTrace();
				}
			return 3;	//DB오류
			}
		

		
//	  =============================================== 로그인 ====================================================
	public int login(String id, String passwd) {
		String sql = "SELECT userPassWd FROM User WHERE userId = ?"; //addUser 테이블의 id(입력) 데이터에 맞는 passwd를 찾는다.
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null; // select 구문을 수행할때 쓰임 값을 가져오는 용도? ResultSet객체에 결과값을 담는다.
			try {
				con = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id); // 쿼리문의 ? 에 인자값으로 넣은 id를 넣어 찾아낸다. 
				rs = pstmt.executeQuery(); // select 구문을 수행할때 쓰임 값을 가져오는 용도?
				if(rs.next()) { //
					if(rs.getString(1).contentEquals(passwd)) { //Equals는 인스턴스객체도 비교하지만 contentEquals는 문자열의 값만 비교
						//즉, String 객체를 StringBuffer / StringBuilder / Char Array 객체들과 비교 가능
						System.out.println("로그인");
						return 1;					
					}else {
						System.out.println("비밀번호 오류");
							return 2;
					}
				}
				System.out.println("아이디 오류");
				return -1;
			}finally {
				rs.close();
				pstmt.close();
				con.close();				
			}
		}catch(SQLException e) {
				e.printStackTrace();
			}
		return -2;	//DB오류
		}
	
	
//	  =============================================== 아이디찾기 ====================================================
	private String userId;
	
	public String getFindUserId() {
		return userId;
	}
	
	public int findUserId(String email, String phone) {
		String sql = "SELECT userphone , userId FROM User WHERE userEmail = ?"; //addUser 테이블의 id(입력) 데이터에 맞는 passwd를 찾는다.
		System.out.println(email);
		System.out.println(phone);
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null; // select 구문을 수행할때 쓰임 값을 가져오는 용도? ResultSet객체에 결과값을 담는다.
			try {
				con = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, email); // 쿼리문의 ? 에 인자값으로 넣은 id를 넣어 찾아낸다. 
				rs = pstmt.executeQuery(); // select 구문을 수행할때 쓰임 값을 가져오는 용도?
				if(rs.next()) { //
					if(rs.getString(1).contentEquals(phone)) { //Equals는 인스턴스객체도 비교하지만 contentEquals는 문자열의 값만 비교
						//즉, String 객체를 StringBuffer / StringBuilder / Char Array 객체들과 비교 가능
						System.out.println(rs.getString(2));
						userId = rs.getString(2);
						return 1;					
					}else {
						System.out.println("번호 오류");
							return 2;
					}
				}
				System.out.println("아이디 오류");
				return -1;
			}finally {
				rs.close();
				pstmt.close();
				con.close();				
			}
		}catch(SQLException e) {
				e.printStackTrace();
			}
		return -2;	//DB오류
		}
	
//	public static void main(String[] args) {
//		UserDao userDao = new UserDao();
//		userDao.findUserId("donoun6@naver.com", "010-8396-5353");
//	}
	
//	  =============================================== 비밀번호 찾기 ====================================================
		private String userPw;
		
		public String getFindUserPw() {
			return userPw;
		}
	  
		public int findUserPw(String id, String phone) {
			String sql = "SELECT userphone , userPassWd FROM User WHERE userId = ?"; //addUser 테이블의 id(입력) 데이터에 맞는 passwd를 찾는다.
			System.out.println(id + "1");
			System.out.println(phone + "1");
			try {
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null; // select 구문을 수행할때 쓰임 값을 가져오는 용도? ResultSet객체에 결과값을 담는다.
				try {
					con = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, id); // 쿼리문의 ? 에 인자값으로 넣은 id를 넣어 찾아낸다. 
					rs = pstmt.executeQuery(); // select 구문을 수행할때 쓰임 값을 가져오는 용도?
					if(rs.next()) { //
						if(rs.getString(1).contentEquals(phone)) { //Equals는 인스턴스객체도 비교하지만 contentEquals는 문자열의 값만 비교
							//즉, String 객체를 StringBuffer / StringBuilder / Char Array 객체들과 비교 가능
							System.out.println(rs.getString(2) + "1");
							userPw = rs.getString(2);
							return 1;					
						}else {
							System.out.println("번호 오류");
								return 2;
						}
					}
					System.out.println("아이디 오류");
					return -1;
				}finally {
					rs.close();
					pstmt.close();
					con.close();				
				}
			}catch(SQLException e) {
					e.printStackTrace();
				}
			return -2;	//DB오류
			}
//		public static void main(String[] args) {
//		UserDao userDao = new UserDao();
//		userDao.findUserPw("donoun6","010-8396-5353");
//	}
		  
}
