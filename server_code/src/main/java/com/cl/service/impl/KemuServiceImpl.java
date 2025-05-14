package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.KemuDao;
import com.cl.entity.KemuEntity;
import com.cl.service.KemuService;
import com.cl.entity.view.KemuView;

@Service("kemuService")
public class KemuServiceImpl extends ServiceImpl<KemuDao, KemuEntity> implements KemuService {



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KemuEntity> page = baseMapper.selectPage(new Query<KemuEntity>(params).getPage(),new QueryWrapper<KemuEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<KemuEntity> wrapper) {
        Page<KemuEntity> page = baseMapper.selectPage(new Query<KemuEntity>(params).getPage(),wrapper);
        Page<KemuView> pageVo = (Page<KemuView>)page.convert(KemuView::new);
	    return new PageUtils(pageVo);
 	}

    @Override
    public List<String> getZhiWei() {
        return baseMapper.getZhiWei();
    }

    @Override
	public List<KemuView> selectListView(QueryWrapper<KemuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KemuView selectView(QueryWrapper<KemuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
