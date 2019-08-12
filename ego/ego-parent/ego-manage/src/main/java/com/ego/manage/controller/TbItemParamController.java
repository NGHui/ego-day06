package com.ego.manage.controller;

import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.commons.pojo.EgoResult;
import com.ego.manage.service.TbItemParamService;
import com.ego.pojo.TbItemParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author 辉
 * 座右铭:坚持总能遇见更好的自己!
 * @date 2019/8/3
 */
@Controller
public class TbItemParamController {
    @Resource
    private TbItemParamService tbItemParamServiceImpl;


    @RequestMapping("item/param/list")
    @ResponseBody
    public EasyUIDataGrid showPage(int page , int rows){
        return tbItemParamServiceImpl.showPage(page,rows);
    }
    @RequestMapping("item/param/delete")
    @ResponseBody
    public EgoResult delete(String ids){
        /**
         * 封装数据,返回给浏览器
         * 1.先调用service中的方法
         * 2.将调用过来方法的返回的结果集封装在EgoResult中
         * 3.判断返回的数据是否真确
         *4.将真确封装好的数据返回给浏览器显示
         */
        EgoResult result = new EgoResult();

        try {
            int index = tbItemParamServiceImpl.delByids(ids);

            if (index==1){
                result.setStatus(200);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setData(e.getMessage());

        }
        return result;
    }

    /**
     * *
     * 点击商品类目按钮显示添加分组按钮
     * 判断类目是否已经添加模板
     * Rest风格
     * @param catId rest风格传递的参数
     * @return
     */

    @RequestMapping("item/param/query/itemcatid/{catId}")
    @ResponseBody
    public EgoResult show(@PathVariable long catId){

        return tbItemParamServiceImpl.showParam(catId);

    }

    /**
     * 商品类目新增
     * @param param
     * @param catId
     * @return
     */
    @RequestMapping("item/param/save/{catId}")
    @ResponseBody
    public EgoResult save(TbItemParam param,@PathVariable long catId){
        param.setItemCatId(catId);
        return tbItemParamServiceImpl.save(param);
    }

}
