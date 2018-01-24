package kr.co.daegu.analysis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.ac.daegu.ConstVal;
import kr.co.daegu.analysis.*;;

public class AnalysisDAO {
	public DataSource dataFactory;
	private Connection conn;
	private String sql;
	private PreparedStatement pstmt;
	private int cnt;
	private ResultSet rs;
	private boolean result=false;
	private ArrayList<AnalysisDTO> analysisList;
	
	public AnalysisDAO() {//처리과정
		try {
			Context ctx = new InitialContext();
			analysisList = new ArrayList<AnalysisDTO>();
			dataFactory = (DataSource) ctx.lookup(ConstVal.DB_NAME);
			conn=dataFactory.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//처리과정
	
	public void analysisDayAver(AnalysisDTO analysisDTO) {
		sql="select avg(original*toriginal + ) from ticketcount where nal between ? and ?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, analysisDTO.getNal1());
			pstmt.setString(2, analysisDTO.getNal2());
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
