package com.ego.manage.service;

import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.pojo.TbItem;

/**
 * @author 辉
 * 座右铭:坚持总能遇见更好的自己!
 * @date 2019/7/13
 */
public interface TbItemService {
	/**
	 * 显示商品
	 * @param page 页数
	 * @param rows 每页数据的大小
	 * @return
	 */
	EasyUIDataGrid show(int page, int rows);
	/**
	 * 批量修改商品状态
	 * @param ids 批量传递过来需要修改商品的id
	 * @param status 商品状态
	 * @return
	 */
	int update(String ids, byte status);

	/**
	 *商品新增 两表新增
	 * @param item 新增商品的属性
	 * @param desc 新增商品的描述
	 * @return
	 */
	int save(TbItem item,String desc,String itemParams) throws Exception;
}
