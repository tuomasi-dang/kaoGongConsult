package com.cl.dao;

import com.cl.entity.KaogongziliaoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.KaogongziliaoView;


/**
 * 考公资料
 * 
 * @author 
 * @email 
 * @date 2024-12-31 14:57:50
 */
public interface KaoyanziliaoDao extends BaseMapper<KaogongziliaoEntity> {
	
	List<KaogongziliaoView> selectListView(@Param("ew") QueryWrapper<KaogongziliaoEntity> wrapper);

	List<KaogongziliaoView> selectListView(@Param("page")Page page, @Param("ew") QueryWrapper<KaogongziliaoEntity> wrapper);
	
	KaogongziliaoView selectView(@Param("ew") QueryWrapper<KaogongziliaoEntity> wrapper);


    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") QueryWrapper<KaogongziliaoEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") QueryWrapper<KaogongziliaoEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") QueryWrapper<KaogongziliaoEntity> wrapper);



}
