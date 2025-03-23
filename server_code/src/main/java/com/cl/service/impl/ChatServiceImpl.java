package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.ChatDao;
import com.cl.entity.ChatEntity;
import com.cl.service.ChatService;
import com.cl.entity.view.ChatView;

@Service("chatService")
public class ChatServiceImpl extends ServiceImpl<ChatDao, ChatEntity> implements ChatService {



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChatEntity> page = baseMapper.selectPage(new Query<ChatEntity>(params).getPage(),new QueryWrapper<ChatEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<ChatEntity> wrapper) {
        Page<ChatEntity> page = baseMapper.selectPage(new Query<ChatEntity>(params).getPage(),wrapper);
        Page<ChatView> pageVo = (Page<ChatView>)page.convert(ChatView::new);
	    return new PageUtils(pageVo);
 	}
    
	@Override
	public List<ChatView> selectListView(QueryWrapper<ChatEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChatView selectView(QueryWrapper<ChatEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
