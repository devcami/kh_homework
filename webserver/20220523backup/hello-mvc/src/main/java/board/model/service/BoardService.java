package board.model.service;

import static common.JdbcTemplate.close;
import static common.JdbcTemplate.commit;
import static common.JdbcTemplate.getConnection;
import static common.JdbcTemplate.rollback;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import board.model.dao.BoardDao;
import board.model.dto.Attachment;
import board.model.dto.Board;
import board.model.dto.BoardExt;

public class BoardService {
	private BoardDao boardDao = new BoardDao();
	public static final int NUM_PER_PAGE = 10;
	
	public List<BoardExt> findAll(Map<String, Object> param) {
		Connection conn = getConnection();
		List<BoardExt> list = boardDao.findAll(conn, param);
		close(conn);
		return list;
	}

	public int getTotalContents() {
		Connection conn = getConnection();
		int totalContents = boardDao.getTotalContents(conn);
		close(conn);
		return totalContents;
	}

	public int insertBoard(Board board) {
		Connection conn = getConnection();
		int result = 0;
		try {
			// 1. board에 등록
			result = boardDao.insertBoard(conn, board); // pk no값 결정 - seq_board_no.nextval
			
			// 2. board pk가져오기 (b.no = a.board_no)
			int no = boardDao.findCurrentBoardNo(conn); //seq_board_no.nextval을 no에 대입
			System.out.println("방금 insertBoard로 등록된 board.no = " + no);
			
			// 3. attachment에 등록
			List<Attachment> attachments = ((BoardExt) board).getAttachments();
			if(attachments != null && !attachments.isEmpty()) {
				for(Attachment attach : attachments) {
					attach.setBoardNo(no);
					result = boardDao.insertAttachment(conn, attach);
				}
			}
			
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
			throw e;
		} finally {
			close(conn);
		}
		return result;
	}

}
