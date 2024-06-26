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
@Table(name = "SUBJECT")
public class SubjectBook {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	//学校コード
	@Column(name = "SCHOOL_CD" , length = 3, nullable = false)
	private String schoolCd;
	//科目コード
	@Column(name = "CD",length = 3, nullable = false)
	private String cd;
	//科目名
	@Column(name = "NAME",length = 20, nullable = true)
	private String name;
	}