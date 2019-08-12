package com.ego.manage.controller;

import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.commons.pojo.EgoResult;
import com.ego.manage.service.TbContentService;
import com.ego.pojo.TbContent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author 辉
 * 座右铭:坚持总能遇见更好的自己!
 * @date 2019/8/9
 */
@Controller
public class TbContentController {
    @Resource
    private TbContentService tbContentServiceImpl;

    /**
     * 显示内容信息
     * @param categoryId
     * @param page
     * @param rows
     * @return
     */
     @RequestMapping("content/query/list")
     @ResponseBody
     public EasyUIDataGrid showContent(long categoryId,int page,int rows){
        return tbContentServiceImpl.selContentByCategoryId(categoryId, page, rows);
     }

    /**
     * 新增内容
     * @param content
     * @return
     */
      @RequestMapping("content/save")
      @ResponseBody
      public EgoResult save(TbContent content){
         EgoResult er = new EgoResult();
         int index = tbContentServiceImpl.save(content);
         if (index>0){
             er.setStatus(200);
         }
         return er;
      }

      @RequestMapping("rest/content/edit")
      @ResponseBody
      public EgoResult edit(TbContent content){
          EgoResult er = new EgoResult();
          int index = tbContentServiceImpl.update(content);
          if (index>0){
              er.setStatus(200);
          }
          return er;
      }

      @RequestMapping("content/delete")
      @ResponseBody
      public EgoResult deletes(String ids) throws Exception {
          EgoResult er = new EgoResult();
          //判断是否进行删除,返回值为1,删除成功,返回值0,删除失败
          int index = tbContentServiceImpl.deletes(ids);
          if (index==1){
              er.setStatus(200);
          }
          return er;
      }
}

