package com.ego.commons.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 辉
 * 座右铭:坚持总能遇见更好的自己!
 * @date 2019/7/13
 */
public class EgoResult {
	//用于显示网页的状态
	private int status;
	//用于封装网页的数据
    private Object data;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	//字符串切割方法
	public static void main(String[] args) {
		String str = "11,12,13,14";
		ArrayList<Integer> integers = new ArrayList<>();
		if (str.contains(",")){
			String[] split = str.split(",");
			for (String s :split) {
				int i = Integer.parseInt(s);
				integers.add(i);
			}
			for (int i: integers) {
				System.out.println(i);
			}
			System.out.println(split.length);
		}

	}
	
}
