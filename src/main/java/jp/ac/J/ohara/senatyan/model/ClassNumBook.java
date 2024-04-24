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
@Table(name="CLASS_NUM")
public class ClassNumBook{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	//学校コード
	@Column(length = 3, nullable = false)
	private String schoolCd;
	//クラス番号
	@Column(length = 5, nullable = false)
	private String classNum;

 
}