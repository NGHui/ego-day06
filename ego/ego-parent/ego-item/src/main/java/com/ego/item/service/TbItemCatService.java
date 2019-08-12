package com.ego.item.service;

import com.ego.item.pojo.PortalMenu;

/**
 * @author 辉
 * 座右铭:坚持总能遇见更好的自己!
 * @date 2019/8/5
 */
public interface TbItemCatService {
	/**
	 * 查询出所有分类类目并转换为特定类型.
	 * @return
	 */
	PortalMenu showCatMenu();
}
