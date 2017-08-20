package javastud.dao;

import java.util.List;

import javastud.model.Student;

public interface StudentDao {
	
	void saveStudent(Student stud) throws Exception;
	List<Student>getAllStudents() throws Exception;
	void deleteStudent(Student stud) throws Exception;
	void resetStudent() throws Exception;
}
