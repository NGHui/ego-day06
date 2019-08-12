package com.ego.dubbo.service;

import com.ego.pojo.TbItemDesc;

/**
 * @author 辉
 * 座右铭:坚持总能遇见更好的自己!
 * @date 2019/7/31
 */
public interface TbItemDescDubboService {
    /**
     * 新增商品描述信息
     * @param itemDesc 商品描述信息
     * @return
     */
    int insDesc(TbItemDesc itemDesc);
}
