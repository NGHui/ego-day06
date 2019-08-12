package com.ego.manage.service;

import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.commons.pojo.EasyUiTree;
import com.ego.commons.pojo.EgoResult;
import com.ego.pojo.TbContentCategory;

import java.util.List;

/**
 * @author 辉
 * 座右铭:坚持总能遇见更好的自己!
 * @date 2019/8/8
 */
public interface TbContentCategoryService {
    /**
     * 查询所有类目的id,并且转换为easyUIdataTree的具体格式
     * @param id 查询类目的id
     * @return
     */
    List<EasyUiTree> showCategory(long id);

    /**
     *类目新增
     * @param cate 类目新增列表实体类
     * @return
     */
    EgoResult create(TbContentCategory cate);

    /**
     * 类目删除
     * @param cate
     * @return
     */
    EgoResult delete(TbContentCategory cate);
}
