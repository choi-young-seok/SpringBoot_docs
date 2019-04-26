package kr.co.noel.study.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import kr.co.noel.study.repositroy.BoardEntity;
import kr.co.noel.study.repositroy.BoardRepository;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class BoardRepositoryTest {

	@Autowired
	BoardRepository boardRepository;
	
	@Test
	public void saveTest() {
		
		log.info("|TEST| START saveTest");
		BoardEntity boardEntity = new BoardEntity();
		
		try {
			boardEntity = BoardEntity.builder()
				.subject("제목 테스트 입니다.")
				.content("테스트 내용을 입력합니다.")
				.writer("최용석")
				.reg_date(new Date())
				.build();
			
		} catch (Exception e) {
			e.printStackTrace();
			log.info(" [TEST] | boardEntity builder FAIL : " + e.getMessage());
		}
		
		try {
			BoardEntity returnBoardEntity = new BoardEntity();
			returnBoardEntity = boardRepository.save(boardEntity);
			assertThat(returnBoardEntity).isNotNull();
			
			log.info(" [TEST] | returnBoardEntity : " + returnBoardEntity.toString());
			log.info(" [TEST] | END saveTest");
			
		} catch (Exception e) {
			e.printStackTrace();
			log.info(" [TEST] | boardRepository.save FAIL : " + e.getMessage());
		}
	}
	
	@Test
	public void selectByNoTest() {
		log.info("|TEST| START selectByNoTest");
		
		Optional<BoardEntity> boardEntity = null; 
		
		try {
			boardEntity = boardRepository.findById((long) 3);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(" [TEST] | boardRepository.findById FAIL : " + e.getMessage());
		}
		
		assertThat(boardEntity).isNotNull();
		log.info("|TEST| END selectByNoTest");
	}
}
