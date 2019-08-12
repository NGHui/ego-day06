package com.ego.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.commons.pojo.EasyUiTree;
import com.ego.commons.pojo.EgoResult;
import com.ego.commons.utils.IDUtils;
import com.ego.dubbo.service.TbContentCategoryDubboService;
import com.ego.manage.service.TbContentCategoryService;
import com.ego.pojo.TbContentCategory;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author 辉
 * 座右铭:坚持总能遇见更好的自己!
 * @date 2019/8/8
 *
 */
@Service
public class TbContentCategoryServiceImpl implements TbContentCategoryService {
    @Reference
    private TbContentCategoryDubboService tbContentCategoryDubboServiceImpl;

    /**
     *
     * @param id 查询类目的id
     * @return
     */
    @Override
    public List<EasyUiTree> showCategory(long id) {
        List<EasyUiTree> trees = new ArrayList<>();
        //将数据封装成List<EasyUiTree>类型,并且返回给浏览器
        List<TbContentCategory> list = tbContentCategoryDubboServiceImpl.selByPid(id);
        for (TbContentCategory cate: list) {
            EasyUiTree tree = new EasyUiTree();
            tree.setId(cate.getId());
            tree.setText(cate.getName());
            tree.setState(cate.getIsParent()?"closed":"open");
            trees.add(tree);
        }
        return trees;
    }

    /**
     *
     * @param cate 类目新增列表实体类
     * @return
     */
    @Override
    public EgoResult create(TbContentCategory cate) {
        EgoResult er = new EgoResult();
        //判断当前节点名称是否已经存在
        List<TbContentCategory> children  = tbContentCategoryDubboServiceImpl.selByPid(cate.getParentId());
        //判断分类名称是否重复
        for (TbContentCategory child : children) {
            if(child.getName().equals(cate.getName())) {
            er.setData("该分类名已存在");
            return er;
        }
        }
        //设置新增时需要的数据
        Date date = new Date();
        cate.setCreated(date);
        cate.setUpdated(date);
        cate.setStatus(1);
        cate.setSortOrder(1);
        cate.setIsParent(false);
        //设置id
        long id = IDUtils.genItemId();
        cate.setId(id);

        int index = tbContentCategoryDubboServiceImpl.insTbContentCategory(cate);
        if(index>0){
            TbContentCategory parent = new TbContentCategory();

            parent.setId(cate.getParentId());
            parent.setIsParent(true);

            tbContentCategoryDubboServiceImpl.updIsParentById(parent);
        }

        er.setStatus(200);
        Map<String,Long> map = new HashMap<>();
        map.put("id", id); er.setData(map);
        return er;
    }

    /**
     * 删除逻辑,两个修改,两个查询
     * @param cate
     * @return
     */
    @Override
    public EgoResult delete(TbContentCategory cate) {

        EgoResult er = new EgoResult();
        Date date = new Date();

        //先设置状态,0表示先设置为删除的状态
        cate.setStatus(0);
        //先查询该删除的类目是否有父菜单
        int index = tbContentCategoryDubboServiceImpl.updIsParentById(cate);
        if(index>0){
            //获取到删除类目的所有的信息
            TbContentCategory curr = tbContentCategoryDubboServiceImpl.selById(cate.getId());
            //通过获取到删除的信息,在获取到被删除的父类所有的信息
            List<TbContentCategory> list = tbContentCategoryDubboServiceImpl.selByPid(curr.getParentId());

            if(list==null||list.size()==0){
                TbContentCategory parent = new TbContentCategory();
                parent.setId(curr.getParentId());
                parent.setIsParent(false);
                //修改父类id的状态,改为一级类目
                int result = tbContentCategoryDubboServiceImpl.updIsParentById(parent);
                if(result>0){
                    er.setStatus(200);
                }
            }else{
                er.setStatus(200);
            }
        }
        return er;
    }



}
