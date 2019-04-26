package kr.co.noel.study.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.noel.study.repositroy.BoardEntity;
import kr.co.noel.study.service.BoardService;

@RestController
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@GetMapping(value = "/board/{board_no}")
	public ResponseEntity<Optional<BoardEntity>> getBoard (@PathVariable(name="board_no") long board_no){
		ResponseEntity<Optional<BoardEntity>> responseEntity = null;
		
		responseEntity = new ResponseEntity<Optional<BoardEntity>>(boardService.getBoard(board_no), HttpStatus.OK);
		
		return responseEntity;
	}
	
	@RequestMapping(value = "/board")
	public ResponseEntity<List<BoardEntity>> getBoardList() {
		
		ResponseEntity<List<BoardEntity>> responseEntity = null;
		
		responseEntity = new ResponseEntity<List<BoardEntity>>(boardService.getBoardList(), HttpStatus.OK);
		
		return responseEntity;
	}
}
