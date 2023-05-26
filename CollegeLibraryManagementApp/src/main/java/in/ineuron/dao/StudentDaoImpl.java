package in.ineuron.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.ineuron.dto.Book;
import in.ineuron.dto.Student;
import in.ineuron.dto.StudentBookTracker;
import in.ineuron.util.JdbcUtil;

public class StudentDaoImpl implements IStudentDao {
	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet resultSet = null;

	@Override
	public String studentRegister(Student student) {

		String sqlInsertQuery = "INSERT INTO student(`sid`,`sname`,`slastname`,`sage`, `smail`,`saddress`,`spwd`)VALUES(?,?,?,?,?,?,?)";
		try {

			connection = JdbcUtil.getJdbcConnection();

			if (connection != null)
				pstmt = connection.prepareStatement(sqlInsertQuery);
			if (pstmt != null) {

				pstmt.setString(1, student.getSid());
				pstmt.setString(2, student.getSname());
				pstmt.setString(3, student.getSlastname());
				pstmt.setInt(4, student.getSage());
				pstmt.setString(5, student.getSmail());
				pstmt.setString(6, student.getSaddress());
				pstmt.setString(7, student.getSpassword());

				int rowAffected = pstmt.executeUpdate();
				if (rowAffected == 1) {
					return "success";
				}
			}

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return "failure";
	}

	@Override
	public String studentLogin(String sid, String spassword) {
		String spwd = null;
		String msg = null;
		String sqlInsertQuery = "SELECT spwd FROM student WHERE sid = ?";

		try {
			connection = JdbcUtil.getJdbcConnection();

			if (connection != null)
				pstmt = connection.prepareStatement(sqlInsertQuery);
			if (pstmt != null) {
				pstmt.setString(1, sid);
				System.out.println("Controll in pstmt != null set string");
			}
			if (pstmt != null) {
				resultSet = pstmt.executeQuery();
				System.out.println("ResultSet exe query");
			}
			if (resultSet != null) {
				if (resultSet.next()) {
					spwd = resultSet.getString(1);
					System.out.println("Student PassWord :: "+spwd);

					if (spassword.equals(spwd)) {
						msg = "success";
					} else {
						msg = "failed";
					}
				} else {
					msg = "failed";
				}
			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public List<Book> studentMyBooks(String sid) {
		List<Book> books = new ArrayList<Book>();
		List<String> bidList = new ArrayList<String>();
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		try { 
			connection = JdbcUtil.getJdbcConnection();
			String sqlQuery1 = "SELECT bid FROM studentbooktracker WHERE sid=? AND submitdate=borrowdate";
			String sqlQuery2 = "SELECT bid, btitle, bauthor, bcategory FROM book WHERE bid=?";
			if (connection != null) {
				pstmt1 = connection.prepareStatement(sqlQuery1);
				if (pstmt1 != null) {
					pstmt1.setString(1, sid);
					resultSet1 = pstmt1.executeQuery();
					while (resultSet1.next()) {
						String bid = resultSet1.getString(1);
						bidList.add(bid);
					}
				} 
				
				pstmt2 = connection.prepareStatement(sqlQuery2);
				if (pstmt2 != null) {
					System.out.println("pstmt2 ::"); 
					for (String bid : bidList) {
						pstmt2.setString(1, bid);
						System.out.println(bid);
						resultSet2 = pstmt2.executeQuery(); 
						while (resultSet2.next()) { 
							Book book = new Book();
							book.setBid(resultSet2.getString("bid"));
							book.setBauthor(resultSet2.getString("bauthor"));
							book.setBtitle(resultSet2.getString("btitle"));
							book.setBcategory(resultSet2.getString("bcategory"));
							books.add(book);
							System.out.println(book.toString());
						}
					}
				}

			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public StudentBookTracker getBorrowAndSubmitDate(String sid, String bid) {
		System.out.println("In getBorrowAndSubmitDate servie");
		Date borrowDate = null;
		Date submitDate = null;
		StudentBookTracker sbt = null;
		System.out.println("In dao ");
		String sqlSelectQuery = "SELECT borrowdate, submitdate FROM studentbooktracker WHERE sid=? AND bid =?";
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				pstmt = connection.prepareStatement(sqlSelectQuery);
				if (pstmt != null) {
					pstmt.setString(1, sid);
					pstmt.setString(2, bid);
				}
				resultSet = pstmt.executeQuery();
				if (resultSet != null) {
					if(resultSet.next()) {

						borrowDate = resultSet.getDate(1);
						submitDate = resultSet.getDate(2);

						sbt = new StudentBookTracker();
						sbt.setBorrowdate(borrowDate);
						sbt.setSubmitdate(submitDate);
						System.out.println(borrowDate);
						System.out.println(submitDate);
						return sbt;
					}

				}
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return sbt;
	}

	@Override
	public String addFine(Student student, String bid) {
		System.out.println("In setting fine in dao");
		String sqlUpdateQuery = "UPDATE studentbooktracker SET fine=? WHERE sid=? AND bid=?";
		Integer fine = student.getFine();
		String sid = student.getSid();
		String msg = "";

		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				pstmt = connection.prepareStatement(sqlUpdateQuery);
				if (pstmt != null) {
					pstmt.setInt(1, fine);
					pstmt.setString(2, sid);
					pstmt.setString(3, bid);
					int rowsAffected = pstmt.executeUpdate();
					System.out.println(rowsAffected);
					if (rowsAffected != 0) {
						msg = "success";
					} else {
						msg = "failed";
					}
				}
			}
		} catch (SQLException | IOException e) {

			e.printStackTrace();
		}
		return msg;

	}

	@Override
	public String studSubmitBook(String sid, String bid) {
		String msg = null;
		int count;

		try {
			connection = JdbcUtil.getJdbcConnection();
			java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());
			System.out.println(sid + ":" + bid);
			String sqlQuery = "UPDATE studentbooktracker SET submitdate=? WHERE sid=? AND bid=?";
			if (connection != null) {
				pstmt = connection.prepareStatement(sqlQuery);
				if (pstmt != null) {
					pstmt.setDate(1, date);
					pstmt.setString(2, sid);
					pstmt.setString(3, bid);
					count = pstmt.executeUpdate();
					if (count == 1) {
						msg = "success";
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
	public Integer studMyFines(String sid, String bid) {
		int fine = 0;
		System.out.println("In my fine in dao");
		try {
			connection = JdbcUtil.getJdbcConnection();
			String sqlQuery = "SELECT fine FROM studentbooktracker WHERE sid = ? AND bid =?";
			if (connection != null) {
				pstmt = connection.prepareStatement(sqlQuery);

				if (pstmt != null) {
					pstmt.setString(1, sid);
					pstmt.setString(2, bid);
					resultSet = pstmt.executeQuery();
				}
					
				if (resultSet != null) {
					if(resultSet.next())
						fine = resultSet.getInt(1);
				}
			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fine;

	}

}
