package com.cl.dao;

import com.cl.entity.CartEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.CartView;


/**
 * 购物中心
 * 
 * @author 
 * @email 
 * @date 2024-12-31 14:57:50
 */
public interface CartDao extends BaseMapper<CartEntity> {
	
	List<CartView> selectListView(@Param("ew") QueryWrapper<CartEntity> wrapper);

	List<CartView> selectListView(@Param("page")Page page,@Param("ew") QueryWrapper<CartEntity> wrapper);
	
	CartView selectView(@Param("ew") QueryWrapper<CartEntity> wrapper);


}
