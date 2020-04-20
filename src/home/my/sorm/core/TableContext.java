package home.my.sorm.core;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

import home.my.sorm.bean.ColumnInfo;
import home.my.sorm.bean.TableInfo;
import home.my.sorm.utils.JavaFileUtils;



/**
 * 负责获取管理数据库所有表结构的关系，并可以根据表结构生成类结构
 * @author Administrator
 *
 */
public class TableContext{
	public static Map<String, TableInfo> tables=new HashMap<String, TableInfo>();
	public static Map<Class, TableInfo> poClassTableMap=new HashMap<Class, TableInfo>();
	private TableContext() {
		try {
			
			Connection conn=DBManger.getConn();
			DatabaseMetaData dbmd=conn.getMetaData();
			ResultSet tableRet=dbmd.getTables(null, "%", "%", new String[] {"TABLE"});
			while (tableRet.next()) {
				String tableName=(String)tableRet.getObject("TABLE_NAME");
				TableInfo ti=new TableInfo(tableName,new ArrayList<ColumnInfo>(),new HashMap<String, ColumnInfo>());
				tables.put(tableName,ti);
				ResultSet set=dbmd.getColumns(null, "%", tableName, "%");
				while (set.next()) {
					ColumnInfo ci=new ColumnInfo(set.getString("COLUMN_NAME"),set.getString("TYPE_NAME"),0);
					ti.getColumns().compute(set.getString("COLUMN_NAME"), (BiFunction<? super String, ? super ColumnInfo, ? extends ColumnInfo>) ci);
				}
				ResultSet set2=dbmd.getPrimaryKeys(null, "%", tableName);
				while (set2.next()) {
					ColumnInfo ci2=(ColumnInfo)ti.getColumns().get(set2.getObject("COLUMN_NAME"));
					ti.setPriKeys(1);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void updeteJavaPOFile() {
		Map<String, TableInfo> map=TableContext.tables;
		for (TableInfo t : map.values()) {
			JavaFileUtils.createJavaPOFile(t, new MySqlTypeConvertor());
		}
	}
	public static void loadPOTabls() {
		for (TableInfo tableInfo : tables.values()) {
			try {
				Class c=Class.forName("home.my.po.Emp");
//			poClassTableMap.compute(c,tableInfo);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
			
	}
}
