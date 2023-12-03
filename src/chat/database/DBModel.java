package chat.database;

import java.sql.*;

public class DBModel {
	static public UserDB userDB = new UserDB();
	
	public static class UserDB {
		String userName;

		public boolean login(String uid, String pwd) {
			DBcon db = new DBcon("user_db");
			Connection con = db.getConnection();
			String query = "SELECT * FROM user_table";
			
			boolean res = false;
			try {
				PreparedStatement pstmt = con.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery();
				
				while (rs.next()) {
					// 여기서 데이터를 가져와서 처리
					if (rs.getString("uid").equals(uid) && rs.getString("pwd").equals(pwd)) {
						res = true;
						userName = rs.getString("user_name");
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return res;
		}
		
		public String getUserName() {
			return userName;
		}
	}
	
	public static class MsgDB {
		public static void addMsg(String text) {
			DBcon db = new DBcon("msg_db");
			Connection con = db.getConnection();
			String query = "INSERT INTO msg_table (msg) VALUES (?)";

			try {
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, text);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

class DBcon {
	String driver = "org.mariadb.jdbc.Driver";
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public DBcon(String DB) {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(
					"jdbc:mariadb://127.0.0.1:3306/"+DB,
					"root",
					"3538");
			if (con != null) {
				System.out.println("DB접속 성공");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패!");
		} catch (SQLException e) {
			System.out.println("DB 접속 실패");
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return con;
	}
}