package com.cl.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import jakarta.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cl.annotation.IgnoreAuth;
import com.cl.entity.OrdersEntity;
import com.cl.service.OrdersService;
import com.cl.utils.UserBasedCollaborativeFiltering;

import com.cl.entity.KaogongziliaoEntity;
import com.cl.entity.view.KaogongziliaoView;

import com.cl.service.KaoyanziliaoService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.service.StoreupService;

/**
 * 考公资料
 * 后端接口
 * @author 
 * @email 
 * @date 2024-12-31 14:57:50
 */
@RestController
@RequestMapping("/kaoyanziliao")
public class KaoyanziliaoController {
    @Autowired
    private KaoyanziliaoService kaoyanziliaoService;

    @Autowired
    private StoreupService storeupService;

    @Autowired
    private OrdersService ordersService;





    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, KaogongziliaoEntity kaoyanziliao,
                  HttpServletRequest request){
                                    QueryWrapper<KaogongziliaoEntity> ew = new QueryWrapper<KaogongziliaoEntity>();
                                                                                                                                                                                                                                                                                                                                    
        
        
        PageUtils page = kaoyanziliaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kaoyanziliao), params), params));
        return R.ok().put("data", page);
    }







    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, KaogongziliaoEntity kaoyanziliao,
                  HttpServletRequest request){
        QueryWrapper<KaogongziliaoEntity> ew = new QueryWrapper<KaogongziliaoEntity>();

		PageUtils page = kaoyanziliaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kaoyanziliao), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KaogongziliaoEntity kaoyanziliao){
       	QueryWrapper<KaogongziliaoEntity> ew = new QueryWrapper<KaogongziliaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kaoyanziliao, "kaoyanziliao"));
        return R.ok().put("data", kaoyanziliaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KaogongziliaoEntity kaoyanziliao){
        QueryWrapper<KaogongziliaoEntity> ew = new QueryWrapper<KaogongziliaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kaoyanziliao, "kaoyanziliao"));
		KaogongziliaoView kaoyanziliaoView =  kaoyanziliaoService.selectView(ew);
		return R.ok("查询考公资料成功").put("data", kaoyanziliaoView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KaogongziliaoEntity kaoyanziliao = kaoyanziliaoService.getById(id);
		kaoyanziliao = kaoyanziliaoService.selectView(new QueryWrapper<KaogongziliaoEntity>().eq("id", id));
        return R.ok().put("data", kaoyanziliao);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KaogongziliaoEntity kaoyanziliao = kaoyanziliaoService.getById(id);
		kaoyanziliao = kaoyanziliaoService.selectView(new QueryWrapper<KaogongziliaoEntity>().eq("id", id));
        return R.ok().put("data", kaoyanziliao);
    }



    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        KaogongziliaoEntity kaoyanziliao = kaoyanziliaoService.getById(id);
        if(type.equals("1")) {
        	kaoyanziliao.setThumbsupNumber(kaoyanziliao.getThumbsupNumber()+1);
        } else {
        	kaoyanziliao.setCrazilyNumber(kaoyanziliao.getCrazilyNumber()+1);
        }
        kaoyanziliaoService.updateById(kaoyanziliao);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KaogongziliaoEntity kaoyanziliao, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(kaoyanziliao);
        kaoyanziliaoService.save(kaoyanziliao);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KaogongziliaoEntity kaoyanziliao, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(kaoyanziliao);
        kaoyanziliaoService.save(kaoyanziliao);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KaogongziliaoEntity kaoyanziliao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kaoyanziliao);
        kaoyanziliaoService.updateById(kaoyanziliao);//全部更新
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        kaoyanziliaoService.removeBatchByIds(Arrays.asList(ids));
        return R.ok();
    }


	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params, KaogongziliaoEntity kaoyanziliao, HttpServletRequest request, String pre){
        QueryWrapper<KaogongziliaoEntity> ew = new QueryWrapper<KaogongziliaoEntity>();
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
		PageUtils page = kaoyanziliaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kaoyanziliao), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 协同算法（基于用户的协同算法）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params, KaogongziliaoEntity kaoyanziliao, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<OrdersEntity> orders = ordersService.list(new QueryWrapper<OrdersEntity>());
        Map<String, Map<String, Double>> ratings = new HashMap<>();
        if(orders!=null && orders.size()>0) {
            for(OrdersEntity o : orders) {
                Map<String, Double> userRatings = null;
                if(ratings.containsKey(o.getUserid().toString())) {
                    userRatings = ratings.get(o.getUserid().toString());
                } else {
                    userRatings = new HashMap<>();
                    ratings.put(o.getUserid().toString(), userRatings);
                }
                if(userRatings.containsKey(o.getGoodid().toString())) {
                    userRatings.put(o.getGoodid().toString(), userRatings.get(o.getGoodid().toString())+1.0);
                } else {
                    userRatings.put(o.getGoodid().toString(), 1.0);
                }

            }
        }
        // 创建协同过滤对象
        UserBasedCollaborativeFiltering filter = new UserBasedCollaborativeFiltering(ratings);

        // 为指定用户推荐物品
        String targetUser = userId;
        int numRecommendations = limit;
        List<String> recommendations = filter.recommendItems(targetUser, numRecommendations);

        // 输出推荐结果
        System.out.println("Recommendations for " + targetUser + ":");
        for (String item : recommendations) {
            System.out.println(item);
        }

        QueryWrapper<KaogongziliaoEntity> ew = new QueryWrapper<KaogongziliaoEntity>();
        if(recommendations!=null && recommendations.size()>0) {
            ew.in("id", recommendations);
            ew.last("order by FIELD(id, "+String.join(",", recommendations)+")");
        }

        PageUtils page = kaoyanziliaoService.queryPage(params, ew);
        List<KaogongziliaoEntity> pageList = (List<KaogongziliaoEntity>)page.getList();
        if(pageList.size()<limit) {
            int toAddNum = limit-pageList.size();
            ew = new QueryWrapper<KaogongziliaoEntity>();
            if(recommendations.size()>0){
                ew.notIn("id", recommendations);
            }
            ew.orderByDesc("id");
            ew.last("limit "+toAddNum);
            pageList.addAll(kaoyanziliaoService.list(ew));
        } else if(pageList.size()>limit) {
            pageList = pageList.subList(0, limit);
        }
        page.setList(pageList);

        return R.ok().put("data", page);
    }




    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", MPUtil.camelToSnake(xColumnName));
        params.put("yColumn", MPUtil.camelToSnake(yColumnName));
        QueryWrapper<KaogongziliaoEntity> ew = new QueryWrapper<KaogongziliaoEntity>();
        List<Map<String, Object>> result = kaoyanziliaoService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul, HttpServletRequest request) {
        String[] yColumnNames = MPUtil.camelToSnake(yColumnNameMul).split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", MPUtil.camelToSnake(xColumnName));
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        QueryWrapper<KaogongziliaoEntity> ew = new QueryWrapper<KaogongziliaoEntity>();
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = kaoyanziliaoService.selectValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", MPUtil.camelToSnake(xColumnName));
        params.put("yColumn", MPUtil.camelToSnake(yColumnName));
        params.put("timeStatType", timeStatType);
        QueryWrapper<KaogongziliaoEntity> ew = new QueryWrapper<KaogongziliaoEntity>();
        List<Map<String, Object>> result = kaoyanziliaoService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,@RequestParam String yColumnNameMul,HttpServletRequest request) {
        String[] yColumnNames = MPUtil.camelToSnake(yColumnNameMul).split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("timeStatType", timeStatType);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        QueryWrapper<KaogongziliaoEntity> ew = new QueryWrapper<KaogongziliaoEntity>();
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = kaoyanziliaoService.selectTimeStatValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", MPUtil.camelToSnake(columnName));
        QueryWrapper<KaogongziliaoEntity> ew = new QueryWrapper<KaogongziliaoEntity>();
        List<Map<String, Object>> result = kaoyanziliaoService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }




    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params, KaogongziliaoEntity kaoyanziliao, HttpServletRequest request){
        QueryWrapper<KaogongziliaoEntity> ew = new QueryWrapper<KaogongziliaoEntity>();
    long count = kaoyanziliaoService.count(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kaoyanziliao), params), params));
        return R.ok().put("data", count);
    }



}
