package kr.co.noel.study.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.noel.study.repositroy.BoardEntity;
import kr.co.noel.study.repositroy.BoardRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardRepository boardRepository;
	
	@Override
	public boolean insertBoard(BoardEntity boardEntity) {
		
		BoardEntity returnBoardEntity = new BoardEntity();
		
		try {
			returnBoardEntity =	boardRepository.save(boardEntity);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("[ERROR] boardRepository.save Fail : " + e.getMessage());
		}
		
//		boolean insertResult = assertThat(returnBoardEntity).equals(boardEntity);
		
		if(returnBoardEntity.equals(boardEntity)) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public String updateBoard(BoardEntity boardEntity) {
		return null;
	}

	@Override
	public Optional<BoardEntity> getBoard(long board_no) {
		
		Optional<BoardEntity> boardEntity = null;
		
		try {
			boardEntity = boardRepository.findById(board_no);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("[ERROR] boardRepository.findById Fail : " + e.getMessage());
		}
		
//		OptionalAssert<BoardEntity> getBoardResult = assertThat(boardEntity).isNotNull();
		
		return boardEntity;
	}

	@Override
	public List<BoardEntity> getBoardList() {
		
		List<BoardEntity> boardList = new ArrayList<BoardEntity>();
		
		try {
			boardList = boardRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			log.info("[ERROR] boardRepository.findAll Fail : " + e.getMessage());
		}
		
		return boardList;
	}

	
}
