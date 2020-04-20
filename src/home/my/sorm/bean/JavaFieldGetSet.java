package home.my.sorm.bean;

/**
 * 封装了额java属性和getset方法
 * @author Administrator
 *
 */
public class JavaFieldGetSet {	
	/**
	 * 属性的源码信息 如：private  userId;
	 */
	private String fieldInfo;
	/**
	 * get方法的源码信息 
	 */
	private String getInfo;
	/**
	 * set方法的源码信息
	 */
	private String setInfo;
	public String getFieldInfo() {
		return fieldInfo;
	}
	public void setFieldInfo(String fieldInfo) {
		this.fieldInfo = fieldInfo;
	}
	public String getGetInfo() {
		return getInfo;
	}
	public void setGetInfo(String getInfo) {
		this.getInfo = getInfo;
	}
	public String getSetInfo() {
		return setInfo;
	}
	public void setSetInfo(String setInfo) {
		this.setInfo = setInfo;
	}
	public JavaFieldGetSet(String fieldInfo, String getInfo, String setInfo) {
		super();
		this.fieldInfo = fieldInfo;
		this.getInfo = getInfo;
		this.setInfo = setInfo;
	}
	public JavaFieldGetSet() {
		super();
	}
	@Override
	public String toString() {
		return fieldInfo  + getInfo + setInfo ;
	}
	
	
}
