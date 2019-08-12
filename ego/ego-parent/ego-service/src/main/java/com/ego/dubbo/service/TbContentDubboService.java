package com.ego.dubbo.service;

import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.commons.pojo.EgoResult;
import com.ego.pojo.TbContent;

/**
 * @author 辉
 * 座右铭:坚持总能遇见更好的自己!
 * @date 2019/8/9
 */
public interface TbContentDubboService {

    /**
     * 内容管理分页查询
     * @param categoryId 商品类目种类的id
     * @param page 页码
     * @param rows 总页数
     * @return
     */
    EasyUIDataGrid selContentByPage(long categoryId ,int page,int rows);

    /**
     * 内容管理新增
     * @param content 内容管理的参数
     * @return
     */
    int insContent(TbContent content);

    /**
     * 内容管理更新
     * @param content
     * @return
     */
    int updContent(TbContent content);

    /**
     * 内容管理删除
     *
     * @param ids
     * @return
     */
    int delContent(String ids) throws Exception;


}
