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
		@Column(length = 3, nullable = false)
		private String SCHOOL_CD;
		@Column(length = 3, nullable = false)
		private String CD;
		@Column(length = 20, nullable = true)
		private String NAME;
		}

