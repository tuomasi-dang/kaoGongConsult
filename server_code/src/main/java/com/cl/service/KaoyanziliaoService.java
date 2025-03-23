package com.cl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.KaoyanziliaoEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.KaoyanziliaoView;


/**
 * 考公资料
 *
 * @author 
 * @email 
 * @date 2024-12-31 14:57:50
 */
public interface KaoyanziliaoService extends IService<KaoyanziliaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KaoyanziliaoView> selectListView(QueryWrapper<KaoyanziliaoEntity> wrapper);
   	
   	KaoyanziliaoView selectView(@Param("ew") QueryWrapper<KaoyanziliaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<KaoyanziliaoEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,QueryWrapper<KaoyanziliaoEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,QueryWrapper<KaoyanziliaoEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,QueryWrapper<KaoyanziliaoEntity> wrapper);



}

