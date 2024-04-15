package jp.ac.J.ohara.senatyan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.ac.J.ohara.senatyan.model.TestBook;


	@Repository
	public interface TestBookRepository extends JpaRepository<TestBook, Long> {

		}