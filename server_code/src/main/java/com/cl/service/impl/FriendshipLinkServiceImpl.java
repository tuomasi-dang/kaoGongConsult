package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.FriendshipLinkDao;
import com.cl.entity.FriendshipLinkEntity;
import com.cl.service.FriendshipLinkService;
import com.cl.entity.view.FriendshipLinkView;

@Service("friendshipLinkService")
public class FriendshipLinkServiceImpl extends ServiceImpl<FriendshipLinkDao, FriendshipLinkEntity> implements FriendshipLinkService {



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FriendshipLinkEntity> page = baseMapper.selectPage(new Query<FriendshipLinkEntity>(params).getPage(),new QueryWrapper<FriendshipLinkEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<FriendshipLinkEntity> wrapper) {
        Page<FriendshipLinkEntity> page = baseMapper.selectPage(new Query<FriendshipLinkEntity>(params).getPage(),wrapper);
        Page<FriendshipLinkView> pageVo = (Page<FriendshipLinkView>)page.convert(FriendshipLinkView::new);
	    return new PageUtils(pageVo);
 	}
    
	@Override
	public List<FriendshipLinkView> selectListView(QueryWrapper<FriendshipLinkEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FriendshipLinkView selectView(QueryWrapper<FriendshipLinkEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
