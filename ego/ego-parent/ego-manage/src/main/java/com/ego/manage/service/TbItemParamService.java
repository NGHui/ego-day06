package com.ego.manage.service;

import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.commons.pojo.EgoResult;
import com.ego.pojo.TbItemParam;

/**
 * @author 辉
 * 座右铭:坚持总能遇见更好的自己!
 * @date 2019/8/3
 */
public interface TbItemParamService {

    /**
     *商品规格参数表分页
     * @param page 页数
     * @param rows 总页码
     * @return
     */
    EasyUIDataGrid showPage(int page,int rows);

    /**
     *
     * @param ids 批量删除的id
     * @return
     */
    int delByids(String ids) throws Exception;

    /**
     * 根据类目id模板信息
     * @param catId 商品类目ID
     * @return
     */
    EgoResult showParam(long catId);

    /**
     * 新增模板信息
     * @param param 新增模板信息参数实体类,对应TbItemParam中的字段
     * @return
     */
    EgoResult save(TbItemParam param);

}
