package com.ego.dubbo.service.impl;

import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.dubbo.service.TbItemParamDubboService;
import com.ego.mapper.TbItemParamMapper;
import com.ego.pojo.TbItemParam;
import com.ego.pojo.TbItemParamExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author 辉
 * 座右铭:坚持总能遇见更好的自己!
 * @date 2019/8/3
 */
public class TbItemParamDubboServiceImpl implements TbItemParamDubboService {
    @Autowired
    private TbItemParamMapper tbItemParamMapper;

    /**
     *
     * @param page 页码
     * @param rows 总页数
     * @return
     */
    @Override
    public EasyUIDataGrid showPage(int page, int rows) {
        //设置分页条件
        PageHelper.startPage(page,rows);
        //创建分页的条件
        TbItemParamExample tbItemParamExample = new TbItemParamExample();
        //按照分页条件查询
        List<TbItemParam> list = tbItemParamMapper.selectByExampleWithBLOBs(tbItemParamExample);
        //将分页后的数据封装在pageinfo中
        PageInfo<TbItemParam> pi = new PageInfo<>(list);

        EasyUIDataGrid grid = new EasyUIDataGrid();
        grid.setRows(pi.getList());
        grid.setTotal(pi.getTotal());
        return grid;
    }

    /**
     *
     * @param ids 批量删除的id
     * @return
     * @throws Exception
     */
    @Override
    public int delByIds(String ids) throws Exception {
        int index = 0;
        String[] idStr = ids.split(",");
        for (String id:idStr) {
            //tbItemParamMapper.deleteByPrimaryKey(Long.parseLong(id));
            //删除成功返回1,删除失败返回0.
            index +=tbItemParamMapper.deleteByPrimaryKey(Long.parseLong(id));
        }if (index==idStr.length){
            System.out.println(index);
            return 1;
        }else {
            throw new Exception("删除失败.可能原因:数据已经不存在!");
        }

    }

    /**
     *
     * @param catId
     * @return
     */
    @Override
    public TbItemParam selByCatid(long catId) {
        TbItemParamExample example = new TbItemParamExample();

        example.createCriteria().andItemCatIdEqualTo(catId);
        List<TbItemParam> list = tbItemParamMapper.selectByExampleWithBLOBs(example);

        if(list!=null&&list.size()>0){
        //要求每个类目只能有一个模板
         return list.get(0);
        }
        return null;
    }

    /**
     *
     * @param param 新增参数实体类对象,对应数据库中TbTtemParam表
     * @return
     */
    @Override
    public int insParam(TbItemParam param) {

        return tbItemParamMapper.insertSelective(param);
    }

}
