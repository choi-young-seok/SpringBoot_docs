package kr.co.noel.study.repositroy;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value="게시글", description ="게시글 관련 데이터")
public class BoardEntity {

	@Id
	@GeneratedValue 
	@ApiModelProperty(example = "1", notes="게시글 번호")
	private long board_no;
	
	@ApiModelProperty(notes="게시글 제목")
	private String subject;
	
	@ApiModelProperty(example = "최용석", notes="게시글 작성자")
	private String writer;
	
	@ApiModelProperty(notes="게시글 내용")
	private String content;
	
	@ApiModelProperty(example = "2019-04-29", notes="YYYY-MM-DD")
	private Date reg_date;
	
	@Builder
	public BoardEntity(String subject, String writer, String content, Date reg_date) {
		this.subject = subject;
		this.writer = writer;
		this.content = content;
		this.reg_date = reg_date;
	}
	
}
