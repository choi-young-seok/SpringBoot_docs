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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.co.noel.study.repositroy.BoardEntity;
import kr.co.noel.study.service.BoardService;

@Api(value = "Board API", description = "게시판 조회 API")
@RestController
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@ApiOperation(
			value = "게시글 조회",
			notes = "게시글 번호에 해당하는 게시글 상세 조회",
			httpMethod = "GET",
			produces = "application/json",
			consumes = "application/json",
			protocols = "http",
			responseHeaders = {
					//header info
			})
//	@ApiImplicitParams({
////		@ApiImplicitParam(name = "샘플", value="샘플설명", required = true, dataType = "요청데이터타입", paramType = "파라미터타입"),
//		@ApiImplicitParam(name = "board_no", value="게시판번호", required = true, dataType = "String", paramType = "REST 경로")
//	})
//	@ApiImplicitParam(name="board_no", value="게시판번호", required = true, paramType = "REST 경로")
	@ApiResponses({ //이부분은 docket 설정에서 따로 설정한 후 제거한다.
		@ApiResponse(code = 200, message = "success"),
		@ApiResponse(code = 404, message = "fail")
	})
	@GetMapping(value = "/board/{board_no}")
	public ResponseEntity<Optional<BoardEntity>> getBoard (@PathVariable(name="board_no") long board_no){
		ResponseEntity<Optional<BoardEntity>> responseEntity = null;
		
		responseEntity = new ResponseEntity<Optional<BoardEntity>>(boardService.getBoard(board_no), HttpStatus.OK);
		
		return responseEntity;
	}
	
	@ApiOperation(
			value = "[게시글 목록 조회]",
			notes = "요청 page에 해당하는 게시글 목록 조회",
			httpMethod = "GET",
			produces = "application/json",
			consumes = "application/json",
			protocols = "http",
			response = BoardEntity.class,
			responseContainer = "List",
			responseHeaders = {
					//header info
			})
	@RequestMapping(value = "/board", method=RequestMethod.GET)
	public ResponseEntity<List<BoardEntity>> getBoardList() {
		
		ResponseEntity<List<BoardEntity>> responseEntity = null;
		
		responseEntity = new ResponseEntity<List<BoardEntity>>(boardService.getBoardList(), HttpStatus.OK);
		
		return responseEntity;
	}
}
