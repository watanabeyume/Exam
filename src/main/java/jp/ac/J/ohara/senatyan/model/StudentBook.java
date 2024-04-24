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
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	//学生番号
	@Column(name = "no", length = 10, nullable = false)
	private String no;
	//学生名
	@Column(name = "name", length = 10, nullable = true)
	private String name;
	//入学年度
		@Column(name = "entYear", length = 10, nullable = true)
		private int entYear;
	//クラス番号
		@Column(name = "classNum", length = 3, nullable = true)
		private String classNum;
	//在学中フラグ
		@Column(name = "isAttend", nullable = true)
		private Boolean isAttend;
	//学校コード
		@Column(name = "schoolCd", length = 3, nullable = true)
		private String schoolCd;

 
}