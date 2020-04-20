package home.my.sorm.bean;
/**
 * 管理配置信息
 * @author Administrator
 *
 */
public class Configuration {
	/**
	 * 驱动类
	 */
	private String driver="com.mysql.jdbc.Driver";
	/**
	 * jdbc的url
	 */
	private String url="jdbc:mysql://localhost:3306/testjdbc";
	/**
	 * 数据库的用户名
	 */
	private String user="root";
	/**
	 * 数据库的密码
	 */
	private String pwd="root";
	/**
	 * 正在使用的数据库
	 */
	private String usingDB="testjdc";
	/**
	 * 项目的源码路径
	 */
	private String srcPath="D:\\JAVA基础\\SORM\\src";
	/**
	 * 扫描生成java类的包（po的意思是：Persistence object）
	 */
	private String poPackage="home.my.po";
	
	public Configuration(String driver, String url, String user, String pwd, String usingDB, String srcPath,
			String poPackage) {
		super();
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.pwd = pwd;
		this.usingDB = usingDB;
		this.srcPath = srcPath;
		this.poPackage = poPackage;
	}
	public Configuration() {
		super();
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getUsingDB() {
		return usingDB;
	}
	public void setUsingDB(String usingDB) {
		this.usingDB = usingDB;
	}
	public String getSrcPath() {
		return srcPath;
	}
	public void setSrcPath(String srcPath) {
		this.srcPath = srcPath;
	}
	public String getPoPackage() {
		return poPackage;
	}
	public void setPoPackage(String poPackage) {
		this.poPackage = poPackage;
	}
	
	
}
