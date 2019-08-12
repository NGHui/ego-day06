package com.ego.manage.service;

import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.pojo.TbContent;

/**
 * @author 辉
 * 座右铭:坚持总能遇见更好的自己!
 * @date 2019/8/9
 */
public interface TbContentService {

    /**
     * 内容管理分页查询
     * @param categoryId 商品类目种类的id
     * @param page 页码
     * @param rows 总页数
     * @return
     */
    EasyUIDataGrid selContentByCategoryId(long categoryId,int page,int rows);

    /**
     * 内容管理新增
     * @param content
     * @return
     */
    int save(TbContent content);

    /**
     * 内容管理更新
     * @param content
     * @return
     */
    int update(TbContent content);

    /**
     *内容管理删除
     * @param ids
     * @return
     */
    int deletes( String ids) throws Exception;

}
