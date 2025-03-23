package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.ZiliaofenleiDao;
import com.cl.entity.ZiliaofenleiEntity;
import com.cl.service.ZiliaofenleiService;
import com.cl.entity.view.ZiliaofenleiView;

@Service("ziliaofenleiService")
public class ZiliaofenleiServiceImpl extends ServiceImpl<ZiliaofenleiDao, ZiliaofenleiEntity> implements ZiliaofenleiService {



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZiliaofenleiEntity> page = baseMapper.selectPage(new Query<ZiliaofenleiEntity>(params).getPage(),new QueryWrapper<ZiliaofenleiEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<ZiliaofenleiEntity> wrapper) {
        Page<ZiliaofenleiEntity> page = baseMapper.selectPage(new Query<ZiliaofenleiEntity>(params).getPage(),wrapper);
        Page<ZiliaofenleiView> pageVo = (Page<ZiliaofenleiView>)page.convert(ZiliaofenleiView::new);
	    return new PageUtils(pageVo);
 	}
    
	@Override
	public List<ZiliaofenleiView> selectListView(QueryWrapper<ZiliaofenleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZiliaofenleiView selectView(QueryWrapper<ZiliaofenleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
