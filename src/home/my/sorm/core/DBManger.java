package home.my.sorm.core;
/**
 * 根据配置信息，维持连接对象的管理（增加连接池功能）
 * @author Administrator
 *
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import home.my.sorm.bean.Configuration;

public class DBManger {
	private static Configuration conf;
	
	static {//静态块
		conf=new Configuration();
	}
	public static Connection getConn() {
		
		try {
			Class.forName(conf.getDriver());
			return DriverManager.getConnection(conf.getUrl(),conf.getUser(),conf.getPwd());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
