package com.cl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.NewsEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.NewsView;


/**
 * 考公资讯
 *
 * @author 
 * @email 
 * @date 2024-12-31 14:57:50
 */
public interface NewsService extends IService<NewsEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<NewsView> selectListView(QueryWrapper<NewsEntity> wrapper);
   	
   	NewsView selectView(@Param("ew") QueryWrapper<NewsEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<NewsEntity> wrapper);
   	

}

