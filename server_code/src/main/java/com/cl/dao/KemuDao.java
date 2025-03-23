package com.cl.dao;

import com.cl.entity.KemuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.KemuView;


/**
 * 科目
 * 
 * @author 
 * @email 
 * @date 2024-12-31 14:57:50
 */
public interface KemuDao extends BaseMapper<KemuEntity> {
	
	List<KemuView> selectListView(@Param("ew") QueryWrapper<KemuEntity> wrapper);

	List<KemuView> selectListView(@Param("page")Page page,@Param("ew") QueryWrapper<KemuEntity> wrapper);
	
	KemuView selectView(@Param("ew") QueryWrapper<KemuEntity> wrapper);


}
