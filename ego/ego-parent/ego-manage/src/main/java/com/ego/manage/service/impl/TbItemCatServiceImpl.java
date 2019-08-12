package com.ego.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ego.commons.pojo.EasyUiTree;
import com.ego.dubbo.service.TbItemCatDubboService;
import com.ego.manage.service.TbItemCatService;
import com.ego.pojo.TbItemCat;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * @author 辉
 * 座右铭:坚持总能遇见更好的自己!
 * @date 2019/7/13
 */
@Service
public class TbItemCatServiceImpl implements TbItemCatService {

    @Reference
    private TbItemCatDubboService tbItemCatDubboServiceImpl;
    @Override
    public List<EasyUiTree> show(long pid) {

        //获取所有子菜单
        List<TbItemCat> list = tbItemCatDubboServiceImpl.show(pid);
        //封装子父节点的状态
        ArrayList<EasyUiTree> listTree = new ArrayList<>();

        for (TbItemCat cat: list) {
            EasyUiTree tree = new EasyUiTree();
            tree.setId(cat.getId());
            tree.setText(cat.getName());
            tree.setState(cat.getIsParent() ? "closed" : "open");
            listTree.add(tree);
        }
        return listTree;
    }
}
