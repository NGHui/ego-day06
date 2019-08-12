package com.ego.dubbo.service.impl;

import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.dubbo.service.TbContentDubboService;
import com.ego.mapper.TbContentMapper;
import com.ego.pojo.TbContent;
import com.ego.pojo.TbContentExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 辉
 * 座右铭:坚持总能遇见更好的自己!
 * @date 2019/8/9
 */
public class TbContentDubboServiceImpl implements TbContentDubboService {
    @Resource
    private TbContentMapper tbContentMapper;
    @Override
    public EasyUIDataGrid selContentByPage(long categoryId, int page, int rows) {

        //使用分页的条件
        PageHelper.startPage(page,rows);
        TbContentExample example = new TbContentExample();

        if (categoryId!=0){
            example.createCriteria().andCategoryIdEqualTo(categoryId);
        }
        //设置分页条件
        List<TbContent> list = tbContentMapper.selectByExampleWithBLOBs(example);
        //将分页的条件封装为对象
        PageInfo<TbContent> pi = new PageInfo<>(list);

        //将对象转为EasyUIDataGrid,返回给JSP页面 JSON格式
        EasyUIDataGrid dataGrid = new EasyUIDataGrid();

        dataGrid.setRows(pi.getList());
        dataGrid.setTotal(pi.getTotal());

        return dataGrid;
    }

    /**
     *
     * @param content 内容管理的参数
     * @return
     */
    @Override
    public int insContent(TbContent content) {
        return tbContentMapper.insertSelective(content);
    }

    /**
     *
     * @param content
     * @return
     */
    @Override
    public int updContent(TbContent content) {
        return tbContentMapper.updateByPrimaryKeySelective(content);
    }

    /**
     *内容管理删除
     * @param ids
     * @return
     */
    @Override
    public int delContent(String ids) throws Exception {
        int index = 0;
        String[] split = ids.split(",");
        for (String id:split) {
            //删除成功就会返回1,失败就返回0
             index += tbContentMapper.deleteByPrimaryKey(Long.parseLong(id));
             //返回值为1就表示删除成功,返回值为0就表示删除失败
        }if (index==split.length){
            return 1;
        }else {
            throw new Exception("删除失败.可能原因:数据已经不存在!");
        }
    }
}
