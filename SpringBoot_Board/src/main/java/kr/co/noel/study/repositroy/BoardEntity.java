package kr.co.noel.study.repositroy;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "tb_board")
@NoArgsConstructor //Lombok -> 기본 생성자 생성
@ToString
public class BoardEntity {

	@Id
	@GeneratedValue
	private long board_no;
	
	private String subject;
	private String writer;
	private String content;
	private Date reg_date;
	
	@Builder
	public BoardEntity(String subject, String writer, String content, Date reg_date) {
		this.subject = subject;
		this.writer = writer;
		this.content = content;
		this.reg_date = reg_date;
	}
	
}
