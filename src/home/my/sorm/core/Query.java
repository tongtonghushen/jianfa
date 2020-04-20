package home.my.sorm.core;
/**
 * 负责查询（对外提供服务的核心类）
 * @author Administrator
 *
 */

import java.util.List;
@SuppressWarnings("all")
public interface Query {
	/*
	 * 直接执行一个DML语句
	 * @param sql sql语句
	 * @param params参数
	 * @return 执行sql语句后影响供记录的行数
	 */
	public int executeDML(String sql,Object[] params);
	
	/*
	 * 讲一个对象存储到数据库中
	 * @param obj 要存储的对象
	 */
	public void insert(Object obj);
	/**
	 * 删除clz表示类对应的表中的记录（指定主键id的记录）
	 * @param clz 跟表对应的类的Class对象
	 * @param id 主键的值
	 * @return 主键值
	 */
	public int delete(Class clz,int id);
	/**
	 * 删除对象在数据库中对应的记录（对象所在的类对应到表，对象的主键的值对应到记录）
	 * @param obj
	 */
	public void delete(Object obj);
	/**
	 * 跟新对象对应的记录，并且只更新指定的字段啊的值
	 * @param obj 所要更新的对象
	 * @param fieldNames 更新的属性列表
	 * @return 执行sql语句影响记录的行数
	 */
	public int updatee(Object obj,String[] fieldNames);
	/**
	 * 查询返回多行记录，并将每行记录封装到clz指定的类的对象中
	 * @param sql 查询语句
	 * @param clz 封装数据的javabean类的Class对象
	 * @param params sql的参数
	 * @return 查询到的结果
	 */
	public List queryRows(String sql,Class clz,Object[] params);
	/**
	 * 查询返回一行记录，并将每行记录封装到clz指定的类的对象中
	 * @param sql 查询语句
	 * @param clz 封装数据的javabean类的Class对象
	 * @param params sql的参数
	 * @return 查询到的结果
	 */
	public List queryUniquRow(String sql,Class clz,Object[] params);
	/**
	 * 查询返回一个数字（一行一列），并将该值返回
	 * @param sql 查询语句
	 * @param params sql的参数
	 * @return 查询到的结果
	 */
	public Number queryValue(String sql,Object[] params);
}
