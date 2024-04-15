package jp.ac.J.ohara.senatyan.service;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import jp.ac.J.ohara.senatyan.model.ClassNumBook;
import jp.ac.J.ohara.senatyan.repository.ClassNumBookRepository;
 
@Service
@Transactional
public class ClassNumBookService {
 
	@Autowired
	private ClassNumBookRepository repository;
 
 
	/**
	 * ユーザー一覧の取得
	 * @return List<UserBook>
	 */
	public List<ClassNumBook> getClassNumList() {
	    List<ClassNumBook> entityList = this.repository.findAll();
	    return entityList;
	}
 
	/**
	 * 詳細データの取得
	 * @param @NonNull Long index
	 * @return  ClassNumBook
	 */
	public ClassNumBook get(@NonNull Long index) {
		ClassNumBook classnumBook = this.repository.findById(index).orElse(new ClassNumBook());
		return classnumBook;
	}
	/**
	 * データの保存
	 * @param ClassNumBook classnumBook
	 */
	public void save(@NonNull ClassNumBook classnumBook) {
		this.repository.save(classnumBook);
	}
 
	/**
	 * データの削除
	 * @param @NonNull Long index
	 */
	public void delete(@NonNull Long index) {
		this.repository.deleteById(index);
	}
	
}