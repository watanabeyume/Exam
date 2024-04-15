package jp.ac.J.ohara.senatyan.service;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import jp.ac.J.ohara.senatyan.model.StudentBook;
import jp.ac.J.ohara.senatyan.repository.StudentBookRepository;
 
@Service
@Transactional
public class StudentBookService {
 
	@Autowired
	private StudentBookRepository repository;
 
 
	/**
	 * ユーザー一覧の取得
	 * @return List<StudentBook>
	 */
	public List<StudentBook> getStudentList() {
	    return repository.findAll();
	}
 
	/**
	 * 詳細データの取得
	 * @param @NonNull Long index
	 * @return  StudentBook
	 */
	public StudentBook get(@NonNull Long index) {
		StudentBook StudentBook = this.repository.findById(index).orElse(new StudentBook());
		return StudentBook;
	}
	/**
		 * データの保存
		 * @param StudentBook schoolBook
		 */
		public void save(@NonNull StudentBook studentBook) {
			this.repository.save(studentBook);
		}
	 
		/**
		 * データの削除
		 * @param @NonNull Long index
		 */
		public void delete(@NonNull Long index) {
			this.repository.deleteById(index);
		}
	
}