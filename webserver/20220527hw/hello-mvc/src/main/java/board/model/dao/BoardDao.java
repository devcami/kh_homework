package board.model.dao;

import static common.JdbcTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import board.model.dto.Attachment;
import board.model.dto.Board;
import board.model.dto.BoardComment;
import board.model.dto.BoardExt;
import board.model.exception.BoardException;
public class BoardDao {
	private Properties prop = new Properties();
	
	public BoardDao() {
		String fileName = BoardDao.class.getResource("/sql/board-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<BoardExt> findAll(Connection conn, Map<String, Object> param) {
		List<BoardExt> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("findAll");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (int) param.get("start"));
			pstmt.setInt(2, (int) param.get("end"));
			rset = pstmt.executeQuery();
			while(rset.next()) {
				BoardExt board = handleBoardResultSet(rset);	
				board.setAttachCount(rset.getInt("attach_cnt"));
				list.add(board);
			}
		} catch (Exception e) {
			throw new BoardException("> 게시판 전체목록 조회 오류", e);
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	private BoardExt handleBoardResultSet(ResultSet rset) throws SQLException {
		BoardExt board = new BoardExt();
		board.setNo(rset.getInt("no"));
		board.setTitle(rset.getString("title"));
		board.setMemberId(rset.getString("member_id"));
		board.setContent(rset.getString("content"));
		board.setReadCount(rset.getInt("read_count"));
		board.setRegDate(rset.getDate("reg_date"));
		return board;
	}

	public int getTotalContents(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int totalContents = 0;
		String sql = prop.getProperty("getTotalContents");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				totalContents = rset.getInt(1);
			}
		} catch (Exception e) {
			throw new BoardException("> 전체 게시글 수 조회 오류", e);
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return totalContents;
	}

	public int insertBoard(Connection conn, Board board) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertBoard");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getMemberId());
			pstmt.setString(3, board.getContent());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			throw new BoardException("> 게시판 글 등록 오류", e);
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int findCurrentBoardNo(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int no = 0;
		String sql = prop.getProperty("findCurrentBoardNo");
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next())
				no = rset.getInt(1);
		} catch (Exception e) {
			throw new BoardException("> 첨부파일 - 게시글 번호 조회 오류 ", e);
		} finally {
			close(rset);
			close(pstmt);
		}
		return no;
	}

	public int insertAttachment(Connection conn, Attachment attach) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertAttachment");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, attach.getBoardNo());
			pstmt.setString(2, attach.getOriginalFilename());
			pstmt.setString(3, attach.getRenamedFilename());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			throw new BoardException("> 첨부파일 등록 오류", e);
		} finally {
			close(pstmt);
		}
		return result;
	}

	public BoardExt findByNo(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		BoardExt board = null;
		String sql = prop.getProperty("findByNo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				board = handleBoardResultSet(rset);
			}
		} catch (Exception e) {
			throw new BoardException("> 게시글 한건 조회 오류", e);
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return board;
	}

	public List<Attachment> findAttachmentByBoardNo(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Attachment> attachments = new ArrayList<>();
		String sql = prop.getProperty("findAttachmentByBoardNo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Attachment attach = handleAttachmentResultSet(rset);
				attachments.add(attach);
			}
		} catch (Exception e) {
			throw new BoardException("> 게시글의 첨부파일 조회 오류", e);
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return attachments;
	}

	private Attachment handleAttachmentResultSet(ResultSet rset) throws SQLException {
		Attachment attach = new Attachment();
		attach.setNo(rset.getInt("no"));
		attach.setBoardNo(rset.getInt("board_no"));
		attach.setOriginalFilename(rset.getString("original_filename"));
		attach.setRenamedFilename(rset.getString("renamed_filename"));
		attach.setRegDate(rset.getDate("reg_date"));
		return attach;
	}

	public int updateReadCount(Connection conn, int no) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("updateReadCount");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			throw new BoardException("> 조회수 증가처리 오류", e);
		} finally {
			close(pstmt);
		}
		return result;
	}

	public Attachment findAttachmentByNo(Connection conn, int no) {
		Attachment attach = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("findAttachmentByNo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rset = pstmt.executeQuery();
			//if(rset.next()) 1건일 시 if도 가능
			while(rset.next()) {
				attach = handleAttachmentResultSet(rset);
			}
		} catch (Exception e) {
			throw new BoardException("> 첨부파일 한건 조회 오류", e);
		} finally {
			close(rset);
			close(pstmt);
		}
		return attach;
	}

	public int deleteBoard(Connection conn, int no) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("deleteBoard");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			throw new BoardException("> 게시글 삭제 오류", e);
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int updateBoard(Connection conn, BoardExt board) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateBoard");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			throw new BoardException("> 게시판 글 수정 오류", e);
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteAttachment(Connection conn, int no) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteAttachment");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			throw new BoardException("> 게시글 첨부파일 삭제 오류", e);
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int insertBoardComment(Connection conn, BoardComment bc) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertBoardComment");
		//values(seq_board_comment_no.nextval, ?, ?, ?, ?, ?, default)
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bc.getCommentLevel());
			pstmt.setString(2, bc.getMemberId());
			pstmt.setString(3, bc.getContent());
			pstmt.setInt(4, bc.getBoardNo());
			//dto - BoardCommnet#commentRef (0~n) -> db - board_comment.comment_ref (null~n)
			pstmt.setObject(5, bc.getCommentRef() == 0 ? null : bc.getCommentRef());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			throw new BoardException("> 댓글 등록 오류", e);
		} finally {
			close(pstmt);
		}
		return result;
	}

	public List<BoardComment> findBoardCommentByBoardNo(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<BoardComment> comments = new ArrayList<>();
		String sql = prop.getProperty("findBoardCommentByBoardNo");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				BoardComment bc = new BoardComment();
				bc.setNo(rset.getInt("no"));
				bc.setCommentLevel(rset.getInt("comment_level"));
				bc.setMemberId(rset.getString("member_id"));
				bc.setContent(rset.getString("content"));
				bc.setBoardNo(rset.getInt("board_no"));
				bc.setCommentRef(rset.getInt("comment_ref"));
				bc.setRegDate(rset.getDate("reg_date"));
				comments.add(bc);
			}
		} catch (Exception e) {
			throw new BoardException("> 해당 게시글 댓글 목록 조회 오류", e);
		} finally {
			close(rset);
			close(pstmt);
		}
		return comments;
	}

	public int deleteComment(Connection conn, int no) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteComment");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			throw new BoardException("> 댓글 삭제 오류", e);
		} finally {
			close(pstmt);
		}
		return result;
	}

}
