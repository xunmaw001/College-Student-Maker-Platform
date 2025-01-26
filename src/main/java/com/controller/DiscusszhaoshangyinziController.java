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

import com.entity.DiscusszhaoshangyinziEntity;
import com.entity.view.DiscusszhaoshangyinziView;

import com.service.DiscusszhaoshangyinziService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 招商引资评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-20 10:24:37
 */
@RestController
@RequestMapping("/discusszhaoshangyinzi")
public class DiscusszhaoshangyinziController {
    @Autowired
    private DiscusszhaoshangyinziService discusszhaoshangyinziService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscusszhaoshangyinziEntity discusszhaoshangyinzi, 
		HttpServletRequest request){

        EntityWrapper<DiscusszhaoshangyinziEntity> ew = new EntityWrapper<DiscusszhaoshangyinziEntity>();


		PageUtils page = discusszhaoshangyinziService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusszhaoshangyinzi), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscusszhaoshangyinziEntity discusszhaoshangyinzi, 
		HttpServletRequest request){
        EntityWrapper<DiscusszhaoshangyinziEntity> ew = new EntityWrapper<DiscusszhaoshangyinziEntity>();

		PageUtils page = discusszhaoshangyinziService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusszhaoshangyinzi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscusszhaoshangyinziEntity discusszhaoshangyinzi){
       	EntityWrapper<DiscusszhaoshangyinziEntity> ew = new EntityWrapper<DiscusszhaoshangyinziEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discusszhaoshangyinzi, "discusszhaoshangyinzi")); 
        return R.ok().put("data", discusszhaoshangyinziService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscusszhaoshangyinziEntity discusszhaoshangyinzi){
        EntityWrapper< DiscusszhaoshangyinziEntity> ew = new EntityWrapper< DiscusszhaoshangyinziEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discusszhaoshangyinzi, "discusszhaoshangyinzi")); 
		DiscusszhaoshangyinziView discusszhaoshangyinziView =  discusszhaoshangyinziService.selectView(ew);
		return R.ok("查询招商引资评论表成功").put("data", discusszhaoshangyinziView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscusszhaoshangyinziEntity discusszhaoshangyinzi = discusszhaoshangyinziService.selectById(id);
        return R.ok().put("data", discusszhaoshangyinzi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscusszhaoshangyinziEntity discusszhaoshangyinzi = discusszhaoshangyinziService.selectById(id);
        return R.ok().put("data", discusszhaoshangyinzi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscusszhaoshangyinziEntity discusszhaoshangyinzi, HttpServletRequest request){
    	discusszhaoshangyinzi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discusszhaoshangyinzi);

        discusszhaoshangyinziService.insert(discusszhaoshangyinzi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscusszhaoshangyinziEntity discusszhaoshangyinzi, HttpServletRequest request){
    	discusszhaoshangyinzi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discusszhaoshangyinzi);

        discusszhaoshangyinziService.insert(discusszhaoshangyinzi);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiscusszhaoshangyinziEntity discusszhaoshangyinzi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discusszhaoshangyinzi);
        discusszhaoshangyinziService.updateById(discusszhaoshangyinzi);//全部更新
        return R.ok();
    }
    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discusszhaoshangyinziService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
