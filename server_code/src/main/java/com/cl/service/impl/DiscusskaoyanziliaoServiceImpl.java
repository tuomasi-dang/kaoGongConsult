package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.DiscusskaoyanziliaoDao;
import com.cl.entity.DiscusskaoyanziliaoEntity;
import com.cl.service.DiscusskaoyanziliaoService;
import com.cl.entity.view.DiscusskaoyanziliaoView;

@Service("discusskaoyanziliaoService")
public class DiscusskaoyanziliaoServiceImpl extends ServiceImpl<DiscusskaoyanziliaoDao, DiscusskaoyanziliaoEntity> implements DiscusskaoyanziliaoService {



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusskaoyanziliaoEntity> page = baseMapper.selectPage(new Query<DiscusskaoyanziliaoEntity>(params).getPage(),new QueryWrapper<DiscusskaoyanziliaoEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<DiscusskaoyanziliaoEntity> wrapper) {
        Page<DiscusskaoyanziliaoEntity> page = baseMapper.selectPage(new Query<DiscusskaoyanziliaoEntity>(params).getPage(),wrapper);
        Page<DiscusskaoyanziliaoView> pageVo = (Page<DiscusskaoyanziliaoView>)page.convert(DiscusskaoyanziliaoView::new);
	    return new PageUtils(pageVo);
 	}
    
	@Override
	public List<DiscusskaoyanziliaoView> selectListView(QueryWrapper<DiscusskaoyanziliaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusskaoyanziliaoView selectView(QueryWrapper<DiscusskaoyanziliaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
