package com.cl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.BaokaozhinanEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.BaokaozhinanView;


/**
 * 报考指南
 *
 * @author 
 * @email 
 * @date 2024-12-31 14:57:50
 */
public interface BaokaozhinanService extends IService<BaokaozhinanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BaokaozhinanView> selectListView(QueryWrapper<BaokaozhinanEntity> wrapper);
   	
   	BaokaozhinanView selectView(@Param("ew") QueryWrapper<BaokaozhinanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<BaokaozhinanEntity> wrapper);


}

