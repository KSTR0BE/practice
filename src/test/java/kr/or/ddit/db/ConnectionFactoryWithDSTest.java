package kr.or.ddit.db;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class ConnectionFactoryWithDSTest {

	@Test
	void testGetConnection() throws SQLException {
		Connection conn = ConnectionFactoryWithDS.getConnection();
		System.out.println(conn);
	}

}
