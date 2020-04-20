package home.my.sorm.utils;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import home.my.sorm.bean.ColumnInfo;
import home.my.sorm.bean.Configuration;
import home.my.sorm.bean.JavaFieldGetSet;
import home.my.sorm.bean.TableInfo;
import home.my.sorm.core.MySqlTypeConvertor;
import home.my.sorm.core.TableContext;
import home.my.sorm.core.TypeConvertor;

/**
 * 封装了生成java文件（源代码）常用的操作
 * @author Administrator
 *
 */
public class JavaFileUtils {
	/**
	 * 根据字段信息生成java属性信息，
	 * @param column column字段信息
	 * @param convertor 类型转换器
	 * @return java属性和setget方法
	 */
	public static JavaFieldGetSet createFieldGetSet(ColumnInfo column,TypeConvertor convertor) {

		
		
		JavaFieldGetSet jfgs=new JavaFieldGetSet();
		
		String javaFieldType =convertor.databaseType2JavaType(column.getDataType());
		
		jfgs.setFieldInfo("private "+javaFieldType+" "+column.getName()+";\n");
		StringBuilder getSrc=new StringBuilder();
		getSrc.append("public "+javaFieldType+" get"+StringUtils.firstChar2UpperCase(column.getName())+"(){\n");
		getSrc.append("return "+column.getName()+";\n}\n");
		getSrc.append("\t\n");
		jfgs.setGetInfo(getSrc.toString());
		
		StringBuilder setSrc=new StringBuilder();
		setSrc.append("\tpublic void set"+StringUtils.firstChar2UpperCase(column.getName())+"(");
		setSrc.append(javaFieldType+" "+column.getName()+"){\n");
		setSrc.append("\t\tthis."+column.getName()+"="+column.getName()+";\n");
		setSrc.append("\t}\n");
		jfgs.setSetInfo(setSrc.toString());
		return jfgs;
	}
	public static String createJavaSrc(TableInfo tableInfo,TypeConvertor convertor) {
		StringBuilder src=new StringBuilder();
		Map<String, ColumnInfo> columns=tableInfo.getColumns();
		List<JavaFieldGetSet> javaFields=new ArrayList<JavaFieldGetSet>();
		for (ColumnInfo c : columns.values()) {
			javaFields.add(createFieldGetSet(c, convertor));
		}
		Configuration con=new Configuration();
		src.append("package "+con.getPoPackage()+";\n\n");
		src.append("import java.sql.*;\n");
		src.append("import java.util.*;\n\n");
		src.append("public class "+StringUtils.firstChar2UpperCase(tableInfo.getTname())+"{\n\n");
		
		for (JavaFieldGetSet f : javaFields) {
			src.append(f.getFieldInfo());
		}
		src.append("\n\n");
		for (JavaFieldGetSet f : javaFields) {
			src.append(f.getGetInfo());
		}
		for (JavaFieldGetSet f : javaFields) {
			src.append(f.getSetInfo());
		}
		src.append("}\n");
		System.out.println(src);
		return src.toString();
	}
	public static void createJavaPOFile(TableInfo tableInfo,TypeConvertor convertor) {
		String src=createJavaSrc(tableInfo, convertor);
		
		BufferedWriter bw=null;
		
		try {
			bw=new BufferedWriter(new FileWriter("a.java"));
			bw.write(src);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
				try {
					if (bw!=null) {
					bw.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
	}
	
	public static void main(String[] args) {
//		ColumnInfo colum=new ColumnInfo("id", "int", 0);
//		JavaFieldGetSet j=createFieldGetSet(colum, new MySqlTypeConvertor());
//		System.out.println(j);
		Map<String, TableInfo> map=TableContext.tables;
		TableInfo t=map.get("emp");
		createJavaSrc(t, new MySqlTypeConvertor());
	}
}
