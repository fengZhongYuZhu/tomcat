package com.wxkj.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.wxkj.dbUtil.DbUtil;

public class Dao {

	private Connection connection=null;
	private Statement statement=null;
	private ResultSet resultSet=null;
	private DataSource data=new ComboPooledDataSource();
	
	
	public void addObj(String sql) {
		// TODO Auto-generated method stub
		try {
			connection=data.getConnection();
			//创建执行对象
			statement=connection.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
//				connection.commit();
				connection.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public List<?> query(String sql,Class<?> class1) {
		// TODO Auto-generated method stub
		List<?> list=null;
		try {
			connection=data.getConnection();
			//创建执行对象
			statement=connection.createStatement();
			resultSet=statement.executeQuery(sql);
			list=(List<?>) DbUtil.resultToList(resultSet, class1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
//				connection.commit();
				connection.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

}
