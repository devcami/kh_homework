package com.kh.spring.board.model.service;

import java.util.List;

import com.kh.spring.board.model.dto.Attachment;
import com.kh.spring.board.model.dto.Board;

public interface boardService {

	List<Board> selectBoardList(int cPage, int numPerPage);

	int selectTotalContent();

	int boardEnroll(Board board);

	Board selectBoard(int no);

	Board selectOneBoardCollection(int no);

	Attachment selectOneAttachment(int attachNo);

	int deleteAttachment(int attachNo);

	int updateBoard(Board board);

}
