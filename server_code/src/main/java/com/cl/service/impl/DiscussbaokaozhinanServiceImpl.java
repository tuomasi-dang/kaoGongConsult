package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.DiscussbaokaozhinanDao;
import com.cl.entity.DiscussbaokaozhinanEntity;
import com.cl.service.DiscussbaokaozhinanService;
import com.cl.entity.view.DiscussbaokaozhinanView;

@Service("discussbaokaozhinanService")
public class DiscussbaokaozhinanServiceImpl extends ServiceImpl<DiscussbaokaozhinanDao, DiscussbaokaozhinanEntity> implements DiscussbaokaozhinanService {



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussbaokaozhinanEntity> page = baseMapper.selectPage(new Query<DiscussbaokaozhinanEntity>(params).getPage(),new QueryWrapper<DiscussbaokaozhinanEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<DiscussbaokaozhinanEntity> wrapper) {
        Page<DiscussbaokaozhinanEntity> page = baseMapper.selectPage(new Query<DiscussbaokaozhinanEntity>(params).getPage(),wrapper);
        Page<DiscussbaokaozhinanView> pageVo = (Page<DiscussbaokaozhinanView>)page.convert(DiscussbaokaozhinanView::new);
	    return new PageUtils(pageVo);
 	}
    
	@Override
	public List<DiscussbaokaozhinanView> selectListView(QueryWrapper<DiscussbaokaozhinanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussbaokaozhinanView selectView(QueryWrapper<DiscussbaokaozhinanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
