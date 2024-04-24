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
@Table(name = "TEST")
public class TestBook {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	//学生番号
	@Column(length = 10, nullable = false)
	private String studentNo;
	//科目コード
	@Column(length = 3, nullable = false)
	private String subjectCd;
	//学校コード
	@Column(length = 10, nullable = false)
	private String schoolCd;
	//回数
	@Column(length = 10, nullable = false)
	private String no;
	//得点
	@Column(length = 10, nullable = true)
	private String point;
	//クラス番号
	@Column(length = 5, nullable = true)
	private String classNum;
}