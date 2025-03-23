package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.AddressDao;
import com.cl.entity.AddressEntity;
import com.cl.service.AddressService;
import com.cl.entity.view.AddressView;

@Service("addressService")
public class AddressServiceImpl extends ServiceImpl<AddressDao, AddressEntity> implements AddressService {



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AddressEntity> page = baseMapper.selectPage(new Query<AddressEntity>(params).getPage(),new QueryWrapper<AddressEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<AddressEntity> wrapper) {
        Page<AddressEntity> page = baseMapper.selectPage(new Query<AddressEntity>(params).getPage(),wrapper);
        Page<AddressView> pageVo = (Page<AddressView>)page.convert(AddressView::new);
	    return new PageUtils(pageVo);
 	}
    
	@Override
	public List<AddressView> selectListView(QueryWrapper<AddressEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public AddressView selectView(QueryWrapper<AddressEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
