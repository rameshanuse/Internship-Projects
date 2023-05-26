package in.ineuron.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ineuron.dto.Book;
import in.ineuron.dto.Management;
import in.ineuron.dto.Student;
import in.ineuron.service.IManagementService;
import in.ineuron.service.IStudentService;
import in.ineuron.servicefactory.ManagementServiceFactory;
import in.ineuron.servicefactory.StudentServiceFactory;

@WebServlet("/controller/*")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	IStudentService studentService = null;
	IManagementService managementService = null;
	RequestDispatcher rd = null;

	public ControllerServlet() {
		super();
		System.out.println("ControllerServlet instantiated..");

	}

	// Student related methods
	public void regStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("***Student Registration***");
		studentService = StudentServiceFactory.getStudentService();

		System.out.println("Request URI :: " + request.getRequestURI());
		System.out.println("Path info   :: " + request.getPathInfo());

		Student student = new Student();

		student.setSid(request.getParameter("sid"));
		student.setSname(request.getParameter("sname"));
		student.setSlastname(request.getParameter("slastname"));
		student.setSage(Integer.parseInt(request.getParameter("sage")));
		student.setSmail(request.getParameter("smail"));
		student.setSaddress(request.getParameter("saddress"));
		student.setSpassword(request.getParameter("spassword"));

		String status = studentService.studentRegister(student);

		request.setAttribute("status", status);
		rd = request.getRequestDispatcher("/studentRegStatus.jsp");
		rd.forward(request, response);
	}

	public void loginStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("***Student Login***");
		studentService = StudentServiceFactory.getStudentService();

		String sid = null;
		String spassword = null;

		sid = request.getParameter("sid");
		spassword = request.getParameter("spassword");

		Student student = new Student();
		student.setSid(sid);
		request.setAttribute("student", student);

		String status = studentService.studentLogin(sid, spassword);
		if (status.equalsIgnoreCase("success")) {
			rd = request.getRequestDispatcher("/studentHomePage.html");
			rd.forward(request, response);
		} else {
			request.setAttribute("status", "failed");
			rd = request.getRequestDispatcher("/studentLoginFailure.jsp");
			rd.forward(request, response);

		}
	}

	public void studentMyBooks(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("***Student My Books***");
		String sid = request.getParameter("sid");
		studentService = StudentServiceFactory.getStudentService();
		List<Book> books = studentService.studentMyBooks(sid);

		if (books.isEmpty()) {
			rd = request.getRequestDispatcher("/studentMyBooksNotFound.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("books", books); 
			rd = request.getRequestDispatcher("/studentMyBooksResult.jsp");
			rd.forward(request, response);
		}
	}

	public void studentSubmitBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("***Student Submit Book***");
		String sid = request.getParameter("sid");
		String bid = request.getParameter("bid");

		studentService = StudentServiceFactory.getStudentService();
		String status = studentService.studSubmitBook(sid, bid);
		request.setAttribute("status", status);
		rd = request.getRequestDispatcher("/studentBookSubmitResult.jsp");
		rd.forward(request, response);
		System.out.println(status);
	}

	public void studentMyFines(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("***Student My fines***");
		Integer studentFine = null;
		String sid = request.getParameter("sid");
		String bid = request.getParameter("bid");

		studentService = StudentServiceFactory.getStudentService();
		studentFine = studentService.studMyFines(sid, bid);

		if (studentFine != null) {
			request.setAttribute("fine", studentFine);
			rd = request.getRequestDispatcher("/studentMyFineResult.jsp");
			rd.forward(request, response);
		} else {
			Integer fine = 0;
			request.setAttribute("fine", fine);
			rd = request.getRequestDispatcher("/studentMyFineResult.jsp");
			rd.forward(request, response);
		}

		System.out.println("In controller My Fine :: " + studentFine);
	}

	// management related methods
	public void mangLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("***Management Login***");

		String mid = request.getParameter("mid");
		String mpwd = request.getParameter("mpwd");

		managementService = ManagementServiceFactory.getManagementService();
		String status = managementService.mangLogin(mid, mpwd);
		request.setAttribute("status", status);

		if (status.equalsIgnoreCase("success")) {
			rd = request.getRequestDispatcher("/mangHomePage.html");
			rd.forward(request, response);
		} else {
			request.setAttribute("status", "failed");
			rd = request.getRequestDispatcher("/mangLoginFailure.jsp");
			rd.forward(request, response);

		}
		System.out.println(status);
	}

	public void mangRegister(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("***Management Register***");

		Management mang = new Management();
		mang.setMid(request.getParameter("mid"));
		mang.setMname(request.getParameter("mname"));
		mang.setMemail(request.getParameter("memail"));
		mang.setMpwd(request.getParameter("mpwd"));

		managementService = ManagementServiceFactory.getManagementService();
		String status = managementService.mangReg(mang);

		request.setAttribute("status", status);
		rd = request.getRequestDispatcher("/mangRegStatus.jsp");
		rd.forward(request, response);

		System.out.println(status);
	}

	public void mangAddBookLib(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("***Management Adding Book to Library");
		Book book = new Book();
		book.setBid(request.getParameter("bid"));
		book.setBtitle(request.getParameter("btitle"));
		book.setBauthor(request.getParameter("bauthor"));
		book.setBcategory(request.getParameter("bcategory"));

		managementService = ManagementServiceFactory.getManagementService();
		String status = managementService.mangAddBookLib(book);
		
		request.setAttribute("status", status);
		rd = request.getRequestDispatcher("/mangAddBookInLibResult.jsp");
		rd.forward(request, response);
		System.out.println(status);
		
	}

	public void mangUpdateBookLib(HttpServletRequest request, HttpServletResponse response) {
	}

	public void mangRemoveBookLib(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("***Management Remove Book");
		String bid = request.getParameter("bid");

		managementService = ManagementServiceFactory.getManagementService();
		String status = managementService.mangRemoveBookLib(bid);
		
		request.setAttribute("status", status);
		rd = request.getRequestDispatcher("/mangDeleteBookResult.jsp");
		rd.forward(request, response);
		System.out.println(status);
		
		System.out.println(status);

	}

	public void mangSearchBookLib(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("***Management Search Book***");
		String attribute = request.getParameter("attribute");
		String value = request.getParameter("value");

		managementService = ManagementServiceFactory.getManagementService();
		Book book = managementService.mangSearchBook(attribute, value);
		System.out.println(book);
		request.setAttribute("book", book);

		RequestDispatcher rd = request.getRequestDispatcher("/mangBooksSearchResult.jsp");
		rd.forward(request, response);

	}

	public void mangIssueBookStud(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("***Management Issue Book");
		String sid = request.getParameter("sid");
		String bid = request.getParameter("bid");

		managementService = ManagementServiceFactory.getManagementService();
		String status = managementService.mangIssueBookStud(sid, bid);

		request.setAttribute("status", status);
		rd = request.getRequestDispatcher("/mangIssueBookResult.jsp");
		rd.forward(request, response);
		System.out.println(status);

		System.out.println(status);
	}

	public void libAvilableBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("***Books Avilable in Libbrary***");

		managementService = ManagementServiceFactory.getManagementService();
		List<Book> books = managementService.libAvailableBooks();

		if (books.isEmpty()) {
			rd = request.getRequestDispatcher("/libBooksNotFound.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("books", books);
			rd = request.getRequestDispatcher("/booksAvailableInLibResult.jsp");
			rd.forward(request, response);
		}
		
		
		System.out.println(books);
		books.toString();
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();

		// student Home Pages URLS
		if (uri.endsWith("regstudent"))
			regStudent(request, response);

		if (uri.endsWith("loginstudent")) {
			loginStudent(request, response);
		}
		if (uri.endsWith("studentmybooks")) {
			studentMyBooks(request, response);
		}
		if (uri.endsWith("studentsubmitbook")) {
			studentSubmitBook(request, response);
		}
		if (uri.endsWith("studentmyfines")) {
			studentMyFines(request, response);
		}

		// management home page URLS
		if (uri.endsWith("manglogin")) {
			mangLogin(request, response);
		}
		if (uri.endsWith("mangregister")) {
			mangRegister(request, response);
		}
		if (uri.endsWith("mangaddbooklib")) {
			mangAddBookLib(request, response);
		}
		if (uri.endsWith("mangupdatebooklib")) {
			mangUpdateBookLib(request, response);
		}
		if (uri.endsWith("mangremovebooklib")) {
			mangRemoveBookLib(request, response);
		}
		if (uri.endsWith("mangsearchbooklib")) {
			mangSearchBookLib(request, response);
		}
		if (uri.endsWith("mangissuebookstud")) {
			mangIssueBookStud(request, response);
		}
		if (uri.endsWith("libavailablebooks")) {
			libAvilableBooks(request, response);
		}

	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
