package com.ego.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.commons.pojo.EgoResult;
import com.ego.dubbo.service.TbItemCatDubboService;
import com.ego.dubbo.service.TbItemParamDubboService;
import com.ego.manage.pojo.TbItemParamChild;
import com.ego.manage.service.TbItemParamService;
import com.ego.pojo.TbItemParam;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 辉
 * 座右铭:坚持总能遇见更好的自己!
 * @date 2019/8/3
 */
@Service
public class TbItemParamServiceImpl implements TbItemParamService {

    @Reference
    private TbItemParamDubboService tbItemParamDubboServiceimpl;
    @Reference
    private TbItemCatDubboService tbItemCatDubboServiceImpl;

    /**
     * @param page 页数
     * @param rows 总页码
     * @return
     */
    @Override
    public EasyUIDataGrid showPage(int page, int rows) {
        //将查询到的数据封装在EasyUIDataGrid中
        EasyUIDataGrid datagrid = tbItemParamDubboServiceimpl.showPage(page, rows);
        //将查到的数据放在集合中
        List<TbItemParam> list = (List<TbItemParam>) datagrid.getRows();
        //该集合是用于存储类目的名称,将所有的数据返回给商品规格参数
        List<TbItemParamChild> listChild = new ArrayList<>();
        //遍历数据库中的数据
        for (TbItemParam param : list) {
            TbItemParamChild child = new TbItemParamChild();
            //将两个数据库中的数据合二为一
            child.setCreated(param.getCreated());
            child.setId(param.getId());
            child.setItemCatId(param.getItemCatId());
            child.setParamData(param.getParamData());
            child.setUpdated(param.getUpdated());
            //这个是TbItemCat表中的name的属性
            child.setItemCatName(tbItemCatDubboServiceImpl.selById(child.getItemCatId()).getName());

            listChild.add(child);
        }
        datagrid.setRows(listChild);
        return datagrid;
    }

    /**
     *
     * @param ids 批量删除的id
     * @return
     */
    @Override
    public int delByids(String ids) throws Exception {
        return tbItemParamDubboServiceimpl.delByIds(ids);
    }

    @Override
    public EgoResult showParam(long catId) {
        EgoResult result = new EgoResult();
        TbItemParam param = tbItemParamDubboServiceimpl.selByCatid(catId);
        if (param!=null){
            result.setStatus(200);
            result.setData(param);
        }
        return result;
    }

    /**
     * service层封装返回数据
     * @param param 新增模板信息参数实体类,对应TbItemParam中的字段
     * @return
     */

    public EgoResult save(TbItemParam param) {
        Date date = new Date();
        param.setCreated(date);
        param.setUpdated(date);
        /**
         * 封装数据,返回给浏览器
         * 1.先调用service中的方法
         * 2.将调用过来方法的返回的结果集封装在EgoResult中
         * 3.判断返回的数据是否真确
         *4.将真确封装好的数据返回给浏览器显示
         */

        //封装浏览器中需要的数据
        int index = tbItemParamDubboServiceimpl.insParam(param);
        EgoResult er = new EgoResult();
        if(index>0){
            er.setStatus(200);
        }
        return er;
    }

}
