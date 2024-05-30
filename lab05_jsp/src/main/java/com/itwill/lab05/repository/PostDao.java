package com.itwill.lab05.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.lab05.datasource.DataSourceUtil;
import com.zaxxer.hikari.HikariDataSource;

// MVC 아키텍처에서 영속성 계층(repository layer)을 담당하는 클래스.
// CRUD 작업을 담당.
// DAO(Data Access Object)
public enum PostDao {
	INSTANCE;

	private static final Logger log = LoggerFactory.getLogger(PostDao.class);
	private final HikariDataSource ds = DataSourceUtil.getInstance().getDataSource();

	// select() 메소드에서 실행할 SQL:
	private static final String SQL_SELECT_ALL = "select * from posts order by id desc";

	public List<Post> select() {
		log.debug("select()");
		log.debug(SQL_SELECT_ALL);

		List<Post> list = new ArrayList<>(); // SELECT 결과를 저장할 리스트.
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_ALL);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Post post = fromResultSetToPost(rs);
				list.add(post);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}
		return list;
	}

	// posts 테이블에 insert 하는 SQL:
	private static final String SQL_INSERT = "insert into posts (title, content, author) values (?, ?, ?)";

	public int insert(Post post) {
		log.debug("insert()");
		log.debug(SQL_INSERT);

		int result = 0;
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, post.getTitle());
			stmt.setString(2, post.getContent());
			stmt.setString(3, post.getAuthor());
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt);
		}

		return result;
	}
    
	private static final String SQL_UPDATE = 
            "update posts set title = ?, content = ?, modified_time = systimestamp "
            + "where id = ?";
    
    public int update(Post post) {
        log.debug("update({})", post);
        log.debug(SQL_UPDATE);
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int result = 0;
        try {
            conn = ds.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, post.getTitle());
            stmt.setString(2, post.getContent());
            stmt.setInt(3, post.getId());
            result = stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt);
        }
        
        return result;
    }

	// posts 테이블에 delete 하는 SQL:
	private static final String SQL_DELETE = "DELETE FROM POSTS WHERE ID = ?";

	public int delete(int id) {
		log.debug("delete() " + id);
		log.debug(SQL_DELETE);

		int result = 0;
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, id);
			result = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt);
		}
		return result;
	}

	// posts 테이블에서 id로 search 하는 SQL:
	private static final String SQL_SELECT_BY_ID = "select * from posts where id = ?";

	public Post select(int id) {
		log.debug("select(id={})",id);
		log.debug(SQL_SELECT_BY_ID);
		
		Post post = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				post = fromResultSetToPost(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}
		return post;
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

	private Post fromResultSetToPost(ResultSet rs) throws SQLException {
		int id = rs.getInt("id");
		String title = rs.getString("title");
		String content = rs.getString("content");
		String author = rs.getString("author");
		LocalDateTime createdTime = rs.getTimestamp("created_time").toLocalDateTime();
		LocalDateTime modifiedTime = rs.getTimestamp("modified_time").toLocalDateTime();

		Post post = Post.builder().id(id).title(title).author(author).content(content).createTime(createdTime)
				.modifiedTime(modifiedTime).build();

		return post;

	}
}
