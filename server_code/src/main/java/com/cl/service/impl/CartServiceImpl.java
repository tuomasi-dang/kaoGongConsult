package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.CartDao;
import com.cl.entity.CartEntity;
import com.cl.service.CartService;
import com.cl.entity.view.CartView;

@Service("cartService")
public class CartServiceImpl extends ServiceImpl<CartDao, CartEntity> implements CartService {



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CartEntity> page = baseMapper.selectPage(new Query<CartEntity>(params).getPage(),new QueryWrapper<CartEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<CartEntity> wrapper) {
        Page<CartEntity> page = baseMapper.selectPage(new Query<CartEntity>(params).getPage(),wrapper);
        Page<CartView> pageVo = (Page<CartView>)page.convert(CartView::new);
	    return new PageUtils(pageVo);
 	}
    
	@Override
	public List<CartView> selectListView(QueryWrapper<CartEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CartView selectView(QueryWrapper<CartEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
