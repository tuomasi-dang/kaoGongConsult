package com.cl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussbaokaozhinanEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussbaokaozhinanView;


/**
 * 报考指南评论表
 *
 * @author 
 * @email 
 * @date 2024-12-31 14:57:50
 */
public interface DiscussbaokaozhinanService extends IService<DiscussbaokaozhinanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussbaokaozhinanView> selectListView(QueryWrapper<DiscussbaokaozhinanEntity> wrapper);
   	
   	DiscussbaokaozhinanView selectView(@Param("ew") QueryWrapper<DiscussbaokaozhinanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<DiscussbaokaozhinanEntity> wrapper);
   	

}

