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

import com.cl.entity.ForumEntity;
import com.cl.entity.view.ForumView;

import com.cl.service.ForumService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.MapUtils;
import com.cl.utils.CommonUtil;

import java.io.IOException;

/**
 * 论坛交流
 * 后端接口
 *
 * @author
 * @email
 * @date 2024-12-31 14:57:50
 */
@RestController
@RequestMapping("/forum")
public class ForumController {
    @Autowired
    private ForumService forumService;


    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, ForumEntity forum,
                  HttpServletRequest request) {
        if (!request.getSession().getAttribute("role").toString().equals("管理员")) {
            forum.setUserid((Long) request.getSession().getAttribute("userId"));
        }
        QueryWrapper<ForumEntity> ew = new QueryWrapper<ForumEntity>();
        PageUtils page = forumService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, forum), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, ForumEntity forum,
                  HttpServletRequest request) {
        if (!request.getSession().getAttribute("role").toString().equals("管理员")) {
            forum.setUserid((Long) request.getSession().getAttribute("userId"));
        }
        QueryWrapper<ForumEntity> ew = new QueryWrapper<ForumEntity>();

        PageUtils page = forumService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, forum), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @IgnoreAuth
    @RequestMapping("/flist")
    public R flist(@RequestParam Map<String, Object> params, ForumEntity forum, HttpServletRequest request) {
        QueryWrapper<ForumEntity> ew = new QueryWrapper<ForumEntity>();
        PageUtils page = forumService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, forum), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ForumEntity forum) {
        QueryWrapper<ForumEntity> ew = new QueryWrapper<ForumEntity>();
        ew.allEq(MPUtil.allEQMapPre(forum, "forum"));
        ForumView forumView = forumService.selectView(ew);
        return R.ok("查询论坛交流成功").put("data", forumView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        ForumEntity forum = forumService.getById(id);
        forum = forumService.selectView(new QueryWrapper<ForumEntity>().eq("id", id));
        return R.ok().put("data", forum);
    }

    /**
     * 前端详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id) {
        ForumEntity forum = forumService.getById(id);
        forum = forumService.selectView(new QueryWrapper<ForumEntity>().eq("id", id));
        return R.ok().put("data", forum);
    }

    /**
     * 论坛详情
     */
    @IgnoreAuth
    @RequestMapping("/list/{id}")
    public R list(@PathVariable("id") String id) {
        ForumEntity forum = forumService.getById(id);
        getChilds(forum);
        return R.ok().put("data", forum);
    }

    private ForumEntity getChilds(ForumEntity forum) {
        List<ForumEntity> childs = new ArrayList<ForumEntity>();
        childs = forumService.list(new QueryWrapper<ForumEntity>().eq("parentid", forum.getId()));
        if (childs == null || childs.size() == 0) {
            return null;
        }
        forum.setChilds(childs);
        for (ForumEntity forumEntity : childs) {
            getChilds(forumEntity);
        }
        return forum;
    }


    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ForumEntity forum, HttpServletRequest request) {
        //ValidatorUtils.validateEntity(forum);
        forum.setUserid((Long) request.getSession().getAttribute("userId"));
        forumService.save(forum);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ForumEntity forum, HttpServletRequest request) {
        //ValidatorUtils.validateEntity(forum);
        forum.setUserid((Long) request.getSession().getAttribute("userId"));
        forumService.save(forum);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ForumEntity forum, HttpServletRequest request) {
        //ValidatorUtils.validateEntity(forum);
        forumService.updateById(forum);//全部更新
        return R.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        forumService.removeBatchByIds(Arrays.asList(ids));
        return R.ok();
    }


}
