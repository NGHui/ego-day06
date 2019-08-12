package com.ego.commons.pojo;

import java.io.Serializable;
import java.util.List;
/**
 * @author 辉
 * 座右铭:坚持总能遇见更好的自己!
 * @date 2019/7/13
 */
public class EasyUIDataGrid implements Serializable {
	//当前页显示数据
	private List<?> rows;
	//总条数
	private long total;
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
}
