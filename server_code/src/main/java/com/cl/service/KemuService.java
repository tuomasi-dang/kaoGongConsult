package com.cl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.KemuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.KemuView;


/**
 * 科目
 *
 * @author 
 * @email 
 * @date 2024-12-31 14:57:50
 */
public interface KemuService extends IService<KemuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KemuView> selectListView(QueryWrapper<KemuEntity> wrapper);
   	
   	KemuView selectView(@Param("ew") QueryWrapper<KemuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<KemuEntity> wrapper);
   	

}

