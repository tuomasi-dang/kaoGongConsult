package com.cl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.AddressEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.AddressView;


/**
 * 地址
 *
 * @author 
 * @email 
 * @date 2024-12-31 14:57:50
 */
public interface AddressService extends IService<AddressEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<AddressView> selectListView(QueryWrapper<AddressEntity> wrapper);
   	
   	AddressView selectView(@Param("ew") QueryWrapper<AddressEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<AddressEntity> wrapper);
   	

}

