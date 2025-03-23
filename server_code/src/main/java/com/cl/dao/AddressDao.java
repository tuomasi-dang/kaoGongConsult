package com.cl.dao;

import com.cl.entity.AddressEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.AddressView;


/**
 * 地址
 * 
 * @author 
 * @email 
 * @date 2024-12-31 14:57:50
 */
public interface AddressDao extends BaseMapper<AddressEntity> {
	
	List<AddressView> selectListView(@Param("ew") QueryWrapper<AddressEntity> wrapper);

	List<AddressView> selectListView(@Param("page")Page page,@Param("ew") QueryWrapper<AddressEntity> wrapper);
	
	AddressView selectView(@Param("ew") QueryWrapper<AddressEntity> wrapper);


}
