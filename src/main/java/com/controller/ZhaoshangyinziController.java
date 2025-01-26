package com.controller;

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
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ZhaoshangyinziEntity;
import com.entity.view.ZhaoshangyinziView;

import com.service.ZhaoshangyinziService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 招商引资
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-20 10:24:37
 */
@RestController
@RequestMapping("/zhaoshangyinzi")
public class ZhaoshangyinziController {
    @Autowired
    private ZhaoshangyinziService zhaoshangyinziService;



    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhaoshangyinziEntity zhaoshangyinzi, 
		HttpServletRequest request){

        EntityWrapper<ZhaoshangyinziEntity> ew = new EntityWrapper<ZhaoshangyinziEntity>();


		PageUtils page = zhaoshangyinziService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhaoshangyinzi), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhaoshangyinziEntity zhaoshangyinzi, 
		HttpServletRequest request){
        EntityWrapper<ZhaoshangyinziEntity> ew = new EntityWrapper<ZhaoshangyinziEntity>();

		PageUtils page = zhaoshangyinziService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhaoshangyinzi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhaoshangyinziEntity zhaoshangyinzi){
       	EntityWrapper<ZhaoshangyinziEntity> ew = new EntityWrapper<ZhaoshangyinziEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhaoshangyinzi, "zhaoshangyinzi")); 
        return R.ok().put("data", zhaoshangyinziService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhaoshangyinziEntity zhaoshangyinzi){
        EntityWrapper< ZhaoshangyinziEntity> ew = new EntityWrapper< ZhaoshangyinziEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhaoshangyinzi, "zhaoshangyinzi")); 
		ZhaoshangyinziView zhaoshangyinziView =  zhaoshangyinziService.selectView(ew);
		return R.ok("查询招商引资成功").put("data", zhaoshangyinziView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhaoshangyinziEntity zhaoshangyinzi = zhaoshangyinziService.selectById(id);
        return R.ok().put("data", zhaoshangyinzi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhaoshangyinziEntity zhaoshangyinzi = zhaoshangyinziService.selectById(id);
        return R.ok().put("data", zhaoshangyinzi);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R thumbsup(@PathVariable("id") String id,String type){
        ZhaoshangyinziEntity zhaoshangyinzi = zhaoshangyinziService.selectById(id);
        if(type.equals("1")) {
        	zhaoshangyinzi.setThumbsupnum(zhaoshangyinzi.getThumbsupnum()+1);
        } else {
        	zhaoshangyinzi.setCrazilynum(zhaoshangyinzi.getCrazilynum()+1);
        }
        zhaoshangyinziService.updateById(zhaoshangyinzi);
        return R.ok();
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhaoshangyinziEntity zhaoshangyinzi, HttpServletRequest request){
    	zhaoshangyinzi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhaoshangyinzi);

        zhaoshangyinziService.insert(zhaoshangyinzi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhaoshangyinziEntity zhaoshangyinzi, HttpServletRequest request){
    	zhaoshangyinzi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhaoshangyinzi);

        zhaoshangyinziService.insert(zhaoshangyinzi);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhaoshangyinziEntity zhaoshangyinzi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhaoshangyinzi);
        zhaoshangyinziService.updateById(zhaoshangyinzi);//全部更新
        return R.ok();
    }
    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhaoshangyinziService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
