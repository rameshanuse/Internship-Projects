package in.ineuron.service;

import java.util.List;

import in.ineuron.dao.IManagementDao;
import in.ineuron.daofactory.ManagementDaoFactory;
import in.ineuron.dto.Book;
import in.ineuron.dto.Management;

public class ManagementServiceImpl implements IManagementService {
	IManagementDao managementDao = null;
	
	@Override
	public String mangReg(Management mang) {
		managementDao = ManagementDaoFactory.getManagementDao();
		return managementDao.mangReg(mang);
	}

	@Override
	public String mangLogin(String mid, String mpwd) {
		managementDao = ManagementDaoFactory.getManagementDao();
		return managementDao.mangLogin(mid, mpwd);
	}

	@Override
	public String mangIssueBookStud(String sid, String bid) {
		managementDao = ManagementDaoFactory.getManagementDao();
		return managementDao.mangIssueBookStud(sid, bid);
	}

	@Override
	public String mangAddBookLib(Book book) {
		managementDao = ManagementDaoFactory.getManagementDao();
		return managementDao.mangAddBookLib(book);
	}

	@Override
	public String mangUpdateBookLib(Book book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String mangRemoveBookLib(String bid) {
		managementDao = ManagementDaoFactory.getManagementDao();
		return managementDao.mangRemoveBookLib(bid);
	}

	@Override
	public Book mangSearchBook(String attribute, String value) {
		managementDao = ManagementDaoFactory.getManagementDao();
		return managementDao.mangSearchBook(attribute, value);
	}

	@Override
	public List<Book> libAvailableBooks() {
		managementDao = ManagementDaoFactory.getManagementDao();
		return managementDao.libAvailableBooks();
	}

}
