package kr.co.noel.study.service;

import java.util.List;
import java.util.Optional;

import kr.co.noel.study.repositroy.BoardEntity;

public interface BoardService {

	public boolean insertBoard(BoardEntity boardEntity);
	
	public String updateBoard(BoardEntity boardEntity);
	
	public Optional<BoardEntity> getBoard(long board_no);
	
	public List<BoardEntity> getBoardList();
	
}
