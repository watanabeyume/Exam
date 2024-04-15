package jp.ac.J.ohara.senatyan.service;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import jp.ac.J.ohara.senatyan.model.TestBook;
import jp.ac.J.ohara.senatyan.repository.TestBookRepository;
 
@Service
@Transactional
public class TestBookService {
 
	@Autowired
	private TestBookRepository repository;
 
 
	/**
	 * ユーザー一覧の取得
	 * @return List<TestBook>
	 */
	public List<TestBook> getTestList() {
	    List<TestBook> entityList = this.repository.findAll();
	    return entityList;
	}
 
	/**
	 * 詳細データの取得
	 * @param @NonNull Long index
	 * @return  TestBook
	 */
	public TestBook get(@NonNull Long index) {
		TestBook TestBook = this.repository.findById(index).orElse(new TestBook());
		return TestBook;
	}
	/**
		 * データの保存
		 * @param TestBook testBook
		 */
		public void save(@NonNull TestBook testBook) {
			this.repository.save(testBook);
		}
	 
		/**
		 * データの削除
		 * @param @NonNull Long index
		 */
		public void delete(@NonNull Long index) {
			this.repository.deleteById(index);
		}
	
}