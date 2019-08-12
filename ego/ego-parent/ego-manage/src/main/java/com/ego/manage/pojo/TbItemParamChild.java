package com.ego.manage.pojo;

import com.ego.pojo.TbItemCat;
import com.ego.pojo.TbItemParam;

/**
 * @author 辉
 * 座右铭:坚持总能遇见更好的自己!
 * @date 2019/8/3
 * 该类存在的目的是将类目的名称存入商品中
 */
public class TbItemParamChild extends TbItemParam {
    private String itemCatName;

    public String getItemCatName() {
        return itemCatName;
    }

    public void setItemCatName(String itemCatName) {
        this.itemCatName = itemCatName;
    }
}
