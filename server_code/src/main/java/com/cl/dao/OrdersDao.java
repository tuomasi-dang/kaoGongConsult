package com.cl.dao;

import com.cl.entity.OrdersEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.OrdersView;


/**
 * 商品订单
 * 
 * @author 
 * @email 
 * @date 2024-12-31 14:57:50
 */
public interface OrdersDao extends BaseMapper<OrdersEntity> {
	
	List<OrdersView> selectListView(@Param("ew") QueryWrapper<OrdersEntity> wrapper);

	List<OrdersView> selectListView(@Param("page")Page page,@Param("ew") QueryWrapper<OrdersEntity> wrapper);
	
	OrdersView selectView(@Param("ew") QueryWrapper<OrdersEntity> wrapper);


    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") QueryWrapper<OrdersEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") QueryWrapper<OrdersEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") QueryWrapper<OrdersEntity> wrapper);



}
