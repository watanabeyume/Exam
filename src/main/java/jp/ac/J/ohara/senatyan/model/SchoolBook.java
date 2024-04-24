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
@Table(name="School")
public class SchoolBook{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	//学校コード
	@Column(length = 3, nullable = false)
	private String cd;
	//学校名
	@Column(length = 20, nullable = true)
	private String name;

 
}