package com.ego.dubbo.service;

import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.pojo.TbItem;
import com.ego.pojo.TbItemDesc;
import com.ego.pojo.TbItemParamItem;

public interface TbItemDubboService {
	/**
	 * 商品分页查询
	 * @param page 页数
	 * @param rows 每页数据的大小
	 * @return
	 */
	EasyUIDataGrid show(int page, int rows);

	/**
	 * 根据id修改状态
	 * @param tbItem 商品表
	 * @return
	 */
	int updItemStatus(TbItem tbItem);

	/**
	 * 商品新增未实现事务回滚
	 * @param tbItem  商品表的字段
	 * @return
	 */
	int insTbItem(TbItem tbItem);

	/**
	 * 新增商品实现事务回滚的方法
	 * @param tbItem 商品表的字段
	 * @param tbItemDesc 商品属性表的字段
	 * @return
	 */
	int insTbItemAndDesc(TbItem tbItem, TbItemDesc tbItemDesc, TbItemParamItem paramItem) throws Exception;
}
