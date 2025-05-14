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
import com.cl.entity.KaogongziliaoEntity;
import com.cl.service.KaoyanziliaoService;
import com.cl.entity.view.KaogongziliaoView;

@Service("kaoyanziliaoService")
public class KaoyanziliaoServiceImpl extends ServiceImpl<KaoyanziliaoDao, KaogongziliaoEntity> implements KaoyanziliaoService {



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KaogongziliaoEntity> page = baseMapper.selectPage(new Query<KaogongziliaoEntity>(params).getPage(),new QueryWrapper<KaogongziliaoEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<KaogongziliaoEntity> wrapper) {
        Page<KaogongziliaoEntity> page = baseMapper.selectPage(new Query<KaogongziliaoEntity>(params).getPage(),wrapper);
        Page<KaogongziliaoView> pageVo = (Page<KaogongziliaoView>)page.convert(KaogongziliaoView::new);
	    return new PageUtils(pageVo);
 	}
    
	@Override
	public List<KaogongziliaoView> selectListView(QueryWrapper<KaogongziliaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KaogongziliaoView selectView(QueryWrapper<KaogongziliaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, QueryWrapper<KaogongziliaoEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, QueryWrapper<KaogongziliaoEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, QueryWrapper<KaogongziliaoEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
