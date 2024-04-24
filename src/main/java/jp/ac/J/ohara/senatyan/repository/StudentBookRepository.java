package jp.ac.J.ohara.senatyan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.ac.J.ohara.senatyan.model.StudentBook;


@Repository
public interface StudentBookRepository extends JpaRepository<StudentBook, Long>{
	List<StudentBook> findByEntYear(Integer entYear);
    List<StudentBook> findByClassNum(String classNum);
    List<StudentBook> findByIsAttend(boolean isAttend);
 
}