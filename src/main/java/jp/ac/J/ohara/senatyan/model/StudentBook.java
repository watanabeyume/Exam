package jp.ac.J.ohara.senatyan.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
 
 
 
@Data
@Entity
@Table(name="STUDENT")
public class StudentBook{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	//学生番号
	@Column(name = "NO", length = 10, nullable = false)
	private String NO;
	
	//学生名
	@Column(name = "NAME",length = 10, nullable = true)
	private String NAME;
	
	//入学年度
		@Column(name = "ENT_YEAR",length = 10, nullable = true)
		private int ENT_YEAR;
		
	//クラス番号
		@Column(name = "CLASS_NUM",length = 3, nullable = true)
		private String CLASS_NUM;
		
	//在学中フラグ
		@Column(name = "IS_ATTEND",length = 10, nullable = true)
		private String IS_ATTEND;
	
	//学生名
		@Column(name = "SCHOOL_CD",length = 3, nullable = true)
		private String SCHOOL_CD;
	
 
}