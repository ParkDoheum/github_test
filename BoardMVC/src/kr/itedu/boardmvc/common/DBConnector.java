package kr.itedu.boardmvc.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnector {
	public static Connection getConn() throws SQLException {
		DataSource ds = null;
		try {
			Context init = new InitialContext();
			ds = (DataSource)init.lookup("java:comp/env/oracleDB");
		} catch(NamingException e) {
			//TODO: 예외처리
		} catch(Exception e) {
			//TODO: 예외처리
		}
		return ds.getConnection();
	}

	public static void close(Connection c, PreparedStatement p, ResultSet r) {
		if(r != null) { try { r.close(); } catch(Exception e) {} }		
		if(p != null) { try { p.close(); } catch(Exception e) {} }		
		if(c != null) { try { c.close(); } catch(Exception e) {} }
	}
	
	public static void close(Connection c) {
		close(c, null, null);
	}
	
	public static void close(PreparedStatement p) {
		close(null, p, null);
	}
	
	public static void close(PreparedStatement p, ResultSet r) {
		close(null, p, r);
	}	
}





