package in.ineuron.service;

import in.ineuron.daofactory.StudentDaoFactory;
import in.ineuron.dto.Book;
import in.ineuron.dto.Student;
import in.ineuron.dto.StudentBookTracker;
import java.util.Date;
import java.util.List;

import in.ineuron.dao.IStudentDao;

public class StudentServiceImpl implements IStudentService {
	IStudentDao studentDao;
	IStudentService studentService = null;

	@Override
	public String studentRegister(Student student) {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.studentRegister(student);
	}

	@Override
	public String studentLogin(String sid, String spassword) {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.studentLogin(sid, spassword);
	}

	@Override
	public List<Book> studentMyBooks(String sid) {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.studentMyBooks(sid);
	}

	@Override
	public String studSubmitBook(String sid, String bid) {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.studSubmitBook(sid, bid);
	}

	@Override
	public Integer studMyFines(String sid, String bid) {
		studentDao = StudentDaoFactory.getStudentDao();
		Integer studMyFines = null;
		Date borrowdate = null;
		Date submitdate = null;
		
		StudentBookTracker sbt = getBorrowAndSubmitDate(sid, bid);
		if (sbt != null) {
			borrowdate = sbt.getBorrowdate();
			submitdate = sbt.getSubmitdate(); 
		} else {
			return null;
		}
		
		System.out.println(borrowdate.getTime());
		System.out.println(submitdate.getTime());
		
		if(borrowdate != null && submitdate != null) {
			
			long diff = submitdate.getTime() - borrowdate.getTime();
			int daysDiff = (int) (diff / (24 * 60 * 60 * 1000) % 365);
			System.out.println("Days Diff:: "+daysDiff);
			// after the 15 days fine was calculated 10Rs/day
			int fineAmount = (daysDiff - 15) * 10;
			System.out.println("Fine Amt:: "+fineAmount);
			if (fineAmount > 0) {
				Student student = new Student();
				student.setFine(fineAmount);
				student.setSid(sid);
				System.out.println("Student :: "+student);
				String status = addFine(student, bid);
				System.out.println("Status from add fine from dao :: "+status);
				if (status.equals("success")) {
					studMyFines = studentDao.studMyFines(sid, bid);
					System.out.println("Fine from Servie ::" +studMyFines);
				} 
			} else { 
				Student student = new Student();
				student.setFine(0);
				student.setSid(sid);
				String status = addFine(student, bid);
				if (status.equals("success")) {
					studMyFines = studentDao.studMyFines(sid, bid);
					System.out.println("Fine from fine table : "+studMyFines);
				} 

			}
		}
		return studMyFines;
	}

	@Override
	public StudentBookTracker getBorrowAndSubmitDate(String sid, String bid) {
		System.out.println("In getBorrowAndSubmitDate servie");
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.getBorrowAndSubmitDate(sid, bid);
	}

	@Override
	public String addFine(Student student, String bid) {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.addFine(student, bid);
	}

}
