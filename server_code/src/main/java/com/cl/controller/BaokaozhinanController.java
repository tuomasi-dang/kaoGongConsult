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

import com.cl.entity.BaokaozhinanEntity;
import com.cl.entity.view.BaokaozhinanView;

import com.cl.service.BaokaozhinanService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.MapUtils;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 报考指南
 * 后端接口
 * @author 
 * @email 
 * @date 2024-12-31 14:57:50
 */
@RestController
@RequestMapping("/baokaozhinan")
public class BaokaozhinanController {
    @Autowired
    private BaokaozhinanService baokaozhinanService;

    @Autowired
    private StoreupService storeupService;






    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,BaokaozhinanEntity baokaozhinan,
                                                                                                                                                                                                                            HttpServletRequest request){
                                    QueryWrapper<BaokaozhinanEntity> ew = new QueryWrapper<BaokaozhinanEntity>();
                                                                                                                                                                                                                                                                                                                                                        

        
        PageUtils page = baokaozhinanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, baokaozhinan), params), params));
        return R.ok().put("data", page);
    }







    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,BaokaozhinanEntity baokaozhinan,
		HttpServletRequest request){
        QueryWrapper<BaokaozhinanEntity> wrapper = new QueryWrapper<>();

        // 动态添加查询条件
        if (StringUtils.isNotBlank(baokaozhinan.getBumenmingcheng())) {
            wrapper.like("bumenmingcheng", baokaozhinan.getBumenmingcheng()); // 模糊查询部门名称
        }
        if (StringUtils.isNotBlank(baokaozhinan.getZhiweimingcheng())) {
            wrapper.like("zhiweimingcheng", baokaozhinan.getZhiweimingcheng()); // 模糊查询职位名称
        }
        if (StringUtils.isNotBlank(baokaozhinan.getXueliyaoqiu())) {
            wrapper.eq("xueliyaoqiu", baokaozhinan.getXueliyaoqiu()); // 精确查询学历要求
        }
        if (StringUtils.isNotBlank(baokaozhinan.getZhuanyeyaoqiu())) {
            wrapper.like("zhuanyeyaoqiu", baokaozhinan.getZhuanyeyaoqiu()); // 模糊查询专业要求
        }
        if (StringUtils.isNotBlank(baokaozhinan.getZhengzhimianmao())) {
            wrapper.eq("zhengzhimianmao", baokaozhinan.getZhengzhimianmao()); // 精确查询政治面貌
        }
        if (baokaozhinan.getZhaokaorenshu() != null) {
            wrapper.ge("zhaokaorenshu", baokaozhinan.getZhaokaorenshu()); // 招考人数：大于等于
        }
        if (baokaozhinan.getBaomingshijian() != null) {
            wrapper.ge("baomingshijian", baokaozhinan.getBaomingshijian()); // 报名时间：大于等于
        }
        if (baokaozhinan.getFeiyongjiaona() != null) {
            wrapper.le("feiyongjiaona", baokaozhinan.getFeiyongjiaona()); // 费用缴纳：小于等于
        }

        // 调用 Service 层的分页查询方法
        PageUtils page = baokaozhinanService.queryPage(params, wrapper);

        // 返回结果
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( BaokaozhinanEntity baokaozhinan){
       	QueryWrapper<BaokaozhinanEntity> ew = new QueryWrapper<BaokaozhinanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( baokaozhinan, "baokaozhinan"));
        return R.ok().put("data", baokaozhinanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(BaokaozhinanEntity baokaozhinan){
        QueryWrapper< BaokaozhinanEntity> ew = new QueryWrapper< BaokaozhinanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( baokaozhinan, "baokaozhinan"));
		BaokaozhinanView baokaozhinanView =  baokaozhinanService.selectView(ew);
		return R.ok("查询报考指南成功").put("data", baokaozhinanView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        BaokaozhinanEntity baokaozhinan = baokaozhinanService.getById(id);
		baokaozhinan = baokaozhinanService.selectView(new QueryWrapper<BaokaozhinanEntity>().eq("id", id));
        return R.ok().put("data", baokaozhinan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        BaokaozhinanEntity baokaozhinan = baokaozhinanService.getById(id);
		baokaozhinan = baokaozhinanService.selectView(new QueryWrapper<BaokaozhinanEntity>().eq("id", id));
        return R.ok().put("data", baokaozhinan);
    }



    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        BaokaozhinanEntity baokaozhinan = baokaozhinanService.getById(id);
        if(type.equals("1")) {
        	baokaozhinan.setThumbsupNumber(baokaozhinan.getThumbsupNumber()+1);
        } else {
        	baokaozhinan.setCrazilyNumber(baokaozhinan.getCrazilyNumber()+1);
        }
        baokaozhinanService.updateById(baokaozhinan);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody BaokaozhinanEntity baokaozhinan, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(baokaozhinan);
        baokaozhinanService.save(baokaozhinan);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody BaokaozhinanEntity baokaozhinan, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(baokaozhinan);
        baokaozhinanService.save(baokaozhinan);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody BaokaozhinanEntity baokaozhinan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(baokaozhinan);
        baokaozhinanService.updateById(baokaozhinan);//全部更新
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        baokaozhinanService.removeBatchByIds(Arrays.asList(ids));
        return R.ok();
    }











}
