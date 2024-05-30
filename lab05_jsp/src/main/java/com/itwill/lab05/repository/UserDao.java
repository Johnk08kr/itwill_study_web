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

//	private Post fromResultSetToPost(ResultSet rs) throws SQLException {
//		int id = rs.getInt("id");
//		String title = rs.getString("title");
//		String content = rs.getString("content");
//		String author = rs.getString("author");
//		LocalDateTime createdTime = rs.getTimestamp("created_time").toLocalDateTime();
//		LocalDateTime modifiedTime = rs.getTimestamp("modified_time").toLocalDateTime();
//
//		Post post = Post.builder().id(id).title(title).author(author).content(content).createTime(createdTime)
//				.modifiedTime(modifiedTime).build();
//
//		return post;
//
//	}	
}
