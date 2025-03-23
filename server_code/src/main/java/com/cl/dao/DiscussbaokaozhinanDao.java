package com.cl.dao;

import com.cl.entity.DiscussbaokaozhinanEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussbaokaozhinanView;


/**
 * 报考指南评论表
 * 
 * @author 
 * @email 
 * @date 2024-12-31 14:57:50
 */
public interface DiscussbaokaozhinanDao extends BaseMapper<DiscussbaokaozhinanEntity> {
	
	List<DiscussbaokaozhinanView> selectListView(@Param("ew") QueryWrapper<DiscussbaokaozhinanEntity> wrapper);

	List<DiscussbaokaozhinanView> selectListView(@Param("page")Page page,@Param("ew") QueryWrapper<DiscussbaokaozhinanEntity> wrapper);
	
	DiscussbaokaozhinanView selectView(@Param("ew") QueryWrapper<DiscussbaokaozhinanEntity> wrapper);


}
