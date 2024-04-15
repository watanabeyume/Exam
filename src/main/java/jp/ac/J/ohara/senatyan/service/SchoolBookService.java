package jp.ac.J.ohara.senatyan.service;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import jp.ac.J.ohara.senatyan.model.SchoolBook;
import jp.ac.J.ohara.senatyan.repository.SchoolBookRepository;
 
@Service
@Transactional
public class SchoolBookService {
 
	@Autowired
	private SchoolBookRepository repository;
 
 
	/**
	 * ユーザー一覧の取得
	 * @return List<SchoolBook>
	 */
	public List<SchoolBook> getSchoolList() {
	    List<SchoolBook> entityList = this.repository.findAll();
	    return entityList;
	}
 
	/**
	 * 詳細データの取得
	 * @param @NonNull Long index
	 * @return  SchoolBook
	 */
	public SchoolBook get(@NonNull Long index) {
		SchoolBook SchoolBook = this.repository.findById(index).orElse(new SchoolBook());
		return SchoolBook;
	}
	/**
	 * データの保存
	 * @param SchoolBook schoolBook
	 */
	public void save(@NonNull SchoolBook schoolBook) {
		this.repository.save(schoolBook);
	}
 
	/**
	 * データの削除
	 * @param @NonNull Long index
	 */
	public void delete(@NonNull Long index) {
		this.repository.deleteById(index);
	}
	
}