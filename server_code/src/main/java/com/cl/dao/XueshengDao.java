package com.cl.dao;

import com.cl.entity.XueshengEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XueshengView;


/**
 * 学生
 * 
 * @author 
 * @email 
 * @date 2024-12-31 14:57:50
 */
public interface XueshengDao extends BaseMapper<XueshengEntity> {
	
	List<XueshengView> selectListView(@Param("ew") QueryWrapper<XueshengEntity> wrapper);

	List<XueshengView> selectListView(@Param("page")Page page,@Param("ew") QueryWrapper<XueshengEntity> wrapper);
	
	XueshengView selectView(@Param("ew") QueryWrapper<XueshengEntity> wrapper);


}
