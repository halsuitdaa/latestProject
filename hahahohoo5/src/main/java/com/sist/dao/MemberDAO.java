package com.sist.dao;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.*;
import com.sist.vo.*;
import com.sist.dbcp.*;
public class MemberDAO {
   private Connection conn;
   private PreparedStatement ps;
   private CreateDBCPConnection dbconn=
		     new CreateDBCPConnection();
   private static MemberDAO dao;
   
   private static SqlSessionFactory ssf=CommonsDataBase.getSsf();
   
   public static MemberDAO newInstance()
   {
	   if(dao==null)
		   dao=new MemberDAO();
	   return dao;
   }
   // ID중복체크 
   public int memberIdCheck(String id)
   {
	   int count=0;
	   try
	   {
		   conn=dbconn.getConnection();
		   String sql="SELECT COUNT(*) FROM camp_member "
				     +"WHERE id=?";
		   ps=conn.prepareStatement(sql);
		   ps.setString(1, id);
		   ResultSet rs=ps.executeQuery();
		   rs.next();
		   count=rs.getInt(1);
		   rs.close();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   dbconn.disConnection(conn, ps);
	   }
	   return count;
   }
   /*try
   {
	   conn=dbconn.getConnection();
   }catch(Exception ex)
   {
	   ex.printStackTrace();
   }
   finally
   {
	   dbconn.disConnection(conn, ps);
   }*/
   public List<ZipcodeVO> postfind(String dong)
   {
	   List<ZipcodeVO> list=new ArrayList<ZipcodeVO>();
	   try
	   {
		   conn=dbconn.getConnection();
		   String sql="SELECT zipcode,sido,gugun,"
				     +"dong,NVL(bunji,' ') "
				     +"FROM zipcode "
				     +"WHERE dong LIKE '%'||?||'%'";
		   ps=conn.prepareStatement(sql);
		   ps.setString(1, dong);
		   ResultSet rs=ps.executeQuery();
		   while(rs.next())
		   {
			   ZipcodeVO vo=new ZipcodeVO();
			   vo.setZipcode(rs.getString(1));
			   vo.setSido(rs.getString(2));
			   vo.setGugun(rs.getString(3));
			   vo.setDong(rs.getString(4));
			   vo.setBunji(rs.getString(5));
			   
			   list.add(vo);
		   }
		   rs.close();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   dbconn.disConnection(conn, ps);
	   }
	   return list;
   }
   public int postfindCount(String dong)
   {
	   int count=0;
	   try
	   {
		   conn=dbconn.getConnection();
		   String sql="SELECT COUNT(*) "
				     +"FROM zipcode "
				     +"WHERE dong LIKE '%'||?||'%'";
		   ps=conn.prepareStatement(sql);
		   ps.setString(1, dong);
		   ResultSet rs=ps.executeQuery();
		   rs.next();
		   count=rs.getInt(1);
		   rs.close();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   dbconn.disConnection(conn, ps);
	   }
	   return count;
   }
   public void memberInsert(MemberVO vo)
   {
	   try
	   {
		   conn=dbconn.getConnection();
		   String sql="INSERT INTO camp_member VALUES("
				     +"?,?,?,?,?,?,?,?,?,?,'n',SYSDATE)";
		   ps=conn.prepareStatement(sql);
		   ps.setString(1, vo.getId());
		   ps.setString(2, vo.getPwd());
		   ps.setString(3, vo.getName());
		   ps.setString(4, vo.getSex());
		   ps.setString(5, vo.getBirthday());
		   ps.setString(6, vo.getEmail());
		   ps.setString(7, vo.getPhone());
		   ps.setString(8, vo.getPost());
		   ps.setString(9, vo.getAddr1());
		   ps.setString(10, vo.getAddr2());
		   ps.executeUpdate();
		   // save(vo)
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   dbconn.disConnection(conn, ps);
	   }
   }
   public static MemberVO isLogin(String id,String pwd)
	{
		MemberVO vo = new MemberVO();
		SqlSession session=null;
		try
		{
			session=ssf.openSession();//getConnection()
			int count=session.selectOne("memberIdCount",id);
	     //resultType과 일치							#{id}
			if(count==0)
			{
				vo.setMsg("NOID");
			}
			else
			{
				MemberVO dvo=session.selectOne("memberPwd",id);
				if(pwd.equals(dvo.getPwd()))
				{
					System.out.println("pwd:"+pwd);
					vo.setMsg("OK");
					vo.setId(dvo.getId());
					vo.setName(dvo.getName());
					vo.setAdmin(dvo.getAdmin());
					vo.setPhone(dvo.getPhone());
					vo.setAddr1(dvo.getAddr1());
					vo.setAddr2(dvo.getAddr2());
					vo.setPost(dvo.getPost());
					vo.setEmail(dvo.getEmail());
				}
				else
				{
					vo.setMsg("NOPWD");
				}
			}
			
		}
		catch(Exception ex)
		{
			// 에러 처리
			ex.printStackTrace();
		}
		finally {
			if(session!=null)
				session.close(); // ps.close, conn.close
			// DBCP => 재사용 (반환)
		}
		return vo;
	}
}