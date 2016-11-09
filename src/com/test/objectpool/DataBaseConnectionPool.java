package com.test.objectpool;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.DataSources;

public class DataBaseConnectionPool {
	
	public static void main(String args[]){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			DataSource unpooled = DataSources.unpooledDataSource("jdbc:mysql://127.0.0.1:3306/cctv","root","");
			DataSource pooled = DataSources.pooledDataSource(unpooled);
			
			Connection con = null;
			Statement smt = null;
			ResultSet rs = null;
			
			con = pooled.getConnection();
			System.out.println("con Class Type is :"+con.getClass().getName());//创建的是代理对象
			
			Object o1 = getInner(con);
			System.out.println("Inner Class Type is :"+o1.getClass().getName());//创建了mysql连接对象
			
			smt = con.createStatement();
			rs =smt.executeQuery("select * from users");
			while(rs.next())
				System.out.println("Data from DB : "+rs.getString(1));
			
			/*
			 * 关闭并把对象返回到连接池
			 */
			rs.close();
			smt.close();
			con.close();
			
			Thread.sleep(10000);
			
			con = pooled.getConnection();
			Object o2 = getInner(con);
			if(o1 == o2){
				System.out.println("o1 and o2 is the same Object.");//返回的对象相同说明连接对象并没有真正的销毁而是返还到了连接池中
			}
			smt = con.createStatement();
			rs =smt.executeQuery("select * from users");
			while(rs.next())
				System.out.println("Data from DB : "+rs.getString(1));
			
			rs.close();
			smt.close();
			con.close();
		} catch (ClassNotFoundException | SQLException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Object getInner(Connection con){
		Object re = null;
		Field f ;
		try{
			f = con.getClass().getDeclaredField("inner");
			f.setAccessible(true);
			re = f.get(con);
			f.setAccessible(false);
		}catch(Exception e ){
			e.printStackTrace();
		}
		
		return re;
	}

}
