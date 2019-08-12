package com.ego.dubbo.service.impl;

import com.ego.dubbo.service.TbItemDescDubboService;
import com.ego.mapper.TbItemDescMapper;
import com.ego.pojo.TbItemDesc;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 辉
 * 座右铭:坚持总能遇见更好的自己!
 * @date 2019/7/31
 */
public class TbItemDescDubboServiceImpl implements TbItemDescDubboService {
    @Autowired
    private TbItemDescMapper tbItemDescMapper;

    /**
     *
     * @param itemDesc 商品描述信息
     * @return
     */
    @Override
    public int insDesc(TbItemDesc itemDesc) {
        return tbItemDescMapper.insert(itemDesc);
    }
}
