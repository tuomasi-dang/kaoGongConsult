package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.KaoyanziliaoDao;
import com.cl.entity.KaoyanziliaoEntity;
import com.cl.service.KaoyanziliaoService;
import com.cl.entity.view.KaoyanziliaoView;

@Service("kaoyanziliaoService")
public class KaoyanziliaoServiceImpl extends ServiceImpl<KaoyanziliaoDao, KaoyanziliaoEntity> implements KaoyanziliaoService {



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KaoyanziliaoEntity> page = baseMapper.selectPage(new Query<KaoyanziliaoEntity>(params).getPage(),new QueryWrapper<KaoyanziliaoEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<KaoyanziliaoEntity> wrapper) {
        Page<KaoyanziliaoEntity> page = baseMapper.selectPage(new Query<KaoyanziliaoEntity>(params).getPage(),wrapper);
        Page<KaoyanziliaoView> pageVo = (Page<KaoyanziliaoView>)page.convert(KaoyanziliaoView::new);
	    return new PageUtils(pageVo);
 	}
    
	@Override
	public List<KaoyanziliaoView> selectListView(QueryWrapper<KaoyanziliaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KaoyanziliaoView selectView(QueryWrapper<KaoyanziliaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, QueryWrapper<KaoyanziliaoEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, QueryWrapper<KaoyanziliaoEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, QueryWrapper<KaoyanziliaoEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
