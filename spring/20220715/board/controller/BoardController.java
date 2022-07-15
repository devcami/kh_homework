package com.kh.spring.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.spring.board.model.dto.Attachment;
import com.kh.spring.board.model.dto.Board;
import com.kh.spring.board.model.service.boardService;
import com.kh.spring.common.HelloSpringUtils;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private boardService boardService;
	
	@Autowired
	ServletContext application;
	
	@GetMapping("/boardList.do")
	public ModelAndView boardList(@RequestParam(defaultValue = "1") int cPage, ModelAndView mav, HttpServletRequest request) {
		try {
			// 목록조회
			int numPerPage = 5;
			List<Board> list = boardService.selectBoardList(cPage, numPerPage);
			log.debug("list = {}", list);
			mav.addObject("list", list); // = model.addAttribute()
			
			// 페이지바
			int totalContent = boardService.selectTotalContent();
			// log.debug("totalContent = {}", totalContent);
			String url = request.getRequestURI();
			String pagebar = HelloSpringUtils.getPagebar(cPage, numPerPage, totalContent, url);
			// log.debug("pagebar = {}", pagebar);
			mav.addObject("pagebar", pagebar);
			
			// viewName 설정
			mav.setViewName("board/boardList");
		} catch (Exception e) {
			log.error("게시글 목록 조회 오류", e);
		}
		return mav;
	}
	
	@GetMapping("/boardForm.do")
	public void boardForm() {}
	
	@PostMapping("/boardEnroll.do")
	public String boardEnroll(@ModelAttribute Board board, 
							  RedirectAttributes redirectAttr, 
							  @RequestParam("upFile") MultipartFile[] upFiles) { //@ModelAttribute 생략가능
		try {
			log.debug("board = {}" , board);
//			log.debug("application = {}", application);
//			log.debug("saveDirectory = {}", saveDirectory);
			
			String saveDirectory = application.getRealPath("/resources/upload/board");
			
			// 업로드한 파일 저장 (webapp/resources/upload/board)
			for(MultipartFile upFile : upFiles) {
				// 실제 파일을 업로드 했는지 체크
				if(upFile.getSize() > 0) {
					// 파일명 재지정
					String originalFilename = upFile.getOriginalFilename();
					String renamedFilename = HelloSpringUtils.getRenamedFilename(originalFilename);
					log.debug("renamedFilename = {}", renamedFilename);
					
					// 업로드 한 파일 저장
					File destFile = new File(saveDirectory, renamedFilename);
					upFile.transferTo(destFile);
					
					// Attachment객체로 만들어 -> Board#attachments field에 추가 -> 바로 해당 글의 상세보기페이지로 이동이 가능하다.
					Attachment attach = new Attachment();
					attach.setOriginalFilename(originalFilename);
					attach.setRenamedFilename(renamedFilename);
					board.addAttachment(attach);
				}
			}
			
			// 여기서 전달한 board는 dao의 selectkey에 의해 no컬럼이 결정된 상태로 온거임!(call by reference)
			int result = boardService.boardEnroll(board); 
			
			redirectAttr.addFlashAttribute("msg", "게시글 작성이 완료되었습니다.");
		} catch(IOException e) {
			log.error("첨부파일 저장 오류", e);
		} catch (Exception e) {
			log.error("게시글 등록 오류", e);
			throw e;
		}
		return "redirect:/board/boardDetail.do?no=" + board.getNo();
	}
	
	@GetMapping("/boardDetail.do")
	public ModelAndView boardDetail(ModelAndView mav, @RequestParam int no) {
		try {
//			Board board = boardService.selectBoard(no);
			Board board = boardService.selectOneBoardCollection(no);
			log.debug("board = {}", board);
			mav.addObject("board", board);
			mav.setViewName("board/boardDetail");
		} catch (Exception e) {
			log.error("게시글 상세보기 오류", e);
			throw e;
		}
		return mav;
	}
	
	@GetMapping("/boardUpdate.do")
	public void boardUpdate(Model model, @RequestParam int no) {
		try {
			Board board = boardService.selectBoard(no);
			log.debug("board = {}", board);
			model.addAttribute("board", board);
		} catch (Exception e) {
			log.error("게시글 수정 폼 요청 오류", e);
			throw e;
		}
	}
	
	
	@PostMapping("/boardUpdate.do")
	public String boardUpdate(RedirectAttributes redirectAttr, 
							  Board board,
							  @RequestParam(value="delFile", required=false) int[] delFiles,
							  @RequestParam("upFile") MultipartFile[] upFiles) {
		try {
			String saveDirectory = application.getRealPath("/resources/upload/board");
			log.debug("board = {}", board);
			
			// 삭제 체크한 파일 삭제
			if(delFiles != null) {
				for(int attachNo : delFiles) {
					Attachment attach = boardService.selectOneAttachment(attachNo);
					// 저장경로에서 삭제
					File delFile = new File(saveDirectory, attach.getRenamedFilename());
					if(delFile.exists()) delFile.delete();
					// DB에서 삭제
					int result = boardService.deleteAttachment(attachNo);
				}
			}
			
			// 업로드 한 파일 저장
			for(MultipartFile upFile : upFiles) {
				// 실제 파일을 업로드 했는지 체크
				if(upFile.getSize() > 0) {
					// 파일명 재지정
					String originalFilename = upFile.getOriginalFilename();
					String renamedFilename = HelloSpringUtils.getRenamedFilename(originalFilename);
					log.debug("renamedFilename = {}", renamedFilename);
					
					// 업로드 한 파일 저장
					File destFile = new File(saveDirectory, renamedFilename);
					upFile.transferTo(destFile);
					
					// Attachment객체로 만들어 -> Board#attachments field에 추가 -> 바로 해당 글의 상세보기페이지로 이동이 가능하다.
					Attachment attach = new Attachment();
					attach.setOriginalFilename(originalFilename);
					attach.setRenamedFilename(renamedFilename);
					board.addAttachment(attach);
				}
			}
			
			// db 게시글 수정
			int result = boardService.updateBoard(board);
			redirectAttr.addFlashAttribute("msg", "게시글 수정이 완료되었습니다.");
			
		} 
		catch (IOException e) {
			log.error("첨부파일 저장 오류", e);
		} 
		catch (Exception e) {
			log.error("게시글 수정 오류", e);
			throw e;
		}
		return "redirect:/board/boardDetail.do?no=" + board.getNo();
	};
	
}
