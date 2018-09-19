package kr.itedu.boardmvc.common;

import static kr.itedu.boardmvc.common.DBConnector.close;
import static kr.itedu.boardmvc.common.DBConnector.getConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.itedu.boardmvc.BoardVO;

public class BoardDAO {
	private static BoardDAO dao;
	
	private BoardDAO() {} //private 생성자
	
	public static BoardDAO getInstance() { //싱글톤 패턴
		if(dao == null) {
			dao = new BoardDAO();
		}
		return dao;
	}	
	
	public ArrayList<BoardVO> getBoardList(int btype) {
		ArrayList<BoardVO> result = new ArrayList<BoardVO>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = getConn();
			String query = String.format(" SELECT bid, btitle, " + 
					" to_char(bregdate, 'YYYY-MM-DD hh24:mi') as bregdate " + 
					" FROM t_board%d " +					
					" ORDER BY bid desc ", btype);
			ps = con.prepareStatement(query);			
			rs = ps.executeQuery();
			while(rs.next()) {
				int bid = rs.getInt("bid");
				String btitle = rs.getString("btitle");
				String bregdate = rs.getString("bregdate");
				BoardVO bv = new BoardVO();
				bv.setBid(bid);
				bv.setBtitle(btitle);
				bv.setBregdate(bregdate);				
				result.add(bv);
			}
			
			
		} catch(SQLException e) {
			//TODO: 예외처리
		} catch(Exception e) {
			//TODO: 예외처리
		} finally {
			close(con, null, null);
		}
		return result;
	}
	
	
	
	
	
}
