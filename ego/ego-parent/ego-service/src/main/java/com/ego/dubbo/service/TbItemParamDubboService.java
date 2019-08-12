package com.ego.dubbo.service;

import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.pojo.TbItemCat;
import com.ego.pojo.TbItemParam;

/**
 * @author 辉
 * 座右铭:坚持总能遇见更好的自己!
 * @date 2019/8/3
 */
public interface TbItemParamDubboService {

    /**
     * 商品规格参数分页
     * @param page 页码
     * @param rows 总页数
     * @return
     */
    EasyUIDataGrid showPage(int page ,int rows);

    /**
     * 商品规格参数批量删除
     * @param ids 批量删除的id
     * @return
     */
    int delByIds(String ids) throws Exception;

    /**
     *  根据类目 id 查询参数模板
     * @param catId
     * @return
     */
    TbItemParam selByCatid(long catId);

    /**
     * 新增支持主键自增
     * @param param 新增参数实体类对象,对应数据库中TbTtemParam表
     * @return
     */
    int insParam(TbItemParam param);


}
