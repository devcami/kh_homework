package com.kh.spring.board.model.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.spring.board.model.dao.BoardDao;
import com.kh.spring.board.model.dto.Attachment;
import com.kh.spring.board.model.dto.Board;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class BoardServiceImpl implements boardService {

	@Autowired
	private BoardDao boardDao;
	
	@Transactional(readOnly = true)
	@Override
	public List<Board> selectBoardList(int cPage, int numPerPage) {
		// Paging 사전작업
		int offset = (cPage - 1) * numPerPage; // 몇개를 건너뛰고 선택할 것인가 (ex. 1page offset 0개 | 2page offset 5개 (6부터 시작) | 3page offset 10개 (11부터 시작...))
		int limit = numPerPage; // 5개씩 사용할 것이다
		RowBounds rowBounds = new RowBounds(offset, limit);
		return boardDao.selectBoardList(rowBounds);
	}
	
	@Override
	public int selectTotalContent() {
		return boardDao.selectTotalContent();
	}
	
	/**
	 * @Transaction은 Runtime 예외가 발생 시에만 rollback처리
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int boardEnroll(Board board) {
		// 1. board insert
		int result = boardDao.boardEnroll(board); 
		// boardEnroll 갔다오면서 selectKey에 의해 no에 boardNo값을 저장했다!
		log.debug("board#no = {}", board.getNo());
		
		// 2. attachments insert
		List<Attachment> attachments = board.getAttachments();
		if(!attachments.isEmpty()) {
			for(Attachment attach : attachments) {
				attach.setBoardNo(board.getNo());
				result = boardDao.insertAttachment(attach);
			}
		}
		
		return result;
	}
	
	@Transactional(readOnly = true)
	@Override
	public Board selectBoard(int no) {
		Board board = boardDao.selectBoard(no);
		List<Attachment> attachments = boardDao.selectListAttachment(no); 
		board.setAttachments(attachments);
		return board;
	}
	
	@Override
	public Board selectOneBoardCollection(int no) {
		return boardDao.selectOneBoardCollection(no);
	}
	
	@Override
	public Attachment selectOneAttachment(int attachNo) {
		return boardDao.selectOneAttachment(attachNo);
	}
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int deleteAttachment(int attachNo) {
		return boardDao.deleteAttachment(attachNo);
	}
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int updateBoard(Board board) {
		// 1. board update
		int result = boardDao.updateBoard(board); 
		
		// 2. new attachments insert
		List<Attachment> attachments = board.getAttachments();
		if(!attachments.isEmpty()) {
			for(Attachment attach : attachments) {
				attach.setBoardNo(board.getNo());
				result = boardDao.insertAttachment(attach);
			}
		}
		return result;
	}
}
