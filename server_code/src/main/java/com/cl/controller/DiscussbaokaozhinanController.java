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

import com.cl.entity.DiscussbaokaozhinanEntity;
import com.cl.entity.view.DiscussbaokaozhinanView;

import com.cl.service.DiscussbaokaozhinanService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.MapUtils;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 报考指南评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2024-12-31 14:57:50
 */
@RestController
@RequestMapping("/discussbaokaozhinan")
public class DiscussbaokaozhinanController {
    @Autowired
    private DiscussbaokaozhinanService discussbaokaozhinanService;







    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussbaokaozhinanEntity discussbaokaozhinan,
                                                                                                                            HttpServletRequest request){
                                    QueryWrapper<DiscussbaokaozhinanEntity> ew = new QueryWrapper<DiscussbaokaozhinanEntity>();
                                                                                                                                                                                        
        
        
        PageUtils page = discussbaokaozhinanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussbaokaozhinan), params), params));
        return R.ok().put("data", page);
    }







    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussbaokaozhinanEntity discussbaokaozhinan,
		HttpServletRequest request){
        QueryWrapper<DiscussbaokaozhinanEntity> ew = new QueryWrapper<DiscussbaokaozhinanEntity>();

		PageUtils page = discussbaokaozhinanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussbaokaozhinan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussbaokaozhinanEntity discussbaokaozhinan){
       	QueryWrapper<DiscussbaokaozhinanEntity> ew = new QueryWrapper<DiscussbaokaozhinanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussbaokaozhinan, "discussbaokaozhinan"));
        return R.ok().put("data", discussbaokaozhinanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussbaokaozhinanEntity discussbaokaozhinan){
        QueryWrapper< DiscussbaokaozhinanEntity> ew = new QueryWrapper< DiscussbaokaozhinanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussbaokaozhinan, "discussbaokaozhinan"));
		DiscussbaokaozhinanView discussbaokaozhinanView =  discussbaokaozhinanService.selectView(ew);
		return R.ok("查询报考指南评论表成功").put("data", discussbaokaozhinanView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussbaokaozhinanEntity discussbaokaozhinan = discussbaokaozhinanService.getById(id);
		discussbaokaozhinan = discussbaokaozhinanService.selectView(new QueryWrapper<DiscussbaokaozhinanEntity>().eq("id", id));
        return R.ok().put("data", discussbaokaozhinan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussbaokaozhinanEntity discussbaokaozhinan = discussbaokaozhinanService.getById(id);
		discussbaokaozhinan = discussbaokaozhinanService.selectView(new QueryWrapper<DiscussbaokaozhinanEntity>().eq("id", id));
        return R.ok().put("data", discussbaokaozhinan);
    }




    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussbaokaozhinanEntity discussbaokaozhinan, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discussbaokaozhinan);
        discussbaokaozhinanService.save(discussbaokaozhinan);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussbaokaozhinanEntity discussbaokaozhinan, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discussbaokaozhinan);
        discussbaokaozhinanService.save(discussbaokaozhinan);
        return R.ok();
    }

     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        DiscussbaokaozhinanEntity discussbaokaozhinan = discussbaokaozhinanService.getOne(new QueryWrapper<DiscussbaokaozhinanEntity>().eq("", username));
        return R.ok().put("data", discussbaokaozhinan);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscussbaokaozhinanEntity discussbaokaozhinan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussbaokaozhinan);
        discussbaokaozhinanService.updateById(discussbaokaozhinan);//全部更新
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussbaokaozhinanService.removeBatchByIds(Arrays.asList(ids));
        return R.ok();
    }


	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscussbaokaozhinanEntity discussbaokaozhinan, HttpServletRequest request,String pre){
        QueryWrapper<DiscussbaokaozhinanEntity> ew = new QueryWrapper<DiscussbaokaozhinanEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = discussbaokaozhinanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussbaokaozhinan), params), params));
        return R.ok().put("data", page);
    }









}
