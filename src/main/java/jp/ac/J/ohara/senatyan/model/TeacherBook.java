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
	@Table(name = "TEACHER")
	public class TeacherBook {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		@Column(length = 10, nullable = false)
		private String TEACHERID;
		@Column(length = 30, nullable = true)
		private String PASSWORD;
		@Column(length = 10, nullable = true)
		private String NAME;
		@Column(length = 3, nullable = true)
		private String SCHOOL_CD;
}
