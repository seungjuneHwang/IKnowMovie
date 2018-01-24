package kr.co.daegu.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.ac.daegu.JdbcUtil;

   public class managerDAO {
   private DataSource dataFactory;
   private Connection conn;
   private PreparedStatement pstmt;
   private String sql;
   private ResultSet rs;
   private String id;
   private int cnt;
   
   public managerDAO() {
         try {
        	 System.out.println("관리자 DAO");
//            Context ctx = new InitialContext();
//            dataFactory = (DataSource)ctx.lookup(ConstVal.DB_NAME);
//            conn = dataFactory.getConnection();
//        	 conn = JdbcUtil.getConnection();
         } catch (Exception e) {
            e.printStackTrace();
         }
   }
   
   public void managerRegister(managerDTO mdto) {
	   System.out.println("회원 가입 메소드");
      sql = "insert into manager(id,pw,pwsh,lv,part,name) values(?,?,?,?,?,?)";
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, mdto.getId());
         pstmt.setString(2, mdto.getPw());
         pstmt.setString(3, mdto.getPwsh());
         pstmt.setString(4, mdto.getLv());
         pstmt.setString(5, mdto.getPart());
         pstmt.setString(6, mdto.getName());
         pstmt.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
   public boolean managerIdCheck(managerDTO mdto) {
	  System.out.println("id 체크 메소드");
      boolean idCheck = false;
      try {
         sql = "select id from manager where id=?";
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, mdto.getId());
         rs=pstmt.executeQuery();
         while(rs.next()) {
            idCheck=true;
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return idCheck;
   }
   public String managerIdSearch(managerDTO mdto) {
      sql = "select id from manager where name=? and part=?";
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, mdto.getName());
         pstmt.setString(2, mdto.getPart());
         rs=pstmt.executeQuery();
         while(rs.next()) {
            id=rs.getString("id");
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return id;
   }
   public String managerPwSearch(managerDTO mdto) {
      String pw=null;
      sql = "select pw from manager where id=? and name=? and part=?";
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, mdto.getId());
         pstmt.setString(2, mdto.getName());
         pstmt.setString(3, mdto.getPart());
         rs=pstmt.executeQuery();
         while(rs.next()) {
            id=rs.getString("id");
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return pw;
   }
   public boolean managerLogin(managerDTO mdto) {//�α���
      boolean login=false;
      sql = "select id,pw from manager where id=? and pw=?";
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, mdto.getId());
         pstmt.setString(2, mdto.getPw());
         rs=pstmt.executeQuery();
         while(rs.next()) {
            login=true;
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return login;
   }//�α���
   public managerDTO managerUpdateView(managerDTO mdto) {//����
      sql = "select id,pw,pwsh,lv,part,name from manager where id=?";
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, mdto.getId());
         rs=pstmt.executeQuery();
         while(rs.next()) {
            mdto.setId(rs.getString("id"));
            mdto.setPw(rs.getString("pw"));
            mdto.setPwsh(rs.getString("pwsh"));
            mdto.setLv(rs.getString("lv"));
            mdto.setPart(rs.getString("part"));
            mdto.setName(rs.getString("name"));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return mdto;
   }//����
   public void managerUpdate(managerDTO mdto) {//����view
      sql = "update manager set pw=?, pwsh=?, lv=?, part=?, name=? where id=?";
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(6, mdto.getId());
         pstmt.setString(1, mdto.getPw());
         pstmt.setString(2, mdto.getPwsh());
         pstmt.setString(3, mdto.getLv());
         pstmt.setString(4, mdto.getPart());
         pstmt.setString(5, mdto.getName());
         cnt = pstmt.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }//����view
   
   public void managerLeave(managerDTO mdto) {//����
      try {
         sql = "delete from manager where id=?";
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, mdto.getId());
         cnt = pstmt.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }//����
}