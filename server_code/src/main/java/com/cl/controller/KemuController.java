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

import com.cl.entity.KemuEntity;
import com.cl.entity.view.KemuView;

import com.cl.service.KemuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.MapUtils;
import com.cl.utils.CommonUtil;

import java.io.IOException;

/**
 * 科目
 * 后端接口
 *
 * @author
 * @email
 * @date 2024-12-31 14:57:50
 */
@RestController
@RequestMapping("/kemu")
public class KemuController {
    @Autowired
    private KemuService kemuService;


    @GetMapping("zhiweimingcheng")
    public R get(){
        return R.ok().put("data", kemuService.getZhiWei());
    }

    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, KemuEntity kemu,
                  HttpServletRequest request) {
        QueryWrapper<KemuEntity> ew = new QueryWrapper<KemuEntity>();


        PageUtils page = kemuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kemu), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 前端列表
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, KemuEntity kemu,
                  HttpServletRequest request) {
        QueryWrapper<KemuEntity> ew = new QueryWrapper<KemuEntity>();

        PageUtils page = kemuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kemu), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/lists")
    public R list(KemuEntity kemu) {
        QueryWrapper<KemuEntity> ew = new QueryWrapper<KemuEntity>();
        ew.allEq(MPUtil.allEQMapPre(kemu, "kemu"));
        return R.ok().put("data", kemuService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KemuEntity kemu) {
        QueryWrapper<KemuEntity> ew = new QueryWrapper<KemuEntity>();
        ew.allEq(MPUtil.allEQMapPre(kemu, "kemu"));
        KemuView kemuView = kemuService.selectView(ew);
        return R.ok("查询科目成功").put("data", kemuView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        KemuEntity kemu = kemuService.getById(id);
        kemu = kemuService.selectView(new QueryWrapper<KemuEntity>().eq("id", id));
        return R.ok().put("data", kemu);
    }

    /**
     * 前端详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id) {
        KemuEntity kemu = kemuService.getById(id);
        kemu = kemuService.selectView(new QueryWrapper<KemuEntity>().eq("id", id));
        return R.ok().put("data", kemu);
    }


    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KemuEntity kemu, HttpServletRequest request) {
        //ValidatorUtils.validateEntity(kemu);
        kemuService.save(kemu);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KemuEntity kemu, HttpServletRequest request) {
        //ValidatorUtils.validateEntity(kemu);
        kemuService.save(kemu);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KemuEntity kemu, HttpServletRequest request) {
        //ValidatorUtils.validateEntity(kemu);
        kemuService.updateById(kemu);//全部更新
        return R.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        kemuService.removeBatchByIds(Arrays.asList(ids));
        return R.ok();
    }


}
