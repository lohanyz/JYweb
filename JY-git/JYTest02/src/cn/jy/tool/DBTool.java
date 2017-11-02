package cn.jy.tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import cn.jy.entity.Boxmanageinfo;
import cn.jy.entity.Businessinfo;
import cn.jy.entity.Editinfo;
import cn.jy.entity.Getgoodsinfo;
import cn.jy.entity.Goodsinfo;
import cn.jy.entity.Harborinfo;
import cn.jy.entity.Oilinfo;
import cn.jy.entity.Portinfo;
import cn.jy.entity.Probleminfo;
import cn.jy.entity.Resigninfo;
import cn.jy.entity.Struckinfo;
import cn.jy.entity.Truckinfo;
import cn.jy.entity.Workerinfo;

public class DBTool {
	private String driver 	= "com.mysql.jdbc.Driver";
	private String dbName 	= "mydb";
	private String password = "";
	private String userName = "root";
	private String url 		= "jdbc:mysql://172.23.207.140:3306/" + dbName+"?useUnicode=true&characterEncoding=UTF-8";
	
	public DBTool() {
	
	}
	
	public DBTool(String driver, String dbName, String password,
			String userName, String url) {
		super();
		this.driver = driver;
		this.dbName = dbName;
		this.password = password;
		this.userName = userName;
		this.url = url;
	}

	//	检查数据库是否有链接;
	public Connection doCheckDB(){
		Connection conn=null;
		try {
	       Class.forName(driver);
	       conn= DriverManager.getConnection(url, userName, password);
	    } catch (Exception e) {
	       return null;
	    }
		return conn;
	}
	//	数据库更新操作;
	public int doDBUpdate(String sqlLanguage){
		int 		 	  nCount	=	0;
		Connection		  conn		=	doCheckDB();
		PreparedStatement ptmt		=	null;;
		try {
			ptmt 	= conn.prepareStatement(sqlLanguage);
			nCount 	= ptmt.executeUpdate();
			if(conn!=null){
				conn.close();
			}
			if(ptmt!=null){
				ptmt.close();
			}
		} catch (SQLException e) {
			return 0;
		}
		return nCount;
	}
	/*
	 * sql的查询内容;
	 * */
	public ArrayList<Workerinfo> doDBQueryWorkerinfo(String sqlLanguage){
		Connection conn		=	doCheckDB();
		Statement  stmt		=	null;
		ArrayList<Workerinfo> list=new ArrayList<>();
		try {
			stmt 		 = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlLanguage);//创建数据对象
			while (rs.next()){
				Workerinfo workerinfo=new Workerinfo(
						rs.getString(1), 
						rs.getString(2),
						rs.getString(3),
						rs.getString(4), 
						rs.getString(5),
						rs.getString(6),
						rs.getString(7)
						);
				list.add(workerinfo);
			}
			if(rs!=null){
				rs.close();				
			}
			if(stmt!=null){				
				stmt.close();
			}
			if(conn!=null){				
				conn.close();
			}
		} catch (SQLException e) {
			
		}
		return list; 
	}
	public ArrayList<Businessinfo> doDBQueryBusinessinfo(String sqlLanguage){
		Connection conn		=	doCheckDB();
		Statement  stmt		=	null;
		
		ArrayList<Businessinfo> list=new ArrayList<>();
		try {
			stmt 		 = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlLanguage);//创建数据对象
			while (rs.next()){
				Businessinfo businessinfo=new Businessinfo(
						rs.getString(1).toString(), 
						rs.getString(2).toString(),
						rs.getString(3).toString(),
						rs.getString(4).toString(),
						rs.getString(5).toString(),
						rs.getString(6).toString(),
						rs.getString(7).toString(),
						rs.getString(8).toString(), 
						rs.getString(9).toString(),
						rs.getString(10).toString(),
						rs.getString(11).toString(),
						rs.getString(12).toString(),
						rs.getString(13).toString()
						);
				list.add(businessinfo);
			}
			if(rs!=null){
				rs.close();				
			}
			if(stmt!=null){				
				stmt.close();
			}
			if(conn!=null){				
				conn.close();
			}
		} catch (SQLException e) {
			
		}
		return list; 
	}
	public ArrayList<Goodsinfo> doDBQueryGoodsinfo(String sqlLanguage){
		Connection conn		=	doCheckDB();
		Statement  stmt		=	null;
		
		ArrayList<Goodsinfo> list=new ArrayList<>();
		try {
			stmt 		 = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlLanguage);//创建数据对象
			while (rs.next()){
				Goodsinfo goodsinfo=new Goodsinfo(
						rs.getString(1).toString(), 
						rs.getString(2).toString(),
						rs.getString(3).toString(),
						rs.getString(4).toString(),
						rs.getString(5).toString(),
						rs.getString(6).toString(),
						rs.getString(7).toString(),
						Integer.parseInt(rs.getString(8).toString()),
						rs.getString(9).toString(),
						Double.valueOf(rs.getString(10).toString()),
						Double.valueOf(rs.getString(11).toString()),
						Double.valueOf(rs.getString(12).toString()),
						Double.valueOf(rs.getString(13).toString()),
						Double.valueOf(rs.getString(14).toString())
						);
				list.add(goodsinfo);
			}
			if(rs!=null){
				rs.close();				
			}
			if(stmt!=null){				
				stmt.close();
			}
			if(conn!=null){				
				conn.close();
			}
		} catch (SQLException e) {
			
		}
		return list; 
	}
	public ArrayList<Truckinfo> doDBQueryTruckinfo(String sqlLanguage){
		Connection conn		=	doCheckDB();
		Statement  stmt		=	null;
		
		ArrayList<Truckinfo> list=new ArrayList<>();
		try {
			stmt 		 = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlLanguage);//创建数据对象
			while (rs.next()){
				Truckinfo truckinfo=new Truckinfo(rs.getString(1).toString(),Double.parseDouble(rs.getString(2).toString()),rs.getString(3).toString(),rs.getString(4).toString());
				list.add(truckinfo);
			}
			if(rs!=null){
				rs.close();				
			}
			if(stmt!=null){				
				stmt.close();
			}
			if(conn!=null){				
				conn.close();
			}
		} catch (SQLException e) {
			
		}
		return list; 
	}
	public ArrayList<Struckinfo> doDBQueryStruckinfo(String sqlLanguage){
		Connection conn		=	doCheckDB();
		Statement  stmt		=	null;
		
		ArrayList<Struckinfo> list=new ArrayList<>();
		try {
			stmt 		 = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlLanguage);//创建数据对象
			while (rs.next()){
				Struckinfo struckinfo=new Struckinfo(rs.getString(1).toString(),rs.getString(2).toString(),rs.getString(3).toString(),rs.getString(4).toString());
				list.add(struckinfo);
			}
			if(rs!=null){
				rs.close();				
			}
			if(stmt!=null){				
				stmt.close();
			}
			if(conn!=null){				
				conn.close();
			}
		} catch (SQLException e) {
			
		}
		return list; 
	}
	public ArrayList<Oilinfo> doDBQueryOilinfo(String sqlLanguage){
		Connection conn		=	doCheckDB();
		Statement  stmt		=	null;
		
		ArrayList<Oilinfo> list=new ArrayList<>();
		try {
			stmt 		 = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlLanguage);//创建数据对象
			while (rs.next()){
				Oilinfo oilinfo=new Oilinfo(
						Integer.valueOf(rs.getString(1).toString()), 
						rs.getString(2).toString(),
						rs.getString(3).toString(),
						Double.valueOf(rs.getString(4).toString()),
						Double.valueOf(rs.getString(5).toString()),
						rs.getString(6).toString(),
						rs.getString(7).toString(),
						Double.valueOf(rs.getString(8).toString()),
						Double.valueOf(rs.getString(9).toString()),
						Double.valueOf(rs.getString(10).toString()),
						Double.valueOf(rs.getString(11).toString()),
						rs.getString(12).toString(),
						rs.getString(13).toString(),
						rs.getString(14).toString(),
						rs.getString(15).toString(),
						rs.getString(16).toString(),
						rs.getString(17).toString()
						);
				list.add(oilinfo);
			}
			if(rs!=null){
				rs.close();				
			}
			if(stmt!=null){				
				stmt.close();
			}
			if(conn!=null){				
				conn.close();
			}
		} catch (SQLException e) {
			
		}
		return list; 
	}
	
	public ArrayList<Probleminfo> doDBQueryProbleminfo(String sqlLanguage){
		Connection conn		=	doCheckDB();
		Statement  stmt		=	null;
		
		ArrayList<Probleminfo> list=new ArrayList<>();
		try {
			stmt 		 = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlLanguage);//创建数据对象
			while (rs.next()){
				Probleminfo probleminfo=
						new Probleminfo(
								Integer.valueOf(
								rs.getString(1).toString()), 
								rs.getString(2).toString(),
								rs.getString(3).toString(),
								rs.getString(4).toString(),
								rs.getString(5).toString(),
								rs.getString(6).toString(),
								rs.getString(7).toString(), 
								rs.getString(8).toString(),
								rs.getString(9).toString(),
								rs.getString(10).toString());
				list.add(probleminfo);
			}
			if(rs!=null){
				rs.close();				
			}
			if(stmt!=null){				
				stmt.close();
			}
			if(conn!=null){				
				conn.close();
			}
		} catch (SQLException e) {
			
		}
		return list; 
	}

	public ArrayList<Boxmanageinfo> doDBQueryBoxmanageinfo(String sqlLanguage) {
		// TODO Auto-generated method stub
		Connection conn		=	doCheckDB();
		Statement  stmt		=	null;
		
		ArrayList<Boxmanageinfo> list=new ArrayList<>();
		try {
			stmt 		 = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlLanguage);//创建数据对象
			while (rs.next()){
				Boxmanageinfo bminfo=new Boxmanageinfo(
						Integer.valueOf(rs.getString(1).toString()), 
						rs.getString(2).toString(), 
						rs.getString(3).toString(), 
						rs.getString(4).toString(),
						rs.getString(5).toString(),
						rs.getString(6).toString(),
						rs.getString(7).toString(),
						rs.getString(8).toString(), 
						rs.getString(9).toString(),
						rs.getString(10).toString(),
						rs.getString(11).toString(),
						rs.getString(12).toString(),
						rs.getString(13).toString(),
						rs.getString(14).toString(),
						rs.getString(15).toString() 
						);
				list.add(bminfo);
			}
			if(rs!=null){
				rs.close();				
			}
			if(stmt!=null){				
				stmt.close();
			}
			if(conn!=null){				
				conn.close();
			}
		} catch (SQLException e) {
			
		}
		return list; 
	}

	public ArrayList<Getgoodsinfo> doDBQueryGetgoodsinfo (String sqlLanguage) {
		// TODO Auto-generated method stub
		Connection conn		=	doCheckDB();
		Statement  stmt		=	null;
		
		ArrayList<Getgoodsinfo> list=new ArrayList<>();
		try {
			stmt 		 = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlLanguage);//创建数据对象
			while (rs.next()){
				Getgoodsinfo getgoodsinfo=new Getgoodsinfo(
						Integer.valueOf(rs.getString(1).toString()), 
						rs.getString(2).toString(), 
						rs.getString(3).toString(),
						rs.getString(4).toString(),
						rs.getString(5).toString(),
						rs.getString(6).toString(),
						rs.getString(7).toString(),
						rs.getString(8).toString(), 
						rs.getString(9).toString(), 
						Integer.valueOf(rs.getString(10).toString()), 
						Double.valueOf(rs.getString(11).toString()),
						Double.valueOf(rs.getString(12).toString()),
						Integer.valueOf(rs.getString(13).toString()), 
						rs.getString(14).toString(),
						rs.getString(15).toString()
						);
				list.add(getgoodsinfo);
			}
			if(rs!=null){
				rs.close();				
			}
			if(stmt!=null){				
				stmt.close();
			}
			if(conn!=null){				
				conn.close();
			}
		} catch (SQLException e) {
			
		}
		return list; 
	}

	public ArrayList<Harborinfo> doDBQueryHarborinfo(String sqlLanguage) {
		// TODO Auto-generated method stub
		Connection conn		=	doCheckDB();
		Statement  stmt		=	null;
		
		ArrayList<Harborinfo> list=new ArrayList<>();
		try {
			stmt 		 = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlLanguage);//创建数据对象
			while (rs.next()){
				Harborinfo harborinfo=new Harborinfo(
						Integer.valueOf(rs.getString(1).toString()), 
						rs.getString(2).toString(), 
						rs.getString(3).toString(), 
						rs.getString(4).toString(),
						rs.getString(5).toString(),
						rs.getString(6).toString(),
						rs.getString(7).toString(),
						rs.getString(8).toString(), 
						rs.getString(9).toString(), 
						rs.getString(10).toString(),
						Integer.valueOf(rs.getString(11).toString()), 
						Integer.valueOf(rs.getString(12).toString()), 
						Double.valueOf(rs.getString(13).toString()),
						rs.getString(14).toString()
						);
				list.add(harborinfo);
			}
			if(rs!=null){
				rs.close();				
			}
			if(stmt!=null){				
				stmt.close();
			}
			if(conn!=null){				
				conn.close();
			}
		} catch (SQLException e) {
			
		}
		return list; 
	}

	public ArrayList<Resigninfo> doDBQueryResigninfo(String sqlLanguage) {
		// TODO Auto-generated method stub
		Connection conn		=	doCheckDB();
		Statement  stmt		=	null;
		
		ArrayList<Resigninfo> list=new ArrayList<>();
		try {
			stmt 		 = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlLanguage);//创建数据对象
			while (rs.next()){
				Resigninfo resigninfo=new Resigninfo(
						Integer.valueOf(rs.getString(1).toString()), 
						rs.getString(2).toString(),
						rs.getString(3).toString(),
						rs.getString(4).toString(),
						rs.getString(5).toString()
						);
				list.add(resigninfo);
			}
			if(rs!=null){
				rs.close();				
			}
			if(stmt!=null){				
				stmt.close();
			}
			if(conn!=null){				
				conn.close();
			}
		} catch (SQLException e) {
			
		}
		return list; 
	}

	public ArrayList<Portinfo> doDBQueryPortinfo(String sqlLanguage) {
		// TODO Auto-generated method stub
		Connection conn		=	doCheckDB();
		Statement  stmt		=	null;
		
		ArrayList<Portinfo> list=new ArrayList<>();
		try {
			stmt 		 = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlLanguage);//创建数据对象
			while (rs.next()){
				Portinfo portinfo=new Portinfo(
						Integer.valueOf(rs.getString(1).toString()), 
						rs.getString(2).toString(), 
						rs.getString(3).toString(), 
						rs.getString(4).toString(),
						rs.getString(5).toString(),
						rs.getString(6).toString(),
						rs.getString(7).toString(),
						rs.getBoolean(8),
						rs.getString(9).toString(), 
						rs.getString(10).toString(),
						rs.getString(11).toString(),
						rs.getString(12).toString(), 
						rs.getString(13).toString(), 
						rs.getString(14).toString(),
						rs.getString(15).toString(),
						rs.getString(16).toString(), 
						Integer.valueOf(rs.getString(17).toString()), 
						Double.valueOf(rs.getString(18).toString()),
						Double.valueOf(rs.getString(19).toString()),
						Integer.valueOf(rs.getString(20).toString()), 
						rs.getString(21).toString(),
						rs.getString(22).toString()
						);
				list.add(portinfo);
			}
			if(rs!=null){
				rs.close();				
			}
			if(stmt!=null){				
				stmt.close();
			}
			if(conn!=null){				
				conn.close();
			}
		} catch (SQLException e) {
			
		}
		return list; 
	}
	public ArrayList<Editinfo> doDBQueryEditinfo(String sqlLanguage){
		Connection conn		=	doCheckDB();
		Statement  stmt		=	null;
		
		ArrayList<Editinfo> list=new ArrayList<>();
		try {
			stmt 		 = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlLanguage);//创建数据对象
			while (rs.next()){
				Editinfo editinfo=new Editinfo(
						Integer.parseInt(rs.getString(1).toString()),
						rs.getString(2).toString(),
						rs.getString(3).toString(),
						rs.getString(4).toString(),
						rs.getString(5).toString(),
						rs.getString(6).toString(),
						rs.getString(7).toString(),
						rs.getString(8).toString()
						);
				list.add(editinfo);
			}
			if(rs!=null){
				rs.close();				
			}
			if(stmt!=null){				
				stmt.close();
			}
			if(conn!=null){				
				conn.close();
			}
		} catch (SQLException e) {
			
		}
		return list; 
	}
}
