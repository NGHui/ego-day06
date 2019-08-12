package com.ego.manage.controller;

import com.ego.commons.pojo.EasyUiTree;
import com.ego.commons.pojo.EgoResult;
import com.ego.manage.service.TbContentCategoryService;
import com.ego.pojo.TbContentCategory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 辉
 * 座右铭:坚持总能遇见更好的自己!
 * @date 2019/8/8
 */
@Controller
public class TbContentCategoryController {
    @Resource
    private TbContentCategoryService tbContentCategoryServiceImpl;

    @RequestMapping("content/category/list")
    @ResponseBody
    //@RequestParam默认参数
    public List<EasyUiTree> showCategory(@RequestParam(defaultValue = "0")long id){

        return tbContentCategoryServiceImpl.showCategory(id);
    }

    /**
     * 新增内容类目
     * @param cate
     * @return
      */
    @RequestMapping("content/category/create")
    @ResponseBody
    public EgoResult create(TbContentCategory cate){
        return tbContentCategoryServiceImpl.create(cate);
    }

    /**
     * 删除
     * @param cate
     * @return
     */
    @RequestMapping("content/category/delete")
    @ResponseBody
    public EgoResult delete(TbContentCategory cate){
        return tbContentCategoryServiceImpl.delete(cate);
    }
}
