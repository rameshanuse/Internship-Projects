package in.ineuron.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class JdbcUtil {

	private JdbcUtil() {
	}

	static {
		// Step1. Loading and register Driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("resource")
	public static Connection getJdbcConnection() throws SQLException, IOException {

		String fileLoc = "D:\\Notes\\ServletProjects\\CollegeLibraryManagementApp2\\src\\main\\java\\in\\ineuron\\properties\\application.properties";
		HikariConfig config = new HikariConfig(fileLoc);
		HikariDataSource dataSource = new HikariDataSource(config);

		return dataSource.getConnection();
	}

}
