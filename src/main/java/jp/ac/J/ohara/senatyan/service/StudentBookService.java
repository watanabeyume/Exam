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
			studentBook.setIsAttend(true);
			this.repository.save(studentBook);
		}
	
		/**
		 * データの削除
		 * @param @NonNull Long index
		 */
		public void delete(@NonNull Long index) {
			this.repository.deleteById(index);
		}
		// 受け取ったidからデータを取得して、Formを返却する
	    public StudentBook getOneBook(Long index) {
			
	        // idを指定して本の情報を取得する
	    	StudentBook studentBook = repository.findById(index).orElseThrow();
			
	        // 画面返却用のFormに値を設定する
	    	/*
	        Student editstudent = new Student();
	        editstudent.setNAME(student.getNAME());
	        editstudent.setCLASS_NUM(student.getCLASS_NUM());
			*/
	        return studentBook;
	    }
	    
	// 本を更新する
	    public void update(StudentBook editstudent) {
			
	        // データベースに登録する値を保持するインスタンスの作成
	        //Student student = new Student();
			
	        // 画面から受け取った値を設定する
	    	/*
	        student.setId(editstudent.getId());
	        student.setNAME(editstudent.getNAME());
	        student.setCLASS_NUM(editstudent.getCLASS_NUM());
	        */
			
	        // データベースを更新する
	        repository.save(editstudent);
	    }
	    public List<StudentBook> filterStudents(Integer entYear, String classNum, Boolean isAttend) {
	        List<StudentBook> students = repository.findAll();
	 
	        // 入学年度で絞り込み
	        if (entYear != null) {
	            students = repository.findByEntYear(entYear);
	        }
	 
	        // クラス番号で絞り込み
	        if (classNum != null && !classNum.isEmpty()) {
	            List<StudentBook> classNumStudents = repository.findByClassNum(classNum);
	            students.retainAll(classNumStudents);
	        }
	 
	        // 在学状況で絞り込み
	        if (isAttend != null) {
	            List<StudentBook> isAttendStudents = repository.findByIsAttend(isAttend);
	            students.retainAll(isAttendStudents);
	        }
	 
	        return students;
	    }
	}
	

