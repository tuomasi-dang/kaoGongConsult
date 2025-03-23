package com.cl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscusskaoyanziliaoEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscusskaoyanziliaoView;


/**
 * 考公资料评论表
 *
 * @author 
 * @email 
 * @date 2024-12-31 14:57:50
 */
public interface DiscusskaoyanziliaoService extends IService<DiscusskaoyanziliaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusskaoyanziliaoView> selectListView(QueryWrapper<DiscusskaoyanziliaoEntity> wrapper);
   	
   	DiscusskaoyanziliaoView selectView(@Param("ew") QueryWrapper<DiscusskaoyanziliaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<DiscusskaoyanziliaoEntity> wrapper);
   	

}

