package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import jakarta.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.AddressEntity;
import com.cl.entity.view.AddressView;

import com.cl.service.AddressService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.MapUtils;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 地址
 * 后端接口
 * @author 
 * @email 
 * @date 2024-12-31 14:57:50
 */
@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;







    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,AddressEntity address,
                                                                        HttpServletRequest request){
                                    if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
                    address.setUserid((Long)request.getSession().getAttribute("userId"));
                }
                            QueryWrapper<AddressEntity> ew = new QueryWrapper<AddressEntity>();
                                                                                                            
        
        
        PageUtils page = addressService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, address), params), params));
        return R.ok().put("data", page);
    }







    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,AddressEntity address,
		HttpServletRequest request){
    	if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		address.setUserid((Long)request.getSession().getAttribute("userId"));
    	}
        QueryWrapper<AddressEntity> ew = new QueryWrapper<AddressEntity>();

		PageUtils page = addressService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, address), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( AddressEntity address){
       	QueryWrapper<AddressEntity> ew = new QueryWrapper<AddressEntity>();
      	ew.allEq(MPUtil.allEQMapPre( address, "address"));
        return R.ok().put("data", addressService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(AddressEntity address){
        QueryWrapper< AddressEntity> ew = new QueryWrapper< AddressEntity>();
 		ew.allEq(MPUtil.allEQMapPre( address, "address"));
		AddressView addressView =  addressService.selectView(ew);
		return R.ok("查询地址成功").put("data", addressView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        AddressEntity address = addressService.getById(id);
		address = addressService.selectView(new QueryWrapper<AddressEntity>().eq("id", id));
        return R.ok().put("data", address);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        AddressEntity address = addressService.getById(id);
		address = addressService.selectView(new QueryWrapper<AddressEntity>().eq("id", id));
        return R.ok().put("data", address);
    }




    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody AddressEntity address, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(address);
    	address.setUserid((Long)request.getSession().getAttribute("userId"));
		Long userId = (Long)request.getSession().getAttribute("userId");
    	if(address.getIsdefault().equals("是")) {
            addressService.update(new UpdateWrapper<AddressEntity>().set("isdefault","否").eq("userid", userId));
    	}
    	address.setUserid(userId);
        addressService.save(address);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody AddressEntity address, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(address);
    	address.setUserid((Long)request.getSession().getAttribute("userId"));
		Long userId = (Long)request.getSession().getAttribute("userId");
    	if(address.getIsdefault().equals("是")) {
            addressService.update(new UpdateWrapper<AddressEntity>().set("isdefault","否").eq("userid", userId));
    	}
    	address.setUserid(userId);
        addressService.save(address);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody AddressEntity address, HttpServletRequest request){
        //ValidatorUtils.validateEntity(address);
        if(address.getIsdefault().equals("是")) {
    		addressService.update(new UpdateWrapper<AddressEntity>().set("isdefault","否").eq("userid", request.getSession().getAttribute("userId")));
    	}
        addressService.updateById(address);//全部更新
        return R.ok();
    }




    /**
     * 获取默认地址
     */
    @RequestMapping("/default")
    public R defaultAddress(HttpServletRequest request){
        QueryWrapper<AddressEntity> wrapper = new QueryWrapper<AddressEntity>().eq("isdefault", "是").eq("userid", request.getSession().getAttribute("userId"));
        AddressEntity address = addressService.getOne(wrapper);
        return R.ok().put("data", address);
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        addressService.removeBatchByIds(Arrays.asList(ids));
        return R.ok();
    }











}
