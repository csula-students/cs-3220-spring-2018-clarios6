package edu.csula.storage.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database implements edu.csula.storage.Database{
	// FIXME: don't hard commit your credential
	/*My local MySQL instalation is currently borked*/
	private static final String database = "cs3220stu44";
	private static final String host = "cs3.calstatela.edu:8080";
	private static final String username = "cs3220stu44";
	private static final String password = "";
	private static final String url = String.format("jdbc:mysql://%s/%s?user=/%s&paswsword=%s", host, database, username, password);
	//jdbc:mysql//[host:port]/[databbase][?user=cs3220xstu25&password=abcd]

	public Database() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch( ClassNotFoundException e ) {
			throw new IllegalStateException(e);
		}
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
}
