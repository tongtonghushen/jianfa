package home.my.sorm.bean;
/**
 * 存储表结构信息
 * @author Administrator
 *
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class TableInfo {
	/**
	 * 表名
	 */
	private String tname;
	/**
	 * 所有字段的信息
	 */
	private Map<String, ColumnInfo> columns;
	/**
	 * 唯一主键（目前我们只能处理表中一个主键）
	 */
	private ColumnInfo onlyPriKey;
	private int priKeys;
	public int getPriKeys() {
		return priKeys;
	}
	public void setPriKeys(int priKeys) {
		this.priKeys = priKeys;
		
	}
	public TableInfo() {
		super();
	}
	public TableInfo(String tname, ArrayList<ColumnInfo> arrayList, HashMap<String, ColumnInfo> hashMap) {
		super();
		this.tname = tname;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public Map<String, ColumnInfo> getColumns() {
		return columns;
	}
	public void setColumns(Map<String, ColumnInfo> columns) {
		this.columns = columns;
	}
	public ColumnInfo getOnlyPriKey() {
		return onlyPriKey;
	}
	public void setOnlyPriKey(ColumnInfo onlyPriKey) {
		this.onlyPriKey = onlyPriKey;
	}
	
}
