package com.cl.dao;

import com.cl.entity.ZiliaofenleiEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZiliaofenleiView;


/**
 * 资料分类
 * 
 * @author 
 * @email 
 * @date 2024-12-31 14:57:50
 */
public interface ZiliaofenleiDao extends BaseMapper<ZiliaofenleiEntity> {
	
	List<ZiliaofenleiView> selectListView(@Param("ew") QueryWrapper<ZiliaofenleiEntity> wrapper);

	List<ZiliaofenleiView> selectListView(@Param("page")Page page,@Param("ew") QueryWrapper<ZiliaofenleiEntity> wrapper);
	
	ZiliaofenleiView selectView(@Param("ew") QueryWrapper<ZiliaofenleiEntity> wrapper);


}
