package home.my.sorm.core;

/**
 * mysql数据类型和java类型的转换
 * @author Administrator
 *
 */
public class MySqlTypeConvertor implements TypeConvertor{

	@Override
	public String databaseType2JavaType(String columType) {
		//varchar-->String
		if ("varchar".equalsIgnoreCase(columType)||"char".equalsIgnoreCase(columType)) {
			return "String";
		}else if ("int".equalsIgnoreCase(columType)||"tinyint".equalsIgnoreCase(columType)) {
			return "Integer";
		}else if ("bigint".equalsIgnoreCase(columType)) {
			return "Long";
		}else if ("double".equalsIgnoreCase(columType)||"float".equalsIgnoreCase(columType)) {
			return "Double";
		}
		
		return null;
	}

	@Override
	public String javaType2DatabaseType(String javaDateType) {
		return null;
	}
	
}
