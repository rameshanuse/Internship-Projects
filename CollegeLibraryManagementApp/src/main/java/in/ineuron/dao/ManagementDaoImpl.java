package in.ineuron.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.ineuron.dto.Book;
import in.ineuron.dto.Management;
import in.ineuron.util.JdbcUtil;

public class ManagementDaoImpl implements IManagementDao {

	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet resultSet = null;

	@Override
	public String mangReg(Management management) {
		String sqlQuery = "";
		int i = 0;
		String msg = "";

		try {
			connection = JdbcUtil.getJdbcConnection();
			String mid = management.getMid();
			String mname = management.getMname();
			String memail = management.getMemail();
			String mpwd = management.getMpwd();

			sqlQuery = "INSERT INTO management(mid, mname, memail, mpwd) VALUES(?,?,?,?)";

			if (connection != null) {
				pstmt = connection.prepareStatement(sqlQuery);
				pstmt.setString(1, mid);
				pstmt.setString(2, mname);
				pstmt.setString(3, memail);
				pstmt.setString(4, mpwd);
				if (pstmt != null) {
					i = pstmt.executeUpdate();
				}
			}

		} catch (SQLException | IOException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (i != 0) {
			msg = "success";
		} else
			msg = "failed";

		return msg;
	}

	@Override
	public String mangLogin(String mid, String mpwd) {

		String sqlQuery = "";
		String msg = "";
		String mpwd2 = "";
		try {
			connection = JdbcUtil.getJdbcConnection();
			sqlQuery = "SELECT mpwd FROM management WHERE mid=?";
			if (connection != null) {
				pstmt = connection.prepareStatement(sqlQuery);
				pstmt.setString(1, mid);

				resultSet = pstmt.executeQuery();
				if (resultSet != null) {
					while (resultSet.next()) {
						mpwd2 = resultSet.getString("mpwd");
					}
					if (mpwd.equals(mpwd2)) {
						msg = "success";
					} else
						msg = "failed";
				} else
					msg = "failed";
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String mangIssueBookStud(String sid, String bid) {
		String msg = "";
		int i = 0;

		try {
			connection = JdbcUtil.getJdbcConnection();
			String sqlQuery = "INSERT INTO studentbooktracker(sid, bid, borrowdate, submitdate, fine) VALUES(?,?,?,?,?)";
			java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());

			if (connection != null) {
				pstmt = connection.prepareStatement(sqlQuery);
				if (pstmt != null) {
					pstmt.setString(1, sid);
					pstmt.setString(2, bid);
					pstmt.setDate(3, date);
					pstmt.setDate(4, date);
					pstmt.setInt(5, 0);

					i = pstmt.executeUpdate();
					if (i == 1) {
						msg = "success";
					} else
						msg = "failed";
				}
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String mangAddBookLib(Book book) {
		String msg = "";
		Boolean flag = true;
		try {
			connection = JdbcUtil.getJdbcConnection();
			String sqlQuery = "INSERT INTO book(bid,btitle,bauthor,bcategory) VALUES(?,?,?,?)";
			if (connection != null) {
				pstmt = connection.prepareStatement(sqlQuery);
				if (pstmt != null) {
					pstmt.setString(1, book.getBid());
					pstmt.setString(2, book.getBtitle());
					pstmt.setString(3, book.getBauthor());
					pstmt.setString(4, book.getBcategory());

					flag = pstmt.execute();
					if (!flag) {
						msg = "success";
					} else
						msg = "failed";
				}
			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String mangUpdateBookLib(Book book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String mangRemoveBookLib(String bid) {
		String msg = "";
		int count = 0;
		try {
			connection = JdbcUtil.getJdbcConnection();
			String sqlQuery = "DELETE FROM book WHERE bid = ?";
			if (connection != null) {
				pstmt = connection.prepareStatement(sqlQuery);
				if (pstmt != null) {
					pstmt.setString(1, bid);

					count = pstmt.executeUpdate();
					if (count == 1) {
						msg = "success";
					} else if (count == 0) {
						msg = "not found";
					} else {
						msg = "failure";
					}
				}
			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public Book mangSearchBook(String attribute, String value) {
		Book book = null;
		try {
			connection = JdbcUtil.getJdbcConnection();
			String sqlQuery = "SELECT bid, btitle, bauthor, bcategory FROM book WHERE " + attribute + "= ? ";
			if (connection != null) {
				pstmt = connection.prepareStatement(sqlQuery);
				if (pstmt != null) {
					pstmt.setString(1, value);
					resultSet = pstmt.executeQuery();

					if (resultSet != null) {
						while (resultSet.next()) {

							book = new Book();
							book.setBid(resultSet.getString(1));
							book.setBtitle(resultSet.getString(2));
							book.setBauthor(resultSet.getString(3));
							book.setBcategory(resultSet.getString(4));
						}
					}
				}

			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return book;
	}

	@Override
	public List<Book> libAvailableBooks() {
		List<Book> books = new ArrayList<Book>();
		try {
			connection = JdbcUtil.getJdbcConnection();
			String sqlQuery = "SELECT bid, btitle, bauthor, bcategory FROM book";
			if (connection != null) {
				pstmt = connection.prepareStatement(sqlQuery);

				if (pstmt != null) {
					resultSet = pstmt.executeQuery();
					while(resultSet.next()) {
						Book book = new Book();
						System.out.println(resultSet);
						book.setBid(resultSet.getString("bid"));
						book.setBauthor(resultSet.getString("bauthor"));
						book.setBtitle(resultSet.getString("btitle"));
						book.setBcategory(resultSet.getString("bcategory"));
						books.add(book);
						System.out.println(book.toString());
					}
				}
			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return books;
	}


}
