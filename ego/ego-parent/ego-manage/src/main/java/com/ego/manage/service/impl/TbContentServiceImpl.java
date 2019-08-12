package com.ego.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.dubbo.service.TbContentDubboService;
import com.ego.manage.service.TbContentService;
import com.ego.pojo.TbContent;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author 辉
 * 座右铭:坚持总能遇见更好的自己!
 * @date 2019/8/9
 */
@Service
public class TbContentServiceImpl implements TbContentService {
    @Reference
    private TbContentDubboService tbContentDubboServiceImpl;
    @Override
    public EasyUIDataGrid selContentByCategoryId(long categoryId, int page, int rows) {
        return tbContentDubboServiceImpl.selContentByPage(categoryId,page,rows);
    }

    /**
     * 内容管理添加
     * @param content
     * @return
     */
    @Override
    public int save(TbContent content) {
        Date date = new Date();
        content.setCreated(date);
        content.setUpdated(date);
        return tbContentDubboServiceImpl.insContent(content);
    }

    /**
     * 内容管理更新
     * @param content
     * @return
     */
    @Override
    public int update(TbContent content) {
        Date date = new Date();
        content.setUpdated(date);
        content.setCreated(date);
        return tbContentDubboServiceImpl.updContent(content);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     * @throws Exception
     */
    @Override
    public int deletes(String ids) throws Exception {
        return tbContentDubboServiceImpl.delContent(ids);
    }
}
