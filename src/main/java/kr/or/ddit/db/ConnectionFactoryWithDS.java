package kr.or.ddit.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * javax.sql.DataSource의 구현체로 Connection을 생성하기 위한 Factory 객체
 *
 */
public class ConnectionFactoryWithDS {
	static DataSource ds;
	static {
		String basename = "kr.or.ddit.db.Dbinfo";
		ResourceBundle bundle = ResourceBundle.getBundle(basename);
		String driverClassName = bundle.getString("driverClassName");
		String url = bundle.getString("url");
		String user = bundle.getString("user");
		String password = bundle.getString("password");
		boolean autoCommit = Boolean.parseBoolean(bundle.getString("autoCommit"));
		long connectionTimeout = Long.parseLong(bundle.getString("connectionTimeout"));
		String connectionTestQuery = bundle.getString("connectionTestQuery");
		int minimumIdle = Integer.parseInt(bundle.getString("minimumIdle"));
		int maximumPoolSize = Integer.parseInt(bundle.getString("maximumPoolSize"));
		
		
		HikariConfig config = new HikariConfig();
		config.setDriverClassName(driverClassName);
		config.setJdbcUrl(url);
		config.setUsername(user);
		config.setPassword(password);
		
		config.setAutoCommit(autoCommit); //오토커밋 활성화
		config.setConnectionTimeout(connectionTimeout); //pool이 꽉찾을때 5초는 기다려라  3
		config.setConnectionTestQuery(connectionTestQuery); //커넥션이 정상인지 아닌지
		config.setMinimumIdle(minimumIdle); //처음에 만들 connection  1
		config.setMaximumPoolSize(maximumPoolSize); //pool최대 갯수  2
		
		ds = new HikariDataSource(config);
	}
	
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
}
