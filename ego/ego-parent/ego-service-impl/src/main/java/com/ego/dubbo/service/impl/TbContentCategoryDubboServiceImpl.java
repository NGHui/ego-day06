package com.ego.dubbo.service.impl;

import com.ego.dubbo.service.TbContentCategoryDubboService;
import com.ego.mapper.TbContentCategoryMapper;
import com.ego.pojo.TbContentCategory;
import com.ego.pojo.TbContentCategoryExample;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 辉
 * 座右铭:坚持总能遇见更好的自己!
 * @date 2019/8/7
 */
public class TbContentCategoryDubboServiceImpl implements TbContentCategoryDubboService {
    @Resource
    private TbContentCategoryMapper tbContentCategoryMapper;

    /**
     *
     * @param id
     * @return
     */
    @Override
    public List<TbContentCategory> selByPid(long id) {
        TbContentCategoryExample example = new TbContentCategoryExample();
        //.andStatusEqualTo(1);表示默认状态是正常,1表示正常,0表示异常
        example.createCriteria().andParentIdEqualTo(id).andStatusEqualTo(1);

        return tbContentCategoryMapper.selectByExample(example);
    }

    /**
     *
     * @param cate 商品新增实体类
     * @return
     */
    @Override
    public int insTbContentCategory(TbContentCategory cate) {

        return tbContentCategoryMapper.insertSelective(cate);
    }

    /**
     *
     * @param cate TbContentCategory 实体类
     * @return
     */
    @Override
    public int updIsParentById(TbContentCategory cate) {

        return tbContentCategoryMapper.updateByPrimaryKeySelective(cate);
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public TbContentCategory selById(long id) {
        return tbContentCategoryMapper.selectByPrimaryKey(id);
    }
}
