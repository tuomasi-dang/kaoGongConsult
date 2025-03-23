package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.OrdersDao;
import com.cl.entity.OrdersEntity;
import com.cl.service.OrdersService;
import com.cl.entity.view.OrdersView;

@Service("ordersService")
public class OrdersServiceImpl extends ServiceImpl<OrdersDao, OrdersEntity> implements OrdersService {



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<OrdersEntity> page = baseMapper.selectPage(new Query<OrdersEntity>(params).getPage(),new QueryWrapper<OrdersEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<OrdersEntity> wrapper) {
        Page<OrdersEntity> page = baseMapper.selectPage(new Query<OrdersEntity>(params).getPage(),wrapper);
        Page<OrdersView> pageVo = (Page<OrdersView>)page.convert(OrdersView::new);
	    return new PageUtils(pageVo);
 	}
    
	@Override
	public List<OrdersView> selectListView(QueryWrapper<OrdersEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public OrdersView selectView(QueryWrapper<OrdersEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, QueryWrapper<OrdersEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, QueryWrapper<OrdersEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, QueryWrapper<OrdersEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
