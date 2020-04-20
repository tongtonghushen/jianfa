package home.my.sorm.core;
/**
 * 负责java数据类型和数据库类型的转换
 * @author Administrator
 *
 */
public interface TypeConvertor {
	
	/**
	 * 将数据库数据类型转换成java的数据类型
	 * @param columType 数据库字段的数据类型
	 * @return Java的数据类型
	 */
	public String databaseType2JavaType(String columType);
	/**
	 * 负责将java数据类型转化成数据库数据类型
	 * @param javaDateType java数据类型
	 * @return 数据库数据类型
	 */
	public String javaType2DatabaseType(String javaDateType);
}
