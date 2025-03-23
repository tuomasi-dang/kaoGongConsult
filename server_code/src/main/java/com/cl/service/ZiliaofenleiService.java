package com.cl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZiliaofenleiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZiliaofenleiView;


/**
 * 资料分类
 *
 * @author 
 * @email 
 * @date 2024-12-31 14:57:50
 */
public interface ZiliaofenleiService extends IService<ZiliaofenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZiliaofenleiView> selectListView(QueryWrapper<ZiliaofenleiEntity> wrapper);
   	
   	ZiliaofenleiView selectView(@Param("ew") QueryWrapper<ZiliaofenleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<ZiliaofenleiEntity> wrapper);
   	

}

