package com.cl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ChatEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ChatView;


/**
 * 管理员聊天
 *
 * @author 
 * @email 
 * @date 2024-12-31 14:57:50
 */
public interface ChatService extends IService<ChatEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChatView> selectListView(QueryWrapper<ChatEntity> wrapper);
   	
   	ChatView selectView(@Param("ew") QueryWrapper<ChatEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<ChatEntity> wrapper);
   	

}

