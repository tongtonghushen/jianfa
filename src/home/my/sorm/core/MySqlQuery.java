package home.my.sorm.core;

import java.util.List;

import home.my.sorm.bean.ColumnInfo;
import home.my.sorm.bean.TableInfo;

public class MySqlQuery implements Query{

	@Override
	public int executeDML(String sql, Object[] params) {
		return 0;
	}

	@Override
	public void insert(Object obj) {
		
	}

	@Override
	public int delete(Class clz, int id) {
		TableInfo tableInfo=TableContext.poClassTableMap.get(clz);
		ColumnInfo onlyPriKeyColumnInfo=tableInfo.getOnlyPriKey();
		String sqlString="delete from"+tableInfo.getTname()+"where"+onlyPriKeyColumnInfo.getName()+"=?";
		executeDML(sqlString, new Object[](id));
		return 0;
	}

	@Override
	public void delete(Object obj) {
	}

	@Override
	public int updatee(Object obj, String[] fieldNames) {
		return 0;
	}

	@Override
	public List queryRows(String sql, Class clz, Object[] params) {
		return null;
	}

	@Override
	public List queryUniquRow(String sql, Class clz, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Number queryValue(String sql, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

}
