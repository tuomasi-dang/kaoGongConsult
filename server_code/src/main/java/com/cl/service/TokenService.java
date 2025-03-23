package com.cl.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cl.entity.TokenEntity;
import com.cl.utils.PageUtils;


/**
 * token
 */
public interface TokenService extends IService<TokenEntity> {
 	PageUtils queryPage(Map<String, Object> params);
    
   	List<TokenEntity> selectListView(QueryWrapper<TokenEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<TokenEntity> wrapper);
	
   	String generateToken(Long userid,String username,String tableName, String role);
   	
   	TokenEntity getTokenEntity(String token);
}
