package com.ego.manage.service.impl;

import com.ego.commons.utils.IDUtils;
import com.ego.dubbo.service.TbItemDescDubboService;
import com.ego.pojo.TbItemDesc;
import com.ego.pojo.TbItemParamItem;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.dubbo.service.TbItemDubboService;
import com.ego.manage.service.TbItemService;
import com.ego.pojo.TbItem;

import java.util.Date;

/**
 * @author 辉
 * 座右铭:坚持总能遇见更好的自己!
 * @date 2019/7/13
 */
@Service
public class TbItemServiceImpl implements TbItemService{
	@Reference//交给dubbo管理
	private TbItemDubboService tbItemDubboServiceImpl;
	@Reference
	private TbItemDescDubboService tbItemDescDubboServiceImpl;

	/**
	 *
	 * @param page 页数
	 * @param rows 每页数据的大小
	 * @return
	 */
	@Override
	public EasyUIDataGrid show(int page, int rows) {
		return tbItemDubboServiceImpl.show(page, rows);
	}

	/**
	 *
	 * @param ids 批量传递过来需要修改商品的id
	 * @param status 商品状态
	 * @return
	 */
	@Override
	public int update(String ids, byte status) {
		int index = 0 ;
		TbItem item = new TbItem();
		String[] idsStr = ids.split(",");
		for (String id : idsStr) {
			item.setId(Long.parseLong(id));
			item.setStatus(status);
			index +=tbItemDubboServiceImpl.updItemStatus(item);
		}
		if(index==idsStr.length){
			return 1;
		}
		return 0;
	}

	/**
	 * @param item 新增商品的属性
	 * @param desc 新增商品的描述
	 * @return
	 */
	@Override
	public int save(TbItem item, String desc,String itemParams) throws Exception {

		/*添加商品方法未回滚
		//给商品设置默认的id
		long id = IDUtils.genItemId();
		item.setId(id);
		Date date = new Date();
		//给商品设置默认的创建的时间
		item.setCreated(date);
		//给商品设置默认的更新的时间
		item.setUpdated(date);
		//给商品创建默认的状态,1表示正常
		item .setStatus((byte)1);
		int index = tbItemDubboServiceImpl.insTbItem(item);
		//添加商品的描述
		if (index>0){
			//4个字段 商品id,创建时间,更新时间,商品描述
            //3个默认的字段 商品id,创建时间,更新时间 ,与商品表需要保持一致.
			TbItemDesc tbItemDesc = new TbItemDesc();
			tbItemDesc.setItemDesc(desc);
			tbItemDesc.setCreated(date);
			tbItemDesc.setUpdated(date);
			tbItemDesc.setItemId(id);
			 index += tbItemDescDubboServiceImpl.insDesc(tbItemDesc);

		}
		if (index==2){
			return 1;
		}
		return 0;*/
		//给商品设置默认的id
		long id = IDUtils.genItemId();
		item.setId(id);
		Date date = new Date();
		//给商品设置默认的创建的时间
		item.setCreated(date);
		//给商品设置默认的更新的时间
		item.setUpdated(date);
		//给商品创建默认的状态,1表示正常
		item .setStatus((byte)1);

		//添加商品的描述
		//4个字段 商品id,创建时间,更新时间,商品描述
		//3个默认的字段 商品id,创建时间,更新时间 ,与商品表需要保持一致.
		TbItemDesc tbItemDesc = new TbItemDesc();
		tbItemDesc.setItemDesc(desc);
		tbItemDesc.setCreated(date);
		tbItemDesc.setUpdated(date);
		tbItemDesc.setItemId(id);

		TbItemParamItem paramItem = new TbItemParamItem();
		paramItem.setCreated(date);
		paramItem.setUpdated(date);
		paramItem.setItemId(id);
		paramItem.setParamData(itemParams);


		int index = 0;

		index = tbItemDubboServiceImpl.insTbItemAndDesc(item, tbItemDesc,paramItem);
		System.out.println("index:" + index);
		return index;
	}
}
