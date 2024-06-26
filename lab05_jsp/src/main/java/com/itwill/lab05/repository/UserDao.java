package com.itwill.lab05.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.lab05.datasource.DataSourceUtil;
import com.zaxxer.hikari.HikariDataSource;

public enum UserDao {
	INSTANCE;

	private static final Logger log = LoggerFactory.getLogger(UserDao.class);
	private final HikariDataSource ds = DataSourceUtil.getInstance().getDataSource();

	// insert() 메소드에서 실행할 SQL:
	private static final String SQL_INSERT = "insert into users(userId, password, email) values (?, ?, ?)";

	public int insert(User user) {
		log.debug("insert()");
		log.debug(SQL_INSERT);

		int result = 0;
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, user.getUserId());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getEmail());
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt);
		}
		return result;
	}
	
	private static final String SQL_SELECT_BY_USERID = "select * from users where userid = ?";
	
	public User selectByUserid(String userid) {
		log.debug("selectByUserid({}", userid);
		log.debug(SQL_SELECT_BY_USERID);
		
		User result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_BY_USERID);
			stmt.setString(1, userid);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				result = fromResultSetToUser(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}
		return result;
	}

	/**
	 * 로그인할 때 필요한 메서드.
	 * 
	 * @param user 로그인을 시도한 userid, password를 저장한 객체.
	 * @return 데이터베이스의 users 테이블에서 userid와 password가 일치하는 레코드가 있으면 null이 아닌 User 타입
	 *         객체를 리턴. userid 또는 password가 일치하지 않으면 null을 리턴.
	 */
	private static final String SQL_SIGN_IN = "select * from users where userid = ? and password = ?";

	public User selectByUseridAndPassword(User user) {
		log.debug("selectByUseridAndPassword({}", user);
		log.debug(SQL_SIGN_IN);

		User result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(SQL_SIGN_IN);
			stmt.setString(1, user.getUserId());
			stmt.setString(2, user.getPassword());
			rs = stmt.executeQuery();

			if (rs.next()) {
				result = fromResultSetToUser(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}
		return result;
	}
	
	private static final String SQL_POINT_UPDATE = "update users set points = points + 10 where userid = ?";
	
	public int updateUserPoint(String userid) {
		log.debug(SQL_POINT_UPDATE);
		
		int result = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(SQL_POINT_UPDATE);
			stmt.setString(1, userid);
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt);
		}
		return result;
	} 

	private User fromResultSetToUser(ResultSet rs) throws SQLException {
		int id = rs.getInt("id");
		String userid = rs.getString("userid");
		String password = rs.getString("password");
		String email = rs.getString("email");
		int point = rs.getInt("points");
		
		return User.builder().id(id).userId(userid).password(password).email(email).point(point).build();
		
	}

	private void closeResources(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void closeResources(Connection conn, Statement stmt) {
		closeResources(conn, stmt, null);
	}

}
