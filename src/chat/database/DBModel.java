package chat.database;

import java.sql.*;

import chat.database.DBModel.DBcheck;
import chat.server.Server;

public class DBModel {
	static public UserDB userDB = new UserDB();
	
	public static class UserDB {
		String uid;
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
						uid = rs.getString("uid");
						userName = rs.getString("user_name");
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return res;
		}
		
		public String getUid() {
			return uid;
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
	
	public static class DBcheck {
    	private static boolean res = false;
    	
    	// 디비 연결 확인에 사용
    	public static Boolean connectDB(String DB) {
    		new DBcon(DB);
    		return res;
    	}
    	
    	public static void setResult(boolean res) {
    		DBcheck.res = res;
    	}
    }
	
	// DB 생성
	public static void createDB(String DB, String tableName, String pwd) {
        Connection con = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mariadb://127.0.0.1:3306/",
                    "root",
                    pwd);

            Statement stmt = con.createStatement();
            String createDBQuery = "CREATE DATABASE IF NOT EXISTS " + DB;
            stmt.executeUpdate(createDBQuery);

            DBcon db = new DBcon(DB);
            Connection dbCon = db.getConnection();
            stmt = dbCon.createStatement();

            String createTableQuery = "";
            if (tableName.equals("msg_table")) {
                createTableQuery = "CREATE TABLE IF NOT EXISTS msg_table (" +
                        "id INT AUTO_INCREMENT PRIMARY KEY," +
                        "msg VARCHAR(255)" +
                        ")";
            } else if (tableName.equals("user_table")) {
                createTableQuery = "CREATE TABLE IF NOT EXISTS user_table (" +
                        "id INT AUTO_INCREMENT PRIMARY KEY," +
                        "uid VARCHAR(50)," +
                        "pwd VARCHAR(50)," +
                        "user_name VARCHAR(50)" +
                        ")";
            }

            stmt.executeUpdate(createTableQuery);
            System.out.println("DB생성 성공" + DB);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

class DBcon {
	String driver = "org.mariadb.jdbc.Driver";
	static String pwd = "3538";
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public DBcon(String DB) {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(
					"jdbc:mariadb://127.0.0.1:3306/"+DB,
					"root",
					pwd);
			if (con != null) {
				System.out.println("DB접속 성공");
				DBcheck.setResult(true);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패!");
		} catch (SQLException e) {
			System.out.println("DB 접속 실패");
			e.printStackTrace();
			DBcheck.setResult(false);
		}
	}
	
	public Connection getConnection() {
		return con;
	}
}