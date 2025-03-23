package com.cl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.OrdersEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.OrdersView;


/**
 * 商品订单
 *
 * @author 
 * @email 
 * @date 2024-12-31 14:57:50
 */
public interface OrdersService extends IService<OrdersEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<OrdersView> selectListView(QueryWrapper<OrdersEntity> wrapper);
   	
   	OrdersView selectView(@Param("ew") QueryWrapper<OrdersEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<OrdersEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,QueryWrapper<OrdersEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,QueryWrapper<OrdersEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,QueryWrapper<OrdersEntity> wrapper);



}

