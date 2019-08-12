package com.ego.dubbo.service;

import com.ego.pojo.TbContentCategory;

import java.util.List;

/**
 * @author 辉
 * 座右铭:坚持总能遇见更好的自己!
 * @date 2019/8/7
 */
public interface TbContentCategoryDubboService {

    /**
     * 根据父 id 查询所有子类目
     * @param id
     * @return
     */
    public List<TbContentCategory > selByPid(long id);

    /**
     *后台管理系统商品内容新增功能
     * @param cate 商品新增实体类
     * @return
     */
    int insTbContentCategory(TbContentCategory cate);
    /**
     * 修改 isparent 通过 id
     * @param cate TbContentCategory 实体类
     *  @return
     */
    int updIsParentById(TbContentCategory cate);

    /**
     * 通过id查询内容类目详细信息
     */
    TbContentCategory selById(long id);


}
