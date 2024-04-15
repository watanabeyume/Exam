package jp.ac.J.ohara.senatyan.service;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import jp.ac.J.ohara.senatyan.model.TeacherBook;
import jp.ac.J.ohara.senatyan.repository.TeacherBookRepository;
 
@Service
@Transactional
public class TeacherBookService {
 
	@Autowired
	private TeacherBookRepository repository;
 
 
	/**
	 * ユーザー一覧の取得
	 * @return List<TeacherBook>
	 */
	public List<TeacherBook> getTeacherList() {
	    List<TeacherBook> entityList = this.repository.findAll();
	    return entityList;
	}
 
	/**
	 * 詳細データの取得
	 * @param @NonNull Long index
	 * @return  TeacherBook
	 */
	public TeacherBook get(@NonNull Long index) {
		TeacherBook TeacherBook = this.repository.findById(index).orElse(new TeacherBook());
		return TeacherBook;
	}
	/**
	 * データの保存
	 * @param TeacherBook teacherBook
	 */
	public void save(@NonNull TeacherBook teacherBook) {
		this.repository.save(teacherBook);
	}
 
	/**
	 * データの削除
	 * @param @NonNull Long index
	 */
	public void delete(@NonNull Long index) {
		this.repository.deleteById(index);
	}
	
}