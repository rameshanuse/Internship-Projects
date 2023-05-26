package in.ineuron.dao;

import java.util.List;

import in.ineuron.dto.Book;
import in.ineuron.dto.Student;
import in.ineuron.dto.StudentBookTracker;

public interface IStudentDao {
	// operations to be implemented
	public String studentRegister(Student student);
 
	public String studentLogin(String sid, String spassword);
	
	public List<Book> studentMyBooks(String sid);
	
	public String studSubmitBook(String sid,String bid);
	
	public Integer studMyFines(String sid, String bid);
	
	public StudentBookTracker getBorrowAndSubmitDate(String sid, String bid);
	
	public String addFine(Student student, String bid);
}
