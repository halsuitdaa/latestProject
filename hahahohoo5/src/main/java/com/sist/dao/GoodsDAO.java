package com.sist.dao;
import java.util.*;
import java.sql.*;
import com.sist.dbcp.*;
import com.sist.vo.*;
/*
 *  Web Site
 *  1) 메뉴 => 화면 이동 확인
 *  2) 데이터베이스 연동
 *  3) 화면 출력 완료
 *  ======================
 *      Front => Ajax / Vue / React
 *  4) 사용자 입력 유도 ===> 사용자 요구사항 분석
 *     예)
 *        예약 =========> 예약번호 /  ID / 맛집 번호 / 예약일
 *                    ======  =====
 *                         예약시간 / 인원 / 예약여부 / 등록일
 *                                 ======   =====
 *  5) 결과를 출력      
 *  
 *  ==> 입문
 *     => 1. 데이터베이스 연결 (DBCP/MyBatis)
 *     => 2. 목록 = 상세보기
 *           => 페이징
 *     => 3. CRUD (게시판)             
 */
import com.sist.vo.GoodsVO;
public class GoodsDAO {
   private Connection conn;
   private PreparedStatement ps;
   private CreateDBCPConnection dbconn=
         new CreateDBCPConnection();
   private static GoodsDAO dao;
   private final int rowSize=9;
   
   private String[] tables={"",
			  "goods1",
			  "goods2",
			  "goods3",
			  "goods4"};
   
   //싱글턴
   public static GoodsDAO newInstance()
   {
      if(dao==null)
         dao=new GoodsDAO();
      return dao;
   }
   
   
 //메인 상품 목록2
   public List<GoodsVO> goodsMainListData(int type)
   {
	   List<GoodsVO> list=
			   new ArrayList<GoodsVO>();
	   
	   try
	   {
		   conn=dbconn.getConnection();
		   String sql="SELECT cno,gno,poster,title,original_price,brand,rownum "
				    + "FROM "+tables[type] 
				    + " WHERE rownum<=8";
		   ps=conn.prepareStatement(sql);
		   ResultSet rs=ps.executeQuery();
		   while(rs.next())
		   {
			  GoodsVO vo= new GoodsVO();
			  vo.setCno(rs.getInt(1));
			  vo.setGno(rs.getInt(2));
			  vo.setPoster(rs.getString(3));
			  vo.setTitle(rs.getString(4));
			  vo.setOriginal_price(rs.getInt(5));
			  vo.setBrand(rs.getString(6));
			  list.add(vo);
		   }
		   rs.close();
	   }
	   catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally {
		dbconn.disConnection(conn, ps);
	   }
	   
	   return list;
   }
 //전체상품 목록
   public List<GoodsVO> goodsAllListData()
   {
      List<GoodsVO> list=
            new ArrayList<GoodsVO>();
      try
      {
         conn=dbconn.getConnection();
         String sql="SELECT gno, title, poster, selling_price,original_price,mileage,brand,delivery_price,after_service,num "
                  +"FROM(SELECT gno, title, poster, selling_price,original_price,mileage,brand,delivery_price,after_service,rownum AS num "
                  +"FROM(SELECT gno, title, poster, selling_price,original_price,mileage,brand,delivery_price,after_service "
                  +"FROM goods1 ORDER BY gno ASC))";
                  
         ps=conn.prepareStatement(sql);
  
         ResultSet rs=ps.executeQuery(); 
        
         while(rs.next())  //rs=> 단위가 Record단위 => 여러개를 동시에
         {
            GoodsVO vo=new GoodsVO();
            vo.setGno(rs.getInt(1));
            vo.setTitle(rs.getString(2));
            vo.setPoster(rs.getString(3));
            vo.setSelling_price(rs.getInt(4));
            vo.setOriginal_price(rs.getInt(5));
            vo.setMileage(rs.getInt(6));
            vo.setBrand(rs.getString(7));
            vo.setDelivery_price(rs.getString(8));
            vo.setAfter_service(rs.getString(9));
            list.add(vo);
            
         }
         rs.close();
      }
      catch(Exception ex)
      {
         ex.printStackTrace();
      }
      finally {
         dbconn.disConnection(conn, ps);
      }
      return list;
   }
   
   // 동우 ver.총 상품 목록
   public List<GoodsVO> goodsListData(int page, int type)
   {
      List<GoodsVO> list=new ArrayList<GoodsVO>();
      try
      {
         conn=dbconn.getConnection();
         String sql="SELECT cno, gno, title, poster, original_price, selling_price, mileage, brand, num "
                + "FROM(SELECT cno, gno, title, poster, original_price, selling_price, mileage, brand, rownum AS num "
                + "FROM(SELECT cno, gno, title, poster, original_price, selling_price, mileage, brand "
                + "FROM " + tables[type] + " ORDER BY gno ASC)) "
                + "WHERE num BETWEEN ? AND ?";
         
         ps=conn.prepareStatement(sql);
         int start=(rowSize*page)-(rowSize-1);
         int end=rowSize*page;
         
         ps.setInt(1, start);
         ps.setInt(2, end);
         
         ResultSet rs=ps.executeQuery();
         while(rs.next())
         {
            GoodsVO vo=new GoodsVO();
            vo.setCno(rs.getInt(1));
            vo.setGno(rs.getInt(2));
            vo.setTitle(rs.getString(3));
            vo.setPoster(rs.getString(4));
            vo.setOriginal_price(rs.getInt(5));
            vo.setSelling_price(rs.getInt(6));
            vo.setMileage(rs.getInt(7));
            vo.setBrand(rs.getString(8));
            
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
   
   // 동우 ver.총 페이지
   public int goodsTotalPage(int type)
   {
      int total=0;
      try
      {
         conn=dbconn.getConnection();
         String sql="SELECT CEIL(COUNT(*)/" + rowSize + ") "
                + "FROM " + tables[type];
         ps=conn.prepareStatement(sql);
         ResultSet rs=ps.executeQuery();
         rs.next();
         total=rs.getInt(1);
         rs.close();
      }catch(Exception ex)
      {
         ex.printStackTrace();
      }
      finally
      {
         dbconn.disConnection(conn, ps);
      }
      return total;
   }
   
   // 동우 ver.상세보기
   public GoodsVO goodsDetailData(int type, int gno)
   {
      GoodsVO vo=new GoodsVO();
      try
      {
         conn=dbconn.getConnection();
         String sql="SELECT * FROM " + tables[type] + " WHERE gno=" + gno;
         ps=conn.prepareStatement(sql);
         ResultSet rs=ps.executeQuery();
         rs.next();
         vo.setCno(rs.getInt(1));
         vo.setGno(rs.getInt(2));
         vo.setTitle(rs.getString(3));
         vo.setPoster(rs.getString(4));
         vo.setOriginal_price(rs.getInt(5));
         vo.setSelling_price(rs.getInt(6));
         vo.setMileage(rs.getInt(7));
         vo.setBrand(rs.getString(8));
         vo.setDelivery_price(rs.getString(9));
         vo.setAfter_service(rs.getString(10));
         rs.close();
      }catch(Exception ex)
      {
         ex.printStackTrace();
      }
      finally
      {
         dbconn.disConnection(conn, ps);
      }
      return vo;
   }

}