package com.cl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.FriendshipLinkEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FriendshipLinkView;


/**
 * 友情链接
 *
 * @author 
 * @email 
 * @date 2024-12-31 14:57:50
 */
public interface FriendshipLinkService extends IService<FriendshipLinkEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FriendshipLinkView> selectListView(QueryWrapper<FriendshipLinkEntity> wrapper);
   	
   	FriendshipLinkView selectView(@Param("ew") QueryWrapper<FriendshipLinkEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<FriendshipLinkEntity> wrapper);
   	

}

