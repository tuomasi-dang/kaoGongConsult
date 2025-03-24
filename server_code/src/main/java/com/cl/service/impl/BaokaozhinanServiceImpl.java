package com.cl.service.impl;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.BaokaozhinanDao;
import com.cl.entity.BaokaozhinanEntity;
import com.cl.service.BaokaozhinanService;
import com.cl.entity.view.BaokaozhinanView;

@Service("baokaozhinanService")
public class BaokaozhinanServiceImpl extends ServiceImpl<BaokaozhinanDao, BaokaozhinanEntity> implements BaokaozhinanService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BaokaozhinanEntity> page = baseMapper.selectPage(new Query<BaokaozhinanEntity>(params).getPage(), new QueryWrapper<BaokaozhinanEntity>());
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, QueryWrapper<BaokaozhinanEntity> wrapper) {
        Page<BaokaozhinanEntity> page = baseMapper.selectPage(new Query<BaokaozhinanEntity>(params).getPage(), wrapper);
        Page<BaokaozhinanView> pageVo = (Page<BaokaozhinanView>) page.convert(BaokaozhinanView::new);
        return new PageUtils(pageVo);
    }

    @Override
    public List<BaokaozhinanView> selectListView(QueryWrapper<BaokaozhinanEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public BaokaozhinanView selectView(QueryWrapper<BaokaozhinanEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }


}
