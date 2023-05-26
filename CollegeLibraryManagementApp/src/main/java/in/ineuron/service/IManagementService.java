package in.ineuron.service;

import java.util.List;

import in.ineuron.dto.Book;
import in.ineuron.dto.Management;

public interface IManagementService {
	public String mangReg(Management mang);

	public String mangLogin(String mid, String mpwd);

	public String mangIssueBookStud(String sid, String bid);

	public String mangAddBookLib(Book book);

	public String mangUpdateBookLib(Book book);
 
	public String mangRemoveBookLib(String bid);

	public Book mangSearchBook(String attr, String val);
	
	public List<Book> libAvailableBooks();
}
