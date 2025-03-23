package com.cl.dao;

import com.cl.entity.FriendshipLinkEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FriendshipLinkView;


/**
 * 友情链接
 * 
 * @author 
 * @email 
 * @date 2024-12-31 14:57:50
 */
public interface FriendshipLinkDao extends BaseMapper<FriendshipLinkEntity> {
	
	List<FriendshipLinkView> selectListView(@Param("ew") QueryWrapper<FriendshipLinkEntity> wrapper);

	List<FriendshipLinkView> selectListView(@Param("page")Page page,@Param("ew") QueryWrapper<FriendshipLinkEntity> wrapper);
	
	FriendshipLinkView selectView(@Param("ew") QueryWrapper<FriendshipLinkEntity> wrapper);


}
