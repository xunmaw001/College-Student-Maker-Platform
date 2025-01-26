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

import com.entity.YouxiuxiangmuEntity;
import com.entity.view.YouxiuxiangmuView;

import com.service.YouxiuxiangmuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 优秀项目
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-20 10:24:36
 */
@RestController
@RequestMapping("/youxiuxiangmu")
public class YouxiuxiangmuController {
    @Autowired
    private YouxiuxiangmuService youxiuxiangmuService;



    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YouxiuxiangmuEntity youxiuxiangmu, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			youxiuxiangmu.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YouxiuxiangmuEntity> ew = new EntityWrapper<YouxiuxiangmuEntity>();


		PageUtils page = youxiuxiangmuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, youxiuxiangmu), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YouxiuxiangmuEntity youxiuxiangmu, 
		HttpServletRequest request){
        EntityWrapper<YouxiuxiangmuEntity> ew = new EntityWrapper<YouxiuxiangmuEntity>();

		PageUtils page = youxiuxiangmuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, youxiuxiangmu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YouxiuxiangmuEntity youxiuxiangmu){
       	EntityWrapper<YouxiuxiangmuEntity> ew = new EntityWrapper<YouxiuxiangmuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( youxiuxiangmu, "youxiuxiangmu")); 
        return R.ok().put("data", youxiuxiangmuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YouxiuxiangmuEntity youxiuxiangmu){
        EntityWrapper< YouxiuxiangmuEntity> ew = new EntityWrapper< YouxiuxiangmuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( youxiuxiangmu, "youxiuxiangmu")); 
		YouxiuxiangmuView youxiuxiangmuView =  youxiuxiangmuService.selectView(ew);
		return R.ok("查询优秀项目成功").put("data", youxiuxiangmuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YouxiuxiangmuEntity youxiuxiangmu = youxiuxiangmuService.selectById(id);
        return R.ok().put("data", youxiuxiangmu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YouxiuxiangmuEntity youxiuxiangmu = youxiuxiangmuService.selectById(id);
        return R.ok().put("data", youxiuxiangmu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YouxiuxiangmuEntity youxiuxiangmu, HttpServletRequest request){
    	youxiuxiangmu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(youxiuxiangmu);

        youxiuxiangmuService.insert(youxiuxiangmu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YouxiuxiangmuEntity youxiuxiangmu, HttpServletRequest request){
    	youxiuxiangmu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(youxiuxiangmu);

        youxiuxiangmuService.insert(youxiuxiangmu);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YouxiuxiangmuEntity youxiuxiangmu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(youxiuxiangmu);
        youxiuxiangmuService.updateById(youxiuxiangmu);//全部更新
        return R.ok();
    }
    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        youxiuxiangmuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
