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

import com.cl.entity.CartEntity;
import com.cl.entity.view.CartView;

import com.cl.service.CartService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.MapUtils;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 购物车
 * 后端接口
 * @author 
 * @email 
 * @date 2024-12-31 14:57:50
 */
@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;







    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,CartEntity cart,
                                                                                                            HttpServletRequest request){
                                    if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
                    cart.setUserid((Long)request.getSession().getAttribute("userId"));
                }
                            QueryWrapper<CartEntity> ew = new QueryWrapper<CartEntity>();
                                                                                                                                                                        
        
        
        PageUtils page = cartService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, cart), params), params));
        return R.ok().put("data", page);
    }







    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,CartEntity cart,
		HttpServletRequest request){
        QueryWrapper<CartEntity> ew = new QueryWrapper<CartEntity>();

		PageUtils page = cartService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, cart), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( CartEntity cart){
       	QueryWrapper<CartEntity> ew = new QueryWrapper<CartEntity>();
      	ew.allEq(MPUtil.allEQMapPre( cart, "cart"));
        return R.ok().put("data", cartService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(CartEntity cart){
        QueryWrapper< CartEntity> ew = new QueryWrapper< CartEntity>();
 		ew.allEq(MPUtil.allEQMapPre( cart, "cart"));
		CartView cartView =  cartService.selectView(ew);
		return R.ok("查询购物车成功").put("data", cartView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CartEntity cart = cartService.getById(id);
		cart = cartService.selectView(new QueryWrapper<CartEntity>().eq("id", id));
        return R.ok().put("data", cart);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CartEntity cart = cartService.getById(id);
		cart = cartService.selectView(new QueryWrapper<CartEntity>().eq("id", id));
        return R.ok().put("data", cart);
    }




    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CartEntity cart, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(cart);
    	cart.setUserid((Long)request.getSession().getAttribute("userId"));
        cartService.save(cart);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody CartEntity cart, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(cart);
        cartService.save(cart);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody CartEntity cart, HttpServletRequest request){
        //ValidatorUtils.validateEntity(cart);
        cartService.updateById(cart);//全部更新
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        cartService.removeBatchByIds(Arrays.asList(ids));
        return R.ok();
    }











}
