package com.cl.dao;

import com.cl.entity.BaokaozhinanEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.BaokaozhinanView;


/**
 * 报考指南
 * 
 * @author 
 * @email 
 * @date 2024-12-31 14:57:50
 */
public interface BaokaozhinanDao extends BaseMapper<BaokaozhinanEntity> {
	
	List<BaokaozhinanView> selectListView(@Param("ew") QueryWrapper<BaokaozhinanEntity> wrapper);

	List<BaokaozhinanView> selectListView(@Param("page")Page page,@Param("ew") QueryWrapper<BaokaozhinanEntity> wrapper);
	
	BaokaozhinanView selectView(@Param("ew") QueryWrapper<BaokaozhinanEntity> wrapper);


}
